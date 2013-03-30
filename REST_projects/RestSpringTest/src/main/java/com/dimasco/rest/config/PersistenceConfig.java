package com.dimasco.rest.config;

import java.beans.PropertyVetoException;
import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.mchange.v2.c3p0.ComboPooledDataSource;

@Configuration
@ImportResource(value={"classpath:META-INF/spring/spring-data.xml"})
@EnableTransactionManagement
public class PersistenceConfig {

	private static final String driverClass = "com.mysql.jdbc.Driver";
	private static final String jdbcUrl = "jdbc:mysql://localhost/rest";
	private static final String user = "root";
	private static final String password = "12345678";

	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactoryBean() {
		LocalContainerEntityManagerFactoryBean factoryBean = 
				new LocalContainerEntityManagerFactoryBean();

		factoryBean.setDataSource(dataSource());
		factoryBean.setPackagesToScan(new String[] {"com.dimasco.rest.domain"});

		HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
		vendorAdapter.setShowSql(true);
		//vendorAdapter.setGenerateDdl(generateDdl)

		factoryBean.setJpaVendorAdapter(vendorAdapter);

		Properties additionalProperties = new Properties();
		additionalProperties.put("hibernate.hbm2ddl.auto", "update");

		factoryBean.setJpaProperties(additionalProperties);


		return factoryBean;
	}

	@Bean
	public DataSource dataSource() {
		final ComboPooledDataSource dataSource = new ComboPooledDataSource();

		try {
			dataSource.setDriverClass(driverClass);
		} catch (PropertyVetoException e) {
			throw new RuntimeException(e);
		}

		dataSource.setJdbcUrl(jdbcUrl);
		dataSource.setUser(user);
		dataSource.setPassword(password);
		dataSource.setMinPoolSize(3);
		dataSource.setMaxPoolSize(15);
		dataSource.setDebugUnreturnedConnectionStackTraces(true);

		return dataSource;
	}

	@Bean
	public PlatformTransactionManager transactionManager() {
		JpaTransactionManager transactionManager = new JpaTransactionManager();
		transactionManager.setEntityManagerFactory(entityManagerFactoryBean().getObject());

		return transactionManager;
	}

	@Bean
	public PersistenceExceptionTranslationPostProcessor exceptionTranslation(){
		return new PersistenceExceptionTranslationPostProcessor();
	}
}

package com.dimasco.rest.config;

import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.web.client.RestTemplate;

@Configuration
//@ImportResource( { "classpath*:/rest_config.xml" } )
@ComponentScan( basePackages = "com.dimasco.rest", excludeFilters=@Filter(value=Configuration.class, type=FilterType.ANNOTATION))
public class AppConfig {

	@Bean
	public static PropertyPlaceholderConfigurer properties(){
		PropertyPlaceholderConfigurer ppc = new PropertyPlaceholderConfigurer();
		final Resource[] resources = new ClassPathResource[ ] {
				//new ClassPathResource( "persistence.properties" ),
				//new ClassPathResource( "restfull.properties" )
		};
		ppc.setLocations( resources );
		ppc.setIgnoreUnresolvablePlaceholders( true );
		return ppc;
	}
	
	@Bean(name="restTemplate")
	public static RestTemplate restTemplate() {
		return new RestTemplate();
	}
}

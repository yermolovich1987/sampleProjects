package com.dimasco.rest.dao;

import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.dimasco.rest.config.AppConfig;
import com.dimasco.rest.config.PersistenceConfig;
import com.dimasco.rest.domain.Foo;

@RunWith(value = SpringJUnit4ClassRunner.class)
@ContextConfiguration( classes = { AppConfig.class, PersistenceConfig.class },loader = AnnotationConfigContextLoader.class )
@Transactional
@TransactionConfiguration(defaultRollback=false)
public class FooDAOTest {

	@Autowired
	private FooDAO fooDao;
	
	@Test
	public void testGettingByName() {
		List<Foo> fooList = fooDao.findByName("Test name");
		System.out.println(fooList);
	}
	
	@Test
	public void testUpdating() {
		fooDao.setDateForAllFoosWithName(new Date(), "Test name");
	}
	
}

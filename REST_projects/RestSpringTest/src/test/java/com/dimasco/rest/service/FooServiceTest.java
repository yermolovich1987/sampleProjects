package com.dimasco.rest.service;

import java.util.Date;

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
import com.dimasco.rest.dao.FooDAO;
import com.dimasco.rest.domain.Foo;

@RunWith(value = SpringJUnit4ClassRunner.class)
@ContextConfiguration( classes = { AppConfig.class, PersistenceConfig.class },loader = AnnotationConfigContextLoader.class )
@Transactional
@TransactionConfiguration(defaultRollback=false)
public class FooServiceTest {
	
	@Autowired
	private FooDAO fooDAO;
	
	@Test
	public void testUpdating() {
		Foo foo = new Foo();
		foo.setName("Changed Foo");
		foo.setDate(new Date());
		
		//fooDAO.save(foo);
		
		Foo oldFoo = fooDAO.findOne(1L);
		
		oldFoo.update(foo);
		
		
	}

}

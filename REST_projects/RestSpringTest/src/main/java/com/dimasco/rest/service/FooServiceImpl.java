package com.dimasco.rest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.dimasco.rest.dao.FooDAO;
import com.dimasco.rest.domain.Foo;

@Component
@Transactional(propagation=Propagation.REQUIRED, rollbackFor=Exception.class)
public class FooServiceImpl implements FooService {

	@Autowired
	private FooDAO fooDAO;
	
	public List<Foo> getAll() {
		return fooDAO.findAll();
	}

	public Foo getById(long id) {
		return fooDAO.findOne(id);
	}

	public Long create(final Foo foo) {
		Foo savedFoo = fooDAO.save(foo);
		
		return savedFoo.getId();
	}

	public void update(final Foo foo) {
		Foo fetchedFoo = fooDAO.findOne(foo.getId());
	
		fetchedFoo.update(foo);
	}

	public void delete(final Foo foo) {
		fooDAO.delete(foo);
	}

	public void deleteById(long id) {
		fooDAO.delete(id);
	}

	
	
}

package com.dimasco.rest.service;

import java.util.List;

import com.dimasco.rest.domain.Foo;

public interface FooService {
	
	List<Foo> getAll();
	
	Foo getById(long id);
	
	Long create(Foo foo);
	
	void update(Foo foo);
	
	void delete(Foo foo);
	
	void deleteById(long id);
}

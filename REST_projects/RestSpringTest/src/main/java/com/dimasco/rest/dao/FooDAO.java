package com.dimasco.rest.dao;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.dimasco.rest.domain.Foo;

public interface FooDAO extends JpaRepository<Foo, Serializable>{

	@Transactional(propagation=Propagation.SUPPORTS, readOnly=true)
	List<Foo> findByName(final String name);
	
	@Modifying
	@Transactional(propagation=Propagation.REQUIRED, readOnly=false)
	@Query(value="update Foo f set f.date=:date where name=:name")
	void setDateForAllFoosWithName(@Param(value = "date") Date date, @Param(value = "name") String name);
	
}

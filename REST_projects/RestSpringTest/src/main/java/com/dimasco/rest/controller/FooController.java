package com.dimasco.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.dimasco.rest.domain.Foo;
import com.dimasco.rest.service.FooService;

/**
 * This class represents example of REST controller building using Spring MVC.
 * 
 * @author DIMAS
 *
 */
@Controller
final class FooController {
	
	@Autowired
	private FooService fooService;
	
	@RequestMapping(value="foo", method=RequestMethod.GET, produces="application/json")
	@ResponseBody
	public final List<Foo> getAll() {
		return fooService.getAll();
	}
	
	//@RequestMapping(value="foo/{id}", method = RequestMethod.GET, headers = {"Accept=application/xml"})
	@RequestMapping(value="foo/{id}", method = RequestMethod.GET, produces="application/json")
	@ResponseBody
	public final Foo get(@PathVariable("id") long id) {
		return fooService.getById(id);
	}
	
	@RequestMapping(value="foo", method = RequestMethod.POST)
	@ResponseStatus(value=HttpStatus.CREATED)
	@ResponseBody
	public final Long create(@RequestBody final Foo entity) {
		return fooService.create(entity);
	}
	
	@RequestMapping(value="foo/{id}", method = RequestMethod.PUT)
	@ResponseStatus(value=HttpStatus.OK)
	public final void update(@RequestBody final Foo entity) {
		fooService.update(entity);
	}
	
	@RequestMapping(value="foo/{id}", method = RequestMethod.DELETE)
	@ResponseStatus(value=HttpStatus.OK)
	public final void delete(@PathVariable("id") final long id) {
		fooService.deleteById(id);
	}
}

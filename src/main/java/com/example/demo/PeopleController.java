package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;

@Requestmapping("/api/people")

public class PeopleController 
{
	@Autowired
	private PeopleRepository pr;
	
	@GetMapping("/{id}")
	public ResponeEntity<People>getPeopleById
	

}

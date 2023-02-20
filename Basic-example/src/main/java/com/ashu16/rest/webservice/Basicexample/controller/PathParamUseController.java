package com.ashu16.rest.webservice.Basicexample.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PathParamUseController {

	@GetMapping(path="/getname/{name}")
	public String useOfPathVar(@PathVariable String name) {
		return "hello world :"+name; 
	}
}

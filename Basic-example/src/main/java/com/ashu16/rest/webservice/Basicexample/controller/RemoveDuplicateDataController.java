package com.ashu16.rest.webservice.Basicexample.controller;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RemoveDuplicateDataController {

	@GetMapping(path = "/getuniquedata")
	public List<String> getUniqueData(){
		return removeDuplicateData();
	}

	private List<String> removeDuplicateData() {
		List<String> names = Arrays.asList("Karan", "shyam", "Shwetha", "Sandhya", "manmohan", "sandhya", "SANDHYA", "KARAN");
		List<String> uniqueData = names.stream().map(name->name.toLowerCase()).distinct().collect(Collectors.toList());
		return uniqueData;
		
	}
}

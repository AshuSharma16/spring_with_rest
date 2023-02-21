package com.ashu16.rest.webservice.Basicexample.controller;

import java.util.Locale;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class I18Controller {

	
	private MessageSource messageSource;
	
	I18Controller(MessageSource messageSource){
		this.messageSource = messageSource;
		
	}
	
	@GetMapping("/i18language")
	public String getI18Code() {
		
		Locale locale = LocaleContextHolder.getLocale();
		return messageSource.getMessage("good.morning.message", null, "Default Message here !!!!", locale);
		
		
	}
}

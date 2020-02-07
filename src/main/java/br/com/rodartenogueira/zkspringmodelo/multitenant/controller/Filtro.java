package br.com.rodartenogueira.zkspringmodelo.multitenant.controller;

import org.springframework.web.bind.annotation.RequestMapping;


public class Filtro {

	@RequestMapping(value = "/filter")
	public String filtro() {
		
		
		return "send data";
	}
}

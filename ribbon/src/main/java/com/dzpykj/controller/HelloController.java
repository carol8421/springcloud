package com.dzpykj.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.dzpykj.hystrixService.HelloService;

@RestController
public class HelloController {
	
	@Autowired
	RestTemplate restTemplate;
	
	@Autowired
	HelloService helloService;
	
	@RequestMapping("/hello/{name}")
	public String hello(@PathVariable String name) {
		return restTemplate.getForObject("http://eurekaclient/hi?name="+name, String.class);
	}
	
	@RequestMapping("/hi/{name}")
	public String hi(@PathVariable String name) {
		return helloService.hello(name);
	}
}

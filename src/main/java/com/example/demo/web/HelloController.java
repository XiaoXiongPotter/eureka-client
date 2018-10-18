package com.example.demo.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;


@RestController
@Slf4j
public class HelloController {

	@Autowired
	private DiscoveryClient client;
	
	@GetMapping("/hello")
	public String index(){
		  String services = "Services: " + client.getServices();
		  log.info("meta："+client.getLocalServiceInstance().getMetadata());
	        System.out.println(services);
	        return services;
		
	}
	
	 @Autowired
	 MyHealthIndicator myHealthChecker;
	 

	    @RequestMapping("/up")
	    public String up(@RequestParam("up") Boolean up) {
	        myHealthChecker.setUp(up);
	 
	        return up.toString();
	    }
}

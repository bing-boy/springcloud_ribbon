package com.cloud.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ConsumerController {

	private static Logger logger = LoggerFactory.getLogger(ConsumerController.class);

	@Autowired
	RestTemplate restTemplate;

	@RequestMapping(value = "/ribbon-consumer/{username}", method = RequestMethod.GET)
	@ResponseBody
	public String helloConsumer(@PathVariable(value = "username") String name) {
		logger.info("ConsumerController.helloConsumer(" + (null == name ? "" : name) + ")");
		return restTemplate.getForEntity("http://HELLO-SERVICE/hello/" + name, String.class).getBody();
	}
}

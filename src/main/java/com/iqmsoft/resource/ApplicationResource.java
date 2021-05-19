package com.iqmsoft.resource;

import org.apache.camel.BeanInject;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.rest.RestBindingMode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;

import com.iqmsoft.dto.Item;
import com.iqmsoft.processor.ItemProcessor;
import com.iqmsoft.service.ItemsService;

@Component
public class ApplicationResource extends RouteBuilder {

	@Autowired
	private ItemsService service;

	@BeanInject
	private ItemProcessor processor;

	@Override
	public void configure() throws Exception {
		restConfiguration().component("servlet").port(8080).host("localhost").bindingMode(RestBindingMode.json);

		rest().get("/hello-world").produces(MediaType.APPLICATION_JSON_VALUE).route()
				.setBody(constant("Welcome to Spring Boot Camel REST")).endRest();

		rest().get("/getItems").produces(MediaType.APPLICATION_JSON_VALUE).route().setBody(() -> service.getOrders())
				.endRest();

		rest().post("/addItem").consumes(MediaType.APPLICATION_JSON_VALUE).type(Item.class).outType(Item.class)
				.route().process(processor).endRest();
	}

}

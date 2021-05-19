package com.iqmsoft.processor;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.iqmsoft.dto.Item;
import com.iqmsoft.service.ItemsService;

@Component
public class ItemProcessor implements Processor{
	
	@Autowired
	private ItemsService service;

	@Override
	public void process(Exchange exchange) throws Exception {
		service.addOrder(exchange.getIn().getBody(Item.class));
	}

}

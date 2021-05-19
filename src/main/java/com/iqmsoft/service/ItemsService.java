package com.iqmsoft.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Service;

import com.iqmsoft.dto.Item;

@Service
public class ItemsService {

	private List<Item> list = new ArrayList<>();

	@PostConstruct
	public void initDB() {
		list.add(new Item(1, "Computer", 5000));
		list.add(new Item(2, "Mouse", 400));
		list.add(new Item(3, "KeyBoard", 15000));
		list.add(new Item(4, "Printer", 4000));
	}

	public Item addOrder(Item order) {
		list.add(order);
		return order;
	}

	public List<Item> getOrders() {
		return list;
	}

}

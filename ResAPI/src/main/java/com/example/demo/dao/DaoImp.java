package com.example.demo.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.example.demo.model.Manager;

@Service
public class DaoImp implements Dao {
	public List<Manager> list = new ArrayList<>();

	@Override
	public List<Manager> getAll() {
		demoData();
		if (list == null)
			return null;
		return list;
	}
	@Override
	public List<Manager> demoData() {
		list.add(new Manager(1, "Hey Bro", "Cha tien cho tao", 100000L, "BC", "DucDuck"));
		list.add(new Manager(2, "Hey Nhoc", "Cha tien cho tao mau thang lon", 10000L, "DN", "Duck"));
		return list;
	}

}

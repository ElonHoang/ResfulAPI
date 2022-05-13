package com.example.demo.dao;

import java.util.List;

import com.example.demo.model.Manager;

public interface Dao {
	public List<Manager> getAll();
	public List<Manager> demoData();
}

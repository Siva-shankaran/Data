package com.example.demo.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Model.Clients;
import com.example.demo.Model.Users;
import com.example.demo.Repositary.Clients_repositary;
import com.example.demo.Repositary.users_repo;
import com.example.demo.utility.Utility_Class;

@Service
public class Service_Layer {

	@Autowired
	private Utility_Class util;
	@Autowired
	private users_repo user_repo;
	@Autowired
	private Clients_repositary client_repo;

	public List<Users> getusers() {
		List<Users> userss = user_repo.findAll();
		return util.maskentities(userss);
	}

	public List<Clients> getclients() {
		List<Clients> clients = client_repo.findAll();
		return util.maskentities(clients);
	}
}

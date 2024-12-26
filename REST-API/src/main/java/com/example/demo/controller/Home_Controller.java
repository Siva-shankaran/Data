package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.Model.Clients;
import com.example.demo.Model.Users;
import com.example.demo.Repositary.Clients_repositary;
import com.example.demo.Repositary.users_repo;
import com.example.demo.service.Service_Layer;
import com.example.demo.utility.Utility_Class;

@RestController
public class Home_Controller {

	@Autowired
	private users_repo userrepo;

	@Autowired
	private Utility_Class util;

	@Autowired
	private Clients_repositary clientrepo;
	
	@Autowired
	private Service_Layer service;

	// http://localhost:8080/api/save
	@PostMapping("/saveusers")
	public Users saveusers(@RequestBody Users data) {
		return userrepo.save(data);
	}
	
	// http://localhost:8080/api/save
		@PostMapping("/saveclients")
		public Clients saveclients(@RequestBody Clients data) {
			return clientrepo.save(data); 
		}

	// http://localhost:8080/getusers
	@GetMapping("/getusers")
	public List<Users> readusers() {
		return service.getusers();

	}
	
	// http://localhost:8080/read
	@GetMapping("/getclients")
	public List<Clients> readclients() {

		return service.getclients();

	}

	// http://localhost:8080/update
	@PutMapping("/update")
	public void updateApi(@RequestBody Users data) {
		userrepo.save(data);
	}

	// http://localhost:8080/delete
	@DeleteMapping("/delete/{id}")
	public void deleteByIdApi(@PathVariable("id") int id) {
		userrepo.deleteById(id);
	}

}

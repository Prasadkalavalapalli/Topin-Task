package com.topin.www.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.topin.www.dto.TopinDto;
import com.topin.www.service.TopinService;

@RestController
@RequestMapping("/topin")
public class TopinController {
	@Autowired
	private TopinService serv;
	
	@PostMapping("/create_user")
	public ResponseEntity<String> createUser(@RequestBody TopinDto dto)
	{
		return serv.createUser(dto);
	}
	@GetMapping("/get_users")
	public ResponseEntity<?> getUsers()
	{
		return serv.getUsers();
	}
	@DeleteMapping("/delete_user")
	public ResponseEntity<String>deleteUser(@RequestParam Long id )
	{
		return serv.deleteUser(id);
	}
	@PutMapping("/update_user/{id}")
	public ResponseEntity<String> updateUser(@PathVariable Long id,@RequestBody TopinDto dto)
	{
		return serv.updateUser(dto,id);
	}
	
}

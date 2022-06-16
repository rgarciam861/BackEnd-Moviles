package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.modelo.AppUser;
import com.example.demo.security.ApplicationUserRol;
import com.example.demo.service.AppUserService;



@RestController
@RequestMapping("users")
public class AppUserController {

	@Autowired
	AppUserService appUserService;

	@PostMapping("addUser")
	public void addUser(@RequestBody AppUser appUser) {
		AppUser nuevoUsuario = new AppUser(appUser.getUsername(), appUser.getPassword());
		this.appUserService.addRoleToUser(nuevoUsuario.getUsername(), ApplicationUserRol.GUEST.name());
		this.appUserService.addUserToList(nuevoUsuario);
	}

}

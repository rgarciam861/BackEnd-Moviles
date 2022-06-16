package com.example.demo;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.controller.AppUserController;
import com.example.demo.modelo.AppUser;
import com.example.demo.repository.AppUserRepository;
import com.example.demo.security.ApplicationUserRol;
import com.example.demo.service.AppUserService;

class UserTest {
	@Autowired
	AppUserRepository userRepository;
	@Test
	void test() {
		AppUser appUser=new AppUser("Man", "Yea");
		appUser.addRole(ApplicationUserRol.GUEST.name());
		AppUserController controller=new AppUserController();
		AppUserService appUserService=new AppUserService();
		appUserService.addUserToList(appUser);
		System.out.println(appUserService.getAllUsers());
	}

}

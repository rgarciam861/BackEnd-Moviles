package com.example.demo.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.modelo.AppUser;

public interface AppUserRepository extends CrudRepository<AppUser, Long>{

}

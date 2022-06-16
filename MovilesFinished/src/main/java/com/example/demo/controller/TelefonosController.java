package com.example.demo.controller;

import java.io.Console;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.modelo.Complementos;
import com.example.demo.modelo.Response;
import com.example.demo.modelo.Telefono;
import com.example.demo.modelo.TelefonoResumen;
import com.example.demo.service.TelefonoService;


@RestController
@RequestMapping("Telefonia")
public class TelefonosController {
	@Autowired
	private TelefonoService telefonoService;
	// Preautorized
	@GetMapping("home")
	public String dame() {
		return "Hola";
	}
	@GetMapping("list")
		public ResponseEntity<Response> movilesList(){
			return ResponseEntity.ok(
					Response.builder()
					.TimeStamp(LocalDateTime.now())
					.Message("moviles recuperados")
					.Status(HttpStatus.OK)
					.Data(Map.of("moviles",this.telefonoService.getTelefonos()))
					.build()
					);
		
	}

	@GetMapping("Resumen")
	public ResponseEntity<Response> resumidos(){
		return ResponseEntity.ok(
				Response.builder()
				.TimeStamp(LocalDateTime.now())
				.Message("moviles recuperados")
				.Status(HttpStatus.OK)
				.Data(Map.of("moviles",this.telefonoService.resumen()))
				.build()
				);
	}
	@GetMapping("{id}")
	public ResponseEntity<Response> buscarMovilId(@PathVariable("id") long id){
		return ResponseEntity.ok(Response.builder()
				.TimeStamp(LocalDateTime.now())
				.Message("Moviles cogidos")
				.Status(HttpStatus.OK)
				.Data(Map.of("moviles", telefonoService.getbyId(id)))
				.build());
	}
	}

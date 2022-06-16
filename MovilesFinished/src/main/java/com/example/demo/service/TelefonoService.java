package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.modelo.Complementos;
import com.example.demo.modelo.Telefono;
import com.example.demo.modelo.TelefonoResumen;
import com.example.demo.repository.ComplementosRepository;
import com.example.demo.repository.TelefonoRepository;

@Service
public class TelefonoService {

@Autowired
private TelefonoRepository telefonoRepository;
@Autowired
private ComplementosRepository complementosRepository;

public TelefonoService() {
}

public ArrayList<Telefono> getTelefonos() {
ArrayList<Telefono> telefonos;
 telefonos = (ArrayList<Telefono>) telefonoRepository.findAll();
// Iterable<Complementos> complementos = complementosRepository.findAll();
 
// telefonos.forEach((movil)->{movil.setComplementos((List<Complementos>) complementos);});
 return telefonos;
}
public List<Telefono> getTelefono() {
	 Optional<Telefono> telefono = telefonoRepository.findById((long) 1);
	 ArrayList<Telefono> telefonos=new ArrayList<>();
	 telefonos.add(telefono.get());
	 
	 return telefonos;
	}
public List<TelefonoResumen> resumen() {
	Iterable<Telefono> findAll = telefonoRepository.findAll();
	
	ArrayList<TelefonoResumen> resumidos=new ArrayList<>();
			findAll.forEach((t)->{resumidos.add(t.resumir());});
			
//	return new TelefonoResumen(telefono.get().getId(),telefono.get().getPeso()
//			, telefono.get().getAlmacenamiento());
	return resumidos;
}
public List<Telefono> getbyId(long id){
	return this.getTelefonos().stream().filter(
			(Telefono telefono)-> telefono.getId()==id)
			.collect(Collectors.toList());
}




}

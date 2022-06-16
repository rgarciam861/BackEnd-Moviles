package com.example.demo;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.Spliterator;
import java.util.stream.StreamSupport;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.controller.ObjectMother;
import com.example.demo.modelo.AppUser;
import com.example.demo.modelo.Bateria;
import com.example.demo.modelo.Complementos;
import com.example.demo.modelo.Marca;
import com.example.demo.modelo.Modelo;
import com.example.demo.modelo.Pantalla;
import com.example.demo.modelo.Procesador;
import com.example.demo.modelo.Ram;
import com.example.demo.modelo.Telefono;
import com.example.demo.repository.AppUserRepository;
import com.example.demo.repository.BateriaRepository;
import com.example.demo.repository.ComplementosRepository;
import com.example.demo.repository.MarcaRepository;
import com.example.demo.repository.ModeloRepository;
import com.example.demo.repository.PantallaRepository;
import com.example.demo.repository.ProcesadorRepository;
import com.example.demo.repository.RamRepository;
import com.example.demo.repository.TelefonoRepository;
import com.example.demo.security.ApplicationUserRol;

@SpringBootTest
class Moviles001ApplicationTests {
	@Autowired
	MarcaRepository marcaRepository;
	@Autowired
	TelefonoRepository telefonoRepository;
	@Autowired
	ModeloRepository modeloRepository;
	@Autowired
	ProcesadorRepository procesadorRepository;
	@Autowired
	PantallaRepository pantallaRepository;
	@Autowired
	ComplementosRepository complementosRepository;
	@Autowired
	RamRepository ramRepository;
	@Autowired
	BateriaRepository bateriaRepository;
	@Autowired
	AppUserRepository appUserRepository;

	@Test
	void contextLoads() {
		Random random = new Random();
		ObjectMother objectMother = new ObjectMother();
		List<Marca> generarMarca = objectMother.generarMarca(10);
		marcaRepository.saveAll(generarMarca);
		List<Modelo> generarModelos = objectMother.generarModelos(20);
		modeloRepository.saveAll(generarModelos);
		Iterable<Marca> marcas = marcaRepository.findAll();
		Iterable<Modelo> modelos = modeloRepository.findAll();

		long marcaLength = StreamSupport.stream(marcas.spliterator(), false).count();
		long modelosLength = StreamSupport.stream(modelos.spliterator(), false).count();

		Optional<Marca> findById = marcaRepository.findById(random.nextLong(marcaLength));
		Optional<Modelo> findById2 = modeloRepository.findById(random.nextLong(modelosLength));
		Procesador calcularProcesador = objectMother.calcularProcesador(findById.get(), findById2.get());
		Procesador procesador2 = objectMother.calcularProcesador(
				marcaRepository.findById(random.nextLong(marcaLength)).get(),
				modeloRepository.findById(random.nextLong(modelosLength)).get());
		procesadorRepository.save(calcularProcesador);
		procesadorRepository.save(procesador2);
		Iterable<Procesador> procesadores = procesadorRepository.findAll();
		long procesadorLenght = StreamSupport.stream(procesadores.spliterator(), false).count();
		Optional<Marca> marca2 = marcaRepository.findById(random.nextLong(marcaLength));
		Optional<Modelo> modelo2 = modeloRepository.findById(random.nextLong(modelosLength));
		Optional<Procesador> procesador1 = procesadorRepository.findById(random.nextLong(procesadorLenght));
		Pantalla generarPantalla = objectMother.generarPantalla(procesador1.get(), modelo2.get(), marca2.get());
		Pantalla generarPantalla2 = objectMother.generarPantalla(
				procesadorRepository.findById(random.nextLong(procesadorLenght)).get(),
				modeloRepository.findById(random.nextLong(modelosLength)).get(),
				marcaRepository.findById(random.nextLong(marcaLength)).get());
		pantallaRepository.save(generarPantalla);
		pantallaRepository.save(generarPantalla2);
		Iterable<Pantalla> pantallas = pantallaRepository.findAll();
		long pantallasLenght = StreamSupport.stream(pantallas.spliterator(), false).count();
		List<Complementos> generarComplementos = objectMother.generarComplementos();
		complementosRepository.saveAll(generarComplementos);
		Optional<Marca> marca3 = marcaRepository.findById(random.nextLong(marcaLength));
		Optional<Modelo> modelo3 = modeloRepository.findById(random.nextLong(modelosLength));
		Ram generarRam = objectMother.generarRam(procesadorRepository.findById((long) 1).get(), marca3.get(),
				modelo3.get());
		ramRepository.save(generarRam);
		Optional<Marca> marca6 = marcaRepository.findById(random.nextLong(marcaLength));
		Optional<Modelo> modelo6 = modeloRepository.findById(random.nextLong(modelosLength));
		Ram generarRam2 = objectMother.generarRam(
				procesadorRepository.findById(random.nextLong(procesadorLenght)).get(), marca6.get(), modelo6.get());
		ramRepository.save(generarRam2);
		Iterable<Ram> rams = ramRepository.findAll();
		long ramsLenght = StreamSupport.stream(rams.spliterator(), false).count();

		Optional<Marca> marca4 = marcaRepository.findById(random.nextLong(marcaLength));
		Optional<Modelo> modelo4 = modeloRepository.findById(random.nextLong(modelosLength));
		Bateria generarBateria = objectMother.generarBateria(pantallaRepository.findById((long) 1).get(), marca4.get(),
				modelo4.get());
		bateriaRepository.save(generarBateria);
		Optional<Marca> marca7 = marcaRepository.findById(random.nextLong(marcaLength));
		Optional<Modelo> modelo7 = modeloRepository.findById(random.nextLong(modelosLength));
		Bateria generarBateria2 = objectMother.generarBateria(
				pantallaRepository.findById(random.nextLong(pantallasLenght)).get(), marca7.get(), modelo7.get());
		bateriaRepository.save(generarBateria2);
		Iterable<Bateria> baterias = bateriaRepository.findAll();
		long bateriasLenght = StreamSupport.stream(baterias.spliterator(), false).count();

		Optional<Marca> marca5 = marcaRepository.findById(random.nextLong(marcaLength));
		Optional<Modelo> modelo5 = modeloRepository.findById(random.nextLong(modelosLength));
		List<Complementos> complementos = (List<Complementos>) complementosRepository.findAll();
		Telefono generarMovil = objectMother.generarMovil(ramRepository.findById((long) 1).get(), marca5.get(),
				modelo5.get(), bateriaRepository.findById((long) 1).get(),
				procesadorRepository.findById((long) 1).get(), pantallaRepository.findById((long) 1).get(),
				complementos);
		telefonoRepository.save(generarMovil);
		Optional<Marca> marca8 = marcaRepository.findById(random.nextLong(marcaLength));
		Optional<Modelo> modelo8 = modeloRepository.findById(random.nextLong(modelosLength));
		Optional<Ram> ram = ramRepository.findById(random.nextLong(ramsLenght));
		Optional<Procesador> procesador = procesadorRepository.findById(random.nextLong(procesadorLenght));
		Optional<Pantalla> pantalla = pantallaRepository.findById(random.nextLong(pantallasLenght));
		Optional<Bateria> bateria = bateriaRepository.findById(random.nextLong(bateriasLenght));
		Telefono telefono2 = objectMother.generarMovil(ram.get(), marca8.get(), modelo8.get(), bateria.get(),
				procesador.get(), pantalla.get(), complementos);
		telefonoRepository.save(telefono2);
		AppUser user1 = new AppUser("luis", "123");
		user1.addRole(ApplicationUserRol.ADMIN.name());
		appUserRepository.save(user1);

	}

}

package com.example.demo.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import com.example.demo.modelo.Bateria;
import com.example.demo.modelo.Complementos;
import com.example.demo.modelo.Marca;
import com.example.demo.modelo.Modelo;
import com.example.demo.modelo.Pantalla;
import com.example.demo.modelo.Procesador;
import com.example.demo.modelo.Ram;
import com.example.demo.modelo.RandomNombre;
import com.example.demo.modelo.Telefono;

public class ObjectMother {
	private final int MAX_NUCLEOS = 11;
	Random random = new Random();
	private String marcas[] = { "Alpha", "Omega", "Delta", "Doko", "Turbo", "Dovux", "LG", "Xiaomi", "Sony", "Realme",
			"Apple", "Samsung", "Acer", "Alcatel", "Asus", "BlackShark", "BlackBerry", "Blackview", "Cubot", "Google",
			"Hisense", "HTC", "Huawei", "Lenovo", "Meizu", "Motorola", "Nokia", "Nubia", "Oppo", "Poco", "Razer", "THL",
			"TCL", "Ulefone", "Vivo", "Redmi", "ZTE" };
	private String marcasProcesador[] = { "Intel", "Ryzen", "MSI" };
	private String Modelos[] = { "DWE24", "TWTW343", "EWTEW2","jserwe","jerw","ewt23","rweih35"};
	private String materialFabricacion[] = { "Cobre", "Oro", "Platino", "Plata" };
	private int almacenamientoGB[] = { 4, 8, 2 };
	String tipodeCarga[] = { "Inalambrica", "Rapida" };
	String tipodeBateria[] = { "Litio", "Ion-litio" };
	private int PesoEnGramos[] = { 40, 88, 220, 100, 200 };
	private String marcasPantalla[] = { "LG", "SAMSUNG", "Tianma" };
	

//	public ArrayList<Telefono> generarMoviles(int cantidad) {
//		ArrayList<Telefono> moviles = new ArrayList<Telefono>();
//		boolean repetido;
//		for (int i = 0; i < cantidad; i++) {
//			do {
//				Telefono movil = generarMovil();
//				repetido = moviles.stream().anyMatch((m) -> m.equals(movil));
//			} while (repetido);
//			moviles.add(generarMovil());
//		}
//		return moviles;
//	}
		public List<Marca> generarMarca(int cantidad) {
			ArrayList<Marca> marca = new ArrayList<Marca>();
			boolean repetido;
			for (int i = 0; i < cantidad; i++) {
				do {
					Marca marcas = generarMarca();
					repetido = marca.stream().anyMatch((m) -> m.equals(marcas));
				} while (repetido);
				marca.add(generarMarca());
			}
			return marca;
	}
		
	private Marca generarMarca() {
		int length = marcas.length;
		int nextInt = random.nextInt(length);
		Marca marca=new Marca(marcas[nextInt]);
		return marca;
	}
	public List<Modelo> generarModelos(int cantidad) {
		ArrayList<Modelo> marca = new ArrayList<Modelo>();
		boolean repetido;
		for (int i = 0; i < cantidad; i++) {
			do {
				Modelo modelo = generarModelo();
				repetido = marca.stream().anyMatch((m) -> m.equals(modelo));
			} while (repetido);
			marca.add(generarModelo());
		}
		return marca;
}
private Modelo generarModelo() {
	return new Modelo(RandomNombre.crearPalabra(10));
}
public List<Complementos> generarComplementos(){
	LinkedList<Complementos> complementos=new LinkedList();
	complementos.add(new Complementos("Wifi"));
	complementos.add(new Complementos("Bluetooth"));
	complementos.add(new Complementos("GPS"));
	return complementos;
}

	public Telefono generarMovil(Ram ram, Marca marca, Modelo modelo, Bateria bateria, Procesador procesador,Pantalla pantalla,List<Complementos> complementos) {
	
		int almacenamiento = almacenamientoGB[random.nextInt(almacenamientoGB.length)];
		int peso = PesoEnGramos[random.nextInt(PesoEnGramos.length)];
		String material = materialFabricacion[random.nextInt(materialFabricacion.length)];
		String nombre=RandomNombre.crearPalabra(10);
		return new Telefono(ram, peso, nombre,almacenamiento, material, marca, modelo, bateria, procesador, pantalla,complementos);
	}
//	private ArrayList<Complementos> getComplementos(){
//		ArrayList<Complementos> complementos=new ArrayList<>();
//		complementos.add(new Complementos("Wifi"));
//		complementos.add(new Complementos("Bluetooth"));
//		return complementos;
//	}
//public List<Ram> generarModelos(Modelo modelo,Marca marca, Procesador procesador) {
//	ArrayList<Ram> ram = new ArrayList<Ram>();
//	
//	boolean repetido;
//	for (int i = 0; i < cantidad; i++) {
//		do {
//			Modelo modelo = generarModelo();
//			repetido = marca.stream().anyMatch((m) -> m.equals(modelo));
//		} while (repetido);
//		marca.add(generarModelo());
//	}
//	return marca;

	
	
	public Ram generarRam(Procesador procesador,Marca marca, Modelo modelo) {
		int medioGB = 512;
		int valor=procesador.getNucleos() * medioGB + random.nextInt(procesador.getNucleos() / 2) * medioGB;
		return new Ram(valor, marca, modelo);
	}



	public Procesador calcularProcesador(Marca marca,Modelo modelo) {
		int nucleos = getNucleosRandom() + 1;
		int frecuencia = calcularFrecuencia(nucleos);
		Procesador procesador = new Procesador(nucleos,frecuencia,marca,modelo);
		return procesador;
	}

	private int getNucleosRandom() {
		return random.nextInt(MAX_NUCLEOS) + 1;
	}

	private int calcularFrecuencia(int nucleos) {
		if (nucleos <= 4) {
			return nucleos * 450;
		} else if (nucleos <= 8) {
			return nucleos * 250;
		} else {
			return nucleos * 180;
		}
	}
//	public List<Modelo> generarPantallas(int cantidad) {
//		ArrayList<Pantalla> pantallas = new ArrayList<Pantalla>();
//		boolean repetido;
//		for (int i = 0; i < cantidad; i++) {
//			do {
//				Modelo pantalla = calcularPantalla();
//				repetido = pantallas.stream().anyMatch((m) -> m.equals(pantalla));
//			} while (repetido);
//			marca.add(generarModelo());
//		}
//		return marca;
//}

	public Pantalla generarPantalla(Procesador procesador,Modelo modelo, Marca marca) {
		float pulgadasIfNucleosMenos4 = (float) (4 + random.nextDouble() * (6 - 4));
		float pulgadasIfNucleosMas5 = (float) (5.6 + random.nextDouble() * (7 - 5.6));
		if (procesador.getNucleos() <= 4) {
			return new Pantalla(pulgadasIfNucleosMenos4, modelo, marca);
		} else {
			return new Pantalla(pulgadasIfNucleosMas5, modelo, marca);
		}
	}
	
//	public ArrayList<Bateria> generarBaterias(int cantidad, Marca marca, Modelo modelo){
//		Pantalla pantalla= new Pantalla();
//		String carga=tipodeCarga[random.nextInt(tipodeCarga.length)];
//		String tipobateria=tipodeBateria[random.nextInt(tipodeBateria.length)];
//		ArrayList<Bateria> baterias= new ArrayList<>();
//		boolean repetido;
//		for (int i = 0; i < tipodeBateria.length; i++) {
//			do {
//				int capacidad=calcularBateria(pantalla);
//				Bateria bateria=new Bateria(tipobateria, carga, capacidad, marca, modelo);
//				repetido = baterias.stream().anyMatch((m) -> m.equals(bateria));
//			} while (repetido);
//			
//		}
//		return baterias;
//	}

	public Bateria generarBateria(Pantalla pantalla,Marca marca,Modelo modelo) {
		String carga=tipodeCarga[random.nextInt(tipodeCarga.length)];
		String tipobateria=tipodeBateria[random.nextInt(tipodeBateria.length)];
		int mwhMinimoPorPulgada = 575;
		
		int variacionBateria = 150;
		int mhwPorPulgada = mwhMinimoPorPulgada + random.nextInt(variacionBateria);
		int capacidad = (int) pantalla.getPulgadas() * mhwPorPulgada;
		
		return new Bateria(tipobateria, carga, capacidad, marca, modelo);
	}

}

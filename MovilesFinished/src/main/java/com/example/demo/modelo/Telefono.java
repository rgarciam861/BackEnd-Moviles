package com.example.demo.modelo;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import antlr.collections.List;
import lombok.Data;

@Entity

public class Telefono implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "ID_RAM")
	private Ram ram;
	@Column(name = "Peso", nullable = false)
	private int Peso;
	@Column(name="Nombre",nullable = false)
	private String Nombre;
	@Column(name = "Almacenamiento", nullable = false)
	private int Almacenamiento;
	@Column(name = "MaterialFabricacion", nullable = false)
	private String materialFabricacion;
	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "ID_MARCA")
	private Marca marca;
	@OneToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "ID_MODELO")
	private Modelo modelo;
	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "ID_BATERIA")
	private Bateria bateria;
	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "ID_PROCESADOR")
	private Procesador procesador;
	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "ID_PANTALLA")
	private Pantalla pantalla;
//	@ManyToMany(cascade = CascadeType.MERGE,fetch = FetchType.EAGER)
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "rel_complementos", joinColumns = { @JoinColumn(name = "Telefono_id") }, inverseJoinColumns = {
			@JoinColumn(name = "Complementos_id") })
//	@JsonIgnore
	private java.util.List<Complementos> complementos;

	public Telefono(Ram ram, int peso, String nombre,int almacenamiento, String materialFabricacion, Marca marca, Modelo modelo,
			Bateria bateria, Procesador procesador, Pantalla pantalla, java.util.List<Complementos> complementos) {
		super();
		this.ram = ram;
		Peso = peso;
		Almacenamiento = almacenamiento;
		this.materialFabricacion = materialFabricacion;
		this.marca = marca;
		this.modelo = modelo;
		this.bateria = bateria;
		this.procesador = procesador;
		this.pantalla = pantalla;
		this.complementos = complementos;
		this.Nombre=nombre;
	}

	public Telefono() {
		super();
	}

	

	@Override
	public String toString() {
		return "Telefono [id=" + id + ", ram=" + ram + ", Peso=" + Peso + ", Nombre=" + Nombre + ", Almacenamiento="
				+ Almacenamiento + ", materialFabricacion=" + materialFabricacion + ", marca=" + marca + ", modelo="
				+ modelo + ", bateria=" + bateria + ", procesador=" + procesador + ", pantalla=" + pantalla
				+ ", complementos=" + complementos + "]";
	}
	public String getNombre() {
		return Nombre;
	}
	public void setNombre(String nombre) {
		Nombre = nombre;
	}

	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}

	public Ram getRam() {
		return ram;
	}

	public void setRam(Ram ram) {
		this.ram = ram;
	}

	public int getPeso() {
		return Peso;
	}

	public void setPeso(int peso) {
		Peso = peso;
	}

	public int getAlmacenamiento() {
		return Almacenamiento;
	}

	public void setAlmacenamiento(int almacenamiento) {
		Almacenamiento = almacenamiento;
	}

	public String getMaterialFabricacion() {
		return materialFabricacion;
	}

	public void setMaterialFabricacion(String materialFabricacion) {
		this.materialFabricacion = materialFabricacion;
	}

	public Marca getMarca() {
		return marca;
	}

	public void setMarca(Marca marca) {
		this.marca = marca;
	}

	public Modelo getModelo() {
		return modelo;
	}

	public void setModelo(Modelo modelo) {
		this.modelo = modelo;
	}

	public Bateria getBateria() {
		return bateria;
	}

	public void setBateria(Bateria bateria) {
		this.bateria = bateria;
	}

	public Procesador getProcesador() {
		return procesador;
	}

	public void setProcesador(Procesador procesador) {
		this.procesador = procesador;
	}

	public Pantalla getPantalla() {
		return pantalla;
	}

	public void setPantalla(Pantalla pantalla) {
		this.pantalla = pantalla;
	}

	public java.util.List<Complementos> getComplementos() {
		return complementos;
	}

	public void setComplementos(java.util.List<Complementos> complementos) {
		this.complementos = complementos;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(Almacenamiento, Nombre, Peso, bateria, complementos, id, marca, materialFabricacion, modelo,
				pantalla, procesador, ram);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Telefono other = (Telefono) obj;
		return Almacenamiento == other.Almacenamiento && Objects.equals(Nombre, other.Nombre) && Peso == other.Peso
				&& Objects.equals(bateria, other.bateria) && Objects.equals(complementos, other.complementos)
				&& Objects.equals(id, other.id) && Objects.equals(marca, other.marca)
				&& Objects.equals(materialFabricacion, other.materialFabricacion)
				&& Objects.equals(modelo, other.modelo) && Objects.equals(pantalla, other.pantalla)
				&& Objects.equals(procesador, other.procesador) && Objects.equals(ram, other.ram);
	}
	public TelefonoResumen resumir() {
		return new TelefonoResumen(this.id, this.Nombre,this.Peso, this.Almacenamiento);
		
	}

}

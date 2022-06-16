package com.example.demo.modelo;

import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Procesador {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "Nucleos", nullable = false)
	private int nucleos;
	@Column(name = "Velocidad", nullable = false)
	private float velocidad;
	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "ID_MARCA")
	private Marca marca;
	@OneToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "ID_MODELO")
	private Modelo modelo;
	public Procesador(int nucleos, float velocidad, Marca marca, Modelo modelo) {
		super();
		this.nucleos = nucleos;
		this.velocidad = velocidad;
		this.marca = marca;
		this.modelo = modelo;
	}
	public Procesador() {
		super();
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public int getNucleos() {
		return nucleos;
	}
	public void setNucleos(int nucleos) {
		this.nucleos = nucleos;
	}
	public float getVelocidad() {
		return velocidad;
	}
	public void setVelocidad(float velocidad) {
		this.velocidad = velocidad;
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
	@Override
	public int hashCode() {
		return Objects.hash(id, marca, modelo, nucleos, velocidad);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Procesador other = (Procesador) obj;
		return Objects.equals(id, other.id) && Objects.equals(marca, other.marca)
				&& Objects.equals(modelo, other.modelo) && nucleos == other.nucleos
				&& Float.floatToIntBits(velocidad) == Float.floatToIntBits(other.velocidad);
	}
	@Override
	public String toString() {
		return "Procesador [id=" + id + ", nucleos=" + nucleos + ", velocidad=" + velocidad + ", marca=" + marca
				+ ", modelo=" + modelo + "]";
	}
	
}

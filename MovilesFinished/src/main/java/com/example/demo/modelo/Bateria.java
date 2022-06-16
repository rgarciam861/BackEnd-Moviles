package com.example.demo.modelo;

import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Bateria {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "TipoDeBateria", nullable = false, length = 20)
	private String TipoDeBateria;
	@Column(name = "TipoDeCarga", nullable = false, length = 20)
	private String TipoDeCarga;
	@Column(name = "Capacidad")
	private int Capacidad;
	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "ID_MARCA")
	private Marca marca;
	@OneToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "ID_MODELO")
	private Modelo modelo;



	public Bateria(String tipoDeBateria, String tipoDeCarga, int capacidad, Marca marca, Modelo modelo) {
		super();
		TipoDeBateria = tipoDeBateria;
		TipoDeCarga = tipoDeCarga;
		Capacidad = capacidad;
		this.marca = marca;
		this.modelo = modelo;
	}



	public Bateria() {
		super();
	}



	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public String getTipoDeBateria() {
		return TipoDeBateria;
	}



	public void setTipoDeBateria(String tipoDeBateria) {
		TipoDeBateria = tipoDeBateria;
	}



	public String getTipoDeCarga() {
		return TipoDeCarga;
	}



	public void setTipoDeCarga(String tipoDeCarga) {
		TipoDeCarga = tipoDeCarga;
	}



	public int getCapacidad() {
		return Capacidad;
	}



	public void setCapacidad(int capacidad) {
		Capacidad = capacidad;
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
		return Objects.hash(Capacidad, TipoDeBateria, TipoDeCarga, id, marca, modelo);
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Bateria other = (Bateria) obj;
		return Capacidad == other.Capacidad && Objects.equals(TipoDeBateria, other.TipoDeBateria)
				&& Objects.equals(TipoDeCarga, other.TipoDeCarga) && Objects.equals(id, other.id)
				&& Objects.equals(marca, other.marca) && Objects.equals(modelo, other.modelo);
	}

}

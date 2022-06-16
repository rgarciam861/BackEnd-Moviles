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
public class Ram {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "Memoria",nullable = false)
	private int memoriaGB;
	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "ID_MARCA")
	private Marca marca;
	@OneToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "ID_MODELO")
	private Modelo modelo;

	public Ram(int memoria, Marca marca, Modelo modelo) {
		super();
		this.memoriaGB = memoria;
		this.marca = marca;
		this.modelo = modelo;
	}

	public Ram() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getMemoriaGB() {
		return memoriaGB;
	}

	public void setMemoriaGB(int memoriaGB) {
		this.memoriaGB = memoriaGB;
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
		return Objects.hash(id, marca, memoriaGB, modelo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Ram other = (Ram) obj;
		return Objects.equals(id, other.id) && Objects.equals(marca, other.marca) && memoriaGB == other.memoriaGB
				&& Objects.equals(modelo, other.modelo);
	}

}

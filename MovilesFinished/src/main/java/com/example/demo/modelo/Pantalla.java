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
public class Pantalla {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;
@Column(name = "Pulgadas",nullable = false)
private float Pulgadas;
@ManyToOne(cascade = CascadeType.MERGE)
@JoinColumn(name = "ID_MARCA")
private Marca marca;
@OneToOne(cascade = CascadeType.MERGE)
@JoinColumn(name = "ID_MODELO")
private Modelo modelo;
public Pantalla(float pulgadas, Modelo modelo, Marca marca) {
	super();
	Pulgadas = pulgadas;
	this.marca = marca;
	this.modelo = modelo;
}
public Pantalla() {
	super();
}
public Long getId() {
	return id;
}
public void setId(Long id) {
	this.id = id;
}
public float getPulgadas() {
	return Pulgadas;
}
public void setPulgadas(float pulgadas) {
	Pulgadas = pulgadas;
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
	return Objects.hash(Pulgadas, id, marca, modelo);
}
@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	Pantalla other = (Pantalla) obj;
	return Float.floatToIntBits(Pulgadas) == Float.floatToIntBits(other.Pulgadas) && Objects.equals(id, other.id)
			&& Objects.equals(marca, other.marca) && Objects.equals(modelo, other.modelo);
}
@Override
public String toString() {
	return "Pantalla [id=" + id + ", Pulgadas=" + Pulgadas + ", marca=" + marca + ", modelo=" + modelo + "]";
}




}

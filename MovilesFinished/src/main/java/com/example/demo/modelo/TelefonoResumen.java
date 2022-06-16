package com.example.demo.modelo;

import java.util.Objects;

public class TelefonoResumen {
private long id;
private String Nombre;
private int peso;
private int almacenamiento;


public TelefonoResumen(long id, String nombre,int peso, int almacenamiento) {
	super();
	this.id = id;
	this.Nombre=nombre;
	this.peso = peso;
	this.almacenamiento = almacenamiento;
}
public long getId() {
	return id;
}
public void setId(long id) {
	this.id = id;
}
public String getNombre() {
	return Nombre;
}
public void setNombre(String nombre) {
	Nombre = nombre;
}
public int getPeso() {
	return peso;
}
public void setPeso(int peso) {
	this.peso = peso;
}
public int getAlmacenamiento() {
	return almacenamiento;
}
public void setAlmacenamiento(int almacenamiento) {
	this.almacenamiento = almacenamiento;
}
@Override
public String toString() {
	return "TelefonoResumen [id=" + id + ", Nombre=" + Nombre + ", peso=" + peso + ", almacenamiento=" + almacenamiento
			+ "]";
}
@Override
public int hashCode() {
	return Objects.hash(Nombre, almacenamiento, id, peso);
}
@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	TelefonoResumen other = (TelefonoResumen) obj;
	return Objects.equals(Nombre, other.Nombre) && almacenamiento == other.almacenamiento && id == other.id
			&& peso == other.peso;
}


}

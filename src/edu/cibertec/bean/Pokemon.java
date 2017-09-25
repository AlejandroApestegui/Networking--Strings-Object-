package edu.cibertec.bean;

import java.io.Serializable;
import java.util.Arrays;

@SuppressWarnings("serial")
public class Pokemon implements Serializable {

	private int numero;
	private String nombre;
	private String[] tipos;

	public Pokemon(int numero, String nombre, String[] tipos) {
		super();
		this.numero = numero;
		this.nombre = nombre;
		this.tipos = tipos;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String[] getTipos() {
		return tipos;
	}

	public void setTipos(String[] tipos) {
		this.tipos = tipos;
	}

	@Override
	public String toString() {
		return "Pokemon [numero=" + numero + ", nombre=" + nombre;
	}

}

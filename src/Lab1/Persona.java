package Lab1;

import java.util.ArrayList;

public class Persona {

	String nombre;
	ArrayList<String> preferencias;
	boolean relacion = false;
	String pareja;

	Persona(String nombre, ArrayList<String> preferencias) {
		this.nombre = nombre;
		this.preferencias = preferencias;
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public ArrayList<String> getPreferencias() {
		return preferencias;
	}
	public void setPreferencias(ArrayList<String> preferencias) {
		this.preferencias = preferencias;
	}
	public boolean isRelacion() {
		return relacion;
	}
	public void setRelacion(boolean relacion) {
		this.relacion = relacion;
	}
	public String getPareja() {
		return pareja;
	}
	public void setPareja(String pareja) {
		this.pareja = pareja;
	}
	
}

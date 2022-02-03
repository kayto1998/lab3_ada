package algoritmo;

public class Persona {

	String nombre;
	String[] preferencias;
	boolean relacion = false;
	String pareja;
	
	Persona(String nombre, String[] preferencias) {
		this.nombre = nombre;
		this.preferencias = preferencias;
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String[] getPreferencias() {
		return preferencias;
	}
	public void setPreferencias(String[] preferencias) {
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

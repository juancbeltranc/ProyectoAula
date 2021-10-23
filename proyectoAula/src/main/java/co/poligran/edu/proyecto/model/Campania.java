package co.poligran.edu.proyecto.model;

public class Campania {
	
	private int anio;
	private String mes;
	private int dia;
	private String nombre;
	public Campania() {
	
	}
	public Campania(int anio, String mes, int dia, String nombre) {
		super();
		this.anio = anio;
		this.mes = mes;
		this.dia = dia;
		this.nombre = nombre;
	}
	public int getAnio() {
		return anio;
	}
	public void setAnio(int anio) {
		this.anio = anio;
	}
	public String getMes() {
		return mes;
	}
	public void setMes(String mes) {
		this.mes = mes;
	}
	public int getDia() {
		return dia;
	}
	public void setDia(int dia) {
		this.dia = dia;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}	
}

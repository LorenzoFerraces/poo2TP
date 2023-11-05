package containers;

import java.util.ArrayList;
import java.util.List;

import services.IServicio;

public class Container {
	int ancho;
	int largo;
	int altura;
	int pesoTotal;
	List<IServicio> servicios;
	
	public Container(int ancho, int largo, int altura, int pesoTotal) {
		this.ancho = ancho;
		this.largo = largo;
		this.altura = altura;
		this.pesoTotal = pesoTotal;
		this.servicios = new ArrayList<IServicio>();
	}
	
	public double consumoPorHora() {
		return 0;
	}

	public int getAncho() {
		return ancho;
	}

	public int getLargo() {
		return largo;
	}

	public int getAltura() {
		return altura;
	}
	
	public int getPesoTotal() {
		return pesoTotal;
	}
	
	public List<IServicio> getServicios() {
		return this.servicios;
	}
	
	public void addServicio(IServicio servicio) {
		this.servicios.add(servicio);
	}
	
	public int costoTotalDeLosServicios() {
		return this.servicios.stream().mapToInt(service -> service.costo()).sum();
	}

	
	
}

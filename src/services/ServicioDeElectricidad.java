package services;

import java.time.Duration;
import java.time.LocalDateTime;

public class ServicioDeElectricidad implements IServicio {
	LocalDateTime momentoInicio;
	LocalDateTime momentoFin;
	double costoKWH;
	double consumoKWH;
	
	public ServicioDeElectricidad(LocalDateTime momentoInicio, LocalDateTime momentoFin, double costoKWH, double consumoKWH) {
		this.momentoInicio = momentoInicio;
		this.momentoFin = momentoFin;
		this.costoKWH = costoKWH;
		this.consumoKWH = consumoKWH;
	}
	
	public long getCantidadDeHorasDelServicio() {
		return Duration.between(this.momentoInicio, this.momentoFin).toHours();
	}

	@Override
	public double costo() {
		return getCantidadDeHorasDelServicio() * consumoKWH * costoKWH;
	}

}

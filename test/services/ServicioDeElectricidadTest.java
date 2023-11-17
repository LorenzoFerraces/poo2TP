package services;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;

class ServicioDeElectricidadTest {
	@Test
	void debeCalcularseLaCantidadDeHorasDeServicioEnElMismoDia() {
		ServicioDeElectricidad customService = new ServicioDeElectricidad(LocalDateTime.of(2023, 11, 5, 12, 0), LocalDateTime.of(2023, 11, 5, 15, 2), 0, 0);
		assertEquals(customService.getCantidadDeHorasDelServicio(), 3);
	}
	
	@Test
	void debeCalcularseLaCantidadDeHorasDeServicioEnDistintosDias() {
		ServicioDeElectricidad customService = new ServicioDeElectricidad(LocalDateTime.of(2023, 11, 5, 12, 0), LocalDateTime.of(2023, 11, 6, 12, 50), 0, 0);
		
		assertEquals(customService.getCantidadDeHorasDelServicio(), 24);
	}
	
	@Test
	void elPrecioVariaDependiendoLasHorasDeServicio() {
		// 25 horas de diferencia entre fechas
		LocalDateTime dateInicio = LocalDateTime.of(2023, 11, 5, 12, 0);
		LocalDateTime dateFin = LocalDateTime.of(2023, 11, 6, 13, 1);
		ServicioDeElectricidad customService = new ServicioDeElectricidad(dateInicio, dateFin, 100, 2);
		
		assertEquals(customService.costo(), 25 * 100 * 2); //Horas * costoKWH * consumoKWH
	}
	
	@Test
	void elPrecioVariaDependiendoElCostoDeKW() {
		// 1 hora de diferencia entre fechas
		LocalDateTime dateInicio = LocalDateTime.of(2023, 11, 5, 12, 0);
		LocalDateTime dateFin = LocalDateTime.of(2023, 11, 5, 13, 1);
		ServicioDeElectricidad customService = new ServicioDeElectricidad(dateInicio, dateFin, 300, 2); //Varia el costo (300)
		
		assertEquals(customService.costo(), 1 * 300 * 2); //Horas * costoKWH * consumoKWH
	}
	
	@Test
	void elPrecioVariaDependiendoElConsumoDeKW() {
		// 1 hora de diferencia entre fechas
		LocalDateTime dateInicio = LocalDateTime.of(2023, 11, 5, 12, 0);
		LocalDateTime dateFin = LocalDateTime.of(2023, 11, 5, 13, 1);
		ServicioDeElectricidad customService = new ServicioDeElectricidad(dateInicio, dateFin, 100, 10);
		
		assertEquals(customService.costo(), 1 * 100 * 10); //Horas * costoKWH * consumoKWH
	}

}

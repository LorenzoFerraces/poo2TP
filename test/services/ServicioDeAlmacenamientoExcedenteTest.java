package services;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ServicioDeAlmacenamientoExcedenteTest {

	@Test
	void siPasaUnDiaElCostoDebeSerIgualAlCostoPorDia() {
		IServicio myService = new ServicioDeAlmacenamientoExcedente(1, 100);
		
		assertEquals(myService.costo(), 100);
		
	}
	
	@Test
	void siPasaUnVariosDiasElCostoDebeSerElCorrespondiente() {
		IServicio myService = new ServicioDeAlmacenamientoExcedente(4, 100);
		
		assertEquals(myService.costo(), 400);
		
	}
	
	@Test
	void siNoPasaNingunDiaElCostoDebeSerCero() {
		IServicio myService = new ServicioDeAlmacenamientoExcedente(0, 100);
		
		assertEquals(myService.costo(), 0);
		
	}

}

package containers;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import services.IServicio;

class ContainerTest {
	Container myContainer;
	
	
	@BeforeEach
	void setUp() {
		myContainer = new Container(100, 100, 100, 100);
	}

	@Test
	void seDebenPoderObtenerLasDimensionesDelContenedor() {
		int ANCHO = 100;
		int LARGO = 200;
		int ALTO = 300;
		int PESO = 400;
		
		Container customContainer = new Container(ANCHO, LARGO, ALTO, PESO);
		
		assertEquals(customContainer.getAncho(), ANCHO);
		assertEquals(customContainer.getLargo(), LARGO);
		assertEquals(customContainer.getAltura(), ALTO);
		assertEquals(customContainer.getPesoTotal(), PESO);
	}
	
	@Test 
	void seDebePoderObtenerLosMetrosCubicosDelContenedor() {
		int ANCHO = 100;
		int LARGO = 200;
		int ALTO = 300;
		int PESO = 400;
		
		Container customContainer = new Container(ANCHO, LARGO, ALTO, PESO);
		
		int expectedMetrosCubicos = ANCHO * LARGO * ALTO;
		
		assertEquals(customContainer.getMetrosCuibicos(), expectedMetrosCubicos);
	}
	
	@Test
	void elConsumoPorHoraDebeSerCero() {		
		assertEquals(myContainer.consumoPorHora(), 0);
	}

	
	@Test
	void elContainerSeInicializaSinServicios() {
		assertEquals(myContainer.getServicios().size(), 0);
	}
	
	
	@Test
	void sePuedeAgregarUnServicio() {
		IServicio myServicio = mock(IServicio.class);
		
		myContainer.addServicio(myServicio);
		
		assertTrue(myContainer.getServicios().contains(myServicio));
	}
	
	@Test
	void sePuedenAgregarMultiplesServicios() {
		IServicio myServicio1 = mock(IServicio.class);
		IServicio myServicio2 = mock(IServicio.class);
		IServicio myServicio3 = mock(IServicio.class);
		
		myContainer.addServicio(myServicio1);
		myContainer.addServicio(myServicio2);
		myContainer.addServicio(myServicio3);
		
		assertTrue(myContainer.getServicios().contains(myServicio1));
		assertTrue(myContainer.getServicios().contains(myServicio2));
		assertTrue(myContainer.getServicios().contains(myServicio3));
		
	}
	
	@Test
	void sePuedeCalcularCostoTotalDeLosServicios() {
		IServicio myServicio1 = mock(IServicio.class);
		IServicio myServicio2 = mock(IServicio.class);
		
		when(myServicio1.costo()).thenReturn(500);
		when(myServicio2.costo()).thenReturn(200);
		
		myContainer.addServicio(myServicio1);
		myContainer.addServicio(myServicio2);
		
		assertEquals(myContainer.costoTotalDeLosServicios(), 700);
	}
	
	@Test
	void elCostoTotalDeUnContainerSinServiciosEsCero() {
		assertEquals(myContainer.costoTotalDeLosServicios(), 0);
	}
	
	
}

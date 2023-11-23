package filtrosDeCircuitos;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import naviera.circuitoMaritimo.CircuitoMaritimo;
import terminalPortuaria.TerminalPortuaria;
import viaje.Viaje;

class FiltroSaleEnTest {
	IFiltrable filtro;
	CircuitoMaritimo circuito1;
	CircuitoMaritimo circuito2;
	CircuitoMaritimo circuito3;
	
	Viaje viaje1;
	Viaje viaje2;
	Viaje viaje3;
	
	List<Viaje> viajes;
	
	TerminalPortuaria terminal1;
	TerminalPortuaria terminal2;

	@BeforeEach
	void setUp() throws Exception {
		this.circuito1 = mock(CircuitoMaritimo.class);
		this.circuito2 = mock(CircuitoMaritimo.class);
		this.circuito3 = mock(CircuitoMaritimo.class);
		
		this.viaje1 = mock(Viaje.class);
		this.viaje2 = mock(Viaje.class);
		this.viaje3 = mock(Viaje.class);
		
		this.viajes = new ArrayList<Viaje>();
		this.viajes.add(viaje1);
		this.viajes.add(viaje2);
		this.viajes.add(viaje3);
		
		this.terminal1 = mock(TerminalPortuaria.class);
		this.terminal2 = mock(TerminalPortuaria.class);
		
		//Se asigna la el Circuito:X al Viaje:X
		when(viaje1.getCircuito()).thenReturn(circuito1);
		when(viaje2.getCircuito()).thenReturn(circuito2);
		when(viaje3.getCircuito()).thenReturn(circuito3);
		
	}
	
	@Test
	void seDebeObtenerElTiempoDeViajeEntreLaTerminalOrigenYLaTerminalGestionada() {
		when(viaje1.getFechaDeSalida()).thenReturn(LocalDate.now()); //fecha mock
		
		//Asignar viaje a circuito y cicruito a terminal
		when(viaje1.getCircuito()).thenReturn(circuito1);
		when(circuito1.getTerminalInicio()).thenReturn(terminal1);
		
		this.filtro = new FiltroSaleEn(LocalDate.now(), this.terminal2);
		filtro.filtrar(viajes);
		
		verify(viaje1).getTiempoEntreTerminales(terminal1, terminal2);
	}

	@Test
	void seObtienenSoloLosCircuitosQueCoincidanConLaFechaDeSalida() {
		LocalDate fechaIncorrecta = LocalDate.of(2023, 11, 23);
		LocalDate fechaCorrecta = LocalDate.of(2023, 6, 24);
		LocalDate fechaEsperada = LocalDate.of(2023, 6, 14);
		
		//Definir el tiempo de viaje
		when(this.viaje1.getTiempoEntreTerminales(any(), any())).thenReturn(10.0);
		when(this.viaje2.getTiempoEntreTerminales(any(), any())).thenReturn(10.0);
		when(this.viaje3.getTiempoEntreTerminales(any(), any())).thenReturn(10.0);
		
		when(this.viaje1.getFechaDeSalida()).thenReturn(fechaIncorrecta);
		when(this.viaje2.getFechaDeSalida()).thenReturn(fechaIncorrecta);
		when(this.viaje3.getFechaDeSalida()).thenReturn(fechaCorrecta);
		
		this.filtro = new FiltroSaleEn(fechaEsperada, this.terminal1);
		
		assertEquals(this.filtro.filtrar(viajes).size(), 1);
		assertTrue(this.filtro.filtrar(viajes).contains(this.viaje3));
	}
	
	
	@Test
	void seObtieneUnaListaVaciaSiNingunCircuitoCumpleLaCondicion() {
		LocalDate fechaIncorrecta = LocalDate.of(2023, 10, 2);
		LocalDate fechaEsperada = LocalDate.of(2023, 10, 11);
		
		//Definir el tiempo de viaje
		when(this.viaje1.getTiempoEntreTerminales(any(), any())).thenReturn(10.0);
		when(this.viaje2.getTiempoEntreTerminales(any(), any())).thenReturn(10.0);
		when(this.viaje3.getTiempoEntreTerminales(any(), any())).thenReturn(10.0);
		
		when(this.viaje1.getFechaDeSalida()).thenReturn(fechaIncorrecta);
		when(this.viaje2.getFechaDeSalida()).thenReturn(fechaIncorrecta);
		when(this.viaje3.getFechaDeSalida()).thenReturn(fechaIncorrecta);
		
		this.filtro = new FiltroSaleEn(fechaEsperada, this.terminal1);
		
		assertTrue(this.filtro.filtrar(viajes).isEmpty());
	}

}

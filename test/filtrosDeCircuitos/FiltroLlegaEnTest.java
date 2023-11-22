package filtrosDeCircuitos;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDateTime;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import naviera.circuitoMaritimo.CircuitoMaritimo;
import terminalPortuaria.TerminalPortuaria;
import viaje.Viaje;

class FiltroLlegaEnTest {
	IFiltrable filtro;
	CircuitoMaritimo circuito1;
	CircuitoMaritimo circuito2;
	CircuitoMaritimo circuito3;
	Viaje viaje1;
	Viaje viaje2;
	Viaje viaje3;
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
		this.terminal1 = mock(TerminalPortuaria.class);
		this.terminal2 = mock(TerminalPortuaria.class);
		
		//Se asigna la el Circuito:X al Viaje:X
		when(viaje1.getCircuitoMaritimo()).thenReturn(circuito1);
		when(viaje2.getCircuitoMaritimo()).thenReturn(circuito2);
		when(viaje3.getCircuitoMaritimo()).thenReturn(circuito3);
	}
	
	@Test
	void seDebeObtenerElTiempoDeViajeEntreLaTerminalGestionadaYElDestino() {
		when(viaje1.getFechaDeSalida()).thenReturn(LocalDateTime.of(2023, 10, 2, 0 ,0)); //fecha mock
		
		//Asignar viaje a circuito y cicruito a terminal
		when(viaje1.getCircuitoMaritimo()).thenReturn(circuito1);
		
		this.filtro = new FiltroLlegaEn(mock(LocalDateTime.class), this.terminal1, this.terminal2, List.of(this.viaje1));
		filtro.filtrar();
		
		verify(viaje1).getTiempoDeViajeEntreTerminales(terminal1, terminal2);
	}
	
	@Test
	void seObtienenSoloLosCircuitosQueCoincidanConLaFechaDeLlegada() {
		LocalDateTime fechaIncorrecta = LocalDateTime.of(2023, 10, 2, 0 ,0);
		LocalDateTime fechaCorrecta = LocalDateTime.of(2023, 10, 1, 0, 0);
		LocalDateTime fechaEsperada = LocalDateTime.of(2023, 10, 11, 0 ,0);
		
		//Definir el tiempo de viaje
		when(this.viaje1.getTiempoDeViajeEntreTerminales(terminal1, terminal2)).thenReturn(10.0);
		when(this.viaje2.getTiempoDeViajeEntreTerminales(terminal1, terminal2)).thenReturn(10.0);
		when(this.viaje3.getTiempoDeViajeEntreTerminales(terminal1, terminal2)).thenReturn(10.0);
		
		when(this.viaje1.getFechaDeSalida()).thenReturn(fechaIncorrecta);
		when(this.viaje2.getFechaDeSalida()).thenReturn(fechaIncorrecta);
		when(this.viaje3.getFechaDeSalida()).thenReturn(fechaCorrecta);
		
		
		this.filtro = new FiltroLlegaEn(fechaEsperada, this.terminal1, this.terminal2, List.of(this.viaje1, this.viaje2, this.viaje3));
		
		assertEquals(this.filtro.filtrar().size(), 1);
		assertTrue(this.filtro.filtrar().contains(this.circuito3));
	}
	
	
	@Test
	void seObtieneUnaListaVaciaSiNingunCircuitoCumpleLaCondicion() {
		LocalDateTime fechaIncorrecta = LocalDateTime.of(2023, 10, 2, 0 ,0);
		LocalDateTime fechaEsperada = LocalDateTime.of(2023, 10, 11, 0 ,0);
		
		//Definir el tiempo de viaje
		when(this.viaje1.getTiempoDeViajeEntreTerminales(any(), any())).thenReturn(10.0);
		when(this.viaje2.getTiempoDeViajeEntreTerminales(any(), any())).thenReturn(10.0);
		when(this.viaje3.getTiempoDeViajeEntreTerminales(any(), any())).thenReturn(10.0);
		
		when(this.viaje1.getFechaDeSalida()).thenReturn(fechaIncorrecta);
		when(this.viaje2.getFechaDeSalida()).thenReturn(fechaIncorrecta);
		when(this.viaje3.getFechaDeSalida()).thenReturn(fechaIncorrecta);
		

		this.filtro = new FiltroLlegaEn(fechaEsperada, this.terminal1, this.terminal2, List.of(this.viaje1, this.viaje2, this.viaje3));
		
		assertTrue(this.filtro.filtrar().isEmpty());
	}


}

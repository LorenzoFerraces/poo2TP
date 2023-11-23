package filtrosDeCircuitos;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
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
		this.viaje1 = mock(Viaje.class);
		this.viaje2 = mock(Viaje.class);
		this.viaje3 = mock(Viaje.class);
		this.terminal1 = mock(TerminalPortuaria.class);
		this.terminal2 = mock(TerminalPortuaria.class);	
	}
	
	@Test
	void seDebeObtenerElTiempoDeViajeEntreLaTerminalGestionadaYElDestino() {
		when(viaje1.getFechaDeSalida()).thenReturn(LocalDate.of(2023, 10, 2)); //fecha mock
		
		//Asignar viaje a circuito
		when(viaje1.getCircuito()).thenReturn(circuito1);
		
		this.filtro = new FiltroLlegaEn(mock(LocalDate.class), this.terminal1, this.terminal2);
		filtro.filtrar(List.of(this.viaje1));
		
		verify(viaje1).getTiempoEntreTerminales(terminal1, terminal2);
	}
	
	@Test
	void seObtienenSoloLosCircuitosQueCoincidanConLaFechaDeLlegada() {
		LocalDate fechaIncorrecta = LocalDate.of(2023, 10, 2);
		LocalDate fechaCorrecta = LocalDate.of(2023, 10, 1);
		LocalDate fechaEsperada = LocalDate.of(2023, 10, 11);
		
		//Definir el tiempo de viaje
		when(this.viaje1.getTiempoEntreTerminales(terminal1, terminal2)).thenReturn(10.0);
		when(this.viaje2.getTiempoEntreTerminales(terminal1, terminal2)).thenReturn(10.0);
		when(this.viaje3.getTiempoEntreTerminales(terminal1, terminal2)).thenReturn(10.0);
		
		when(this.viaje1.getFechaDeSalida()).thenReturn(fechaIncorrecta);
		when(this.viaje2.getFechaDeSalida()).thenReturn(fechaIncorrecta);
		when(this.viaje3.getFechaDeSalida()).thenReturn(fechaCorrecta);
		
		
		this.filtro = new FiltroLlegaEn(fechaEsperada, this.terminal1, this.terminal2);
		
		assertEquals(this.filtro.filtrar(List.of(this.viaje1, this.viaje2, this.viaje3)).size(), 1);
		assertTrue(this.filtro.filtrar(List.of(this.viaje1, this.viaje2, this.viaje3)).contains(this.viaje3));
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
		

		this.filtro = new FiltroLlegaEn(fechaEsperada, this.terminal1, this.terminal2);
		
		assertTrue(this.filtro.filtrar(List.of(this.viaje1, this.viaje2, this.viaje3)).isEmpty());
	}


}

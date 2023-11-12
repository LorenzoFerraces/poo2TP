package viaje;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDateTime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import naviera.circuitoMaritimo.CircuitoMaritimo;
import terminalPortuaria.TerminalPortuaria;

class ViajeTest {
	Viaje miViaje;
	CircuitoMaritimo circuito;
	TerminalPortuaria terminal1;
	TerminalPortuaria terminal2;
	LocalDateTime fechaSalida;
	
	
	@BeforeEach
	void setUp() throws Exception {
		this.circuito = mock(CircuitoMaritimo.class);
		this.terminal1 = mock(TerminalPortuaria.class);
		this.terminal2 = mock(TerminalPortuaria.class);
		this.fechaSalida = mock(LocalDateTime.class);
		this.miViaje = new Viaje(this.circuito, this.fechaSalida);
	}

	@Test
	void sePuedeObtenerElCircuitoQueVaASeguirElViaje() {
		assertEquals(miViaje.getCircuitoMaritimo(), this.circuito);
	}
	
	@Test
	void sePuedeObtenerLaFechaDeSalidaDelViaje() {
		assertEquals(miViaje.getFechaDeSalida(), this.fechaSalida);
	}
	
	
	@Test
	void sePuedeCalcularELTiempoDeViajeEntreDosTerminales() {
		double tiempo_esperado = 1200.0; //Valor expresado en minutos
		when(circuito.getTiempoDeViajeEntreTerminales(terminal1, terminal2)).thenReturn(tiempo_esperado);
		
		assertEquals(this.miViaje.getTiempoDeViajeEntreTerminales(terminal1, terminal2), tiempo_esperado);
		
		verify(circuito).getTiempoDeViajeEntreTerminales(terminal1, terminal2); //Verifcar que se llame a la funcion de circuito
	}

}

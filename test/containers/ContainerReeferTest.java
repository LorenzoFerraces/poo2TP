package containers;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import container.Container;
import container.ContainerReefer;

class ContainerReeferTest {
	@Test
	void elConsumoDeKwPorHoraEsCorrecto() {
		double KW_HORA = 55;
		
		Container myReeferContainer = new ContainerReefer(100,100,100, 100, KW_HORA);
		
		assertEquals(myReeferContainer.consumoPorHora(), KW_HORA);
	}

}

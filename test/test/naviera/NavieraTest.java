package test.naviera;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import buque.Buque;
import naviera.Naviera;

class NavieraTest {
	
	private Naviera nav;
	
	@BeforeEach
	void setUp() throws Exception {
	}
	
	@Test
	void testAddBuque() {
		Buque b = mock(Buque.class);
		assertTrue(nav.addBuque(b));
	}


}

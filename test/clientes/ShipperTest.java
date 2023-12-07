package clientes;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class ShipperTest {

	private Shipper unShipper;
	
	@BeforeEach
	void setUp() throws Exception {
		unShipper = new Shipper();
	}

	// Métodos de super clase Cliente
	@Test
	void testUnShipperRecienCreadoNoTieneFacturas() {
		assertEquals(0, unShipper.getFacturas().size());
	}
	
	@Test
	void testUnShipperRecibeUnaFactura() {
		unShipper.recibirFactura("");
		assertEquals(1, unShipper.getFacturas().size());
	}

}

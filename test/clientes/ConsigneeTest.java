package clientes;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import empresaTransportista.Camion;
import empresaTransportista.Conductor;
import ordenes.OrdenImportacion;

class ConsigneeTest {

	private OrdenImportacion orden;
	private Consignee unConsignee;
	
	@BeforeEach
	void setUp() throws Exception {
		orden = mock(OrdenImportacion.class);
		unConsignee = new Consignee();
	}

	@Test
	void testUnConsigneeRecienCreadoNoTieneFacturas() {
		assertEquals(0, unConsignee.getFacturas().size());
	}
	
	@Test
	void testUnConsigneeRecibeUnaFactura() {
		unConsignee.recibirFactura("");
		assertEquals(1, unConsignee.getFacturas().size());
	}
	
	@Test
	void testRecibirAvisoPorImportacion() {
		unConsignee.recibirAvisoPorImportacion(orden);
		verify(orden).cargarDatosRetiroDeCarga(any(Camion.class), any(Conductor.class)); // Verifica que se haya disparado el mensaje
	}

}

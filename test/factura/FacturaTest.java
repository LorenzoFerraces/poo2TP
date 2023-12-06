package factura;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.time.LocalDateTime;
import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import container.Container;
import naviera.viaje.circuitoMaritimo.CircuitoMaritimo;
import ordenes.Orden;
import services.ServicioDeLavado;
import naviera.viaje.Viaje;

class FacturaTest {

	private Factura factura; // SUT
	// DOCs
	private Orden orden;
	private ServicioDeLavado servicioLavado;
	private Viaje viaje;
	private CircuitoMaritimo circuito;
	private Container carga;
	
	@BeforeEach
	void setUp() throws Exception {
		orden = mock(Orden.class);
		servicioLavado = mock(ServicioDeLavado.class);
		viaje = mock(Viaje.class);
		circuito = mock(CircuitoMaritimo.class);
		carga = mock(Container.class);
		
		factura = new Factura(orden, LocalDateTime.now());
		
	}

	@Test
    void testFacturaParaShipper() {
        // Setup
        when(servicioLavado.costo()).thenReturn(100.0);
        when(carga.getServicios()).thenReturn(Arrays.asList(servicioLavado));
        when(orden.getCarga()).thenReturn(carga);

        // Verificar el resultado
        String stringEsperado = "Factura: \nFecha de expedicion: " + factura.getFechaDeFacturacion().toString() + "\nServicios brindados: \n" +
            "ServicioDeLavado: 100.0\n\n" +
            "Subtotal Servicios: 100.0\n" +
        	"Total a pagar: 100.0\n";
        assertEquals(stringEsperado.trim(), factura.facturaParaShipper());
        
        // String esperado
        /*
        Factura: 
		Fecha de expedicion: 2023-11-22T16:37:45.689723600
		Servicios brindados: 
		ServicioDeLavado: 100.0

		Subtotal Servicios: 100.0
		Total a pagar: 100.0
         */
    }
	
	@Test
    void testFacturaParaConsignee() {
        // Setup
        when(servicioLavado.costo()).thenReturn(100.0);
        when(circuito.precioTotal()).thenReturn(200.0);
        when(viaje.getCircuito()).thenReturn(circuito);
        when(carga.getServicios()).thenReturn(Arrays.asList(servicioLavado));
        when(orden.getCarga()).thenReturn(carga);
        when(orden.getViajeElegido()).thenReturn(viaje);

        // Verificar el resultado
        String stringEsperado = "Factura: \nFecha de expedicion: " + factura.getFechaDeFacturacion().toString() + "\nServicios brindados: \n" +
            "ServicioDeLavado: 100.0\n\n" +
            "Subtotal Servicios: 100.0\n" +
            "Subtotal Viaje: 200.0\n" +
        	"Total a pagar: 300.0\n";
        assertEquals(stringEsperado.trim(), factura.facturaParaConsignee());
        
        // String esperado
        /*
        Factura: 
		Fecha de expedicion: 2023-11-22T16:37:45.689723600
		Servicios brindados: 
		ServicioDeLavado: 100.0

		Subtotal Servicios: 100.0
		Subtotal Viaje: 200.0
		Total a pagar: 300.0
         */
    }
}

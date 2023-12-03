package clientes;

import java.util.ArrayList;
import java.util.List;

public abstract class Cliente {

	protected List<String> facturas;

	public Cliente() {
		this.facturas = new ArrayList<String>();
	}

	public void recibirFactura(String factura) {
		facturas.add(factura);
	}

	public List<String> getFacturas() {
		return facturas;
	}

}
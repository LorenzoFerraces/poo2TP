package services;

import containers.Container;

public class ServicioDeLavado implements IServicio {
	Container container;
	int COSTO_CONTAINER_GRANDE = 1500;
	int COSTO_CONTAINER_CHICO = 800;

	public ServicioDeLavado(Container container) {
		this.container = container;
	}
	
	

	@Override
	public int costo() {
		int costoFinal;
		
		//Si supera los 70m2 se cobra a costo de container grande
		if (this.container.getMetrosCuibicos() >= 70) {
			costoFinal = this.COSTO_CONTAINER_GRANDE;
		} else {
			costoFinal = this.COSTO_CONTAINER_CHICO;
		}
		
		return costoFinal;
	}

}

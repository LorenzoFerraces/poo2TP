package services;

public class ServicioDeAlmacenamientoExcedente implements IServicio {
	int cantDias;
	int costoPorDia;
	
	public ServicioDeAlmacenamientoExcedente(int cantDias, int costoPorDia) {
		this.cantDias = cantDias;
		this.costoPorDia = costoPorDia;
	}

	@Override
	public double costo() {
		return this.cantDias * this.costoPorDia;
	}

}

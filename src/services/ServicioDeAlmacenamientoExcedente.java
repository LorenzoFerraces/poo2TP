package services;

public class ServicioDeAlmacenamientoExcedente implements IServicio {
	int cantDias;
	int costoPorDia;
	
	public ServicioDeAlmacenamientoExcedente(int cantDias, int costoPorDia) {
		this.cantDias = cantDias;
		this.costoPorDia = costoPorDia;
	}
	
	public void setCantDias(int cantDias) {
		this.cantDias = cantDias;
	}
	
	public void costoPorDia(int costoPorDia) {
		this.costoPorDia = costoPorDia;
	}

	@Override
	public double costo() {
		return this.cantDias * this.costoPorDia;
	}

}

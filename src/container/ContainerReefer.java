package container;

public class ContainerReefer extends Container {
	double kwHora;
	
	public ContainerReefer(int ancho, int largo, int altura, int pesoTotal, double kwHora) {
		super(ancho, largo, altura, pesoTotal);
		this.kwHora = kwHora;
	}
	
	@Override
	public double consumoPorHora() {
		return this.kwHora;
	}

}

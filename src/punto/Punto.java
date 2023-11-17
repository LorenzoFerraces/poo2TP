package punto;

public class Punto extends Par<Double,Double> {
	
	public Punto (Double x, Double y) {
		super(x,y);
	}
	
	public Double calcularDistancia(Punto p) {
//		formula para medir la distancia de dos puntos 
//		sqrt((x2-x1)^2 + (y2-y1)^2)
		return Math.sqrt(
				Math.pow((p.getFirst() - this.getFirst()), 2) + 
				(Math.pow((p.getSecond() - this.getSecond()), 2)));
	}

}

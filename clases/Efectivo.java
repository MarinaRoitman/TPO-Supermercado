package clases;

public class Efectivo extends medioDePago{
	double dcto = 0.1;
	
	public double calcularMonto(double precio) {
		// Recibe el precio y realiza el descuento correspondiente. Devuelve ese resultado
		double devolver = precio - (precio*dcto);
		return devolver;
	}

}

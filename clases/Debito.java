package clases;


public class Debito extends medioDePago {

	public double calcularMonto(double precio) {
		// Devuelve el precio porque no hay descuento o recargo
		return precio;
	}
}

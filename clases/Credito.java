package clases;

public class Credito extends medioDePago{
	int cantCuotas;
	
	public void setCantCuotas(int cant) {
		if(cant == 2 || cant == 6 || cant == 3) {
			this.cantCuotas = cant;
		}
	}
	
	public int getCantCuotas() {
		return cantCuotas;
	}
	
	public double calcularMonto(double precio) {
		double devolver;
		// Recibe el precio y realiza el recargo correspondiente. Devuelve el precio con recargo
		//2 cuotas tienen un recargo del 6% del valor total de la venta.
		if(cantCuotas == 2) {
			devolver = precio + precio*0.06;
		}
		//3 cuotas tienen un recargo del 12% del valor total de la venta.
		else if(cantCuotas == 3) {
			devolver = precio + precio*0.12;
		}
		//6 cuotas tienen un recargo del 20% del valor total de la venta.
		else{
			devolver = precio + precio*0.2;
		}
		return devolver;
		
	}
		
}

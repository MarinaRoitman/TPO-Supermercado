package clases;

public abstract class medioDePago {
	double total;
	
	public double calcularMonto() {
		return total;
	}
	
	public void setTotal(double total) {
		this.total = total;
	}
	
}

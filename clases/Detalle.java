package clases;

public class Detalle {
	int cantidad;
	String codigoProducto;
	
	//Getters y setters
	public int getCantidad(){
		return cantidad;
	}
	
	public void setCantidad(int cantidad){
		this.cantidad = cantidad;
	}
	
	public String getCodProd(){
		return codigoProducto;
	}
	
	public void setCodProd(String codigoProducto){
		this.codigoProducto = codigoProducto;
	}
	
	//Constructor
	public Detalle(int cantidad, String codigoProducto) {
		this.cantidad = cantidad;
		this.codigoProducto = codigoProducto;
	}
}

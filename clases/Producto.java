package clases;

public class Producto {
	String codigo;
	String nombreProd;
	String descripcion;
	double precio;
	int stockMinimo;
	int stock;
	boolean activo;
	

	//Getters y setters
	public String getCodigo(){
		return codigo;
	}
	
	public void setCodigo(String codigo){
		this.codigo = codigo;
	}
	
	public String getNombre(){
		return nombreProd;
	}
	
	public void setNombreProd(String nombreProd){
		this.nombreProd = nombreProd;
	}
	
	public String getDescripcion(){
		return descripcion;
	}
	
	public void setDescripcion(String descripcion){
		this.descripcion = descripcion;
	}
	
	public double getPrecio(){
		return precio;
	}
	
	public void setPrecio(double precio){
		this.precio = precio;
	}
	
	public int getStockMinimo(){
		return stockMinimo;
	}
	
	public void setStockMinimo(int stockMinimo){
		this.stockMinimo = stockMinimo;
	}
	
	public int getStock(){
		return stock;
	}
	
	public void setStock(int stock){
		this.stock = stock;
	}
	
	public boolean getActivo(){
		return activo;
	}
	
	public void setActivo(boolean activo){
		this.activo = activo;
	}
	
	//Constructor
	public Producto(String codigo, String nombreProd, String descripcion, double precio, int stockMinimo, int stock, boolean activo) {
		this.codigo = codigo;
		this.nombreProd = nombreProd;
		this.descripcion = descripcion;
		this.precio = precio;
		this.stockMinimo = stockMinimo;
		this.stock = stock;
		this.activo = activo;
	}
}

package clases;

import java.util.ArrayList;

public class Venta {
	String codigoVenta;
	ArrayList<Detalle> carrito = new ArrayList<Detalle>();
	medioDePago medio;
	
	//Getters y setters
	public String getCodigoVenta(){
		return codigoVenta;
	}
	
	public void setCodigoVenta(String codigoVenta){
		this.codigoVenta = codigoVenta;
	}
	
	public ArrayList<Detalle> getCarrito(){
		return carrito;
	}
	
	public medioDePago getMedio(){
		return medio;
	}
	
	public void setMedio(medioDePago medio){
		this.medio = medio;
	}
	
	
	//Constructor
	public Venta(String codigoVenta, ArrayList<Detalle> carrito, medioDePago medio) {
		this.codigoVenta = codigoVenta;
		this.carrito = carrito;
		this.medio = medio;
	}
	
	public Venta() {
		
	}
	
	public void eliminarDetalle(Detalle d, int cantidad) {
		//Quita del detalle la cantidad recibida, si resta mas de lo q hay directamente saca el item del carrito
		for(int i = 0; i<carrito.size(); i++) {
			if(d.getCodProd().equals(carrito.get(i).getCodProd())) {
				if(carrito.get(i).getCantidad()-cantidad>0) {
					carrito.get(i).setCantidad(carrito.get(i).getCantidad()-cantidad);
				}else {
					carrito.remove(i);
				}
			}
		}
	}
	
	public void agregarDetalle(Detalle d) {
		//Agrega un detalle al carrito y si ya existe suma la cantidad
		boolean existe = false;
		for(int i = 0; i < carrito.size(); i++) {
			if(d.codigoProducto.equals(carrito.get(i).codigoProducto)) {
				carrito.get(i).cantidad += d.cantidad;
				existe = true;
			}
		}
		if(!existe) {
			carrito.add(d);
		}
	}
	
	public Detalle getDetalleById(String codigo) {
		//Devuelve un detalle en base al codigo q recibe
		Detalle d = null;
		for(int i = 0; i<carrito.size(); i++) {
			if(codigo.equals(carrito.get(i).getCodProd())) {
				d = carrito.get(i);
			}
		}
		return d;
	}
	
	public boolean existe(String codigo) {
		//Devuelve si existe o no el detalle con el codigo de producto q recibe
		boolean existe = false;
		for(int i = 0; i<carrito.size(); i++) {
			if(carrito.get(i).getCodProd().equals(codigo)) {
				existe = true;
			}
		}
		return existe;
	}
	
	public void vaciarCarrito() {
		carrito.clear();
		}
	}

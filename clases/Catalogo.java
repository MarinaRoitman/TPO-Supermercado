package clases;

import java.util.ArrayList;


public class Catalogo {
	ArrayList<Producto> productos = new ArrayList<Producto>();
	
	public void agregarItems(Producto prod) {
		//Recibe un producto y lo agrega al array productos[]
		boolean existe = false;
		for(int i = 0; i<productos.size(); i++) {
			if(prod.getCodigo() == productos.get(i).getCodigo()) {
				existe = true;
			}
		}
		if(!existe) {
			productos.add(prod);
		}
	}
	
	public void hacerInactivo(String codigoProducto) {
		//Recibe un codigo de producto y pone activo en false
		for(int i = 0; i<productos.size(); i++) {
			if(codigoProducto.equals(productos.get(i).getCodigo())) {
				productos.get(i).setActivo(false);
			}
		}
	}
	
	public void hacerActivo(String codigoProducto) {
		//Recibe un codigo de producto y pone activo en true
		for(int i = 0; i<productos.size(); i++) {
			if(codigoProducto.equals(productos.get(i).getCodigo())) {
				productos.get(i).setActivo(true);
			}
		}
	}
	
	public ArrayList<Producto> getCatalogo() {
		//Devuelve productos
		return productos;
	}
	
	public boolean existe(Producto p) {
		Boolean r = false;
		for (int i = 0; i < productos.size(); i++) {
			if (productos.get(i).codigo.equals(p.codigo)){
				r = true;
			}
		}
		return r;
	}
	
	public Producto getProductoById(String codigo) {
		Producto prod = null;
		for(int i = 0; i<productos.size(); i++) {
			String cod = productos.get(i).getCodigo();
			if(codigo.equals(cod)) {
				prod = productos.get(i);
			}
		}
		return prod;
	}
}

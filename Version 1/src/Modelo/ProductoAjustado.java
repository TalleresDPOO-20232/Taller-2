package Modelo;

import java.util.ArrayList;
import java.util.List;


public class ProductoAjustado implements Producto{
	private ProductoMenu Base;
	private Integer precio;
	private String Nombre;
	private List<Ingrediente> agregados;
	private List<Ingrediente> eliminados;
	
	
	public ProductoAjustado(ProductoMenu base) {
		agregados =  new ArrayList<Ingrediente>();
		eliminados =  new ArrayList<Ingrediente>();
		
	}
	public Integer getPrecio() {
		return precio;
	}
	public String getNombre() {
		return Nombre;
	}
	public String generarTextoFactura() {
		return null;
	}
}

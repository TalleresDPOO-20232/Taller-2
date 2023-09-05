package Modelo;

public class ProductoMenu implements Producto {
	private String nombre;
	private Integer precioBase;
	
	public ProductoMenu(String Pnombre, Integer PprecioBase) {
		nombre = Pnombre;
		precioBase = PprecioBase;
		}

	public Integer getPrecio() {
		return precioBase;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public String generarTextoFactura() {
		return null;
	}


}

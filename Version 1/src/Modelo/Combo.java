package Modelo;

import java.util.ArrayList;
import java.util.List;

public class Combo implements Producto{

	private String nombre;
	private Double descuento;
	private List<ProductoMenu> itemsCombo;
	
	
	
	public Combo(String Pnombre, Double Pdescuento) {
		nombre = Pnombre;
		descuento = Pdescuento;
		itemsCombo=new ArrayList<ProductoMenu>();
	}
	public void agregarItemACombo(Producto ItemCombo) {
		itemsCombo.add((ProductoMenu)ItemCombo);
	}

	public Integer getPrecio() {
		return null;
	}

	public String getNombre() {
		return nombre;
	}

	public String generarTextoFactura() {
		return null;
	}
	
	
}

package Modelo;

public class Ingrediente {
	private String nombre;
	private Integer costoAdicional;
	
	
	public Ingrediente(String Pnombre, Integer PcostoAdicional) {
		nombre = Pnombre;
		costoAdicional = PcostoAdicional;
	}
	
	public String getNombre() {
		return nombre;
	}
	public Integer getCostoAdicional() {
		return costoAdicional;
	}
	
}

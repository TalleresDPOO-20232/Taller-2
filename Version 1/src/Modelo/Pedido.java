package Modelo;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Pedido {
	private static Integer numeroPedidos = 0;
	private static Double IVA = 0.19;
	private Integer id;
	private String cliente;
	private String direccion;
	private List<Producto> itemsPedido;
	public Pedido(String Pcliente, String Pdireccion) {
		numeroPedidos = numeroPedidos +1;
		id = numeroPedidos;
		cliente = Pcliente;
		direccion = Pdireccion;
		itemsPedido = new ArrayList<Producto>();
	}
	public Integer getIdPedido() {
		return id;
	}
	
	public void agregarProducto(Producto nuevoItem) {
		
	}
	
	private Integer getPrecioNetoPedido() {
		
		return 1;
	}
	private Integer getPrecioTotalPedido() {
		
		return 1;
	}
	private Integer getIVAPedido() {
		
		return 1;
	}
	
	private Integer generarTextoFactura() {
		
		return 1;
	}
	public void guardarFactura(File name) {
		
		
	}
}

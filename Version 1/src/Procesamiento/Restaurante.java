package Procesamiento;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Scanner;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import Modelo.ProductoMenu;
import Modelo.Combo;
import Modelo.Ingrediente;
import Modelo.Pedido;
import Modelo.Producto;
import Modelo.ProductoAjustado;


public class Restaurante {
	private List <Ingrediente> ingredientes;
	private List <ProductoMenu> menuBase;
	private List <Combo> combos;
	private List <Pedido> pedidos;
	private Pedido pedidoEnCurso;
	private static Scanner scanner = new Scanner(System.in);
	private int pos = 0;
	private int posf;
	private String data;
	public Restaurante() {
				
	}
	public void cargarInformacionRestaurante(File archivoIngredientes, File archivoMenu, File archivoCombos) throws IOException {
		cargarIngredientes(archivoIngredientes);
		cargarMenu(archivoMenu);
		cargarCombos(archivoCombos);
	}
	private void cargarIngredientes(File archivoIngredientes) throws IOException {
		FileReader lector = new FileReader(archivoIngredientes);	
		BufferedReader BuffIngr = new BufferedReader(lector);
		String data = BuffIngr.readLine();
		while (data != null) {
			String[] info = data.split(";");
			int precio = Integer.parseInt(info[1]);
			Ingrediente ingrediente = new Ingrediente(info[0], precio);
			ingredientes.add(ingrediente);
			data = BuffIngr.readLine();
		}
		BuffIngr.close();
	}
	
	private void cargarMenu(File archivoMenu) throws IOException {
		FileReader lector = new FileReader(archivoMenu);	
		BufferedReader BuffMenu = new BufferedReader(lector);
		String data = BuffMenu.readLine();
		while (data != null) {
			String[] informacion = data.split(";");
			int precio = Integer.parseInt(informacion[1]);
			ProductoMenu menu = new ProductoMenu(informacion[0], precio);
			menuBase.add(menu);
			data = BuffMenu.readLine();
		}
		BuffMenu.close();
	}
	
	private void cargarCombos(File archivoCombos) throws IOException {
		FileReader lector = new FileReader(archivoCombos);	
		BufferedReader BuffCombo = new BufferedReader(lector);
		String data = BuffCombo.readLine();
		while (data != null) {
			String[] informacion = data.split(";");
			int desc= Integer.parseInt(informacion[1].split("%")[0]);
			Double descuento =(double) (desc/100);
			Combo comboact = new Combo(informacion[0], descuento);
			for (int i = 2; i < informacion.length; i++) {
				int precio = 0;
				for (int j=0; i< ingredientes.size(); j++) {
					if  (ingredientes.get(j).getNombre().equals(informacion[i])) {
						precio = ingredientes.get(j).getCostoAdicional();
					};
				}
				ProductoMenu producto = new ProductoMenu(informacion[i], precio);
				comboact.agregarItemACombo(producto);
			}
			combos.add(comboact);
			data = BuffCombo.readLine();
		}
		BuffCombo.close();
	}
	public void iniciarPedido(String cliente, String direccion ) {
		Pedido ActPedido = new Pedido(cliente, direccion);
		int opcion;
		do {
			menu1Pedir();
			System.out.println("Seleccione una opción: ");
            opcion = scanner.nextInt();
            switch (opcion) {
                case 1:
                	System.out.println("\nSelecciones una opcion del menu\n");
                	for(int i = 1; i<menuBase.size()+1; i++) {
                		String data = i + ". " +menuBase.get(i-1).getNombre();
                		System.out.println(data);
                	}
                	posf = menuBase.size()+1;
                	data = posf + ". Regresar al menu anterior. ";
            		System.out.println(data);
                	pos = scanner.nextInt() - 1;
                	if (pos < menuBase.size()) {
                		ProductoMenu agrMenu = menuBase.get(pos-1);
                		ActPedido.agregarProducto(agrMenu);
                	}
                    break;
                case 2:
                	
                	System.out.println("\nSelecciones una opcion de combos\n");
                	for(int i = 1; i<combos.size()+1; i++) {
                		data = i + ". " +combos.get(i-1).getNombre();
                		System.out.println(data);
                	}
                	posf = combos.size()+1;
                	data = posf + ". Regresar al menu anterior. ";
            		System.out.println(data);
                	pos = scanner.nextInt() - 1;
                	
                	if (pos < combos.size()) {
                		Combo agrCombo = combos.get(pos-1);
                		ActPedido.agregarProducto(agrCombo);
                	}
                    break;
                case 3:
                	System.out.println("\nSeleccion una opcion del menu como producto base\n");
                	for(int i = 1; i<menuBase.size()+1; i++) {
                		data = i + ". " +menuBase.get(i-1).getNombre();
                		System.out.println(data);
                	}
                	posf = menuBase.size()+1;
                	String data = posf + ". Regresar al menu anterior. ";
            		System.out.println(data);
                	pos = scanner.nextInt() - 1;
                	if (pos < menuBase.size()) {
                		ProductoMenu agrMenu = menuBase.get(pos-1);
                		ProductoAjustado ProdAjus= new ProductoAjustado(agrMenu);
                		boolean continuar = true;
                		while(continuar) {
                			System.out.println("\nAgregar o eliminar ingredientes\n");
                			System.out.println("1. Agregar ingredientes");
                			System.out.println("2. Eliminar ingredientes");
                			System.out.println("3. Salir");
                			int ingr = scanner.nextInt();
                			if (ingr== 1) {
                				
                			}
                		}
                		ActPedido.agregarProducto(ProdAjus);
                	}
                    break;
                case 4:
                    break;
                default:
                    System.out.println("Opcion Invalida intente nuevamente");
            }
        } while (opcion != 4);
	}
	public void ingredienesopcion() {
		
		
	}
	public void menu1Pedir() {
		System.out.println("\nPedido creado, opciones del nuevo pedido\n");
		System.out.println("1. Agregar elementos del menu");
		System.out.println("2. Agregar un combo");
		System.out.println("3. Agregar un producto ajustado");
		System.out.println("4. Finalizar pedido");
	}
	
	public void cerraryGuardarPedido() {
		
	}
	public Pedido getPedidoEnCurso() {
		Pedido pedidoAct = null;
		return pedidoAct;
	}
	
	public List<ProductoMenu> getMenuBase(){
		
		return menuBase;
	}
	
	public List <Ingrediente> getIngredientes(){
		
		return ingredientes;
	}
	
}

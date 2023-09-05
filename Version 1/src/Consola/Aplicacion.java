package Consola;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import Procesamiento.Restaurante;



public class Aplicacion {
	private Restaurante restaurante;
	

	public void ejecutarOpcion()
	{
		System.out.println("Bienveenido al restaurante \n");
		restaurante = new Restaurante();
		cargarInformacion();
		boolean continuar = true;
		while (continuar)
		{
			try
			{
				mostrarMenu();
				int opcion_seleccionada = Integer.parseInt(input("Por favor seleccione una opción"));
				if (opcion_seleccionada == 1)
					mostrarMenu();
				else if (opcion_seleccionada == 2) {
					String cliente = input("Por favor ingrese el nombre del cliente");
					String direccion= input("Por favor ingrese la direccion del cliente");
					restaurante.iniciarPedido(cliente,direccion);
				}
					
				else if (opcion_seleccionada == 3)
				else if (opcion_seleccionada == 4)
				else if (opcion_seleccionada == 5)
				else if (opcion_seleccionada == 6)
				{
					System.out.println("Saliendo de la aplicación ...");
					continuar = false;
				}
				else
				{
					System.out.println("Por favor seleccione una opción válida.");
				}
			}
			catch (NumberFormatException e)
			{
				System.out.println("Debe seleccionar uno de los números de las opciones.");
			}
		}
	}

	public void mostrarMenu()
	{	System.out.println("\nBienvenido al Restaurante \n");
		System.out.println("\nOpciones de la aplicación\n");
		System.out.println("1. Mostrar el menú");
		System.out.println("2. Iniciar nuevo pedido");
		System.out.println("3. Agregar un elemento a un pedido");
		System.out.println("4. Cerrar un pedido y guardar la factura");
		System.out.println("5. Consultar la información de un pedido dado su id");
		System.out.println("6. Salir de la aplicación\n");
	}
	private void cargarInformacion() throws IOException {
		File ingredientes = new File("./data/ingredientes.txt");
		File menu = new File("./data/menu.txt");
		File combos = new File("./data/combos.txt");
		restaurante = new Restaurante();
		restaurante.cargarInformacionRestaurante(ingredientes, menu, combos);
		
	}
	public String input(String mensaje)
	{
		try
		{
			System.out.print(mensaje + ": ");
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			return reader.readLine();
		}
		catch (IOException e)
		{
			System.out.println("Error leyendo de la consola");
			e.printStackTrace();
		}
		return null;
	}
	
	public static void main(String[] args)
	{

		Aplicacion aplicacion = new Aplicacion();
		aplicacion.ejecutarOpcion();
	}
}


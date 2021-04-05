package unidad8.colecciones;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalTime;
import java.util.LinkedList;
import java.util.Queue;

public class Ejercicio9 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Queue<Producto> productos = new LinkedList<>();
		Queue<Robot> robots = new LinkedList<>();
LocalTime horaComienzo = null;
		
		while (robots.isEmpty()) {
		System.out.print("> ");
		try {
		for (String rbt: br.readLine().split(";")) {
			String[] rbtArray = rbt.split("-");
			robots.add(new Robot(rbtArray[0], Integer.parseInt(rbtArray[1])));
			}
		} catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("Entrada no válida.");
		} catch(NumberFormatException e) {
			System.out.println("Introduzca un entero para el tiempo de procesamiento del robot en segundos.");
		}
		}
		while (horaComienzo == null) {
			System.out.print("> ");
			try {
			String[] hora = br.readLine().split(":");
			horaComienzo = LocalTime.of(Integer.parseInt(hora[0]), Integer.parseInt(hora[1]), Integer.parseInt(hora[2]));
			} catch(ArrayIndexOutOfBoundsException e) {
				System.out.println("Entrada no válida.");
			} catch(NumberFormatException e) {
				System.out.println("Entrada no válida. El formato es hh:mm:ss.");
			}
		}
		for (Robot r: robots)
			r.setHora(horaComienzo);

		System.out.print("> ");
		String línea;
			while (!(línea = br.readLine()).equalsIgnoreCase("fin")) {
				if (!línea.isBlank())
				productos.add(new Producto(línea));
				else System.out.println("Introduzca el nombre de algún producto.");
			System.out.print("> ");
		}
			
while (!productos.isEmpty()) {
	horaComienzo = horaComienzo.plusSeconds(1);
	String primeroLínea = productos.peek().getNombre();
	for (Robot r: robots) {
		if (primeroLínea.equals(productos.peek().getNombre()) && (horaComienzo.isAfter(r.getHora()) || horaComienzo.toString().equals(r.getHora().toString())))
			System.out.println(r.procesar(productos.poll(), horaComienzo));
	}
	if (!productos.isEmpty() && primeroLínea.equals(productos.peek().getNombre()))
		productos.add(productos.poll());
}
	}

}

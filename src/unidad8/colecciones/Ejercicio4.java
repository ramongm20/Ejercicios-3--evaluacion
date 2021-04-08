package unidad8.colecciones;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Ejercicio4 {

	static Palabras palabras = new Palabras();
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		while (ejecutar(in.readLine()));
	}
	
	static boolean ejecutar(String linea) {
		Scanner s = new Scanner(linea);
		try {
			String cmd = s.next("añadir:|lista|borrar|borrar:|fin");
			switch (cmd) {
			case "añadir:":
				cmdAñadir(s);
				break;
			case "lista": 
				cmdLista(s);
				break;
			case "borrar":
			case "borrar:":
				cmdBorrar(s);
				break;
			case "fin":
				return false;
			}
		} catch (NoSuchElementException e) {
			System.out.println("no se reconoce el comando");
		} finally {
			s.close();
		}
		return true;
	}
	
	static void cmdAñadir(Scanner s) {
		palabras.addPalabras(s.nextLine());
	}
	
	static void cmdBorrar(Scanner s) {
		palabras = new Palabras();
		if (s.hasNext())
			palabras.addPalabras(s.nextLine());
	}
	
	static void cmdLista(Scanner s) {
		System.out.println(palabras.listaPalabras(s.nextInt()));
	}

}

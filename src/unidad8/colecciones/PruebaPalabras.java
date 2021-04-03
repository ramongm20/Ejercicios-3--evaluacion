package unidad8.colecciones;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class PruebaPalabras {

	public static void main(String[] args) throws IOException {
		Palabras plbrs = new Palabras();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

System.out.print("> ");
Scanner sc;
String entrada;
while (!((entrada = br.readLine()).equals("fin"))) {
	sc = new Scanner(entrada);
	try {
	String comando = sc.next("texto:|lista|borrar|borrar:");
	switch (comando) {
	case "texto:":
		while (sc.hasNext())
			plbrs.addPalabra(sc.next());
		break;
	case "lista":
		try {
			int nºPalabras = sc.nextInt();
			if (nºPalabras>0 && nºPalabras<plbrs.size()) {
				Iterator<String> it = plbrs.iterator();
				int i=0;
				while (it.hasNext() && i<nºPalabras) {
					i++;
					System.out.print(it.next() + " ");
				}
				System.out.println();
			} else System.out.println("Introduzca un número de palabras válido.");
		} catch(InputMismatchException e) {
			System.out.println("Debe indicar un número de palabras de la lista menor o igual que las almacenadas.");
		}
		break;
	case "borrar":
		plbrs.clear();
		break;
	case "borrar:":
		plbrs.clear();
		while (sc.hasNext())
			plbrs.addPalabra(sc.next());
		break;
		default:
	}
	} catch(InputMismatchException e) {
		System.out.println("Comando no válido.");
	} catch(NoSuchElementException e) {
		System.out.println("Introduzca un comando válido.");
	}
	System.out.print("> ");
	sc.close();
}
	}

}

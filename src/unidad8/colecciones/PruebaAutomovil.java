package unidad8.colecciones;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class PruebaAutomovil {
public static void main(String[] args) throws IOException {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	Scanner sc;
	ArrayList<Automovil> autos = new ArrayList<>();
	
	int n = 0;
		while (n<1) {
			System.out.print("#> ");
			try {
				n = Integer.parseInt(br.readLine());
			} catch (NumberFormatException e) {
				System.out.println("Introduzca el número de coches.");
			}
		}
	for (int i=1; i<=n; i++) {
		System.out.print(i + "> ");
		sc = new Scanner(br.readLine());
		try {
		autos.add(new Automovil(sc.next(), sc.nextDouble(), sc.nextDouble(), sc.nextDouble()));
		sc.close();
		} catch(InputMismatchException e) {
			System.out.println("Entrada no válida");
			i--;
		} catch (NoSuchElementException e) {
			System.out.println("Entrada no válida.");
			i--;
		} catch(RuntimeException e) {
		System.out.println(e.getMessage());
		i--;
		}
	}

System.out.println("> ");
String entrada;
	while (!((entrada = br.readLine()).equals("fin"))) {
		sc = new Scanner(entrada);
		try {
		sc.next("desplazar");
		String modelo = sc.next();
		if (!Automovil.getModelos().contains(modelo))
			throw new RuntimeException("No existe el modelo.");
			for (Automovil a: autos) {
				if (a.getModelo().equalsIgnoreCase(modelo)) {
					Double consumido = a.desplazar(sc.nextInt());
					if (consumido != null)
						System.out.printf("%s %.2f %.2f\n", a.getModelo(), a.getCantidadCombustible(), consumido);
					else System.out.println("Combustible insuficiente para este desplazamiento.");
				}
			} // cierra for
			sc.close();
		} catch(InputMismatchException e) {
			System.out.println("Entrada no válida");
		} catch (NoSuchElementException e) {
			System.out.println("Entrada no válida.");
		} catch(RuntimeException e) {
			System.out.println(e.getMessage());
		}
		System.out.println("> ");
	} // cierra while
	autos.forEach(a -> System.out.println(a));
}
}

package unidad8.colecciones;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Scanner;

public class Ejercicio1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
Collection<String> nombres;
System.out.print("> ");
int nºnombres = sc.nextInt();
nombres = new ArrayList<>(nºnombres);
for (int i=1; i<=nºnombres; i++) {
	System.out.print(i+"> ");
	String nombre = sc.next();
	if (!nombres.contains(nombre))
		nombres.add(nombre);
}
sc.close();
nombres.forEach(n -> System.out.println(n));
	}

}

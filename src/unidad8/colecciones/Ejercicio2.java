package unidad8.colecciones;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;
import java.util.Random;


public class Ejercicio2 {

	public static void main(String[] args) {
		// Almacenar en una lista 100 números aleatorios entre 1 y 100 y mostrarlos todos utilizando uno de los métodos de iteración.
		
Random r = new Random();
List<Integer> lista = new ArrayList<>(100);

for (int i=0; i<100; i++)
	lista.add(r.nextInt(99)+1);

System.out.println("Lista" + " (" + lista.size()+ ")");
for (Integer integer : lista)
	System.out.println(integer);
// Almacenar los números de la lista original en otra colección sin que se repita ninguno y mostrarlos todos usando un método de iteración diferente al anterior.

List<Integer> lista2 = new ArrayList<>(100);
addNoRepe(lista, lista2);
System.out.println("Lista2" + " (" + lista2.size()+ ")");
lista2.forEach(n -> System.out.println(n));

// Almacenar los números de la lista original en otra colección en la que se almacenen ordenados y sin que se repita ninguno y mostrarlos todos usando un método de iteración diferente al anterior.

List<Integer> lista3 = new ArrayList<>(100);
Collections.sort(lista);
addNoRepe(lista, lista3);

System.out.println("Lista3" + " (" + lista3.size()+ ")");
ListIterator<Integer> li = lista3.listIterator();
while (li.hasNext())
	System.out.println(li.next());

	}
	public static void addNoRepe(List<Integer> lista, List<Integer> lista2) {
	for (int i=0; i<lista.size(); i++) {
		int num = lista.get(i);
		if (!lista2.contains(num))
			lista2.add(num);
	}
	}

}

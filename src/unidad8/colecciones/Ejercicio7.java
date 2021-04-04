package unidad8.colecciones;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;


public class Ejercicio7 {

	public static void main(String[] args) throws IOException {
		Set<Integer> n = new TreeSet<>();
		Set<Integer> m = new TreeSet<>();

		int[] tamaños = getArray(2);
		int[] serie = getArray(tamaños[0] + tamaños[1]);
		
		for (int i=0; i<tamaños[0]; i++)
			n.add(serie[i]);
		
		for (int i=tamaños[0]; i<serie.length; i++)
			m.add(serie[i]);
		
		n.retainAll(m);
		System.out.println(n);
		
		}
		
	public static int[] getArray(int size) {
		int [] a = new int[size];
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Scanner sc;
		while (true) {
			System.out.print("> ");
			try {
				sc = new Scanner(br.readLine());
				for (int i=0; i<size; i++)
					a[i] = sc.nextInt();
				sc.close();
				break;
			} catch(InputMismatchException e) {
				System.out.println("Introduzca números enteros.");
			} catch (IOException e) {
				e.printStackTrace();
			} catch(NoSuchElementException e) {
				System.out.println("Faltan números.");
			}
		}
		return a;
	}
}

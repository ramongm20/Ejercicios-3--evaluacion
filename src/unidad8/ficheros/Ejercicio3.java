package unidad8.ficheros;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Ejercicio3 {

	public static void main(String[] args) throws IOException {
		File file;
		if (args.length == 0) {
			Scanner s = new Scanner(System.in);
			System.out.print("Ruta: ");
			file = new File(s.nextLine());
			s.close();
		}
		else
			file = new File(args[0]);
		
		try (BufferedReader br = new BufferedReader(new FileReader(file))) {
			int contCaracteres = 0;
			int contPalabras = 0;
			int contLineas = 0;
			String line;
			while ((line = br.readLine()) != null) {
				contLineas++;
				for (String palabra : line.split("\\P{L}+")) {
					contPalabras++;
					contCaracteres += palabra.length();
				}
			}
			System.out.println("Número de caracteres: " + contCaracteres);
			System.out.println("Número de palabras: " + contPalabras);
			System.out.println("Número de líneas: " + contLineas);
		} catch (IOException e) {}
	}

}

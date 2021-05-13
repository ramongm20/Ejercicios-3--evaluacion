package unidad8.ficheros;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;


public class Ejercicio6 {

	public static void main(String[] args) throws IOException{
File file1 = new File(System.getProperty("user.home")+"/desktop/el quijote utf-8.txt");
File file2 = new File(System.getProperty("user.home")+"/desktop/el quijote ISO-8859-1.txt");

BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

System.out.println("Escoja una opción:");
System.out.println("1. El Quijote UTF-8.");
System.out.println("2. El Quijote ISO.");

switch (br.readLine()) {
case "1":
	abrir(file1, StandardCharsets.UTF_8);
	break;
case "2":
	abrir(file2, StandardCharsets.ISO_8859_1);
	break;
}
br.close();
	}

	static void abrir(File file, Charset sc) throws IOException {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file), sc))) {
			int contador = 0;
			String línea;
			while ((línea = br.readLine()) != null) {
				if (contador == 41) {
				System.out.println(línea);
				break;
				}
				contador++;
			}
		}
	}
	
}


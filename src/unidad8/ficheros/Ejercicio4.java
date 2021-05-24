package unidad8.ficheros;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Ejercicio4 {

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
		
		int contCaracteres = 0;
		int contPalabras = 0;
		int contLineas = 0;
		try (BufferedReader br = new BufferedReader(new FileReader(file))) {
			String line;
			while ((line = br.readLine()) != null) {
				contLineas++;
				for (String palabra : line.split("\\P{L}+")) {
					contPalabras++;
					contCaracteres += palabra.length();
				}
			}
		} catch (IOException e) {}
		try (DataOutputStream dos = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(System.getProperty("user.home")+"/documents/ficheros.bin", true)))) {
			dos.writeUTF(file.getAbsolutePath());
			dos.writeInt(contCaracteres);
			dos.writeInt(contPalabras);
			dos.writeInt(contLineas);
		}
	}

}

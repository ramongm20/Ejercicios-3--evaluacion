package unidad8.ficheros;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Ejercicio5 {

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
		
		try (PrintWriter pw = new PrintWriter(new FileWriter(file.getAbsolutePath()+".txt"))) {
		try (DataInputStream in = new DataInputStream(new BufferedInputStream(new FileInputStream(file)))) {
				try {
					while (true) {
						pw.println("Ruta: " + in.readUTF());
						pw.println("Caracteres: " + String.valueOf(in.readInt()));
						pw.println("Palabras: " + String.valueOf(in.readInt()));
						pw.println("Líneas: " + String.valueOf(in.readInt()));
					}
			} catch (EOFException e) {
				System.out.println("Lectura correcta.");
			}
		} catch (IOException e) {
			System.out.println(e);
		}
		} catch (IOException e) {
			System.out.println(e);
		}
		System.out.println("Hecho.");
	}

}

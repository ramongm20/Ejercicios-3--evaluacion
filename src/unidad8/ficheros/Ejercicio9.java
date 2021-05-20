package unidad8.ficheros;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class Ejercicio9 {

	public static void main(String[] args) {
		ArrayList<Publicación> publicaciones = new ArrayList<>();

		publicaciones.add(new Libro("El Quijote", 1605, "Cervantes"));
		publicaciones.add(new Revista("x", 1, 1, 2021, 100));
		publicaciones.add(new Revista("Enigma", 1, 1, 2021, 100));
		publicaciones.add(new Libro("El buscón", 1603, "Quevedo"));
		
		File file = new File("biblioteca.bin");

		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file))) {
				oos.writeObject(publicaciones);
				System.out.println("Información guardada correctamente.");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
			System.out.println(ois.readObject());
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
	}

}

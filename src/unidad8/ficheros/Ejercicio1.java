package unidad8.ficheros;

import java.io.File;

public class Ejercicio1 {

	public static void main(String[] args) {
		File f = new File(args[0]);
		if (f.exists()) {
			if (f.isDirectory())
				System.out.println("La ruta es de un directorio.");
			else if (f.isFile())
				System.out.println("La ruta es de un fichero que ocupa " + f.length() + " bytes.");
			System.out.println(f.getName());
			// permisos
			System.out.println("Read: " + f.canRead());
			System.out.println("Write: " + f.canWrite());
			System.out.println("Execute: " + f.canExecute());
		} else
			System.out.println("La ruta no es válida.");
	}

}

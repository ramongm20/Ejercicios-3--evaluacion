package unidad8.ficheros;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Set;
import java.util.TreeSet;

import unidad8.colecciones.Palabras;

public class Ejercicio7 {

    public static void main(String[] args) throws IOException {
    	String path = System.getProperty("user.home") + "/desktop/";
    	Set<String> solucion = palabrasDesconocidas(path + "El Quijote UTF-8.txt", cargarLemario(path + "Lemario ES UTF-8.txt"));
    	System.out.println(solucion);
    }
 
    public static Palabras cargarLemario(String file) throws IOException {
        Palabras lemario = new Palabras();
        try (BufferedReader in = new BufferedReader(new FileReader(file))) {
            String linea;
            while ( (linea = in.readLine()) != null)
                lemario.addPalabras(linea.toLowerCase());
            System.out.println("Lemario cargado");
            return lemario;
        }
    }

    public static Set<String> palabrasDesconocidas(String file, Palabras lemario) throws IOException {
        Set<String> set = new TreeSet<>();
        try (BufferedReader in = new BufferedReader(new FileReader(file))) {
            String linea;
            while ((linea = in.readLine()) != null) {
                String[] palabras = linea.toLowerCase().split("\\P{L}+");
                for (String palabra : palabras) {
                    if (palabra.length() > 0 && !lemario.contiene(palabra))
                        set.add(palabra);
                }
            }
            return set;
        }
    }

}

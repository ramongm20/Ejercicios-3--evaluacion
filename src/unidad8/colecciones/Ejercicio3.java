package unidad8.colecciones;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Ejercicio3 {

	public static void main(String[] args) throws IOException {
BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
System.out.print("> ");
Set<String> sinRepetir = new HashSet<>();
Set<String> repetidas = new HashSet<>();

for (String palabra: br.readLine().split(" ")) {
	if (sinRepetir.contains(palabra)) {
		repetidas.add(palabra);
		sinRepetir.remove(palabra);
	} else if (!repetidas.contains(palabra))
	sinRepetir.add(palabra);
}
System.out.println("Sin repetir: "+ sinRepetir);
System.out.println("Repetidas: " + repetidas);
	}

}

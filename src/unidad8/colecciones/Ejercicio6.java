package unidad8.colecciones;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class Ejercicio6 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Map<String, String> agenda = new TreeMap<>();
		
		String entrada;
		System.out.print("> ");
		while (!(entrada = br.readLine()).equalsIgnoreCase("salir")) {
			String[] tokens = entrada.split(":");
			for (int i=0; i<tokens.length; i++)
				tokens[i] = tokens[i].trim();

			try {
				if (tokens.length > 2 || tokens[0].isBlank() || (tokens.length == 1 && !tokens[0].matches("contactos")))
					throw new RuntimeException("Entrada no válida");
				
				switch (tokens[0]) {
				case "buscar":
					String nombreB = tokens[1];
					if (agenda.containsKey(nombreB))
						System.out.println("Teléfono: " + agenda.get(nombreB));
					else System.out.println("El contacto no existe.");
					break;
				case "eliminar":
					String nombreE = tokens[1];
					if (agenda.containsKey(nombreE)) {
						System.out.println("¿Eliminar " + nombreE + " de la agenda? (s/n)");
						System.out.print("> ");
						String in;
						while (!(in = br.readLine()).equalsIgnoreCase("s") && !in.equalsIgnoreCase("n")) {
							System.out.println("Entrada no válida.");
							System.out.print("> ");
						}
						if (in.equalsIgnoreCase("s")) {
							agenda.remove(nombreE);
							System.out.println("Contacto eliminado.");
						} else System.out.println("Cancelado.");
					} else System.out.println("El contacto no existe.");
					break;
				case "contactos":
					Set<Map.Entry<String, String>> entradas = agenda.entrySet();
					entradas.forEach(e -> System.out.println(e.getKey() + ": " + e.getValue()));
					break;
				default:
					if (!tokens[1].matches("\\d+")) {
						System.out.println("El formato para el teléfono es solo numérico.");
					} else {
						String nombre = tokens[0];
						String tlf = tokens[1];
						if (agenda.containsKey(nombre))
							agenda.replace(nombre, agenda.get(nombre) + ", " + tlf);
						else agenda.put(nombre, tlf);
					}
					break;
				}
			
			} catch(RuntimeException e) {
				System.out.println(e.getMessage());
			}
			System.out.print("> ");
		}
	}

}

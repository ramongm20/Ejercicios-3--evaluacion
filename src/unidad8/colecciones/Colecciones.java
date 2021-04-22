package unidad8.colecciones;

import java.util.Set;

public class Colecciones {

	static void eliminarLasDeLongitudPar(Set<String> cadenas) {
		cadenas.removeIf(s -> s.length() % 2 == 0);
	}
}


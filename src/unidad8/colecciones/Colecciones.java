package unidad8.colecciones;

import java.util.Map;
import java.util.Set;

public class Colecciones {

	static void eliminarLasDeLongitudPar(Set<String> cadenas) {
		cadenas.removeIf(s -> s.length() % 2 == 0);
	}

	static boolean contieneImpares(Set<Integer> enteros) {
		return enteros.stream().anyMatch(n -> n % 2 == 1);
	}

	static boolean valoresUnicos(Map<String, String> mapa) {
		return mapa.values().stream().distinct().count() != mapa.values().size();
	}

}

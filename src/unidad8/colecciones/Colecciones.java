package unidad8.colecciones;

import java.util.HashMap;
import java.util.List;
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
static boolean algunaSeRepiteAlMenos3Veces(List<String> lista) {
	Map<String, Integer> mapa = new HashMap<>();
	for (String s: lista)
		if (mapa.containsKey(s))
			if (mapa.get(s) == 2)
				return true;
			else
				mapa.put(s, mapa.get(s) + 1);
		else
			mapa.put(s, 1);
	return false;
	
//	return lista.stream().collect(HashMap<String, Integer>::new, (a, b) -> a.put(b, a.containsKey(b) ? a.get(b) + 1 : 1), (a, b) -> {}).values().stream().anyMatch(value -> value >= 3);

}
}

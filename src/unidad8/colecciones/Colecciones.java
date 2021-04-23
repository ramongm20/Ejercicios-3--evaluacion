package unidad8.colecciones;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;
import java.util.Queue;
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
		for (String s : lista)
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

	public static void duplicar(Deque<Integer> pila) {
		Deque<Integer> aux = new LinkedList<>();
		while (!pila.isEmpty())
			aux.push(pila.pop());
		while (!aux.isEmpty()) {
			int n = aux.pop();
			pila.push(n);
			pila.push(n);
		}
	}

	static void negativosAbajoPositivosArriba(Deque<Integer> pila) {
		Queue<Integer> aux = new PriorityQueue<>();
		while (!pila.isEmpty())
			aux.add(pila.pop());
		while (!aux.isEmpty())
			pila.push(aux.poll());
	}

	static int moda(List<Integer> lista) {
		if (lista.isEmpty())
			return 0;

		Map<Integer, Integer> mapa = new HashMap<>();
		for (Integer n : lista)
			if (mapa.containsKey(n))
				mapa.put(n, mapa.get(n) + 1);
			else
				mapa.put(n, 1);

		int repeticiones = 0;
		int moda = 0;

		Iterator<Entry<Integer, Integer>> iter = mapa.entrySet().iterator();

		while (iter.hasNext()) {
			Entry<Integer, Integer> e = iter.next();
			if (e.getValue() > repeticiones) {
				moda = e.getKey();
				repeticiones = e.getValue();
			}
		}
		return moda;
	}

	static void eliminarSiMayoresEncima(Deque<Integer> pila) {
		Deque<Integer> aux = new ArrayDeque<>();

		while (!pila.isEmpty()) {
			Integer tope = pila.pop();
			aux.push(tope);
			while (!pila.isEmpty() && pila.peek() < tope)
				pila.pop();
		}
		while (!aux.isEmpty())
			pila.push(aux.pop());

	}
}

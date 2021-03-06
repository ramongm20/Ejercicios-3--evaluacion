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
import java.util.TreeMap;

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

	static Map<String, Integer> interseccion(Map<String, Integer> m1, Map<String, Integer> m2) {
		Set<Map.Entry<String, Integer>> s1 = m1.entrySet();
		Set<Map.Entry<String, Integer>> s2 = m2.entrySet();
		Map<String, Integer> m3 = new TreeMap<>();

		s1.retainAll(s2);
		s1.forEach(e -> m3.put(e.getKey(), e.getValue()));

		return m3;
	}

	static int valorMenosRepetido(Map<String, Integer> mapa) {
		Map<Integer, Integer> frecuenciaEdad = new HashMap<>();
		for (Integer n : mapa.values()) {
			if (frecuenciaEdad.containsKey(n))
				frecuenciaEdad.put(n, frecuenciaEdad.get(n) + 1);
			else
				frecuenciaEdad.put(n, 1);
		}
		int repeticiones = mapa.size();
		PriorityQueue<Integer> edad = new PriorityQueue<>();

		Iterator<Entry<Integer, Integer>> iter = frecuenciaEdad.entrySet().iterator();

		while (iter.hasNext()) {
			Entry<Integer, Integer> e = iter.next();
			if (e.getValue() < repeticiones) {
				edad.clear();
				edad.add(e.getKey());
				repeticiones = e.getValue();
			}
		}
		return edad.peek();
	}

	static int contarComunes(List<Integer> l1, List<Integer> l2) {
		l1.retainAll(l2);
		return (int) l1.stream().distinct().count();
	}

	static Map<String, Integer> cuentaPares(List<String> lista) {
		Map<String, Integer> pares = new TreeMap<>();
		for (String s : lista) {
			for (int i = 0; i < s.length() - 1; i++) {
				String par = s.substring(i, i + 2);
				if (pares.containsKey(par))
					pares.put(par, pares.get(par) + 1);
				else
					pares.put(par, 1);
			}
		}
		return pares;
	}
}

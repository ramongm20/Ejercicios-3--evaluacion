package unidad8.colecciones;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class Palabras {
	
	private Map<Integer, Set<String>> mapa;
	
	public Palabras() {
		mapa = new TreeMap<>();
	}
	
	public Palabras(String texto) {
		addPalabras(texto);
	}
	
	private void add(String palabra) {
		int l = palabra.length();
		Set<String> palabras = mapa.get(l);
		if (palabras == null) {
			palabras = new TreeSet<>();
			mapa.put(l, palabras);
		}
		palabras.add(palabra);
	}
	
	public void addPalabras(String texto) {
		for(String palabra: texto.split("\\P{L}+"))
			add(palabra);
	}
	
	public boolean contiene(String palabra) {
		try {
			return mapa.get(palabra.length()).contains(palabra);
		} catch (NullPointerException e) {
			return false;
		}
	}
	public Set<String> listaPalabras(int n) {
		return mapa.get(n);
	}
}

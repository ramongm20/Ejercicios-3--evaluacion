package unidad8.colecciones;

import java.util.TreeSet;

public class Palabras extends TreeSet<String> {

	private static final long serialVersionUID = 1L;
	public Palabras() {
		super();
	}
public Palabras (String palabras) {
	super();
	for (String p: palabras.split(" "))
		this.add(p);
}
	public void addPalabra(String p) {
		this.add(p);
	}
	public void addCadenaPalabras(String palabras) {
		for (String p: palabras.split(" "))
		this.add(p);
	}
}

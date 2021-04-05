package unidad8.colecciones;

import java.time.LocalTime;

public class Robot {

	private String nombre;
	private int tiempoProcesamiento;
	private LocalTime hora;
	public Robot(String nombre, int tiempoProcesamiento) {
		super();
		this.nombre = nombre;
		this.tiempoProcesamiento = tiempoProcesamiento;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getTiempoProcesamiento() {
		return tiempoProcesamiento;
	}
	public void setTiempoProcesamiento(int tiempoProcesamiento) {
		this.tiempoProcesamiento = tiempoProcesamiento;
	}
public String procesar(Producto p, LocalTime h) {
	if (h.isAfter(hora) || h.toString().equals(this.getHora().toString())) {
	p.setRobot(this);
	p.setHoraComienzo(h);
	LocalTime nuevaHora = h.plusSeconds(tiempoProcesamiento);
	p.setHoraFin(nuevaHora);
	this.setHora(nuevaHora);
	return this.getNombre() + " - " + p.getNombre() + " [" + h + "]";
	}
	return null;
}
public void setHora(LocalTime h) {
	hora = h;
}
public LocalTime getHora() {
	return hora;
}
}

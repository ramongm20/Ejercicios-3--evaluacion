package unidad8.colecciones;

import java.time.LocalTime;

public class Producto {

	private String nombre;
	private Robot robot;
	private LocalTime horaComienzo;
	private LocalTime horaFin;
	public Producto(String nombre) {
		super();
		this.nombre = nombre;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Robot getRobot() {
		return robot;
	}
	public void setRobot(Robot procesador) {
		this.robot = procesador;
	}
	public LocalTime getHoraComienzo() {
		return horaComienzo;
	}
	public void setHoraComienzo(LocalTime comienzo) {
		this.horaComienzo = comienzo;
	}
	public LocalTime getHoraFin() {
		return horaFin;
	}
	public void setHoraFin(LocalTime fin) {
		this.horaFin = fin;
	}
	
}

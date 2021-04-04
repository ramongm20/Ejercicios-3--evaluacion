package unidad8.colecciones;

import java.util.Set;
import java.util.TreeSet;

/**
 * Automovil.java
 * @author Ramón García
 *
 */
public class Automovil {
	private static Set<String> modelos = new TreeSet<>();
private String modelo = "";
private double capacidadDeposito = 0d;
private double cantidadCombustible = 0d;
private double consumo = 0d;
private int kmRecorridos = 0;
private double combustibleConsumido = 0d;
/**
 * Constructor con una cantidad de litros específica en el depósito
 * @param modelo Modelo del automovil
 * @param capacidadDeposito En litros
 * @param cantidadCombustible En litros
 * @param consumo Litros por kilómetro
 */
public Automovil(String modelo, double capacidadDeposito, double cantidadCombustible, double consumo) {
	modelo = modelo.toLowerCase();
	if (!modelos.contains(modelo)) {
		modelos.add(modelo);
	this.modelo = modelo;
	} else throw new RuntimeException("Ya existe un automóvil con ese modelo.");
	this.capacidadDeposito = capacidadDeposito;
	this.cantidadCombustible = cantidadCombustible;
	this.consumo = consumo;
} // cierre constructor
/**
 *Inicia con el depósito lleno 
 * @param modelo Modelo del automóvil
 * @param capacidadDeposito Capacidad máxima del depósito
 * @param consumo Litros por kilómetro
 */
public Automovil(String modelo, double capacidadDeposito, double consumo) {
	this(modelo, capacidadDeposito, capacidadDeposito, consumo);
} // cierre constructor
/**
 * Obtiene el modelo del automóvil
 * @return Modelo del automóvil
 */
public String getModelo() {
	return modelo;
} // cierra getModelo
/**
 * Obtiene la cantidad restante de combustible
 * @return Cantidad de combustible que le queda al automóvil
 */
public double getCantidadCombustible() {
	return cantidadCombustible;
} // cierra getCantidadCombustible
/**
 * Llena el deposito de combustible hasta su capacidad máxima
 */
public void llenarDeposito() {
	cantidadCombustible = capacidadDeposito;
} // cierra llenarDeposito
/**
 * Llena el deposito con la cantidad especificada
 * @param l Combustible que se echa al depósito
 * @return Combustible que falta o que sobra
 */
public double llenarDeposito(double l) {
	double espacioLibre = capacidadDeposito - cantidadCombustible;
	if (l <= espacioLibre) {
		cantidadCombustible += l;
		return cantidadCombustible-capacidadDeposito;
} else {
		cantidadCombustible = capacidadDeposito;
		return l-capacidadDeposito;
	}
} // cierra llenarDeposito
/**
 * Desplaza el automóvil los km especificados i es posible
 * @param km Distancia que debe recorrer el automóvil
 * @return El consumo en litros del desplazamiento
 */
public Double desplazar(int km) {
	double kmPosibles = cantidadCombustible / consumo;
	if (km <= kmPosibles) {
		double consumido = km * consumo;
		cantidadCombustible -= consumido;
		kmRecorridos += km;
		combustibleConsumido += consumido;
		return consumido;
	} else return null;
} // cierra desplazar
/**
 * Sobrescribe el método toString de Object
 */
@Override
public String toString() {
	return String.format("%s %.2f %d %.2f", modelo, cantidadCombustible, kmRecorridos, combustibleConsumido);
} // cierra toString
public static Set<String> getModelos() {
	return modelos;
}
}
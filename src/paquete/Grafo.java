package paquete;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Grafo {

	private List<Nodo> nodos = new ArrayList<>();
	private MatrizSimetrica matrizAdyacencia;
	private String nombreDeGrafo;
	private int cantidadDeNodos;
	private int cantidadDeAristas;
	private double porcentajeAdyacencia;
	private int gradoMinimo;
	private int gradoMaximo;
	private int cantidadDeColoresCorridaActual;

	public Grafo(int cantNodos) {
		this.cantidadDeNodos = cantNodos;
		this.matrizAdyacencia = new MatrizSimetrica(cantNodos);

		for (int i = 0; i < cantNodos; i++) {
			nodos.add(new Nodo(i));
		}
	}

	public Grafo(String path) throws FileNotFoundException {
		File archivo = new File(path);
		Scanner entrada = new Scanner(archivo);
		this.nombreDeGrafo = path;
		this.cantidadDeNodos = entrada.nextInt();
		this.matrizAdyacencia = new MatrizSimetrica(this.cantidadDeNodos);

		for (int i = 0; i < this.cantidadDeNodos; i++) {
			this.nodos.add(new Nodo(i));
		}

		this.cantidadDeAristas = entrada.nextInt();
		entrada.useLocale(Locale.US);
		this.porcentajeAdyacencia = entrada.nextDouble();
		this.gradoMaximo = entrada.nextInt();
		this.gradoMinimo = entrada.nextInt();

		for (int j = 0; j < this.cantidadDeAristas; j++) {
			this.matrizAdyacencia.set(entrada.nextInt(), entrada.nextInt(), 1);
		}

		for (int k = 0; k < this.cantidadDeNodos; k++) {
			Nodo nodo = this.nodos.get(k);
			for (int j = 0; j < this.cantidadDeNodos; j++) {
				if (this.matrizAdyacencia.get(nodo.id, j) == 1) {
					nodo.grado++;
				}
			}
		}
		entrada.close();
	}

	public void setUnion(int nodo1, int nodo2) {
		this.matrizAdyacencia.set(nodo1, nodo2, 1);
		this.nodos.get(nodo1).grado++;
		this.nodos.get(nodo2).grado++;
	}

	public SalidaColoreo colorear(List<Integer> secuencia) {

		int cantNodosPintados = 0, colorActual = 1, j;
		boolean loPuedoPintarDelColorActual;

		int[] nodosPintados = new int[this.nodos.size()];

		// Uso algoritmo que colorea todo lo que puede con un color
		while (cantNodosPintados != nodosPintados.length) {

			for (Integer i : secuencia) {
				if (nodosPintados[i] == 0) { // No quiero que recorra nodos que ya fueron pintados.
					j = 0;
					loPuedoPintarDelColorActual = true; // Corte de control, la primera vez siempre ingresa.
					while (j < nodosPintados.length && loPuedoPintarDelColorActual) {
						if (this.matrizAdyacencia.get(i, j) == 1) {
							if (nodosPintados[j] != colorActual) {
								loPuedoPintarDelColorActual = true;
							} else {
								loPuedoPintarDelColorActual = false;
							}
						}
						j++;
					}
				} else {
					loPuedoPintarDelColorActual = false;
				}

				if (loPuedoPintarDelColorActual) {
					nodosPintados[i] = colorActual;
					cantNodosPintados++;
				}
			}

			colorActual++;// ya di una vuelta

		}

		return new SalidaColoreo(this, nodosPintados, colorActual - 1);
	}

	public MatrizSimetrica getMatrizAdyacencia() {
		return matrizAdyacencia;
	}

	public List<Nodo> getNodos() {
		return nodos;
	}

	public ArrayList<Integer> calcularSecuencial() {
		ArrayList<Integer> secuencia = new ArrayList<>();

		for (int i = 0; i < this.nodos.size(); i++) {
			secuencia.add(i);
		}
		return secuencia;
	}

	public ArrayList<Integer> calcularWheelsPower() {
		ArrayList<Integer> secuencia = new ArrayList<>();
		ArrayList<Nodo> aux = new ArrayList<>();
		
		for (int i = 0; i < this.nodos.size(); i++) {
			aux.add(new Nodo(i, this.nodos.get(i).grado));
		}
		
		Collections.sort(aux,Collections.reverseOrder());
		for(Nodo n: aux) {
			secuencia.add(n.id);
		}
		
		return secuencia;
	}

	public ArrayList<Integer> calcularMatula() {
		ArrayList<Integer> secuencia = new ArrayList<>();
		ArrayList<Nodo> aux = new ArrayList<>();
		
		for (int i = 0; i < this.nodos.size(); i++) {
			aux.add(new Nodo(i, this.nodos.get(i).grado));
		}
		
		Collections.sort(aux);
		for(Nodo n: aux) {
			secuencia.add(n.id);
		}
		
		return secuencia;
	}

}

package paquete;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Grafo {

	private List<Nodo> nodos;
	private MatrizSimetrica matrizAdyacencia;

	public Grafo(int cantNodos) {
		this.matrizAdyacencia = new MatrizSimetrica(cantNodos);
		this.nodos = new ArrayList<>();

		for (int i = 0; i < cantNodos; i++) {
			nodos.add(new Nodo(i));
		}
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

		return null;
	}
	
	public ArrayList<Integer> calcularMatula() {
		ArrayList<Integer> secuencia = new ArrayList<>();

		return null;
	}


}

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
		Nodo nodoActual, nodo;

		List<Nodo> nodosColoreados = new ArrayList<>();
		nodosColoreados.addAll(this.nodos); // Creo un nuevo grafo

		// Uso algoritmo que colorea todo lo que puede con un color
		while (cantNodosPintados != nodosColoreados.size()) {

			for (Integer i : secuencia) {
				nodo = nodosColoreados.get(i);
				if (nodo.color == 0) { // No quiero que recorra nodos que ya fueron pintados.
					j = 0;
					loPuedoPintarDelColorActual = true; // Corte de control, la primera vez siempre ingresa.
					while (j < nodosColoreados.size() && loPuedoPintarDelColorActual) {
						nodoActual = nodosColoreados.get(j);
						if (this.matrizAdyacencia.get(nodo.id, nodoActual.id) == 1) {
							if (nodoActual.color != colorActual) {
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
					nodosColoreados.get(nodo.id).pintar(colorActual);
					cantNodosPintados++;
				}
			}

			colorActual++;// ya di una vuelta

		}

		return new SalidaColoreo(this, nodosColoreados, colorActual - 1);
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

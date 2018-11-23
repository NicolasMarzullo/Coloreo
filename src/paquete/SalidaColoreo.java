package paquete;

import java.util.List;

public class SalidaColoreo {

	private Grafo grafo;
	private int[] nodosColoreados;
	private int cantDeColorUsuados;

	public SalidaColoreo(Grafo grafo, int[] nodosColoreados, int cantDeColorUsuados) {
		this.grafo = grafo;
		this.nodosColoreados = nodosColoreados;
		this.cantDeColorUsuados = cantDeColorUsuados;
	}
	
	@Override
	public String toString() {
		System.out.println("CANTIDAD DE COLORES USADOS: " + cantDeColorUsuados);
		for (int i = 0; i < this.nodosColoreados.length; i++) {
			System.out.println("Nodo: " + i + "   Color: " + nodosColoreados[i]);
		}

//		this.grafo.getMatrizAdyacencia().imprimirGradosDeLosNodos();
		return null;
	}

}

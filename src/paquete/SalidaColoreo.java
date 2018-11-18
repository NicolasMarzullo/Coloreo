package paquete;

import java.util.List;

public class SalidaColoreo {

	private Grafo grafo;
	private List<Nodo> nodosColoreados;
	private int cantDeColorUsuados;
	
	public SalidaColoreo(Grafo grafo, List<Nodo> nodosColoreados, int cantDeColorUsuados) {
		this.grafo = grafo;
		this.nodosColoreados = nodosColoreados;
		this.cantDeColorUsuados = cantDeColorUsuados;
	}

	@Override
	public String toString() {
		System.out.println("CANTIDAD DE COLORES USADOS: " + cantDeColorUsuados);
		for(Nodo n: this.nodosColoreados) {
			System.out.println(n);
		}
		
		this.grafo.getMatrizAdyacencia().imprimirGradosDeLosNodos();
		return null;
	}
	

	
	
	
}

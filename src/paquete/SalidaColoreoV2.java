package paquete;

import java.util.List;

public class SalidaColoreoV2 {

	private List<Nodo> grafoColoreado;
	private int cantDeColoresUsados;
	
	
	public SalidaColoreoV2(List<Nodo> grafoColoreado, int cantDeColoresUsados) {
		this.grafoColoreado = grafoColoreado;
		this.cantDeColoresUsados = cantDeColoresUsados;
	}


	@Override
	public String toString() {
		
		System.out.println("Cantidad de colores usados: " + this.cantDeColoresUsados);
		for(Nodo n: this.grafoColoreado) {
			System.out.println("NODO: " + n.id + "  Color" + n.color);
		}
		
		return null;
	}
	
	
	
}

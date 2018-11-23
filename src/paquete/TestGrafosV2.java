package paquete;

import org.junit.Test;

import generador.Generador;
import generador.Regular;

public class TestGrafosV2 {
	
	@Test
	public void testSecuencial() {
		Grafo g = new Grafo(5);
		g.setUnion(0, 1);
		g.setUnion(0, 2);
		g.setUnion(1, 3);
		g.setUnion(2, 3);
		g.setUnion(3, 4);
		
		SalidaColoreoV2 salida = g.colorearV2(g.calcularSecuencial());
		
		salida.toString();
		
	}
	
	@Test
	public void testSecuencialOtro() {
		Grafo g = new Grafo(8);
		g.setUnion(0, 1);
		g.setUnion(0, 3);
		g.setUnion(1, 2);
		g.setUnion(2, 3);
		g.setUnion(1, 4);
		g.setUnion(3, 6);
		g.setUnion(4, 5);
		g.setUnion(5, 6);
		g.setUnion(5, 7);
		
		SalidaColoreoV2 salida = g.colorearV2(g.calcularSecuencial());
		
		salida.toString();
		
	}
	
	
	@Test
	public void testSecuencialGenerado() {
		Generador gen = new Regular(10000,70);
		
		try {
			gen.generar();
			gen.calcularParametrosDelGrafo();
			gen.escribirEnArchivo("grafosGenerados/g1.in");
			Grafo g = new Grafo("grafosGenerados/g1.in");
			SalidaColoreoV2 salida = g.colorearV2(g.calcularSecuencial());
			salida.toString();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	@Test
	public void testRegularDeparcial() {
		Grafo g = new Grafo(12);
		g.setUnion(0, 1);
		g.setUnion(0, 5);
		g.setUnion(1, 2);
		g.setUnion(2, 3);
		g.setUnion(3, 4);
		g.setUnion(4, 5);
		g.setUnion(0, 6);
		g.setUnion(1, 7);
		g.setUnion(8, 2);
		g.setUnion(9, 3);
		g.setUnion(4, 10);
		g.setUnion(5, 11);
		g.setUnion(11, 10);
		g.setUnion(10, 9);
		g.setUnion(9, 8);
		g.setUnion(8, 7);
		g.setUnion(6, 7);
		
		
		SalidaColoreoV2 salida = g.colorearV2(g.calcularSecuencial());
		
		salida.toString();
		
	}
//	
//	@Test
//	public void testMatula() {
//		Grafo g = new Grafo(5);
//		g.setUnion(0, 1);
//		g.setUnion(0, 2);
//		g.setUnion(1, 3);
//		g.setUnion(2, 3);
//		g.setUnion(3, 4);
//		
//		SalidaColoreo salida = g.colorear(g.calcularMatula());
//		
//		salida.toString();
//		
//	}
//	
//	@Test
//	public void testWheelsPower() {
//		Grafo g = new Grafo(5);
//		g.setUnion(0, 1);
//		g.setUnion(0, 2);
//		g.setUnion(1, 3);
//		g.setUnion(2, 3);
//		g.setUnion(3, 4);
//		
//		SalidaColoreo salida = g.colorear(g.calcularWheelsPower());
//		salida.toString();
//		
//	}

}

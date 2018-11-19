package paquete;

import org.junit.Test;

import generador.Generador;
import generador.Regular;

public class TestsGrafos {
	
	@Test
	public void testSecuencial() {
		Grafo g = new Grafo(5);
		g.setUnion(0, 1);
		g.setUnion(0, 2);
		g.setUnion(1, 3);
		g.setUnion(2, 3);
		g.setUnion(3, 4);
		
		SalidaColoreo salida = g.colorear(g.calcularSecuencial());
		
		salida.toString();
		
	}
	
	@Test
	public void testSecuencialExigido() {
		Generador gen = new Regular(100,99);
		
		try {
			gen.generar();
			gen.escribirEnArchivo("grafosGenerados/g1.IN");
			Grafo g = new Grafo("grafosGenerados/g1.IN");
			SalidaColoreo salida = g.colorear(g.calcularSecuencial());
			salida.toString();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
	
	
	@Test
	public void testMatula() {
		Grafo g = new Grafo(5);
		g.setUnion(0, 1);
		g.setUnion(0, 2);
		g.setUnion(1, 3);
		g.setUnion(2, 3);
		g.setUnion(3, 4);
		
		SalidaColoreo salida = g.colorear(g.calcularMatula());
		
		salida.toString();
		
	}
	
	@Test
	public void testWheelsPower() {
		Grafo g = new Grafo(5);
		g.setUnion(0, 1);
		g.setUnion(0, 2);
		g.setUnion(1, 3);
		g.setUnion(2, 3);
		g.setUnion(3, 4);
		
		SalidaColoreo salida = g.colorear(g.calcularWheelsPower());
		salida.toString();
		
	}
	
	
}

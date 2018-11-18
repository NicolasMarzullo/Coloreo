package paquete;


public class MatrizSimetrica {
	private int cantidadNodos;
	private int[][] matriz;
	private int[] gradoDeLosNodos;

	public MatrizSimetrica(int cantidadNodos) {
		this.cantidadNodos = cantidadNodos;

		this.gradoDeLosNodos = new int[cantidadNodos];
		matriz = new int[cantidadNodos][];

		for (int i = 0; i < cantidadNodos; i++) {
			matriz[i] = new int[i];
		}
	}

	public int get(int fila, int columna) {

		if (columna == fila) {
			return -1;
		}

		if (columna > fila) {
			return this.matriz[columna][fila];
		}
		return this.matriz[fila][columna];
	}

	public void set(int fila, int columna, int val) {

		if (columna == fila) {
			return;
		}

		if (columna > fila) {
			this.matriz[columna][fila] = val;
		}else {
			this.matriz[fila][columna] = val;
		}
		
		this.gradoDeLosNodos[columna]++;
		this.gradoDeLosNodos[fila]++;
	}

	public void imprimirGradosDeLosNodos() {
		for(int i =0; i<this.cantidadNodos;i++) {
			System.out.println(this.gradoDeLosNodos[i]);
		}
	}

	

}

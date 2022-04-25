

public class Nodo {
	Nodo ligaIzq, ligaDer;
	int elemento;

	public Nodo(int elemento) {
		this.elemento = elemento;
		this.ligaDer = null;
		this.ligaIzq = null;
	}
}


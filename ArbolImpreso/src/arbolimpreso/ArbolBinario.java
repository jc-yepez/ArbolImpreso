
import java.util.ArrayList;

public class ArbolBinario {
	Nodo raiz;
	ArrayList<Nodo> nodos = new ArrayList<Nodo>();

	
	boolean estaVacio() {
		return raiz == null;
	}

	public void insertar(int elemento) {
		if (estaVacio()) {
			this.raiz = new Nodo(elemento);
		} else {
			Nodo temp = raiz;
			Nodo aux = null;

			while (temp != null) {
				aux = temp;
				if (elemento < temp.elemento) {
					temp = temp.ligaIzq;
				} else {
					temp = temp.ligaDer;
				}
			}

			if (elemento < aux.elemento) {
				aux.ligaIzq = new Nodo(elemento);
			} else {
				aux.ligaDer = new Nodo(elemento);
			}

		}

	}

	private void imprimirPre(Nodo reco) {
		if (reco != null) {
			System.out.println(reco.elemento);
			imprimirPre(reco.ligaIzq);
			imprimirPre(reco.ligaDer);
		}
	}

	public void imprimirPre() {
		imprimirPre(raiz);
	}

	private int altura(Nodo nodo) {
		if (nodo == null) {
			return 0;
		} else {
			return Math.max(altura(nodo.ligaIzq), altura(nodo.ligaDer)) + 1;
		}
	}

	public int altura() {
		return altura(this.raiz);
	}

	public void imprimirArbol() {
		this.nodos.add(this.raiz);
		printTree.printNode(this.nodos, altura());

	}

}

class printTree {
	public static void printNode(ArrayList<Nodo> nodos, int altura) {
		imprimirNodoInterno(nodos, 1, 5);
	}

	private static void imprimirNodoInterno(ArrayList<Nodo> nodos, int nivel, int altura) {
		if (nodos.isEmpty() || printTree.isAllElementsNull(nodos)) {
			return;
		}

		int floor, edgeLines, firstSpaces, betweenSpaces;

		floor = altura - nivel;
		edgeLines = (int) Math.pow(2, (Math.max(floor - 1, 0)));
		firstSpaces = (int) Math.pow(2, (floor)) - 1;
		betweenSpaces = (int) (Math.pow(2, (floor + 1)) - 1);

		imprimirEspaciosBlanco(firstSpaces);

		ArrayList<Nodo> newNodes = new ArrayList<Nodo>();

		for (Nodo nodo : nodos) {
			if (nodo != null) {
				System.out.print(nodo.elemento);
				newNodes.add(nodo.ligaIzq);
				newNodes.add(nodo.ligaDer);
			} else {
				newNodes.add(null);
				newNodes.add(null);
				System.out.print(" ");
			}
			imprimirEspaciosBlanco(betweenSpaces);
		}
		System.out.println("");

		for (int i = 1; i <= edgeLines; i++) {
			for (int j = 0; j < nodos.size(); j++) {
				imprimirEspaciosBlanco(firstSpaces - i);
				if (nodos.get(j) == null) {
					imprimirEspaciosBlanco(edgeLines + edgeLines + i + 1);
					continue;
				}

				if (nodos.get(j).ligaIzq != null) {
					System.out.print("/");
				} else {
					imprimirEspaciosBlanco(1);
				}

				imprimirEspaciosBlanco(i + i - 1);

				if (nodos.get(j).ligaDer != null) {
					System.out.print("\\");
				} else {
					imprimirEspaciosBlanco(1);
				}
				imprimirEspaciosBlanco(edgeLines + edgeLines - i);
			}
			System.out.println("");
		}
		imprimirNodoInterno(newNodes, nivel + 1, altura);

	}

	private static void imprimirEspaciosBlanco(int count) {
		for (int i = 0; i < count; i++)
			System.out.print(" ");
	}

	private static boolean isAllElementsNull(ArrayList<Nodo> nodos) {
		for (Object object : nodos) {
			if (object != null)
				return false;
		}
		return true;
	}
}
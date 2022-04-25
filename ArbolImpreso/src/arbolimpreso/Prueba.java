

public class Prueba {
	public static void main(String[] args) {
		ArbolBinario ab = new ArbolBinario();
		ab.insertar(4);
		ab.insertar(3);
		ab.insertar(6);
		ab.insertar(2);
		ab.insertar(5);
		//ab.insertar(2);
		ab.insertar(7);
		//ab.insertar(3);
		//ab.insertar(1);
		ab.insertar(9);
		//ab.insertar(16);
		//ab.insertar(14);
		
		
		//ab.insertar(11);
		//ab.insertar(12);
		//System.out.println(ab.altura());
		
		//ab.imprimirPre();
		
		ab.imprimirArbol();

	}
}

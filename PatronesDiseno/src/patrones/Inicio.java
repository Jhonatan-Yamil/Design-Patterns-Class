package patrones;

public class Inicio {

	public static void main(String[] args) {
		Cliente usuario = new Cliente("Diego", 100, 1111);
		Sistema t1 = new Sistema(usuario);
		t1.inicio();
	}

}

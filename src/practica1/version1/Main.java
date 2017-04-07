package practica1.version1;

import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		Mundo mundo = new Mundo();
		Scanner sc = new Scanner(System.in);
		Controlador controlador = new Controlador(mundo, sc);
		controlador.realizarSimulacion();
	}

}

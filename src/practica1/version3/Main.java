package practica1.version3;

import java.util.Scanner;
import java.util.Vector;

public class Main {
	
	public static void main(String[] args) {
		Mundo mundo = new Mundo();
		Scanner sc = new Scanner(System.in);
		Controlador controlador = new Controlador(mundo, sc);
		controlador.pintarSuperficie();
		controlador.realizarSimulacion();
		
		/*System.out.println("------------------------------------");
		
		Vector fila=new Vector();
		
		Vector colum=new Vector();
		
		colum.add(0);
		colum.add(1);
		colum.add(2);
		colum.add(2);
		fila.add(colum);
		colum=new Vector();
		colum.add(3);
		colum.add(4);
		colum.add(5);
		colum.add(6);
		fila.add(colum);
		
		for (int i = 0; i < fila.size(); i++) {
			colum=(Vector) fila.get(i);
			for (int j = 0; j < colum.size() ; j++) {
				System.out.print(colum.get(j)+" ");
			}
			System.out.println();
		}*/
		
	}

}

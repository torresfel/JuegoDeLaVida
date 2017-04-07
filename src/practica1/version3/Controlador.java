package practica1.version3;

import java.util.Scanner;

public class Controlador {
	private Mundo mundo;
	private Scanner in;
	
	public Controlador(Mundo mundo, Scanner in){
		this.mundo = mundo;
		this.in = in;
	}
	public void realizarSimulacion(){
		String opcion;
		int x,y;
		
		do{
			opcion="";
			
			System.out.print("Introduzca opcion:");
			opcion=in.next();
			opcion=opcion.toUpperCase();
			
			switch (opcion) {
			case "PASO":
				mundo.evoluciona();
				break;
			case "INICIAR":
				mundo=new Mundo();
				break;
			case "CREARCELULA":
				//System.out.println("Introduzca coordenadas f c");				
				x=in.nextInt();
				y=in.nextInt();
				
				mundo.crearCelula(x, y);
				break;
			case "ELIMINARCELULA":
				//System.out.println("Introduzca coordenadas f c");
				x=in.nextInt();
				y=in.nextInt();
				//System.out.println("Creamos nueva celula en la posición: ("+x+","+y+")");
				mundo.getSuperficie().eliminarCelula(x, y);
				break;
			case "AYUDA":
				ayuda();
				break;
			case "VACIAR":
				System.out.println("Vaciando la superficie....");
				mundo.getSuperficie().vaciar();
				break;
			case "SALIR":
				System.out.println("Fin de la simulacion.....");
				break;
			default:
				System.out.println("El comando introducido no existe");
				break;
			}
			if(!opcion.equals("SALIR")){
				this.mundo.getSuperficie().pintarCuadro();
				System.out.println("-----------------------------------");
			}
			
			
			
			
		}while(!opcion.equals("SALIR"));
		
		System.exit(0);
		
	}
	public void ayuda(){
		System.out.println("1.-PASO: realiza un paso en la simulacion");
		System.out.println("2.-INICIAR: inicia una nueva simulación");
		System.out.println("3.-CREAR CELULA f c: crea una nueva celula en la posición (f,c) si es posible");
		System.out.println("4.-ELIMINAR CELULA f c: elimina una celula de la posición (f,c) si es posible");
		System.out.println("5.-AYUDA: muestra esta ayuda");
		System.out.println("6.-VACIAR:  crea un mundo vacío");
		System.out.println("7.-SALIR: cierra la aplicación");
	}
	public void pintarSuperficie(){
		mundo.pintarCuadro();
	}
}

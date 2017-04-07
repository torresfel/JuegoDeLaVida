package practica1.version0;

public class Mundo {
	/**
	 * superficie = Objeto de la clase superficie
	 */
	private Superficie superficie;
	/**
	 * numCels = Numero de celulas con las que se inicializa la superficie
	 */
	public static final int numCels = 6;
	/**
	 * DIMF = Numero de filas de la superficie
	 */
	public static final int DIMF = 2;
	/**
	 * DIMC = Numero de columnas de la superficie
	 */
	public static final int DIMC = 5;
	
	/**
	 * Constructora de la clase Mundo
	 */
	public static final int MAX_PASOS_SIN_MOVER = 1;
	public static final int PASOS_REPRODUCCION = 2;
	public Mundo(){
		int RandF = 0;
		int RandC = 0;
		Celula c;
		
		superficie=new Superficie(DIMF,DIMC);
		
		for (int i = 0; i < numCels; i++) {
			c = new Celula(MAX_PASOS_SIN_MOVER,PASOS_REPRODUCCION); 
			do{
				RandF = (int) (Math.random()*DIMF);
				RandC = (int) (Math.random()*DIMC);
			}while(superficie.getSuperficie()[RandF][RandC]!=null);
			
			superficie.setHuecoSuperficie(RandF,RandC,c);	
			
		}
	}
	
}

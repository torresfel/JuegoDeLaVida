package practica1.version2;

import java.lang.reflect.Array;
import java.util.Vector;


public class Mundo {
	/**
	 * superficie = Objeto de la clase superficie
	 */
	private Superficie superficie;
	/**
	 * numCels = Numero de celulas con las que se inicializa la superficie
	 */
	public static final int numCels = 5;
	/**
	 * DIMF = Numero de filas de la superficie
	 */
	public static final int DIMF = 3;
	/**
	 * DIMC = Numero de columnas de la superficie
	 */
	public static final int DIMC = 4;
	
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
	
	public Superficie getSuperficie() {
		return superficie;
	}

	public void setSuperficie(Superficie superficie) {
		this.superficie = superficie;
	}

	public void pintarCuadro(){
		superficie.pintarCuadro();
	}


	public void evoluciona(){
		boolean[][] comprobador=new boolean[practica1.version2.Mundo.DIMF][Mundo.DIMC];
		Celula c;
		Vector posValidas,coord;
		int rand;
		for (int i = 0; i < comprobador.length; i++) {
			for (int j = 0; j < comprobador[i].length; j++) {
				comprobador[i][j]=false;
			}
		}	
		for (int i = 0; i < comprobador.length; i++) {
			for (int j = 0; j < comprobador[i].length; j++) {
				if (this.superficie.getSuperficie()[i][j]!=null && comprobador[i][j]==false) {
					posValidas=new Vector();
					for (int i2 = i-1; i2 <= i+1; i2++) {
						for (int j2 = j-1; j2 <= j+1; j2++) {
							if(!(i2<0 || i2>=DIMF || j2<0 || j2>=DIMC)){
								if (this.superficie.getSuperficie()[i2][j2]==null) {
									coord=new Vector();
									coord.add(i2);
									coord.add(j2);
									posValidas.add(coord);														
								}		
							}
						}
					}
					if(!posValidas.isEmpty()){
						coord=new Vector();
						rand=(int) (Math.random()*posValidas.size());
						coord=(Vector) posValidas.get(rand);
						System.out.println("La celula ("+i+","+j+") se mueve a la posicion ("+coord.get(0)+","+coord.get(1)+")");
						c=this.superficie.getSuperficie()[i][j];						
						this.superficie.setHuecoSuperficie((int) coord.get(0),(int) coord.get(1), c);		
						if(c.getnPasos()==0){
							c.setnPasos(2);
							this.superficie.crearCelula(i, j, MAX_PASOS_SIN_MOVER, PASOS_REPRODUCCION);
							comprobador[i][j]=true;
							System.out.println("Nace nueva celula en ("+i+","+j+") cuyo padre ha sido ("+coord.get(0)+","+coord.get(1)+")");							
						}else{
							this.superficie.eliminarCelula(i, j);
							c.reducirPasoRep();
							comprobador[i][j]=false;
						}						
						comprobador[(int) coord.get(0)][(int) coord.get(1)]=true;
					}else{
						if(this.superficie.getSuperficie()[i][j].getnPasosNoMov()==0){
							System.out.println("Muere la celula de la casilla ("+i+","+j+") por inactividad");
							this.superficie.eliminarCelula(i, j);
						}else{							
							this.superficie.getSuperficie()[i][j].reducirPasoNoMov();
						}
					}					
				}
			}
		}		
	}
	public void crearCelula(int x,int y){
		if(superficie.getSuperficie()[x][y]==null){
			Celula c=new Celula(this.MAX_PASOS_SIN_MOVER,this.PASOS_REPRODUCCION);
			superficie.setHuecoSuperficie(x, y, c);
		}else{
			System.out.println("Esa posicion ya esta ocupada");
		}
	}
	
	
}

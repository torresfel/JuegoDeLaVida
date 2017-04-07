package practica1.version3;

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
		boolean[][] comprobador=new boolean[Mundo.DIMF][Mundo.DIMC];
		Celula cel;
		int[][] posValidas;
		int rand;
		for (int i = 0; i < comprobador.length; i++) {
			for (int j = 0; j < comprobador[i].length; j++) {
				comprobador[i][j]=false;
			}
		}	
		for (int f = 0; f < comprobador.length; f++) {
			for (int c = 0; c < comprobador[f].length; c++) {
				if (this.superficie.getSuperficie()[f][c]!=null && comprobador[f][c]==false) {
					posValidas=arrayPosValidas(comprobador,f,c);
					
					if(posValidas!=null){ //si se puede mover
						rand=(int) (Math.random()*posValidas.length);
						System.out.println("La celula ("+f+","+c+") se mueve a la posicion ("+posValidas[rand][0]+","+posValidas[rand][1]+")");
						cel=this.superficie.getSuperficie()[f][c];						
						this.superficie.setHuecoSuperficie(posValidas[rand][0],posValidas[rand][1], cel); //se mueve la celula a su posicion dejando una copia en su origen		
						if(cel.getnPasos()==0){//cuando se reproduce
							cel.setnPasos(2);
							this.superficie.crearCelula(f, c, MAX_PASOS_SIN_MOVER, PASOS_REPRODUCCION);
							System.out.println("Nace nueva celula en ("+f+","+c+") cuyo padre ha sido ("+posValidas[rand][0]+","+posValidas[rand][1]+")");							
						}else{
							this.superficie.eliminarCelula(f, c);
							cel.reducirPasoRep();
							comprobador[f][c]=false;
						}						
						comprobador[posValidas[rand][0]][posValidas[rand][1]]=true;
					}else{ //no se puede mover
						if(this.superficie.getSuperficie()[f][c].getnPasosNoMov()==0){
							System.out.println("Muere la celula de la casilla ("+f+","+c+") por inactividad");
							this.superficie.eliminarCelula(f, c);
						}else this.superficie.getSuperficie()[f][c].reducirPasoNoMov();
					}					
				}
			}
		}		
	}
	
	public int[][] arrayPosValidas(boolean[][] comprobador,int f,int c){
		int nPosValidas = nPosValidas(comprobador,f,c);
		int[][] posValidas=new int[nPosValidas][2];
		int iPosValidas = 0;
		for (int i2 = f-1; i2 <= f+1; i2++) {
			for (int j2 = c-1; j2 <= c+1; j2++) {
				if(!(i2<0 || i2>=DIMF || j2<0 || j2>=DIMC)){
					if (this.superficie.getSuperficie()[i2][j2]==null) {
						
						posValidas[iPosValidas][0]=i2;
						posValidas[iPosValidas][1]=j2;
						iPosValidas++;
					}		
				}
			}
		}
		
		
		return posValidas;
		
	}
	public int nPosValidas(boolean[][] comprobador,int f,int c){
		int nPosValidas=0;
		if (comprobador[f][c]==false) {
			for (int i2 = f-1; i2 <= f+1; i2++) {
				for (int j2 = c-1; j2 <= c+1; j2++) {
					if(!(i2<0 || i2>=DIMF || j2<0 || j2>=DIMC)){
						if (this.superficie.getSuperficie()[i2][j2]==null) {
							nPosValidas++;		
						}
					}
				}
			}
		}
		return nPosValidas;
		
	}
	
	public void crearCelula(int x,int y){
		if(superficie.getSuperficie()[x][y]==null){
			System.out.println("Creamos nueva celula en la posición: ("+x+","+y+")");
			Celula c=new Celula(this.MAX_PASOS_SIN_MOVER,this.PASOS_REPRODUCCION);
			superficie.setHuecoSuperficie(x, y, c);
		}else{
			System.out.println("Esa posicion ya esta ocupada");
		}
	}
	
	
}

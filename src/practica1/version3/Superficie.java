package practica1.version3;

public class Superficie {
	private Celula[][] superficie;
	private int filas;
	private int colum;
	
	public Superficie(int nF, int nC){
		this.filas = nF;
		this.colum = nC;
		this.superficie=new Celula[nF][nC];
		for (int i = 0; i < nF; i++) {
			for (int j = 0; j < nC; j++) {
				this.superficie[i][j] = null;
			}
		}
	}

	public Celula[][] getSuperficie() {
		return superficie;
	}

	public void setSuperficie(Celula[][] superficie) {
		this.superficie = superficie;
	}
	
	public void setHuecoSuperficie(int f,int col,Celula c){
		this.superficie[f][col]=c;
	}

	public int getFilas() {
		return filas;
	}

	public void setFilas(int filas) {
		this.filas = filas;
	}

	public int getColum() {
		return colum;
	}

	public void setColum(int colum) {
		this.colum = colum;
	}
	
	public void crearCelula(int f,int c,int nNoMov,int nPasos){
		Celula cel=new Celula(nNoMov,nPasos);
		this.superficie[f][c]=cel;
	}
	
	public void pintarCuadro(){
		for (int i = 0; i < superficie.length; i++) {
			for (int j = 0; j < superficie[i].length; j++) {
				if(superficie[i][j]!=null){
					System.out.print(superficie[i][j].getnPasosNoMov()+"-"+superficie[i][j].getnPasos()+"\t");
				}else{
					System.out.print(" - \t");
				}
			}
			System.out.println("");
		}
	}
	
	public void eliminarCelula(int f,int c){
		this.superficie[f][c]=null;
	}
	
	public void vaciar(){
		for (int i = 0; i < superficie.length; i++) {
			for (int j = 0; j < superficie[i].length; j++) {
				superficie[i][j]=null;
			}
		}
	}
	
}

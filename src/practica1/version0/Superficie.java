package practica1.version0;

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
	
	
}

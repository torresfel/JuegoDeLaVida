package practica1.version0;

public class Celula {
	private int nPasosNoMov;
	private int nPasos;
	
	
	public Celula(int nPasosNoMov, int nPasos) {
		this.nPasosNoMov = nPasosNoMov;
		this.nPasos = nPasos;
	}

	public int getnPasosNoMov() {
		return nPasosNoMov;
	}

	public void setnPasosNoMov(int nPasosNoMov) {
		this.nPasosNoMov = nPasosNoMov;
	}

	public int getnPasos() {
		return nPasos;
	}

	public void setnPasos(int nPasos) {
		this.nPasos = nPasos;
	}
	
	
}

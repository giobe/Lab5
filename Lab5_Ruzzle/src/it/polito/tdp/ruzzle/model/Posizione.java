package it.polito.tdp.ruzzle.model;


public class Posizione {


	char valore;
	int riga;
	int colonna;
	public Posizione(int riga, int colonna) {
		this.riga = riga;
		this.colonna = colonna;
	}
	public int getRiga() {
		return riga;
	}
	
	public char getValore() {
		return valore;
	}
	public void setValore(char valore) {
		this.valore = valore;
	}
	public void setRiga(int riga) {
		this.riga = riga;
	}
	public int getColonna() {
		return colonna;
	}
	public void setColonna(int colonna) {
		this.colonna = colonna;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + colonna;
		result = prime * result + riga;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Posizione other = (Posizione) obj;
		if (colonna != other.colonna)
			return false;
		if (riga != other.riga)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Posizione [valore=" + valore + ", riga=" + riga + ", colonna=" + colonna + "]";
	}
	
	
}


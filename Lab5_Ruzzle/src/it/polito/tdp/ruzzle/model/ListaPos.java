package it.polito.tdp.ruzzle.model;

import java.util.LinkedList;

public class ListaPos {

	LinkedList<Posizione> posizioni = new LinkedList<Posizione>();

	public ListaPos() {
	}
	
	public void addPosizione(Posizione p){
		posizioni.add(p);
	}
	public String toString(){
		String a="";
		for(Posizione p : posizioni){
			a+= p.toString()+"  ";
		}
		return a;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((posizioni == null) ? 0 : posizioni.hashCode());
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
		ListaPos other = (ListaPos) obj;
		if (posizioni == null) {
			if (other.posizioni != null)
				return false;
		} else if (!posizioni.equals(other.posizioni))
			return false;
		return true;
	}
	
}

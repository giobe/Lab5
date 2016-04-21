package it.polito.tdp.ruzzle.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;



public class Scacchiera {
	 int N=4;
	int magico;
	ArrayList<Posizione> vicini = new ArrayList<Posizione>();
    Map<Posizione, Integer> caselle;
	private List<String> valori;
	private List<Posizione> posizioni;
	
	public Scacchiera(){
		
		caselle = new HashMap<Posizione,Integer>();
		posizioni = new ArrayList<Posizione>();
		

	}
	public void genera(){
		char alfabeto[]={'a','b','c','d','e','f','g','h','i','l','m','n','o','p','q','r','s','t','u','v','z'};
		int casuale;
		for(int riga=0;riga<4;riga++){
		for(int colonne=0;colonne<4;colonne++)
		{
		casuale=(int) (Math.random()*alfabeto.length);
		Posizione p = new Posizione(riga,colonne);
		char valore = alfabeto[casuale];
		p.setValore(valore);
		posizioni.add(p);
		
		//caselle.put(p,valore)
		}
		}
	}
	
	public Integer get(Posizione p){
		return caselle.get(p);
	}
	public void set(Posizione p, Integer i){
		if(caselle.get(p)==null)
			caselle.put(p, i);
		else
			throw new RuntimeException("casella gia occupata");
	}
	public void delete(Posizione p){
		if(caselle.get(p)!=null)
			caselle.put(p, null);
		else
			throw new RuntimeException("casella gia vuota");
	}
	
	public boolean valid(Posizione p){
		return posizioni.contains(p);
	}
	public int size(){
		return posizioni.size();
	}
	
	public List<Posizione> getPos(){
		return posizioni;
	}
	public List<Integer> getValori(){
		return null;
	}
	public Posizione cercaPos(int riga, int colonna){
		for(Posizione p : posizioni){
			if(p.getRiga()==riga && p.getColonna()==colonna)
				return p;
		}
		return null;
	}
	
	public List<Posizione> vicini(Posizione p){
		vicini.clear();
		LinkedList<Posizione> viciniPossibili = new LinkedList<Posizione>();
		
		viciniPossibili.add(new Posizione(p.getRiga()-1,p.getColonna()-1));
		
		viciniPossibili.add(cercaPos(p.getRiga()-1,p.getColonna()));
		viciniPossibili.add(cercaPos(p.getRiga()-1,p.getColonna()+1));
		viciniPossibili.add(cercaPos(p.getRiga(),p.getColonna()-1));
		viciniPossibili.add(cercaPos(p.getRiga(),p.getColonna()+1));
		viciniPossibili.add(cercaPos(p.getRiga()+1,p.getColonna()-1));
		viciniPossibili.add(cercaPos(p.getRiga()+1,p.getColonna()));
		viciniPossibili.add(cercaPos(p.getRiga()+1,p.getColonna()+1));
		
	for(Posizione p1 : viciniPossibili){
	
		if(posizioni.contains(p1))
			vicini.add(p1);
	}
		return vicini;
		
	}
	
	public int sommaRiga(int riga){
		int tot=0;
		for(Posizione p : posizioni){
			if(p.getRiga()==riga && caselle.get(p)!=null)
				tot=tot+caselle.get(p);
		}
		return tot;
	}
	public int sommaColonna(int colonna){
		int tot=0;
		for(Posizione p : posizioni){
			if(p.getColonna()==colonna && caselle.get(p)!=null)
				tot=tot+caselle.get(p);
		}
		return tot;
	}
	public int sommaDiagonale1(){
		int tot=0;
		for(Posizione p : posizioni){
			if(p.getRiga()==p.getColonna() && caselle.get(p)!=null)
				tot=tot+caselle.get(p);
		}
		return tot;
	}
	public int sommaDiagonale2(){
		int tot=0;
		for(Posizione p : posizioni){
			if(p.getColonna()==(N-1-p.getRiga()) && caselle.get(p)!=null)
					tot=tot+caselle.get(p);
		}
		return tot;
	}
	public boolean containsValue(int h){
		return caselle.containsValue(h);
		
	}
	
	public static void main(String[] args){
		Scacchiera s = new Scacchiera();
		s.genera();
	}
	

}

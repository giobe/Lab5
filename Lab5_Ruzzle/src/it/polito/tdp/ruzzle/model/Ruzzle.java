package it.polito.tdp.ruzzle.model;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.TreeMap;

import it.polito.tdp.db.ParolaDao;

public class Ruzzle {
	TreeMap<String, ListaPos> presenti = new TreeMap<String, ListaPos>();
	ParolaDao dao = new ParolaDao();
	//char[] lettere = new char[16];
	String lettere ="";
	ListaPos posiz = new ListaPos();
	public Scacchiera sc = new Scacchiera();
	
	public ArrayList<String> paroleTrovate(){
		ArrayList<String> parole = new ArrayList<>(presenti.keySet());
		return parole;
	}

	public void cercaParole() {
		
		sc.genera();
		for (int i = 0; i < 16; i++) {
			if (i == 3 || i == 7 || i == 11) {
				System.out.print(sc.getPos().get(i).getValore() + "\n");
			} else
				System.out.print(sc.getPos().get(i).getValore());
		}
		int passo = 0;
		cerca(sc, passo);
		System.out.println("\n stampa le parole presenti");
		ArrayList<String> key = new ArrayList<String>(presenti.keySet());
		for (int i = 0; i < presenti.size(); i++) {
			System.out.println(key.get(i).toString());
		}
		dao.close();
		return;

	}

	public void cerca(Scacchiera sc, int passo) {
		
		if (passo == sc.size() - 1) {
			//System.out.println("passso =16");
			//inziale++;
			//cerca(sc,
			return;
		}
		//System.out.println("\n sei nel else quindi passo <16");
		Posizione p = sc.getPos().get(passo);

		/*if (passo == 0) {
			System.out.println("sei nel passo=0");
			lettere[0] = p.getValore();            //// conviene forse spostar tutto sto if passo==0
			posiz.addPosizione(p);                 // nel for generico sotto e cosi cerca vicini gia solo
			//cerca(sc,passo+1);                   // su prima casella e cosi via e poi cabiera prima casella?
		}*/

		for (int i = 0; i < sc.vicini(p).size(); i++) {// ci vuol funzione
														// VICINI!!
			if (passo == 0) {
			//System.out.println("sei nel passo=0");
			lettere=p.getValore()+"";//lettere[0] = p.getValore();            //// conviene forse spostar tutto sto if passo==0
			posiz.addPosizione(p);                 // nel for generico sotto e cosi cerca vicini gia solo
			//cerca(sc,passo+1);                   // su prima casella e cosi via e poi cabiera prima casella?
		}
			
			//System.out.println("sei nel for dei vicini");
			if (!posiz.posizioni.contains(sc.vicini(p).get(i))) {
				//System.out.println("sei in caso che non ha gia usato lettera");

				//lettere[passo+1] = sc.vicini(p).get(i).getValore();// lettere=lettere+c+d;
				
				lettere+=sc.vicini(p).get(i).getValore();
				posiz.addPosizione(sc.vicini(p).get(i));
				
				/*for(int k=0;k<=passo;k++){
					if(k==passo)
						System.out.println(lettere[k]+"\n");
					else
					System.out.print(lettere[k]);
				}*/

				if (inizialiPresenti(lettere, passo) == true) {
					//System.out.println("iniziali presenti");
					if (parolaPresente(lettere, passo) == true) {
						//CharList let = new CharList(lettere);
						presenti.put(lettere, posiz);
						System.out.println("inserita parola "+lettere);
					}
					cerca(sc, passo + 1);

				}

				posiz.posizioni.remove(sc.vicini(p).get(i));
				lettere=lettere.substring(0, lettere.length()-1);
				// backtrack su posizioni
			}
		}
	}

	public boolean inizialiPresenti(String lettere2, int passo) {

		if (dao.contiene(lettere2, passo) == true) {
			return true;
		} else
			return false;
	}

	public boolean parolaPresente(String lettere2, int passo) {

		if (dao.cerca(lettere2,passo) == true)
			return true;
		else
			return false;
	}

	public static void main(String[] args) {

		Ruzzle r = new Ruzzle();
		r.cercaParole();

	}

}

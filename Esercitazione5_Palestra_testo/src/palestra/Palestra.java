package palestra;

import java.io.*;
import java.util.*;

public class Palestra {
	
	private LinkedList<Iscritto> l = new LinkedList<Iscritto>(); 
	private TreeMap<String, Iscritto> mi = new TreeMap<String, Iscritto>();
	private int numIscritti=0;
	
	private LinkedList<Esercizio> e = new LinkedList<Esercizio>();
	private TreeMap<String, Esercizio> me = new TreeMap<String, Esercizio>();
	
	private LinkedList<SchedaAllenamento> sa = new LinkedList<SchedaAllenamento>();
	private TreeMap<String, SchedaAllenamento> msa = new TreeMap<String, SchedaAllenamento>();
	
	public Iscritto nuovaIscrizione(String nome, String cognome, String sesso, int eta, double peso) {
		Iscritto nuovo = new Iscritto(numIscritti, nome, cognome, sesso, eta, peso);
		l.add(nuovo);
		mi.put(nome+"-"+cognome, nuovo);
		numIscritti++;
		return nuovo;
	}
	
	public Iscritto cercaIscrittoPerId(int codice) {
		if(codice > numIscritti) {
			return null;
		}
		return l.get(codice);
	}
	
	public Collection<Iscritto> cercaIscrittoPerNomeCognome(String nome, String cognome){
		LinkedList<Iscritto> tmp = new LinkedList<Iscritto>();
		for(Iscritto i : mi.values()) {
			if(i.getNome().contains(nome) && i.getCognome().contains(cognome)) {
				tmp.add(i);
			}
		}
		
		return tmp;
	}
	
	public Collection<Iscritto> elencoIscritti(){
		return mi.values();
	}
	
	public Cardio nuovoEsercizio(String codice, String descrizione, int minuti) {
		Cardio nuovo = new Cardio(codice, descrizione, minuti);
		e.add(nuovo);
		me.put(codice, nuovo);
		return nuovo;
	}
	
	public Weightlifting nuovoEsercizio(String codice, String descrizione, int ripetizioni, int carico) {
		Weightlifting nuovo = new Weightlifting(codice, descrizione, ripetizioni, carico);
		e.add(nuovo);
		me.put(codice, nuovo);
		return nuovo;
	}
	
	public CorpoLibero nuovoEsercizio(String codice, String descrizione, double calorie) {
		CorpoLibero nuovo = new CorpoLibero(codice, descrizione, calorie);
		e.add(nuovo);
		me.put(codice, nuovo);
		return nuovo;
	}
	
	public Esercizio esercizio(String codice) {
		return me.get(codice);
	}
	
	public Collection<Esercizio> esercizi() {
		return e;
	}
	
	public Collection<Esercizio> elencoEserciziPerCodice() {		
		return me.values();
	}
	
	public Collection<Esercizio> elencoEserciziPerTipologia() {
		LinkedList<Esercizio> tmp = new LinkedList<Esercizio>();
		LinkedList<Esercizio> tmp2 = new LinkedList<Esercizio>();
		for(Esercizio es : e) {
			if(es.getTipo() == "CAR")
				tmp.add(es);
		}
		for(Esercizio es : e) {
			if(es.getTipo() == "WGT")
				tmp2.add(es);
		}
		Collections.sort(tmp2, new OrdinaSchedaPerCarico());
		for(Esercizio es : tmp2) {
			tmp.add(es);
		}
		for(Esercizio es : e) {
			if(es.getTipo() == "CPL")
				tmp.add(es);
		}
		return tmp;
	}
	
	public Collection<Esercizio> elencoEserciziCorpoLiberoPerCalorie() {	
		LinkedList<Esercizio> tmp = new LinkedList<Esercizio>();
		for(Esercizio es : e) {
			if(es.getTipo() == "CPL")
				tmp.add(es);
		}
		Collections.sort(tmp , new OrdinaPerCalorie());
		return tmp;
	}
	
	public SchedaAllenamento nuovaSchedaAllenamento(int codiceIscritto, String data, Collection<String> codiciEsercizi) {
		int flag = 0;
		if(numIscritti - codiceIscritto > 0) {
			for(Esercizio es : me.values()) {
				if(codiciEsercizi.contains(es.getCodice())) {
					SchedaAllenamento nuovo = new SchedaAllenamento(codiceIscritto, data, codiciEsercizi);
					for(SchedaAllenamento s : msa.values()) {
						if(s.getCodice().equals(nuovo.getCodice())) {
							s.aggiornaEsercizi(codiciEsercizi);
							flag = 1;
						}
					}
					if(flag == 0) {
						sa.add(nuovo);
						msa.put(nuovo.getCodice(), nuovo);
					}
					return nuovo;
				}
			}
		}
		return null;
	}
	
	public Collection<Esercizio> eserciziScheda(String codiceScheda){
		SchedaAllenamento s;
		LinkedList<Esercizio> esercizi = new LinkedList<Esercizio>();
		s = msa.get(codiceScheda);
		for(String str : s.getCodiciEsercizi()) {
			if(me.get(str) != null) {
				esercizi.add(me.get(str));
			}
		}
		return esercizi;
	}
	
	public SchedaAllenamento cercaSchedaPerId(String codiceScheda) throws SchedaNonEsistenteException{
		SchedaAllenamento nuovo = msa.get(codiceScheda);
		if(nuovo == null) {
			throw new SchedaNonEsistenteException();
		}
		return nuovo;
	}
	
	public Collection<SchedaAllenamento> elencoSchedePerIdIscritto(int codiceIscritto) throws UtenteNonEsistenteException{
			Iscritto nuovo = cercaIscrittoPerId(codiceIscritto);
			LinkedList<SchedaAllenamento> tmp = new LinkedList<SchedaAllenamento>();
			if (nuovo == null) {
				throw new UtenteNonEsistenteException();
			} else {
				System.out.println(nuovo);
				LinkedList<SchedaAllenamento> elencoSchedePerId =  (LinkedList<SchedaAllenamento>) sa.clone();
				Collections.sort(elencoSchedePerId, new OrdinaSchedePerId());
				for(SchedaAllenamento s : elencoSchedePerId) {
						if(s.getCodiceIscritto() == codiceIscritto) {
							tmp.add(s);
						}
				}
				return tmp;
			}		
		}
		
	
	public void leggiDatiPalestra(String nomeFile) {
		try {
			FileReader fr = new FileReader(nomeFile);
			BufferedReader br = new BufferedReader(fr);
			String c;
			while( (c = br.readLine()) != null) {
				String array[] = c.split(";");
				if(array[0].equals("I")) {
					
					Iscritto nuovo = new Iscritto(numIscritti, array[1], array[2], array[3], Integer.parseInt(array[4]), Double.parseDouble(array[5]));
					l.add(nuovo);
					mi.put(array[1]+"-"+array[2], nuovo);
					numIscritti++;
				}
				else if(array[0].equals("C")) {
					Cardio nuovo = new Cardio(array[1], array[2], Integer.parseInt(array[3]));
					e.add(nuovo);
					me.put(array[1], nuovo);
				}
				else if(array[0].equals("W")) {
					Weightlifting nuovo = new Weightlifting(array[1], array[2], Integer.parseInt(array[3]), Integer.parseInt(array[4]));
					e.add(nuovo);
					me.put(array[1], nuovo);
				}
				else if(array[0].equals("P")) {
					CorpoLibero nuovo = new CorpoLibero(array[1], array[2], Double.parseDouble(array[3]));
					e.add(nuovo);
					me.put(array[1], nuovo);
				}
			}
			
			fr.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}
		
}

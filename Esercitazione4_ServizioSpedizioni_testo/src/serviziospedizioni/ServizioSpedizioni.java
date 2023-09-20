package serviziospedizioni;

import java.util.*;

public class ServizioSpedizioni {
	
	Corriere corrieri[] = new Corriere[100];
	Collo colli[] = new Collo[100];
	Spedizione spedizioni[] = new Spedizione[100];
	String dataTmp;
	int numCorrieri = 0, numColli = 0, numSpedizioni = 0, nSpedizioniP=0, nSpedizioniS=0;
	
	public Corriere registraCorriere(String nome, String cognome, int eta, String citta) {
		int ripetizioni = 1, flag = 0;
		corrieri[numCorrieri] = new Corriere(nome, cognome, eta, citta);
		for(int i = 0; i<numCorrieri; i++) {
			if(this.corrieri[i].getCodiceCorriere().subSequence(0, 8).equals(this.corrieri[numCorrieri].getCodiceCorriere()) == true) {
				this.corrieri[i].setCodiceCorriere(ripetizioni);
				ripetizioni++;
				flag = 1;
			}
		}
		if(flag == 1) {
			this.corrieri[numCorrieri].setCodiceCorriere(ripetizioni);
		}
		numCorrieri++;
		return corrieri[numCorrieri-1];
	}
	
	public Corriere cercaCorriere(String codiceCorriere) {
		for(int i = 0; i < numCorrieri; i++) {
			if(this.corrieri[i].getCodiceCorriere().equals(codiceCorriere) == true) {
				return this.corrieri[i];
			}
		}
		return null;
	}
	
	public Corriere[] cercaCorrieri(){
		Corriere c[] = new Corriere[numCorrieri];
		for(int i = 0; i<numCorrieri;i++) {
			c[i] = this.corrieri[i];
		}
		return c;
	}
	
	public Standard creaCollo(String citta, String dataDeposito, String indirizzoMittente, String indirizzoDestinatario) {
		int rep = 1;
		Standard s = new Standard(citta, dataDeposito, indirizzoMittente, indirizzoDestinatario);
		for(int i = 0; i<numColli; i++) {
			if(this.colli[i].getCodiceCollo().substring(0, 2).equals(s.getCodiceCollo().subSequence(0, 2)) == true) {
				this.colli[i].setCodice(rep);
				rep++;
			}
		}
		s.setCodice(rep);
		this.colli[numColli] = s;
		numColli++;
		return s;
	}
	
	public Prioritario creaCollo(String citta, String dataDeposito, String indirizzoMittente, String indirizzoDestinatario, String mailMittente) {
		int rep = 1;
		Prioritario p = new Prioritario(citta, dataDeposito, indirizzoMittente, indirizzoDestinatario, mailMittente);
		for(int i = 0; i<numColli; i++) {
			if(this.colli[i].getCodiceCollo().substring(0, 2).equals(p.getCodiceCollo().subSequence(0, 2)) == true) {
				this.colli[i].setCodice(rep);
				rep++;
			}
		}
		p.setCodice(rep);
		this.colli[numColli] = p;
		numColli++;
		return p;
	}
	
	public Collo cercaCollo(String codiceCollo) {
		for(int i = 0; i < numColli; i++) {
			if(this.colli[i].getCodiceCollo().equals(codiceCollo) == true) {
				return this.colli[i];
			}
		}
		return null;
	}
	
	public Collo[] cercaColli() {
		Collo c[] = new Collo[numColli];
		for(int i = 0; i < numColli; i++) {
			c[i] = this.colli[i];
		}
		return c;
	}
	
	public Spedizione creaSpedizione(String codiceCollo, String citta, String dataConsegna) {
		String temp;
		Collo c = null;
		int indiceTemporaneo = -1, min = 10;
		this.spedizioni[numSpedizioni] = new Spedizione(codiceCollo, citta, dataConsegna);
		if(dataConsegna != dataTmp) {
			dataTmp = dataConsegna;
			for(int i = 0; i<numCorrieri; i++) {
				this.corrieri[i].azzeraSpedizioni();
			}
		}
		for(int i = 0; i<numCorrieri; i++) {
			if(this.corrieri[i].getCitta().equals(citta) == true) {
				if(this.corrieri[i].getnSpedizioni() < 3 && this.corrieri[i].getnSpedizioni() < min) {
					indiceTemporaneo = i;
					min = this.corrieri[i].getnSpedizioni(); 
				}
			}
		}
		if(indiceTemporaneo != -1) {
			c = cercaCollo(codiceCollo);
			this.corrieri[indiceTemporaneo].incrementanSpedizioni();
			if(c.getTipo().equals("S")) {
				nSpedizioniS++;
				temp = c.getTipo() + "_" + citta.substring(0, 2).toUpperCase() + "_" + nSpedizioniS;
			}
			else {
				nSpedizioniP++;
				temp = c.getTipo() + "_" + citta.substring(0, 2).toUpperCase() + "_" + nSpedizioniP;	
			}
			this.spedizioni[numSpedizioni].setCodiceSpedizione(temp);
			this.spedizioni[numSpedizioni].setCodiceCorriere(this.corrieri[indiceTemporaneo].getCodiceCorriere());
			numSpedizioni++;
			return this.spedizioni[numSpedizioni-1];
		}
		else {
			return null;
			}
	}
	
	public Spedizione cercaSpedizione(String codiceSpedizione) {
		for(int i = 0; i < numSpedizioni; i++) {
			if(spedizioni[i].getCodiceSpedizione().equals(codiceSpedizione)) {
				return this.spedizioni[i];
			}
		}
		return null;
	}
	
	public Spedizione[] cercaSpedizioni() {
		Spedizione s[] = new Spedizione[numSpedizioni];
		for(int i = 0; i < numSpedizioni; i++) {
			s[i] = this.spedizioni[i];
		}
		return s;
	}
	
	public Collection<Corriere> elencoCorrieriPerEta() {
		int indTemp=-1;
		LinkedList<Corriere> c = new LinkedList<Corriere>();
		for(int i = 0; i<numCorrieri;i++) {
			int min = 100;
			for(int j=0;j<numCorrieri;j++) {
				if(this.corrieri[j].getEta() < min && this.corrieri[j].getUtilizzato() == false) {
					min = this.corrieri[j].getEta();
					indTemp = j;
				}
			}
			if(indTemp != -1) {
				c.add(this.corrieri[indTemp]);
				this.corrieri[indTemp].setUtilizzato(true);
			}
		}
		return c;
	}
	
	public Collection<Spedizione> elencoSpedizioniCorrierePerData(String codiceCorriere) {
		int conta = 0, indTemp = -1;
		LinkedList<Spedizione> s = new LinkedList<Spedizione>();
		for(int i=0; i < numSpedizioni; i++) {
			if(this.spedizioni[i].getCodiceCorriere().equals(codiceCorriere)) {
				conta++;
				this.spedizioni[i].setUtilizzato(false);
			}
		}
		for(int i=0; i < conta; i++) {
			String min = "2100/01/01";
			for(int j = 0; j < numSpedizioni; j++) {
				if(this.spedizioni[j].getCodiceCorriere().equals(codiceCorriere) && this.spedizioni[j].getDataConsegna().compareTo(min) < 0 && this.spedizioni[j].isUtilizzato() == false) {
					min = this.spedizioni[j].getDataConsegna();
					indTemp = j;
				}
			}
			if(indTemp != -1) {
				s.add(this.spedizioni[indTemp]);
				this.spedizioni[indTemp].setUtilizzato(true);
			}
		}
		return s;
	}

	public Collection<Spedizione> elencoSpedizioniCittaPerPriorita(String citta) {
		int conta = 0, indTemp;
		Collo c = null;
		LinkedList<Spedizione> s = new LinkedList<Spedizione>();
		for(int i=0; i < numSpedizioni; i++) {
			if(this.spedizioni[i].getCitta().equals(citta) == true) {
				conta++;
				this.spedizioni[i].setUtilizzato(false);
			}
		}
		for(int i=0; i < conta; i++) { 
			indTemp=-1;
			String minP = "2100/01/01";
			for(int j = 0; j < numSpedizioni; j++) {
				c = cercaCollo(this.spedizioni[j].getCodiceCollo());
				if(this.spedizioni[j].getCitta().equals(citta) && this.spedizioni[j].getDataConsegna().compareTo(minP) <= 0 && this.spedizioni[j].isUtilizzato() == false && c.getTipo().equals("P")) {
					minP = this.spedizioni[j].getDataConsegna();
					indTemp = j;
				}		
			}			
			if(indTemp != -1) {
				s.add(this.spedizioni[indTemp]);
				this.spedizioni[indTemp].setUtilizzato(true);
			} else {
				String minS = "2100/01/01";
				for(int j = 0; j< numSpedizioni;j++) {
					c = cercaCollo(this.spedizioni[j].getCodiceCollo());
					if(this.spedizioni[j].getCitta().equals(citta) && this.spedizioni[j].getDataConsegna().compareTo(minS) <0 && this.spedizioni[j].isUtilizzato() == false && c.getTipo() == "S") {
						minS = this.spedizioni[j].getDataConsegna();
						indTemp = j;
					}
				} 
				s.add(this.spedizioni[indTemp]);
				this.spedizioni[indTemp].setUtilizzato(true);
			}
			
		}
		return s;
	}
}

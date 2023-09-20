package aeroporto;

public class Aeroporto {
	
	String nomeAereoporto, address, elencoViaggi, viaggiPerTratta;
	int numMax, numDecolli = 0;
	Aerei a = new Aerei();
	String viaggio[] = new String[1000];
	int numPass[] = new int[1000];
	int chilometri[] = new int[10000];
	int indiceAssegnato[] = new int[1000];
	int num = 0, indice;
	
	public Aeroporto(String denominazione, String indirizzo, int numeroAerei) {
		nomeAereoporto = denominazione;
		address = indirizzo;
		numMax = numeroAerei;
	}

	public String getDenominazione() {
		return nomeAereoporto;
	}

	public String getIndirizzo() {
		return address;
	}
	
	public int getNumeroAerei () {
		return numMax;
	}
	
	public void setNumeroDecolli(int numeroDecolli){
		numDecolli = numeroDecolli;
	}
	
	public String descrizioneAeroporto() {
		return numMax + " (" + numDecolli + ")";
	}
	
	public int aggiungiAereo(String modello, int capienza, int chilometriAutonomia) {
			return a.aggiungiAereo(modello, capienza, chilometriAutonomia); 
	}
	
	public String aereo(int identificativoAereo) {
		return a.Aereo(identificativoAereo);
	}

	public String[] aerei() {
		return a.bloccoAerei();
	}

	public String aggiungiViaggio(String nomeTratta, int numeroPasseggeri, int chilometriTratta) {
		viaggio[num] = nomeTratta;
		numPass[num] = numeroPasseggeri;
		chilometri[num] = chilometriTratta;
		indiceAssegnato[num] = -1;
		num++;
		indice = a.assegnaAereo(nomeTratta, numeroPasseggeri, chilometriTratta); 
		if(indice != -1) {
			indiceAssegnato[num-1] = indice;
			return indice + ";" + nomeTratta;
		}
		else return indice + ";" + nomeTratta;
	}

	public String viaggio(int identificativoAereo, String nomeTratta) {
		for(int i=0; i<num; i++) {
			if(identificativoAereo == indiceAssegnato[i] && nomeTratta == viaggio[i]) {
				return identificativoAereo + ";" + nomeTratta + ";" + numPass[i] + ";" + chilometri[i];
			}
		}
		return null;
	}
	
	
	public String viaggi() {
		int i;
		boolean primo = true;
		for(i = 0; i<num;i++) {
			if(primo == true && indiceAssegnato[i] != -1) {
				elencoViaggi =indiceAssegnato[i] + ";" + viaggio[i] + ";" + numPass[i] + ";" + chilometri[i]; 
				primo = false;
			}
			else if(primo == false && indiceAssegnato[i] != -1){
				elencoViaggi = elencoViaggi + "\n" + indiceAssegnato[i] + ";" + viaggio[i] + ";" + numPass[i] + ";" + chilometri[i];
			}
		}
		 
		return elencoViaggi;
	}

	public String viaggiPerTratta(String nomeTratta) {
		int i;
		boolean primo = true;
		for(i = 0; i<num; i++) {
			if(nomeTratta == viaggio[i]) {
				if(primo == true) {
					viaggiPerTratta = indiceAssegnato[i] + ";" + viaggio[i] + ";" + numPass[i] + ";" + chilometri[i];
					primo = false;
				}  else {
					viaggiPerTratta = viaggiPerTratta + "\n" + indiceAssegnato[i] + ";" + viaggio[i] + ";" + numPass[i] + ";" + chilometri[i];
				}
			}
			
		}
		return viaggiPerTratta;
	}
}


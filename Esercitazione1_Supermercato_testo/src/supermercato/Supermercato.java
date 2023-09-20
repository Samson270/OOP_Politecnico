package supermercato;

public class Supermercato {

    // Inserire tutti gli attributi necessari, eventualmente creare altre classi
	String indirizzo;
	double costoGiornaliero;
	int nVendite=0;
	String nome[] = new String[50];
	String marca[] = new String[50];
	int unita[] = new int[50];
	double prezzo[] = new double[50];
	/**
	* Crea un nuovo Supermercato (costruttore)
	*/
	public Supermercato() {
	}
	

	/**
	* Imposta l'indirizzo del supermercato
	*/
	public void setIndirizzo(String i) {
		indirizzo = i;
	}

	/**
	* Restituisce l'indirizzo del supermercato
	*/
	public String getIndirizzo() {
		return indirizzo;
	}

	/**
	* Imposta il costo giornaliero del supermercato
	*/
	public void setCostoGiornaliero(double s) {
		costoGiornaliero = s;
	}

	/**
	* Restituisce il costo giornaliero del supermercato
	*/
	public double getCostoGiornaliero() {
		return costoGiornaliero;
	}

	/**
	* Gestisce la vendita di un prodotto del supermercato
	*/  
	public void nuovaVendita(String n, String m, int u, double p) {
		nome[nVendite] = n;
		marca[nVendite] = m;
		unita[nVendite] = u;
		prezzo[nVendite] = p;
		nVendite = nVendite + 1;
	}

	/**
	* Restituisce le informazioni relative all'ultima vendita
	*/  
	public String ultimaVendita() {
		return nome[nVendite-1] + ", " + marca[nVendite-1] + ", " + unita[nVendite-1] + ", " + prezzo[nVendite-1];
	}

	/**
	* Restituisce le informazioni relative alla vendita di cui nome prodotto e marca sono passati come parametro 
	*/  
	public String vendita(String n, String m) {
		for(int i=0; i<nVendite; i++) {
			if(nome[i] == n && marca[i]==m) {
				return nome[i] + ", " + marca[i] + ", " + unita[i] + ", " + prezzo[i];
			}
		}
		return null;
	}

	/**
	* Restituisce il numero di giorni i cui costi sono coperti
	*/  
	public double giorniCoperti() {
		double somma=0;
		for(int i=0; i<nVendite; i++) {
			somma = somma + (prezzo[i]*unita[i]);
		}
		
		return somma/costoGiornaliero;
		
	}

}

package serviziospedizioni;

public class Corriere {
	
	private String nome, cognome, citta, codice;
	private int eta, nSpedizioni;
	private boolean utilizzato;
	
	public Corriere(String nome, String cognome, int eta, String citta) {
		this.nome = nome;
		this.cognome = cognome;
		this.citta = citta;
		this.eta = eta;
		this.nSpedizioni = 0;
		this.utilizzato = false;
		this.codice = nome.substring(0, 2).toUpperCase() + cognome.substring(0, 2).toUpperCase() + eta + citta.substring(0, 2).toUpperCase();
	}

	public String getCodiceCorriere() {
		return codice;
	}
	
	public void setUtilizzato(boolean b) {
		this.utilizzato = b;
	}
	public boolean getUtilizzato() {
		return utilizzato;
	}
	
	public void setCodiceCorriere(int inc) {
		this.codice = codice.substring(0, 8) + "_" + inc;
	}
	
	public String getNome() {
		return nome;
	}
	
	public String getCognome() {
		return cognome;
	}
	
	public int getEta() {
		return eta;
	}
	
	public int getnSpedizioni() {
		return nSpedizioni;
	}
	
	public void azzeraSpedizioni() {
		nSpedizioni = 0;
	}
	
	public void incrementanSpedizioni() {
		nSpedizioni++;
	}
	
	public String getCitta() {
		return citta;
	}
	
	public String descriviti() {
		return codice + " " + nome + " " + cognome + " " + eta + " " + citta;
	}

	
}

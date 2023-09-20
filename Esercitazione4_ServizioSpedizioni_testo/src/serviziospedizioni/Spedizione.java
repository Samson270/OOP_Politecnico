package serviziospedizioni;

public class Spedizione {
	
	private String codiceCollo, citta, dataConsegna, codiceSpedizione, codiceCorriere;
	boolean utilizzato;
	
	
	public Spedizione(String codiceCollo, String citta, String dataConsegna) {
		this.codiceCollo = codiceCollo;
		this.citta = citta;
		this.dataConsegna = dataConsegna;
		this.utilizzato = false;
	}


	
	public String getCitta() {
		return citta;
	}
	public String getCodiceCollo() {
		return codiceCollo;
	}
	public String getDataConsegna() {
		return dataConsegna;
	}
	
	public String getCodiceSpedizione() {
		return codiceSpedizione;
	}
	
	public void setCodiceSpedizione(String cod) {
		this.codiceSpedizione = cod;
	}

	public void setCodiceCorriere(String cod) {
		this.codiceCorriere = cod;
	}
	
	public boolean isUtilizzato() {
		return utilizzato;
	}


	public void setUtilizzato(boolean utilizzato) {
		this.utilizzato = utilizzato;
	}


	public String getCodiceCorriere() {
		return codiceCorriere;
	}

	public String descriviti() {
		return codiceSpedizione + " " + codiceCorriere + " " + codiceCollo + " " + dataConsegna;
	}
}

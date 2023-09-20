package serviziospedizioni;

public class Collo {
	
	protected String citta, dataDeposito, indirizzoMittente, indirizzoDestinatario, codice;
	
	
	
	public Collo(String citta, String dataDeposito, String indirizzoMittente, String indirizzoDestinatario) {
		this.citta = citta;
		this.dataDeposito = dataDeposito;
		this.indirizzoMittente = indirizzoMittente;
		this.indirizzoDestinatario = indirizzoDestinatario;
		this.codice = citta.substring(0, 2).toUpperCase() + "_";
	}

	
	public String getTipo() {
		return null;
	}
	
	public String getCodiceCollo() {
		return codice;
	}
	
	public void setCodice(int cod) {
		this.codice = codice.substring(0,3) + cod;
	}


	public String getCitta() {
		return citta;
	}
	
	public String getDataDeposito() {
		return dataDeposito;
	}
	
	public String getIndirizzoDestinatario() {
		return indirizzoDestinatario;
	}
	
	public String getIndirizzoMittente() {
		return indirizzoMittente;
	}
	
	public String descriviti() {
		return codice + " " + citta + " " + dataDeposito + " " + indirizzoMittente + " " + indirizzoDestinatario;
	}
}

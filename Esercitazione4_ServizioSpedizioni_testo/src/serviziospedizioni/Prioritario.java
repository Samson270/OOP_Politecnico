package serviziospedizioni;

public class Prioritario extends Collo {

	private String mailMittente;
	
	public Prioritario(String citta, String dataDeposito, String indirizzoMittente, String indirizzoDestinatario, String mailMittente) {
		super(citta, dataDeposito, indirizzoMittente, indirizzoDestinatario);
		this.mailMittente = mailMittente;
	}
	
	@Override
	public String getTipo() {
		return "P";
	}
	
	@Override
	public String descriviti() {
		return codice + " " + citta + " " + dataDeposito + " " + indirizzoMittente + " " + indirizzoDestinatario + " " + mailMittente;
	}

	public String getMailMittente() {
		return mailMittente;
	}

}

package serviziospedizioni;

public class Standard extends Collo {
		
	public Standard(String citta, String dataDeposito, String indirizzoMittente, String indirizzoDestinatario) {
		super(citta, dataDeposito, indirizzoMittente, indirizzoDestinatario);
	}
	
	@Override
	public String getTipo() {
		return "S";
	}
	
	public String descriviti() {
		return codice + " " + citta + " " + dataDeposito + " " + indirizzoMittente + " " + indirizzoDestinatario;
	}
}

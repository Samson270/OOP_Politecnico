package banca;

public class Fido {

	private String codiceConto, codiceCliente; 
	private double importo, rataMensile, tassoRischio;
	
	public Fido(String codiceConto, String codiceCliente, double importo, double rataMensile, double tassoRischio) {
		super();
		this.codiceConto = codiceConto;
		this.codiceCliente = codiceCliente;
		this.importo = importo;
		this.rataMensile = rataMensile;
		this.tassoRischio = tassoRischio;
	}

	public String descriviti() {
		return codiceConto + " " + codiceCliente + " F " + tassoRischio + " "+ importo;
	}

}

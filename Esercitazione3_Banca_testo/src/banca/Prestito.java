package banca;

public class Prestito {

	private String codiceConto, codiceCliente, tipo;
	private double importo, rataMensile, tassoRischio;
	
	
	
	
	public Prestito(String codiceConto, String codiceCliente, String tipo, double importo, double rataMensile, double tassoRischio) {
		super();
		this.codiceConto = codiceConto;
		this.codiceCliente = codiceCliente;
		this.tipo = tipo;
		this.importo = importo;
		this.rataMensile = rataMensile;
		this.tassoRischio = tassoRischio;
		tipo = "F";
	}
	
	public Prestito(String codiceConto, String codiceCliente,String tipo, double importo, double rataMensile) {
		super();
		this.codiceConto = codiceConto;
		this.codiceCliente = codiceCliente;
		this.tipo = tipo;
		this.importo = importo;
		this.rataMensile = rataMensile;
		tipo = "M";
	}


	public String getTipo() {
		return tipo;
	}

	public String getCodiceCliente() {
		return codiceCliente;
	}

	public String descriviti() {
		if(tipo.equals("F")) {
			return codiceConto + " " + codiceCliente + " F " + tassoRischio + " " + importo;
		}
		else {
			return codiceConto + " " + codiceCliente + " M " + importo;
		}
	}
	
}

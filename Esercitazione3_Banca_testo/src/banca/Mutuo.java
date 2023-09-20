package banca;

public class Mutuo {

	private String codiceConto, codiceCliente;
	private double importo, rataMensile;
	private int numeroMesi;
	
	public Mutuo(String codiceConto, String codiceCliente, double importo, double rataMensile, int numeroMesi) {
		super();
		this.codiceConto = codiceConto;
		this.codiceCliente = codiceCliente;
		this.importo = importo;
		this.rataMensile = rataMensile;
		this.numeroMesi = numeroMesi;
	}

	public String descriviti() {
		return codiceConto + " " + codiceCliente + " M " + importo;
	}

}

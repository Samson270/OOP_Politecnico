package palestra;

public class Esercizio {
	
	private String codice, descrizione;
	
	
	public Esercizio(String codice, String descrizione) {
		this.codice = codice;
		this.descrizione = descrizione;
	}
	
	public String getTipo() {
		return null;
	}

	public String getCodice() {
		return codice;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public String descriviti() {
		return codice + " " + descrizione;
	}
}

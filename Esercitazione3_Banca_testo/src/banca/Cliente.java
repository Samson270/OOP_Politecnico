package banca;

public class Cliente {

	private String codiceFiscale, cognome, nome, professione;
	private String[] contiIntestati = new String[1000];
	private int conti = 0;
	private boolean garantePrestito;
	

	public Cliente(String codiceFiscale, String cognome, String nome, String professione) {
		super();
		this.codiceFiscale = codiceFiscale;
		this.cognome = cognome;
		this.nome = nome;
		this.professione = professione;
		garantePrestito = false;
	}

	public boolean isGarantePrestito() {
		return garantePrestito;
	}

	public void setGarantePrestito(boolean garantePrestito) {
		this.garantePrestito = garantePrestito;
	}
	
	public boolean contoAssociato(String codiceConto) {
		for(int i=0; i<conti; i++) {
			if(contiIntestati[i].equals(codiceConto) == true) {
				return true;
			}
		}
		return false;
	}
	
	
	
	public String getContiIntestati() {
		String str = null;
		boolean primo = true;
		for(int i=0; i<conti; i++) {
			if(primo==true) {
				str = contiIntestati[i];
				primo = false;
			}
			else {
				str = str + "\n" + contiIntestati[i];
			}
		}
		return str;
	}

	public void setContiIntestati(String contiIntestati) {
		this.contiIntestati[conti] = contiIntestati;
		conti++;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setProfessione(String professione) {
		this.professione = professione;
	}

	public String getCodiceFiscale() {
		return codiceFiscale;
	}

	public String getCognome() {
		return cognome;
	}

	public String getNome() {
		return nome;
	}

	public String getProfessione() {
		return professione;
	}

	public String descriviti() {
		return codiceFiscale + " " + cognome + " " + nome + " " + professione;
	}


	
}

package palestra;

public class Iscritto {
	
	private int codice, et�;
	private double  peso; 
	private String nome, cognome, sesso;
	
	
	
	public Iscritto(int codice, String nome, String cognome, String sesso, int et�, double peso) {
		this.codice = codice;
		this.et� = et�;
		this.peso = peso;
		this.nome = nome;
		this.cognome = cognome;
		this.sesso = sesso;
	}



	public int getCodice() {
		return codice;
	}



	public void setCodice(int codice) {
		this.codice = codice;
	}



	public int getEt�() {
		return et�;
	}



	public void setEt�(int et�) {
		this.et� = et�;
	}



	public double getPeso() {
		return peso;
	}



	public void setPeso(double peso) {
		this.peso = peso;
	}



	public String getNome() {
		return nome;
	}



	public void setNome(String nome) {
		this.nome = nome;
	}



	public String getCognome() {
		return cognome;
	}



	public void setCognome(String cognome) {
		this.cognome = cognome;
	}



	public String getSesso() {
		return sesso;
	}



	public void setSesso(String sesso) {
		this.sesso = sesso;
	}



	public String descriviti() {
		return codice + " " + nome + " " + cognome + " " + sesso + " " + et� + " " + peso;
	}

}
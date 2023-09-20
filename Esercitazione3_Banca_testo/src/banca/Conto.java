package banca;

public class Conto {
	
	 private double tassoInteresse, capitale;
	 private String dataApertura, nomeOperatore, nomeFiliale;
	 private String codice;
	 private boolean intestato;
	 private String[] intestatari = new String[300];
	 private int contaInt = 0;
	
	
	 
	public String getIntestatario() {
		return intestatari[0];
	}
	public String getListaIntestatari() {
		String str = null;
		boolean primo = true;
		for(int i=0; i<contaInt; i++) {
			if(primo==true) {
				str =intestatari[i];
				primo = false;
			}
			else {
				str = str + "\n" + intestatari[i];
			}
		}
		return str;
	}


	public void setIntestatari(String intestatari) {
		this.intestatari[contaInt] = intestatari;
		contaInt++;
	}

	public Conto(double tassoInteresse, double capitale, String dataApertura, String nomeOperatore,String nomeFiliale,int num) {
		super();
		this.tassoInteresse = tassoInteresse;
		this.capitale = capitale;
		this.dataApertura = dataApertura;
		this.nomeOperatore = nomeOperatore;
		this.nomeFiliale = nomeFiliale;
		codice = generaCodice(num);
		setIntestato(false);
	}
	
	public void aggiornaCapitale(double importo) {
		capitale = capitale + importo;
	}
	public String getCodice() {
		
		return codice;
	}

	public double getTassoInteresse() {
		return tassoInteresse;
	}

	public double getCapitale() {
		return capitale;
	}

	public String getDataApertura() {
		return dataApertura;
	}

	public String getNomeOperatore() {
		return nomeOperatore;
	}

	public String getNomeFiliale() {
		return nomeFiliale;
	}

	public String descriviti() {
		return codice + " " + tassoInteresse + " " + capitale + " " + dataApertura + " " + nomeOperatore + " " + nomeFiliale;
	}
	
	public boolean isIntestato() {
		return intestato;
	}

	public void setIntestato(boolean intestato) {
		this.intestato = intestato;
	}
	
	
	
	
	/************************************************************************************/
	static String generaCodice(int n) {
		String cod;
		if(n<10 ) {
			cod = "00" + n;
		} else if(n>=10 && n<=99) {
			cod = "0" + n;
		}
		else{
			cod = "" + n;
		}
		return cod;
	}
	/************************************************************************************/


		
}

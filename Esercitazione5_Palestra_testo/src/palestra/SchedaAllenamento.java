package palestra;

import java.util.Collection;

public class SchedaAllenamento {
	
	private int codiceIscritto;
	private String data, codiceScheda;
	private Collection<String> codiciEsercizi;
	
	
	
	public SchedaAllenamento(int codiceIscritto, String data, Collection<String> codiciEsercizi) {
		this.codiceIscritto = codiceIscritto;
		this.data = data;
		this.codiciEsercizi = codiciEsercizi;
		this.codiceScheda = data + "_" + codiceIscritto;
	}

	public int getCodiceIscritto() {
		return codiceIscritto;
	}

	public void aggiornaEsercizi(Collection<String> codici) {
		for(String s : codici) {
			if(codiciEsercizi.contains(s) == false) {
				codiciEsercizi.add(s);
			}
		}
	}
	

	public String getData() {
		return data;
	}



	public Collection<String> getCodiciEsercizi() {
		return codiciEsercizi;
	}



	public String getCodice() {
		return codiceScheda;
	}
}

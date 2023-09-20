package palestra;

public class Weightlifting extends Esercizio {
	
	private int ripetizioni, carico;
	private String tipo;
	
	public Weightlifting(String codice, String descrizione, int ripetizioni, int carico) {
		super(codice, descrizione);
		this.ripetizioni = ripetizioni;
		this.carico = carico;
		this.tipo = "WGT";
	}

	
	public int getRipetizioni() {
		return ripetizioni;
	}


	public int getCarico() {
		return carico;
	}

	@Override
	public String getTipo() {
		return tipo;
	}

	@Override
	public String descriviti() {
		return super.descriviti() + " " + tipo + " " + ripetizioni + " " + carico;
	}
}

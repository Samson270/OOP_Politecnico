package palestra;

public class Cardio extends Esercizio {

	private int minuti;
	private String tipo;
	
	
	
	public Cardio(String codice, String descrizione, int minuti) {
		super(codice, descrizione);
		this.minuti = minuti;
		this.tipo = "CAR";
	}

	

    public int getMinuti() {
		return minuti;
	}

    @Override
    public String getTipo() {
		return tipo;
	}


	@Override
	public String descriviti() {
		return super.descriviti() + " " + tipo + " " + minuti;
	}
}

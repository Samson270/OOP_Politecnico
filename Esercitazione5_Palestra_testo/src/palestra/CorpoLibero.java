package palestra;

public class CorpoLibero extends Esercizio {
	
	private double calorie;
	private String tipo;
	
	
	public CorpoLibero(String codice, String descrizione, double calorie) {
		super(codice, descrizione);
		this.calorie = calorie;
		this.tipo = "CPL";
	}


	public double getCalorie() {
		return calorie;
	}

	@Override
	public String getTipo() {
		return tipo;
	}

	@Override
	public String descriviti() {
		return super.descriviti() + " " + tipo +" " + calorie;
	}

}

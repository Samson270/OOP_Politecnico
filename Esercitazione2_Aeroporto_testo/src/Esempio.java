import aeroporto.Aeroporto;

/**
 * Classe con un main di esempio
 */

public class Esempio {

	public static void main(String[] args) {
		
		System.out.println("Creazione aeroporto e impostazione degli attributi\n\n");

		Aeroporto a = new Aeroporto("Sandro Pertini Torino-Caselle", "Via Aeroporto 12", 50);
		
		String denominazione = a.getDenominazione();
		String indirizzo = a.getIndirizzo();
		int numeroAerei = a.getNumeroAerei();
		
		System.out.println("Creato aeroporto " + denominazione + " all'indirizzo " + indirizzo + " che puo ospitare " + numeroAerei + " aerei\n\n");
		System.out.println("Impostazione numero di decolli e descrizione dell'aeroporto\n\n");
		
		a.setNumeroDecolli(2);
		String descrizioneAeroporto = a.descrizioneAeroporto();
		System.out.println("Descrizione aeroporto: " + descrizioneAeroporto + "\n\n");
		
		System.out.println("Creazione di tre aerei\n\n");
		int id1 = a.aggiungiAereo("Modello1", 200, 3000);
		int id2 = a.aggiungiAereo("Modello2", 160, 3000);
		int id3 = a.aggiungiAereo("Modello3", 200, 2900);
		
		System.out.println("Creati gli aerei con id " + id1 + ", " + id2 + " e " + id3 +"\n\n");
		System.out.println("Informazioni su un aereo\n\n");
		
		String aereoTrovato = a.aereo(id2);
		System.out.println("Informazioni: " + aereoTrovato +"\n\n");
		
		System.out.println("Stampa aerei\n\n");
		if(a.aerei() != null)
			for (String s : a.aerei())
				if (s != null)
					System.out.println(s);
		
		
		System.out.println("\n\nCreazione di un viaggio\n\n");
		String viaggio1 = a.aggiungiViaggio("Torino-Bari", 170, 2800);
		
		System.out.println("Creazione di un viaggio\n\n");
		String viaggio2 = a.aggiungiViaggio("Torino-Bari", 150, 3000);
		
		System.out.println("Viaggi creati\n\n");
		System.out.println("Viaggio 1: " + viaggio1);
		System.out.println("Viaggio 2: " + viaggio2);
		
		
		System.out.println("Ricerca di un viaggio\n\n");
		String viaggioTrovato = a.viaggio(id2, "Torino-Bari");
		if (viaggioTrovato!=null) 
			System.out.println("Trovato viaggio " + viaggioTrovato + "\n\n");
		else
			System.out.println("Nessun viaggio trovato");
		
		System.out.println("Elenco dei viaggi:\n\n");
		String viaggi = a.viaggi();
		System.out.println(viaggi);
		
		System.out.println("\n\nElenco dei viaggi per la tratta Torino-Bari:\n\n");
		String viaggiPerTratta = a.viaggiPerTratta("Torino-Bari");
		System.out.println(viaggiPerTratta);
	} 
}

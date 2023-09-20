import serviziospedizioni.*;

public class Esempio {

	public static void main(String[] args) {

		ServizioSpedizioni s = new ServizioSpedizioni();

		System.out.println("########## R1 - Corrieri ##########");

		System.out.println("Registrazione di un corriere.");
		Corriere c1 = s.registraCorriere("Mario", "Rossi", 35, "Torino");

		System.out.println("Informazioni sul corriere creato.\n");
		System.out.println("Codice: " + c1.getCodiceCorriere());
		System.out.println("Nome: " + c1.getNome());
		System.out.println("Cognome: " + c1.getCognome());
		System.out.println("Eta: " + c1.getEta());
		System.out.println("Citta': " + c1.getCitta());

		System.out.println("\nRegistrazione di altri corrieri.");
		s.registraCorriere("Andrea", "Bianchi", 28, "Alessandria");
		s.registraCorriere("Marco", "Romano", 35, "Torino");

		System.out.println("Ricerca del corriere con codice MARO35TO_1");
		Corriere cTrovato = s.cercaCorriere("MARO35TO_1");

		System.out.println("Informazioni sul corriere trovato.\n");
		System.out.println("Codice: " + cTrovato.getCodiceCorriere());
		System.out.println("Nome: " + cTrovato.getNome());
		System.out.println("Cognome: " + cTrovato.getCognome());
		System.out.println("Eta: " + cTrovato.getEta());
		System.out.println("Citta': " + cTrovato.getCitta());

		System.out.println("\nElenco dei corrieri finora registrati in ordine di creazione.\n");
		Corriere[] corrieri = s.cercaCorrieri();
		for (Corriere ci : corrieri) {
			System.out.println("Codice: " + ci.getCodiceCorriere());
		}

		System.out.println("\n########## R2 - Colli ##########");

		System.out.println("Creazione di un nuovo collo.");
		Collo col1 = s.creaCollo("Torino", "2021/11/19", "Via Passo Buole 22", "Via dei Fraschei 17");

		System.out.println("Informazioni sul collo creato.\n");
		System.out.println("Codice: " + col1.getCodiceCollo());
		System.out.println("Citta': " + col1.getCitta());
		System.out.println("Data di deposito': " + col1.getDataDeposito());
		System.out.println("Indirizzo mittente: " + col1.getIndirizzoMittente());
		System.out.println("Indirizzo destinatario: " + col1.getIndirizzoDestinatario());
		if (col1 instanceof Standard) {
			System.out.println("Tipologia: Standard");
		}
		else {
			System.out.println("Tipologia: Prioritario");
			System.out.println("Mail mittente: " + ((Prioritario)col1).getMailMittente());
		}

		System.out.println("\nCreazione di altri ordini.");
		s.creaCollo("Torino", "2021/11/19", "Via Vespucci 42", "Via Dante 54", "mario.bianchi@gmail.com");
		s.creaCollo("Torino", "2021/11/19", "Via Avogadro 16", "Via Giolitti 61");

		System.out.println("Ricerca del collo con codice TO_1");
		Collo colTrovato = s.cercaCollo("TO_1");

		System.out.println("Informazioni sul collo trovato.\n");
		System.out.println("Codice: " + colTrovato.getCodiceCollo());
		System.out.println("Citta': " + colTrovato.getCitta());
		System.out.println("Data di deposito': " + colTrovato.getDataDeposito());
		System.out.println("Indirizzo mittente: " + colTrovato.getIndirizzoMittente());
		System.out.println("Indirizzo destinatario: " + colTrovato.getIndirizzoDestinatario());
		if (colTrovato instanceof Standard) {
			System.out.println("Tipologia: Standard");
		}
		else {
			System.out.println("Tipologia: Prioritario");
			System.out.println("Mail mittente: " + ((Prioritario)colTrovato).getMailMittente());
		}

		System.out.println("\n########## R3 - Spedizioni ##########");

		System.out.println("Creazione di una nuova spedizione.");
		Spedizione sp1 = s.creaSpedizione("TO_1", "Torino", "2021/11/20");

		System.out.println("Informazioni sulla spedizione creata.\n");
		System.out.println(sp1.descriviti());

		System.out.println("\nCreazione di altre spedizioni.");
		s.creaSpedizione("TO_2", "Torino", "2021/11/20");
		s.creaSpedizione("TO_3", "Torino", "2021/11/20");

		System.out.println("Ricerca della Spedizione TO_1");
		Spedizione spTrovata = s.cercaSpedizione("S_TO_1");

		System.out.println("Informazioni sulla spedizione trovata.\n");
		System.out.println(spTrovata.descriviti());
		
		System.out.println("\nElenco delle spedizioni finora registrate in ordine di creazione.\n");
		Spedizione[] ss = s.cercaSpedizioni();
		for (Spedizione si : ss) {
			System.out.println(si.descriviti());
		}

		System.out.println("\n########## R4 - Elenchi ##########");
		System.out.println("Elenco dei corrieri per eta\n");		
		for (Corriere ci : s.elencoCorrieriPerEta()) {
			System.out.println(ci.descriviti() + "\n");
		}
		
		System.out.println("\nElenco spedizioni di un corriere per data.\n");		
		for (Spedizione si : s.elencoSpedizioniCorrierePerData(c1.getCodiceCorriere())) {
			System.out.println(si.descriviti() + "\n");
		}
		
		System.out.println("\nElenco degli ordini nella citta' di Torino per priorita'.\n");		
		for (Spedizione si : s.elencoSpedizioniCittaPerPriorita("Torino")) {
			System.out.println(si.descriviti() + "\n");
		}
	}
	
}
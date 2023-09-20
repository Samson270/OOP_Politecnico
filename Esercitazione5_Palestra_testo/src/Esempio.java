import java.util.ArrayList;
import palestra.*;

public class Esempio {

	public static void main(String[] args) throws SchedaNonEsistenteException, UtenteNonEsistenteException {

		Palestra p = new Palestra();
		
		System.out.println("\n/****** R1 ******/");
		
		System.out.println("Nuove iscrizioni");
		Iscritto i1 = p.nuovaIscrizione("Mario", "Rossi", "Uomo", 25, 84.5);
		Iscritto i2 = p.nuovaIscrizione("Paolo", "Bianchi", "Uomo", 28, 80.1);
		Iscritto i3 = p.nuovaIscrizione("Anna", "Verdi", "Donna", 22, 57.9);
		
		System.out.println("\nUtenti iscritti:\n");
		System.out.println(i1.descriviti());
		System.out.println(i2.descriviti());
		System.out.println(i3.descriviti());
		
		System.out.println("\nRicerca iscritto:\n");
		Iscritto iTrovato = p.cercaIscrittoPerId(1);
		System.out.println(iTrovato.descriviti());
		
		System.out.println("\nRicerca iscritto/i per nome e cognome:\n");
		ArrayList<Iscritto> iTrovatiNomeCognome = new ArrayList<>(p.cercaIscrittoPerNomeCognome("o", "i"));
		for(Iscritto ii : iTrovatiNomeCognome)
			System.out.println(ii.descriviti());
		
		System.out.println("\nElenco iscritti:\n");
		ArrayList<Iscritto> elencoIscritti = new ArrayList<>(p.elencoIscritti());
		for(Iscritto ii : elencoIscritti)
			System.out.println(ii.descriviti());
		
		System.out.println("\n/****** R2 ******/");
		
		System.out.println("Nuovi esercizi");
		Esercizio e1 = p.nuovoEsercizio("rpj", "Rope-Jump", 20);
		Esercizio e2 = p.nuovoEsercizio("sqt", "Squat", 6, 120);
		Esercizio e3 = p.nuovoEsercizio("brp", "Burpees", 10);
		Esercizio e4 = p.nuovoEsercizio("psu", "Push-up", 24.5);
		Esercizio e5 = p.nuovoEsercizio("pu", "Pull-up", 34.5);
		Esercizio e6 = p.nuovoEsercizio("ddl", "Deadlift", 6, 150);
		
		System.out.println("\nEsercizi creati:\n");
		System.out.println(e1.descriviti());
		System.out.println(e2.descriviti());
		System.out.println(e3.descriviti());
		System.out.println(e4.descriviti());
		System.out.println(e5.descriviti());
		System.out.println(e6.descriviti());
		
		System.out.println("\nRicerca esercizio:\n");
		Esercizio eTrovato = p.esercizio("sqt");
		System.out.println(eTrovato.descriviti());
		
		System.out.println("\nElenco esercizi:\n");
		ArrayList<Esercizio> elencoEsercizi = new ArrayList<>(p.esercizi());
		for(Esercizio ei : elencoEsercizi)
			System.out.println(ei.descriviti());
		
		System.out.println("\nElenchi esercizi");
		System.out.println("\nCodice, alfabeticamente:\n");
		ArrayList<Esercizio> elenco1 = new ArrayList<>(p.elencoEserciziPerCodice());
		for(Esercizio ei : elenco1)
			System.out.println(ei.descriviti());
		
		System.out.println("\nTipologia:\n");
		ArrayList<Esercizio> elenco2 = new ArrayList<>(p.elencoEserciziPerTipologia());
		for(Esercizio ei : elenco2)
			System.out.println(ei.descriviti());
		
		System.out.println("\nCorpo libero per calorie:\n");
		ArrayList<Esercizio> elenco3 = new ArrayList<>(p.elencoEserciziCorpoLiberoPerCalorie());
		for(Esercizio ei : elenco3)
			System.out.println(ei.descriviti());
		
		System.out.println("\n/****** R3 ******/");
		
		System.out.println("Nuove schede");
		ArrayList<String> eserciziScheda1 = new ArrayList<>();
		eserciziScheda1.add("psu");
		eserciziScheda1.add("rpj");
		SchedaAllenamento s1 = p.nuovaSchedaAllenamento(0, "2021/12/03", eserciziScheda1);
		
		System.out.println("\nScheda creata:\n");
		for(Esercizio ei : p.eserciziScheda(s1.getCodice()))
			System.out.println(ei.descriviti());
		
		System.out.println("\nAggiunta esercizi:\n");
		eserciziScheda1.add("sqt");
		p.nuovaSchedaAllenamento(0, "2021/12/03", eserciziScheda1);
		for(Esercizio ei : p.eserciziScheda("2021/12/03_0"))
			System.out.println(ei.descriviti());
		
		System.out.println("\nRicerca scheda:\n");
		SchedaAllenamento sTrovata = p.cercaSchedaPerId("2021/12/03_0");
		for(Esercizio ei : p.eserciziScheda(sTrovata.getCodice()))
			System.out.println(ei.descriviti());
		
		System.out.println("\nElenco schede per iscritto\n");
		ArrayList<SchedaAllenamento> schedeTrovate = new ArrayList<>(p.elencoSchedePerIdIscritto(0));
		
		for (SchedaAllenamento si : schedeTrovate) {
			System.out.println("Scheda:" + si.getCodice());
			for(Esercizio ei : p.eserciziScheda(si.getCodice()))
				System.out.println(ei.descriviti());
		}
		
		System.out.println("\n/****** R4 ******/");
		
		System.out.println("\nLettura da file:\n");
		Palestra p2 = new Palestra();
		
		p2.leggiDatiPalestra("input.txt");
		
		System.out.println("\nElenco iscritti:\n");
		ArrayList<Iscritto> elencoIscritti2 = new ArrayList<>(p2.elencoIscritti());
		for(Iscritto ii : elencoIscritti2)
			System.out.println(ii.descriviti());
		
		System.out.println("\nElenco esercizi:\n");
		ArrayList<Esercizio> elencoEsercizi2 = new ArrayList<>(p2.esercizi());
		for(Esercizio ei : elencoEsercizi2)
			System.out.println(ei.descriviti());
	}

}
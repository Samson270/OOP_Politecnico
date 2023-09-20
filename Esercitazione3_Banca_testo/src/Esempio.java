import banca.*;

public class Esempio {

	public static void main(String[] args) {

		Banca b = new Banca();

		// R1. Banca
		
		System.out.println("Creato conto");
		Conto c1 = b.nuovoConto(0.06, 30500, "20211104", "Mario Bianchi", "Banca di Torino - Castelfidardo");

		System.out.println("Codice: "+c1.getCodice());
		System.out.println("Tasso: "+c1.getTassoInteresse());
		System.out.println("Capitale: "+c1.getCapitale());
		System.out.println("Data di apertura: "+c1.getDataApertura());
		System.out.println("Nome filiale: "+c1.getNomeFiliale());
		System.out.println("Nome operatore: "+c1.getNomeOperatore());

		System.out.println("\nDefinito altro conto");
		Conto c2 = b.nuovoConto(0.08, 21900, "20211104", "Paolo Rossi", "Banca di Torino - Castelfidardo");

		System.out.println("Codice: "+c2.getCodice());
		System.out.println("Tasso: "+c2.getTassoInteresse());
		System.out.println("Capitale: "+c2.getCapitale());
		System.out.println("Data di apertura: "+c2.getDataApertura());
		System.out.println("Nome filiale: "+c2.getNomeFiliale());
		System.out.println("Nome operatore: "+c2.getNomeOperatore());

		System.out.println("\nRicerca conto 001");
		Conto contoTrovato = b.cercaConto("001");

		System.out.println("\nInformazioni conto trovato");
		System.out.println(""+contoTrovato.descriviti());
		
		System.out.println("\nRicerca conti contenenti 'oss'");
		
		Conto contiTrovati[] = b.cercaConti("oss");

		System.out.println("\nInformazioni conti trovati");
		for(Conto c : contiTrovati)
			if(c!=null) 
				System.out.println(""+c.descriviti());
		
		// R2. Clienti
		
		System.out.println("\nDefinito cliente");
		b.nuovoCliente("NRELRN78P17L219V", "Neri", "Lorenzo", "Impiegato pubblico");

		System.out.println("\nRicerca cliente NRELRN78P17L219V");

		Cliente cl1 = b.cercaCliente("NRELRN78P17L219V");
		System.out.println("Codice Fiscale: "+cl1.getCodiceFiscale());
		System.out.println("Cognome: "+cl1.getCognome());
		System.out.println("Nome: "+cl1.getNome());
		System.out.println("Professione: "+cl1.getProfessione());

		System.out.println("\nAssegnazione  123 a corso "+"0000");
		
		String[] conti = {"000"};

		b.associaClienteConto("NRELRN78P17L219V", conti);
		
		System.out.println("\nConti cliente NRELRN78P17L219V");
		String contiCliente = b.contiCliente("NRELRN78P17L219V");
		
		System.out.println(contiCliente);
		
		System.out.println("\nClienti conto 000");
		String clientiConto = b.clientiConto("000");
		
		System.out.println(clientiConto);
		
		
		// R3. Prestiti
		
		System.out.println("\nNuovo prestito per il conto 000 e con garante il cliente NRELRN78P17L219V");
		b.nuovoPrestito("000", "NRELRN78P17L219V", 5000, 416.67, 12);
		
		System.out.println("\nPrestiti cliente NRELRN78P17L219V");
		Prestito prestitiCliente[] = b.prestiti("NRELRN78P17L219V");
		
		for(Prestito p : prestitiCliente)
			if(p!=null) 
				System.out.println(""+p.descriviti());
		
	}

}
package banca;

public class Banca {

	private Conto[] conti = new Conto[1000];
	private Cliente[] clienti = new Cliente[300];	
	private Fido[] fidi = new Fido[300];
	private Mutuo[] mutui = new Mutuo[300];
	private Prestito[] prestiti = new Prestito[300];
	private int numConti = 0;
	private int numClienti = 0;
	private int numFidi = 0;
	private int numMutui = 0;
	private int numPrestiti = 0;
	
	public Banca() {
	}
	
	public Conto nuovoConto(double tassoInteresse, double capitale, String dataApertura, String nomeOperatore, String nomeFiliale) {
		conti[numConti] = new Conto(tassoInteresse, capitale, dataApertura, nomeOperatore, nomeFiliale, numConti);
		numConti++;
		return conti[numConti-1];
	}

	public Conto cercaConto(String codiceConto) {
		for(Conto c : conti) {
			if(c!=null && c.getCodice().equals(codiceConto) == true) {
				return c;
			}
		}
		return null;
	}

	public Conto[] cercaConti(String daCercare) {
		Conto[] array = null;
		int k=0, conta = 0;
		for(Conto c : conti) {
			if(c!=null && (c.getNomeFiliale().toUpperCase().contains(daCercare.toUpperCase()) == true || c.getNomeOperatore().toUpperCase().contains(daCercare.toUpperCase()) == true)) {				
				k++;
			}
		}
		array = new Conto[k];
		for(int i = 0; i<numConti;i++) {
			if(this.conti[i].getNomeFiliale().toUpperCase().contains(daCercare.toUpperCase()) == true || this.conti[i].getNomeOperatore().toUpperCase().contains(daCercare.toUpperCase()) == true) {
				array[conta] = this.conti[i];
				conta++;
			}
		}
	
		System.out.println(array[0].getNomeFiliale() + "\n\n\n"/* + array[1].getNomeFiliale()*/);
		return array;
	}
	
	public Cliente nuovoCliente(String codiceFiscale, String cognome, String nome, String professione) {
		for(Cliente c : clienti) {
			if(c != null && c.getCodiceFiscale().equals(codiceFiscale) == true) {
				c.setCognome(cognome);
				c.setNome(nome);
				c.setProfessione(professione);
				return c;
			}
		}
		clienti[numClienti] = new Cliente(codiceFiscale, cognome, nome, professione);
		numClienti++;
		return clienti[numClienti-1];
	}
	
	public Cliente cercaCliente(String codiceFiscale) {
		for(Cliente c : clienti) {
			if(c != null && c.getCodiceFiscale().equals(codiceFiscale) == true) {
				return c;
			}
		}
		return null;
	}
	
	public boolean[] associaClienteConto(String codiceFiscale, String[] codiciConto) {
		boolean[] intestati = new boolean[codiciConto.length];
		for(Cliente cli : clienti) {
			if(cli != null && cli.getCodiceFiscale().equals(codiceFiscale) == true) {
				for(int i=0;i<codiciConto.length;i++) {
					intestati[i] = false;
					for(Conto con : conti) {
						if(con != null && con.getCodice().equals(codiciConto[i]) == true) {
							con.setIntestato(true);
							con.setIntestatari(codiceFiscale);
							intestati[i] = true;
							cli.setContiIntestati(con.getCodice());
						}
					}
				}
			}
		}
		return intestati;
	}
	
	public Cliente intestatario(String codiceConto) {
		for(Conto c : conti) {
			if(c != null && c.getCodice().equals(codiceConto) == true) {
				for(Cliente cli : clienti) {
					if(cli != null && cli.getCodiceFiscale().equals(c.getIntestatario()) == true) {
						return cli;
					}
				}
			}
		}
		return null;
	}

	public String contiCliente(String codiceFiscale) {
		for(Cliente c : clienti) {
			if(c != null && c.getCodiceFiscale().equals(codiceFiscale) == true) {
				return c.getContiIntestati();
			}
		}
		return null;
	}

	public String clientiConto(String codiceConto) {
		for(Conto c : conti) {
			if(c != null && c.getCodice().equals(codiceConto) == true) {
				return c.getListaIntestatari();
			}
		}
		return null;
	}
	
	public Fido nuovoPrestito(String codiceConto, String codiceCliente, double importo, double rataMensile, double tassoRischio) {
		for(Cliente cli : clienti) {
			if(cli != null && cli.getCodiceFiscale().equals(codiceCliente)) {
				for(Conto c : conti) {
					if(c != null && c.getCodice().equals(codiceConto)) {
						if(cli.contoAssociato(codiceConto) == true) {	
							if(tassoRischio <= 0.75) {
								fidi[numFidi] = new Fido(codiceConto, codiceCliente, importo, rataMensile, tassoRischio);
								cli.setGarantePrestito(true);
								c.aggiornaCapitale(importo);
								numFidi++;
								prestiti[numPrestiti] = new Prestito(codiceConto, codiceCliente, "F", importo, rataMensile, tassoRischio);
								numPrestiti++;
								return fidi[numFidi-1];
							}
						}
					}
				}
			}
		}
		return null;
	}
	
	public Mutuo nuovoPrestito(String codiceConto, String codiceCliente, double importo, double rataMensile, int numeroMesi) {
		for(Cliente cli : clienti) {
			if(cli != null && cli.getCodiceFiscale().equals(codiceCliente)) {
				for(Conto c : conti) {
					if(c != null && c.getCodice().equals(codiceConto)) {
						if(cli.contoAssociato(codiceConto) == true) {
							if(cli.isGarantePrestito() == false) {
								c.aggiornaCapitale(importo);
								mutui[numMutui] = new Mutuo(codiceConto, codiceCliente, importo, rataMensile, numeroMesi);
								numMutui++;
								prestiti[numPrestiti] = new Prestito(codiceConto, codiceCliente, "M", importo, rataMensile);
								numPrestiti++;
								return mutui[numMutui-1];
							}
						}
					}
				}
			}
		}
		return null;
	}

	public Prestito[] prestiti() {
		Prestito[] listaPerCodice = new Prestito[numPrestiti];
		int k = 0;
		for(int i = 0; i  < numPrestiti; i++) {
			listaPerCodice[k] = this.prestiti[i];
			k++;
		}
		return listaPerCodice;		
	}
	
	public Prestito[] prestiti(String codiceFiscale) {
		Prestito[] listaPerCodice = null;
		int k = 0, conta=0;
		for(int i = 0; i < numPrestiti; i++) {
			if(this.prestiti[i].getCodiceCliente().equals(codiceFiscale) == true) {
				conta++;
			}
		}
		listaPerCodice = new Prestito[conta];
		for(int i=0; i<numPrestiti;i++) {	
			if(this.prestiti[i].getCodiceCliente().equals(codiceFiscale) == true) {
				listaPerCodice[k] = this.prestiti[i];
				k++;
			}
		}
		return listaPerCodice;
	}
	
	public Prestito[] prestiti(String codiceFiscale, String tipo) {
		Prestito[] listaPerCodiceTipo = null; 
		int k = 0, conta = 0;
		for(int i = 0; i < numPrestiti; i++) {
			if(this.prestiti[i].getCodiceCliente().equals(codiceFiscale) == true && this.prestiti[i].getTipo().equals(tipo) == true) {
				conta++;
			}
		}
		listaPerCodiceTipo = new Prestito[conta];
		for(Prestito p : prestiti) {
			if(p != null && p.getCodiceCliente().equals(codiceFiscale) == true && p.getTipo().equals(tipo) == true) {
				listaPerCodiceTipo[k] = p;
				k++;
			}
		}
		return listaPerCodiceTipo;
	}
}



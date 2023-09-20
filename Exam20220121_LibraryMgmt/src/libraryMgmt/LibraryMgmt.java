package libraryMgmt;
import java.util.*;
import java.time.*;
import java.time.temporal.ChronoUnit;

public class LibraryMgmt {
	
	int volumeCount=0, indicePrestito = 0;
	LocalDate date;
	LinkedList<Libro> libri = new LinkedList<Libro>();
	TreeMap<String, Libro> mt = new TreeMap<String, Libro>();
	LinkedList<User> utenti = new LinkedList<User>();
	TreeMap<String, User> mu = new TreeMap<String, User>();
	LinkedList<Prestito> prestiti = new LinkedList<Prestito>();


	//R0
	/**
	 * Defines the current date
	 * @param date current date
	 */
	public void setCurrentDate(LocalDate date) {
		this.date = date;
	}

	/**
	 * retrieves current library system date
	 * @return current date
	 */
	public LocalDate getCurrentDate () {
		return date;
	}

	/**
	 * Moves current date forward
	 * @param nOfDays number of days forward
	 */
	public void addDays (long nOfDays) {
		date = date.plusDays(nOfDays);
	}


	//R1
	/**
	 * Add a new book with corresponding volumes
	 * 
	 * @param title    title of the book
	 * @param nVolumes number of volumes available
	 * @param authors  list of authors
	 * @return volume index range
	 * @throws LMException
	 */
	public String addBook(String title, int nVolumes, String... authors) throws LMException {
		LinkedList<String> l = new LinkedList<String>();
		if(mt.containsKey(title)) {
			throw new LMException(title);
		}
		else {
			for(String s : authors) {
				if(s != null) {
					l.add(s);
				}
			}
			int tmp = volumeCount+1;
			volumeCount += nVolumes;
			Libro book = new Libro(title, nVolumes, l, tmp, volumeCount);
			libri.add(book);
			mt.put(title, book);
			return tmp + ":" + volumeCount;
		}
	}

	/**
	 * Adds a new user with relative parameters
	 * 
	 * @param name
	 * @param maxNofBooks
	 * @param duration
	 * @return
	 * @throws LMException
	 */
	public String addUser (String name, int maxNofBooks, int duration) throws LMException {
		if(mu.containsKey(name)) {
			throw new LMException(name);
		}
		else {
			User u = new User(name, maxNofBooks, duration);
			mu.put(name, u);
			utenti.add(u);
			return name + ":" + maxNofBooks + ":" + duration;
		}
	}

	//R2
	/**
	 * Adds a new volume loan in the system.
	 * 
	 * @param user : user name
	 * @param title: book title
	 * @return loan index
	 * @throws LMException
	 */
	public int addLoan (String user, String title) throws LMException {
		Libro b = mt.get(title);
		User u = mu.get(user);
		if(u.getMaxNofBooks() == u.getNoleggi()) {
			throw new LMException("maxNofBooks");
		}
		else if(b.getVol1() > b.getVol2()) {
			throw new LMException("noVolumesLeft");
		} else {
			for(Prestito p : prestiti) {
				if(p.getUser().equals(user)) {
					if(p.getDataPrev().compareTo(date)<0) {
						throw new LMException("Wrong loan return date");
					}
				}
			}
			Prestito p = new Prestito(user, title, b.getVol1(), date.plusDays(u.getDuration()), null);
			b.setVol1(b.getVol1()+1);
			u.incNoleggi(1);
			prestiti.add(p);
			indicePrestito = indicePrestito + 1;
			return indicePrestito;
		}
	}

	/**
	 * Retrieves loan information
	 * 
	 * @param loanIndex
	 * @return information as string
	 */
	public String getLoanInfo (int loanIndex) {
		Prestito p = prestiti.get(loanIndex-1);
		return p.getUser() + ":" + loanIndex + ":" + p.getIndex() + ":" + p.getDataPrev() + ":" + p.getStato(date);
	}

	/**
	 * Closes a loan
	 * 
	 * @param loanIndex loan index
	 * @return loan return date
	 */
	public LocalDate closeLoan (int loanIndex)  { //throws LMException
		Prestito p = prestiti.get(loanIndex-1);
		p.setDataRest(date);
		p.setStato("closed");
		User u = mu.get(p.getUser());
		u.decNoleggi(1);
		Libro b = mt.get(p.getTitle());
		b.setVol1(b.getVol1()-1);
		return this.date;
	}


	/**
	 * Retrieves number of volumes currently on loan to user
	 * @param user
	 * @return number of volumes
	 */
	public int numberOfBooks (String user) {
		int conta=0;
		for(Prestito p : prestiti) {
			if(p.getUser().equals(user)) {
				if(p.getStato(date).equals("ongoing") || p.getStato(date).equals("overdue")) {
					conta++;
				}
			}
		}
		return conta;
	}

	//R3  statistics

	/**
	 * Returns map of authors grouped by title
	 * 
	 * @return map title -> author list
	 */
	public TreeMap<String, ArrayList<String>> authorsByTitle() {
		Collections.sort(libri, new OrdinaLibri());
		TreeMap<String, ArrayList<String>> tmp = new TreeMap<String, ArrayList<String>>();
		for(Libro l : libri) {
			tmp.put(l.getTitle(), l.getArrayAuthors());
		}
		return tmp;
	}


	/**
	 * Retrieves total loans for users (including closed ones)
	 * 
	 * @return map user -> loan number
	 */
	public TreeMap<String, Integer> numberOfTotalLoansByUser() {
		int conta = 0;
		Collections.sort(utenti, new OrdinaUsers());
		TreeMap<String, Integer> tmp = new TreeMap<String, Integer>();
		for(User u : utenti) {
			conta = 0;
			for(Prestito p : prestiti) {
				if(p.getUser().equals(u.getName()))
					conta++;
			}
			if(conta != 0)
				tmp.put(u.getName(), conta);
		}
		return tmp;
	}

	//R4  queries

	/**
	 * returns the list of loans whose due date is equal to the current date.
	 * 
	 * @return list of loan indexes
	 */
	public List<Integer> dailyOverdue(){
		LinkedList<Integer> tmp = new LinkedList<Integer>();
		int i=1;
		for(Prestito p : prestiti) {
			if(p.getDataPrev().compareTo(date) == 0) {
				tmp.add(i);
			}
			i++;
		}
		return tmp;
	}

	/**
	 * returns the average delay of loan returns for given user
	 * @param userName
	 * @return
	 */
	public double averageDelay(String userName) {
		int conta=0;
		double media = 0.0;
		for(Prestito p : prestiti) {
			if(p.getUser().equals(userName)) {
				if(p.getDataPrev().compareTo(p.getDataRest())<0) {
					media += p.getDataPrev().until(p.getDataRest(), ChronoUnit.DAYS);
					conta++;
					}
				else
					conta++;
			}
		}
		return media/conta;
	}

	/**
	 * returns the number of volumes available for the book with the given title
	 * @param title
	 * @return number of available volumes
	 */
	public long availableVolumes(String title) {
		Libro b = mt.get(title);
		return b.getVol2() - b.getVol1()+1;
	}


}

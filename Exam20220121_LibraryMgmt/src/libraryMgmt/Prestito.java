package libraryMgmt;

import java.time.LocalDate;

public class Prestito {
	private String user, title, stato;
	private int index;
	private LocalDate DataPrev, DataRest;
	
	public Prestito(String user, String title, int index, LocalDate dataPrev, LocalDate dataRest) {
		this.user = user;
		this.title = title;
		this.index = index;
		DataPrev = dataPrev;
		DataRest = dataRest;
		stato = "ongoing";
	}
	
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getIndex() {
		return index;
	}
	public void setIndex(int index) {
		this.index = index;
	}
	public LocalDate getDataPrev() {
		return DataPrev;
	}
	public void setDataPrev(LocalDate dataPrev) {
		DataPrev = dataPrev;
	}
	public LocalDate getDataRest() {
		return DataRest;
	}
	public void setDataRest(LocalDate dataRest) {
		DataRest = dataRest;
	}
	
	
	public String getStato(LocalDate date) {
		if(DataRest != null) {
			stato = "closed";
		}else if(DataPrev.compareTo(date)>=0) {
			stato = "ongoing";
		} else {
			stato = "overdue";
		}
		return stato;
	}
	public void setStato(String stato) {
		this.stato = stato;
	}
	
}

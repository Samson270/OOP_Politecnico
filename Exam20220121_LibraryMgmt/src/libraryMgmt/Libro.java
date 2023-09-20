package libraryMgmt;

import java.util.*;

public class Libro {
	private String title;
	private int nVolumes, Vol1, Vol2;

	LinkedList<String> authors;
	
	public Libro(String title, int nVolumes, LinkedList<String> authors, int Vol1, int Vol2) {
		this.title = title;
		this.nVolumes = nVolumes;
		this.authors = authors;
		this.Vol1 = Vol1;
		this.Vol2 = Vol2;
		Collections.sort(this.authors, new OrdinaAutori());
	}

	public int getVol1() {
		return Vol1;
	}

	public void setVol1(int vol1) {
		Vol1 = vol1;
	}
	
	public int getVol2() {
		return Vol2;
	}

	public void setVol2(int vol2) {
		Vol2 = vol2;
	}
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getnVolumes() {
		return nVolumes;
	}

	public void setnVolumes(int nVolumes) {
		this.nVolumes = nVolumes;
	}

	public LinkedList<String> getAuthors() {
		return authors;
	}

	public void setAuthors(LinkedList<String> authors) {
		this.authors = authors;
	}
	
	public ArrayList<String> getArrayAuthors() {
		ArrayList<String> autori = new ArrayList<String>();
		for(String s : this.authors) {
			autori.add(s);
		}
		return autori;
	}
	
	
}

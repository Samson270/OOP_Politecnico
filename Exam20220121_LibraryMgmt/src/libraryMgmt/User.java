package libraryMgmt;

public class User {
	private String name;
	private int maxNofBooks, duration, noleggi=0;

	public User(String name, int maxNofBooks, int duration) {
		this.name = name;
		this.maxNofBooks = maxNofBooks;
		this.duration = duration;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getMaxNofBooks() {
		return maxNofBooks;
	}
	public void setMaxNofBooks(int maxNofBooks) {
		this.maxNofBooks = maxNofBooks;
	}
	public int getDuration() {
		return duration;
	}
	public void setDuration(int duration) {
		this.duration = duration;
	}
	
	public int getNoleggi() {
		return noleggi;
	}
	public void incNoleggi(int n) {
		this.noleggi += n;
	}
	public void decNoleggi(int n) {
		this.noleggi -= n;
	}
	
}

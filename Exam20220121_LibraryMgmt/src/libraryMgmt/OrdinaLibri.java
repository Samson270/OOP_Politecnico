package libraryMgmt;

import java.util.Comparator;

public class OrdinaLibri implements Comparator {
		
		@Override
		public int compare(Object o1, Object o2) {
			Libro s1 = (Libro)o1;
			Libro s2 = (Libro)o2;
			return s1.getTitle().compareTo(s2.getTitle());
			}
	
}

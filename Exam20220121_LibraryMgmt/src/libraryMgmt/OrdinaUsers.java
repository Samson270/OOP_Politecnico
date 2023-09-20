package libraryMgmt;

import java.util.Comparator;

public class OrdinaUsers implements Comparator{

		@Override
		public int compare(Object o1, Object o2) {
			User s1 = (User)o1;
			User s2 = (User)o2;
			return s1.getName().compareTo(s2.getName());
		}

	
}

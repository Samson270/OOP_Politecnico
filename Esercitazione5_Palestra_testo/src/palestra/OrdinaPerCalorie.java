package palestra;

import java.util.*;

public class OrdinaPerCalorie implements Comparator{

	@Override
	public int compare(Object o1,Object o2) {
		CorpoLibero c1 = (CorpoLibero)o1;
		CorpoLibero c2 = (CorpoLibero)o2;
		return Double.compare(c1.getCalorie(), c2.getCalorie());
	}

}

package palestra;

import java.util.*;

public class OrdinaSchedePerId implements Comparator{

	@Override
	public int compare(Object o1, Object o2) {
		SchedaAllenamento s1 = (SchedaAllenamento)o1;
		SchedaAllenamento s2 = (SchedaAllenamento)o2;
		if(s1.getCodiceIscritto() - s2.getCodiceIscritto() != 0) {
			return s1.getCodiceIscritto() - s2.getCodiceIscritto();
		}
		else {
			return s1.getData().compareTo(s2.getData());
		}
	}

}

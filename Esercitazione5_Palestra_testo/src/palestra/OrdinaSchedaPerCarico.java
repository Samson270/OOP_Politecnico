package palestra;

import java.util.Comparator;

public class OrdinaSchedaPerCarico implements Comparator{

	@Override
	public int compare(Object o1, Object o2) {
		 Weightlifting w1 = ( Weightlifting)o1;
		 Weightlifting w2 = ( Weightlifting)o2;
		 return w2.getCarico() - w1.getCarico();
	}

	
}

package aeroporto;

public class Aerei {
	int Max = 1000;
	String Nome[] = new String[Max];
	int capienza[] = new int[Max];
	int chilometriAutonomia[] = new int[10000];
	boolean assegnato[] = new boolean[Max];
	int id[] = new int[Max];
	int num = 0;
	
	
	public int aggiungiAereo(String name,int cap,int km) {
		int n = controllaAereo(name, cap, km);
		if(n == -1) {
		Nome[num] = name;
		capienza[num] = cap;
		chilometriAutonomia[num] = km;
		id[num] = num;
		assegnato[num] = false;
		num++;
		return id[num-1];}
		else return n;
	}
	
	public String Aereo(int i) {
		return Nome[i] + ";" + capienza[i] + ";" + chilometriAutonomia[i];
	}
	
	
	public int getNum() {
		return num;
	}

	public String[] bloccoAerei() {
		String aereo[] = new String[num];
		for(int i=0; i<num; i++) {
			aereo[i] = id[i] + ";" + Nome[i];
		}
		return aereo;
	}
	
	public int assegnaAereo(String tratta, int numPass, int km) {
		int scartoPasseggeri = 1000;
		int scartoKm = 10000;
		int index = -1;
		for(int i=0; i<num; i++) {
			if(assegnato[i] != true) {
				if(capienza[i] - numPass < scartoPasseggeri && capienza[i] - numPass >= 0 && chilometriAutonomia[i] - km >= 0) {
					index = i;
					scartoPasseggeri = capienza[i] - numPass; 
					scartoKm = chilometriAutonomia[i] - km;
				}
				else if(capienza[i] - numPass == scartoPasseggeri) {
					if(chilometriAutonomia[i] - km < scartoKm && chilometriAutonomia[i] - km >= 0) {
						index = i;
						scartoKm = chilometriAutonomia[i] - km;						
					}
				}
			}
		}
		if(index != -1) {
			assegnato[index] = true;
			System.out.println("valore di ritorno: " + index );
			return id[index];
		}
		else return -1;
	}
	
	
	
	
	
	
	
	 int controllaAereo(String n, int c, int k) {
		for(int i = 0; i < num; i++) {
		    if(n == Nome[i] && c == capienza[i] && k == chilometriAutonomia[i]) {
				return id[i];
			}			
		}
		return -1;
	}
}



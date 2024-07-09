// Necessário para que existam módulos que retornam ambos Pino e Torre, dependendo do caso.

import java.util.*;

interface Peça {
	
	public String getCor();
	public void setTorre();
	public void unsetTorre();
	public int size();
	public ArrayList<Pino> getPinos();

}
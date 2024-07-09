// Classe que define a contrução e manipulação de torres de pinos

import java.util.ArrayList;

public class Torre implements Peça{
	
	private String cor;
	private Pino pino, pino1, pino2;
	private Peça peça;
	private ArrayList<Pino> torre;
	private ArrayList<Pino> pinos;
	

	public Torre(Pino pino1, Pino pino2){
		if (pino1.getCor() == pino2.getCor()){
			this.torre = new ArrayList<Pino>();
			pino1.setTorre();
			this.torre.add(pino1);
			this.torre.add(pino2);
			this.cor = pino1.getCor();
		}
	}

	public Torre(ArrayList<Pino> pinos, Pino pino){
		if (pinos.get(0).getCor() == pino.getCor()){
			pinos.add(pino);
			this.torre = pinos;
			this.cor = pino.getCor();
		}
	}

	public Torre(ArrayList<Pino> pinos) {
		this.torre = pinos;
		this.cor = pino.getCor();
	}

	public Torre(Peça peça, Pino pino) {
		if ( peça instanceof Pino) {
			peça = (Pino)peça;
			if (((Pino)peça).getCor() == pino.getCor()){
				this.torre = new ArrayList<Pino>();
				peça.setTorre();
				this.torre.add((Pino)peça);
				this.torre.add(pino);
				this.cor = pino.getCor();
			}
		} else {
			peça = (Torre)peça;
			if (peça.getCor() == pino.getCor()){
				this.torre.add(pino);
				this.cor = pino.getCor();
			}
		}

	}

	public void add(Pino pino) {
		this.torre.add(pino);
		return;
	}

	public ArrayList<Pino> getPinos(){
		return this.torre;
	}

	public String getCor(){
        return this.cor;
	}

	public int size() {
		return this.torre.size();
	}

    public void setTorre() { // Só existe para resolver casos em que se tenta fazer setTorre em algo que já é torre;
    	return;
    }
    public void unsetTorre() { 
        return;
    }
}

/*
Classe criada apenas porque parece não existir tupls em java. TUdo que eu queria é (Peça, Indice), mas não. Um ArrayList só pode ter um tipo.
Se for um ArrayList<Object> vai haver uma perda de informação pois a Peça vai ser convertida para um Object genérico e todos os métodos de Peça
se tornam inacessíveis. 
Tentei criar um Pair mas isso requere javafx que teria que baixar e só causa problemas. Portanto fui forçado a criar essa classe redundante. 
*/
public class Par {

	private Peça peça;
	private int indice; 
	
	public Par(Pino pino, int indice) {
		this.peça = peça;
		this.indice = indice;
	}

	public Par(Torre torre, int indice) {
		this.peça = peça;
		this.indice = indice;
	}


	public Peça getPeça() {
		return this.peça;
	}

	public int getIndice() {
		return this.indice;
	}
}
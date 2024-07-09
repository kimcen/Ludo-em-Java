/* Classe que controla as posições de tudo no tabuleiro.
Existem 52 casas no tabuleiro, começando na casa inicial azul e seguindo em sentido horário.
*/
import java.util.*;
import java.util.HashMap;


public class Tabuleiro {
	
	private ArrayList<Pino> quadrados; // Um array com todas as casas
	private ArrayList<Integer> casasSeguras; // Um array com as casas em que pinos não podem ser comidos
	private Pino pino; 
	private String cor;
	private Par par; // Usado para retornar checarCaminho
	private HashMap<String, ArrayList<pino>> retaFinal; // Guarda as posições das quatro retas finais


	public Tabuleiro() {
		quadrados = new ArrayList<pino>(53); // É preciso testar pra ver se ela já é iniciada com null em todas as casas, senão, preencher com null // A primeira casa "0" não é utilizada nunca, sempre é null

		casasSeguras = new ArrayList<Integer>();
		casasSeguras.add(10);
		casasSeguras.add(23);
		casasSeguras.add(36);
		casasSeguras.add(49);
		casasSeguras.add(2); // casas iniciais das cores
		casasSeguras.add(15);
		casasSeguras.add(28);
		casasSeguras.add(41);

		retaFinal = new HashMap<String, ArrayList<Pino>>();
		retaFinal.put("Azul", new ArrayList<Pino>(5));
		retaFinal.put("Vermelho", new ArrayList<Pino>(5));
		retaFinal.put("Verde", new ArrayList<Pino>(5));
		retaFinal.put("Amerelo", new ArrayList<Pino>(5));

	}
	
	public boolean éEspecial(int casa) {
		return casasSeguras.contains(casa);
	}


	// AtualizaCasa(int casa, Object pino) retira o pino do array e o sobescreve a nova posição
	public void atualizarCasa(int posiçãoNoTabuleiro, Pino pino) {  //pino pode ser Torre

		//Caso em que o peão entrou no fim
		if (posiçãoNoTabuleiro == Integer.MAX_VALUE) {
			retaFinal.get(cor).remove(pino);
		}
		// Está na reta final
		if (posiçãoNoTabuleiro > 52) {
			cor = pino.getCor();
			try{
				quadrados.remove(pino);
				retaFinal.get(cor).set( posiçãoNoTabuleiro - 53 , pino);
			}finally{ // se der erro, ignorar. Não sei se tem que botar um catch com código vazio
				retaFinal.get(cor).set( posiçãoNoTabuleiro - 53 , pino);
			}
		} else {
			try {
				quadrados.remove(pino); // Exclui a posição antiga do pino
			}finally{
				quadrados.set(posiçãoNoTabuleiro, pino);
			}
		}
	}

	// Retorna o objeto que ocupa a casa
	public Pino getCasa(int posiçãoNoTabuleiro, String cor){
		// se a peça está na reta final
		if (posiçãoNoTabuleiro > 52){
			pino = retaFinal.get(cor).get( posiçãoNoTabuleiro-52 );
		}else{
			pino = quadrados.get(posiçãoNoTabuleiro);
		}
		return pino;
	}


	// Checa se o caminho entre duas casas está livre ou se tem algum obstáculo. 
	public Par checarCaminho(int casaInicial, int casaFinal, String cor) { 
		for (int counter = casaInicial + 1; counter <= casaFinal; counter++) {
			pino = quadrados.get(counter);

			// Se casa está vazia
			if (pino == null){
				par = null;
			} else {

				// outra cor, retorna o par com a peça e posição
				if (pino.getCor() != cor){
		                return new Par(pino, counter);
		            
		        // mesma cor, pode passar por cima caso não seja o último
				} else {
		            par = new Par(pino, counter);
				}
			} 
		}
		// null se não encontrou nada, Par com o primeiro pino de outra cor encontrado e a posição dele. 
		return par;
	}

	public void voltarBase(Pino pino) {
		quadrados.remove(pino);
		return;
	}

}
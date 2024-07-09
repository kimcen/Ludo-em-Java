// Fim é o nome das quatro casas no centro do tabuleiro

import java.util.*;

public class Finais implements CasaEspecial {

    private String cor;
    private Pino pino;
    private ArrayList<Pino> pinos;
    private Map<String, ArrayList<Pino>> finais;

    public Finais(ArrayList<Jogador> jogadores) {
        finais = new HashMap<String, ArrayList<Pino>>();

        for (Jogador jogador : jogadores) {
            cor = jogador.getCor();
            pinos = new ArrayList<Pino>();

            finais.put(cor, pinos);
        }
    }

    public void retirarPino(Pino pino) {
        finais.get(pino.getCor()).remove(pino);
        return;
    }

    public void adicionarPino(Pino pino) {
        finais.get(pino.getCor()).add(pino);
        return;
    }

    public boolean isFull(String cor) {
        if (finais.get(cor).size() == 4)
            return true;
        else
            return false;
    }

    public String getCor() {
        return cor;
    }

    public Map<String, ArrayList<Pino>> getPinos() {
        return finais;
    }
}

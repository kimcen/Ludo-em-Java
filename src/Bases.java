// Base é o nome das quatro casas iniciais

import java.util.*;

public class Bases implements CasaEspecial {

    private String cor;
    private Pino pino, p1, p2, p3, p4;
    private ArrayList<Pino> pinos;
    private Map<String, ArrayList<Pino>> bases;

    public Bases(ArrayList<Jogador> jogadores) {
        bases = new HashMap<String, ArrayList<Pino>>();

        for (Jogador jogador : jogadores) {
            cor = jogador.getCor();
            pinos = new ArrayList<Pino>();
            p1 = new Pino(cor, 1);
            p2 = new Pino(cor, 2);
            p3 = new Pino(cor, 3);
            p4 = new Pino(cor, 4);

            pinos.add(p1);
            pinos.add(p2);
            pinos.add(p3);
            pinos.add(p4);
            bases.put(cor, pinos);
        }
    }

    public void retirarPino(Pino pino) {
        bases.get(pino.getCor()).remove(pino);
        return;
    }

    public void adicionarPino(Pino pino) {
        bases.get(pino.getCor()).add(pino);
        return;
    }

    public boolean isFull(String cor) {
        if (bases.get(cor).size() == 4)
            return true;
        else
            return false;
    }

    public Map<String, ArrayList<Pino>> getPinos() {
        return bases;
    }
}

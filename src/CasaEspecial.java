import java.util.ArrayList;
import java.util.Map;


interface CasaEspecial {

    public void adicionarPino(Pino pino);

    public boolean isFull(String cor);

    public Map<String, ArrayList<Pino>> getPinos();
}
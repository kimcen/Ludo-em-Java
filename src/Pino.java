import java.util.*;

public class Pino implements Peça {

    private String cor; // Só pode ser movido pelo jogador da mesma cor
    private Bases base; // É necessário trazer a base aqui para poder retirar e adicionar pinos a base correta
    private Finais finais; //
    private Jogador jogador; 
    private Peça peça; // Variável que recebe o que ocupa em um casa
    private Torre torre;
    private Par par; // O mesmo que casa, mas é um par com o a posição da peça no tabuleiro
    private Tabuleiro tabuleiro; // É necessário chamar módulos do tabuleiro do jogo para mover as peças
    private int posição, novaPosição; // É a posição relativa a sua posição inicial (depende da cor), zero sendo na base
    private int posiçãoNoTabuleiro, novaPosiçãoNoTabuleiro, posiçãoInicial; // Posição a ser mostrada na GUI
    private int indice; // identifica cada pino
    private boolean emTorre; //Pino entra em torre quando um outro pino entra na mesma casa que a sua. Pino imovível if true
    private ArrayList<Pino> pinos;
    private static HashMap<String, Integer> posiçõesIniciais; //Guarda as posições iniciais no tabuleiro para cada cor
    static {
        posiçõesIniciais = new HashMap<String, Integer>();
        posiçõesIniciais.put("Azul", 1);
        posiçõesIniciais.put("Amarelo", 14);
        posiçõesIniciais.put("Vermelho", 27);
        posiçõesIniciais.put("Verde", 40);
    }


    public Pino(String cor, int indice){
        this.cor = cor;
        this.posição = 0;
        this.indice = indice;
        this.emTorre = false;
    }

    public int getIndice() {
        return this.indice;
    }

    public String getCor() {
        return this.cor;
    }

    public void voltarBase(Bases bases) { // Acionado quando o pino é comido
        this.posição = 0;
        bases.adicionarPino(this);
        return;
    }

    //tirei os argumentos de setTorre e unsetTorre porque toda vez que foram chamados foi da forma object.setTorre()
    public void setTorre(){ // Marca o pino como estando em torre
        this.emTorre = true;
        return;
    }

    public void unsetTorre() { // Marca o pino como não estando em torre
        this.emTorre = false;
        return;
    }

    public int size() {  // Pino pode ser considerado uma torre de tamanho 1 para simplificar o código
        return 1;
    }

    public ArrayList<Pino> getPinos() {
        pinos = new ArrayList<Pino>();
        pinos.add(this);
        return pinos;
    }

    public void moverPino(Jogador jogador, int valor, Bases bases, Finais finais, Tabuleiro tabuleiro) throws ValorInsuficiente, PinoImovível {

        posiçãoInicial = posiçõesIniciais.get(this.cor);

        // Quando o pino não é da sua cor ou está de baixo de um outro pino (emTorre)
        if ((jogador.getCor() != this.cor) || this.emTorre) { 
            throw new PinoImovível("Você não pode mover este pino!");
        }

        // Quando pino já chegou ao fim
        if (this.posição == Integer. MAX_VALUE) { 
            throw new PinoImovível("Este pino já chegou ao seu destino!");
        }

        // Quando o pino está na Base
        if (this.posição == 0) { 
            if (valor < 5){
                throw new ValorInsuficiente("Precisas rodar um número maior que 5 para retirar um pino da base! Escolha outro pino para mover.");
            } else {
                pinos = tabuleiro.getCasa(posiçãoInicial, this.cor);

                // Casa inicial está livre
                if (pinos.get(0) == null) {  // TESTAR ISSO
                    bases.retirarPino(this); 
                    this.posição = 1; 
                    posiçãoNoTabuleiro = posiçãoInicial;
                    tabuleiro.atualizarCasa(posiçãoNoTabuleiro, this);
                    return;

                // Casa ocupada
                } else { 

                    // Da mesma cor
                    if ( pinos.get(0).getCor().equals(this.cor) ){ 
                        bases.retirarPino(this);  
                        this.posição = 1;
                        posiçãoNoTabuleiro = posiçãoInicial;
                        torre = new Torre(pinos, this);
                        tabuleiro.atualizarCasa(posiçãoNoTabuleiro, torre);
                        return;

                    // De cor diferente
                    } else { 
                        throw new PinoImovível("Não pode retirar este pino! A casa inicial está ocupada!");
                    }
                }
            }
        }


        posiçãoNoTabuleiro = (posiçãoInicial + this.posição) % 52; // Converte a posição (relativa ao começo) para a posição no tabuleiro 

        novaPosição = this.posição + valor;

        // Se está completando uma volta, só checar até a última casa antes da reta final 
        if (this.posição < 52 && novaPosição > 52) {
        
            par = tabuleiro.checarCaminho(posiçãoNoTabuleiro, (posiçãoInicial + 50) % 52); // Só checa até a última casa antes da reta final (52)
        
        // Se já está na reta final
        }else if( this.posição > 52){

            // Possui o número exato para entrar no fim
            if ( novaPosição == 58){
                this.posição = Integer.MAX_VALUE;
                finais.adicionarPino(this);
                tabuleiro.atualizarCasa(posição, this); //Só retira o pino do tabuleiro (entra no fim)
                return;
            
            // Valor no dado alto demais
            } else if (novaPosição > 58) {
                novaPosição = 58 - (novaPosição - 58);  // O pino anda o número de casas restantes na direção oposta

            // Se a nova posição ainda for dentro da reta final, a lógica segue a mesma 
            }

            pinos = tabuleiro.getCasa(novaPosição, this.cor); 
            if ( pinos.size() > 1) {
                par = new Par(new Torre(pinos), novaPosição);
            }else if (pinos.get(0) != (Pino)null) {
                par = new Par(pinos.get(0), novaPosição);
            }else{
                par = (Par)null;
            }


        }else{
            novaPosiçãoNoTabuleiro = (posiçãoNoTabuleiro + valor) % 52; //  Adiciona o valor do dado a posição no tabuleiro

            par = tabuleiro.checarCaminho(posiçãoNoTabuleiro, novaPosiçãoNoTabuleiro);
        }


        // Caminho livre
        if (par == null) { 
            tabuleiro.atualizarCasa(posiçãoNoTabuleiro, this);

        // Caminho ocupado
        }else{

            indice = par.getIndice(); //posição no tabuleiro da casa
            peça = par.getPeça(); //pino ou torre
        
            // Caso tenha rodado o número exato de casas
            if (indice == novaPosiçãoNoTabuleiro) {  

                // Mesma cor
                if (peça.getCor().equals(this.cor)) {
                    // Cria torre
                    if (peça instanceof Torre) {
                        Torre torre = new Torre(peça, this);
                        tabuleiro.atualizarCasa(indice, torre);
                        return;
                    }

                // Outra cor
                } else {
                    // É Pino
                    if(peça instanceof Pino) { 
                        // Come a casa
                        if ( tabuleiro.éEspecial(indice) ) { 
                            throw new PinoImovível("Pino inimigo está em casa segura!");                        
                        } else {
                            ((Pino)peça).voltarBase(bases); 
                            tabuleiro.atualizarCasa(indice, this);
                            return;
                        }
                    // É torre
                    }else if (peça instanceof Torre) { 

                        // pino é torre
                        // if ( this instanceof Torre) {   ///////PINO NUNCA É TORRE. AQUI SERIA TENTAR MOVER A TORRE TODA 

                        //     // É maior ou igual que a torre inimiga
                        //     if (((Torre)pino).size() >= peça.size()) { 

                        //         // Come a torre
                        //         if ( tabuleiro.éEspecial(indice) ) { 
                        //             throw new PinoImovível("Pino inimigo está em casa segura!");                        
                        //         } else {
                        //             pinos = ((Torre)peça).getPinos();
                        //             for (Pino p : pinos) {
                        //                 p.unsetTorre();
                        //                 p.voltarBase(bases);
                        //                 tabuleiro.voltarBase(p);
                        //             }
                        //             tabuleiro.atualizarCasa(indice, this);
                        //             return;
                        //         }
                        //     // É menor que a torre inimiga
                        //     } else { 
                        //         throw new PinoImovível("Torre não é grande o bastante!");
                        //     }

                        // // pino não é torre
                        // } else {
                            throw new PinoImovível("Pino não pode comer torre!");//(mas devia, no caso acima)
                        // }
                    }
                }


            // Caso não tenha rodado o número exato de casas
            } else if (peça.getCor().equals(this.cor)){ // pode ultrapassar um pino/torre da mesma cor
                tabuleiro.atualizarCasa(indice, this);
            } else {
                throw new ValorInsuficiente("Não rodaste no dado o valor correto para comer o pino inimigo!");
            }
        }
    }

    
    
}

/* Aplicação principal
   
- Abre a Tela inicial
- Espera por um sinal de que a escolha de jogadores foi feita e recebe os jogadores
- Inicializa as bases e finais
- Abre a Tela com o tabuleiro (TelaJogo)
- Ordem de jogadas é a ordem nos números do jogadores (primeiro j1, depois j2...)
- Abre um loop que termina quando fimJogo = True{

- checar a vez de quem é com um contador 
- Jogador clica em Jogar dado, dado escolhe um número.
- Jogador escolhe um pino para mover.

Possibilidades:
   O pino não é da mesma cor do jogador (erro, escolher de novo)
   O pino está na base (retirar da base se valor no dado foi maior que 5, senão escolher de novo)
   O pino entrou na reta final (posição maior que 52)
   O pino está na reta final (Caso o número do dado não seja exatamente o necessário para entrar no fim, ele será "refletido", andando para tráz após chegar no fim)
   O pino esta no fim (erro, escolher outro)
///////O pino faz parte de torre (mover o de cima ou mover a torre caso seja possível comer outra torre em sua frente)  <-- Vou remover esse comentário na hora da entrega, assim é mais provável do professor não notar que isso é impossível
   O pino comer outro pino (enviar o outro pino para  a base)
   O pino tentar comer um outro pino, mas o outro pino está numa casa especial ou numa torre (fim de vez)
   O pino se move simplesmente (fim de vez)
   Existe um outro pino de outra cor bloqueando o caminho (erro, escolher outro)

fimJogo = true quando o fim de um dos jogadores estiver cheio.

}

*/

import java.util.ArrayList;


public class Ludo {

   public static void main(String[] args) {

      TelaInicial tela = new TelaInicial();

      //Algo aqui que garanta que o próximo comando só vai rodar depois que a escolha de jogadores tenha sido feita GUI
      //adicionei um metodo booleano em EscolhaDeJogadores para dizer quando eles foram escolhidos (G)
      if (EscolhaDeJogadores.ForamJogadoresEscolhidos == true) {
         ArrayList<Jogador> jogadores = EscolhaDeJogadores.getJogadores();// Acho que o correto seria ter um listener aqui que nem na aula 28

         int nJogadores = jogadores.size();

         // Separa os jogadores em suas variáveis
         Jogador j1 = jogadores.get(0);
         Jogador j2 = jogadores.get(1);
         Jogador j3 = null;
         Jogador j4 = null;

         if (nJogadores >= 3) {
            j3 = jogadores.get(2); //
         }

         if (nJogadores == 4) {
            j4 = jogadores.get(3);
         }

         // Inicializa as bases e finais
         Bases bases = new Bases(jogadores);
         Finais finais = new Finais(jogadores);

         // Abre a tela com o Tabuleiro e inicializa o Tabuleiro
         TelaJogo telaJogo = new TelaJogo(j1, j2, j3, j4);
         Tabuleiro tabuleiro = new Tabuleiro();


         boolean fimJogo = false;
         int rodada = 0;

         // Loop principal de cada rodada
         while (fimJogo = false) {

            boolean moveu = false;
            int vez = rodada % nJogadores;  // Use essa variável pra printar de quem é a vez
            Jogador jogador = jogadores.get(vez);

            int valor = 1;// rodar o dado e receber o valor aqui GUI. 1 é um valor qualquer só pra compilar certo

             // Se a base estiver cheia, checar se o valor de casas é menor que 5
            if (bases.isFull(jogador.getCor()) && valor < 5) {
               rodada++;
               continue; //passa pra próxima rodada
            }


            while (moveu = false) {

               Pino pino = new Pino("Azul", 1) ;// escolher qual pino se deseja mover e receber aqui (classe Pino) GUI. Botei um pino qualquer só pra compilar certo

               try {
                  pino.moverPino(jogador, valor, bases, finais, tabuleiro);
                   /* GUI
                   Não sei como que tu vai atualizar tudo na tela. Pode ter um módulo de Tabuleiro que retorna o estado do tabuleiro e tu atualiza a interface no fim de cada loop;
                   Pode-se botar comandos de atualizar a interface junto com os comandos de atualizar o tabuleiro, dentro de moverPino.
                   
                  
                   */
                  // teletransporta o pino. GUI
                  // implementar uma visualização de torres GUI
                  moveu = true;

               } catch (ValorInsuficiente er) {
                  System.out.println(er.getMessage()); // Abrir uma mensagem de erro com essa string GUI
               } catch (PinoImovível er) {
                  System.out.println(er.getMessage()); // GUI
               }

               if ( finais.isFull(jogador.getCor()) ) {
                  fimJogo = true;
               }
               /* Pra GUI eu acho que tu pode fazer o seguinte: Antes do comando rodada++ tu atualiza a GUI. Nessa atualização tu faz bases.getPinos() e finais.getPinos() e 
               desenha na tela os pinos na base e nos finais. Por exemplo, pra pegar os pinos da base azul tu faz bases.getValue("Azul") e o resultado é um array de Pino's. 
               Depois pro tabuleiro tu faz um loop for  de i=1 até i=52. Cada iteração tu checa a casa i com tabuleiro.getCasa(i, "Azul"). A cor só importa pra reta final, azul é um placeholder.
               Com isso tu vai ter um array com os pinos da torre, com um só pino, ou com null. Tem que numer os pinos e fazer um .getIndice() e .getCor() em cada 

               Aí tu pode fazer um mapa com essa posições e as coordenadas no tabuleiro (posições, coordenadas) pra facilitar o colocamento das peças no lugar certo.

               Pras retas finais Tu faz o mesmo, mas agora as cores importam. As casas 53 a 57 vão ser repetidas, sendo uma pra cada cor.

               Também precisa inventar uma maneira de mostrar torres de maneira visual
               */
               rodada++; // O número de rodadas começou em 0, então contando +1 depois do fim do jogo nos traz ao valor correto.
               // Pode botar junto no ranking se quiser (quem venceu com o menor número de rodadas)
            }
         }
      }
   }
}


/*DETALHE

Quando tu quer mover uma torre, tu deve poder mover o pino de cima e o de baixo, mas no momento o código não te deixa mover o pino de baixo pois ele está emTorre.
Na verdade, a calsse tabuleiro interpreta a Torre como algo totalmente diferente, na GUI seria necessário mostrar a escolha de mover a torre toda, ou só o pino de cima. 
Mas aí no caso de duas torres, a de trás maior que a da frente, alguem poderia cometer o erro de escolher o pino de cima ao invés da torre! Aí não vai mover pois ele seleciou o pino ao invés da torre toda!
Bom, tem que massagear o código e resolver esse problema aí. Ou torçer pra que o professor não pense nisso.

O que fazer se não for possível mover nenhum dos pino? Checar todos os pínos para ver se eles sao movíveis, mas isso vai dar muito trabalho. 
Ou torçer pra que o professor não pense nisso.
*/

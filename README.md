# Ludo em Java
Trabalho final da cadeira de Programação Orientada a Objeto

Implementação do jogo LUDO (versão para até 4 jogadores), o qual tem como objetivo levar os quatro pinos dos jogadores, que ficam em um local de espera, até o meio do tabuleiro em sua respectiva cor (no começo do jogo cada jogador irá escolher uma das cores que serão mostradas na tela). O jogador que conseguir realizar isso primeiro é o vencedor. Neste jogo, são os dados que decidem quantas casas as peças irão andar a cada rodada.

Regras Principais:
- Uma peça só sai do local de espera se tirar o número 5 no dado.
- Se tirar o número 6, além de andar seis casas, pode jogar outra vez. Todavia, se tirar três 6 seguidos, a última peça movida volta para o local de espera.
- Se um pino coincidir com uma casa já ocupada por outro pino de cor distinta, esta será eliminada (volta para o local de espera). O jogador que tiver uma peça eliminada avança 20 casas com qualquer de suas peças que estiverem em jogo.
- Ficam excluídas do caso anterior as peças que, no momento, estiverem ocupando uma casa pré-determinada segura (provavelmente será determinado algumas posições dentro o Array que serão seguras sempre).
- Duas peças da mesma cor numa casa formam uma torre. Essa terá que se desfazer quando o jogador que a forma tirar um 6 no dado.
- Para entrar no meio do tabuleiro é preciso que o número do dado seja exato, as seis últimas casas de cada jogador são reservadas para isso.
- ATENÇÃO, se a peça não tiver no local de espera ou terminado o jogo, qualquer peça do jogador pode ser mexida na sua rodada, só depende da estratégia do jogador

Descrição das classes implementadas:
- Classe Jogador – nome e cor - métodos: construtor, jogarDado, moverPino. Cada jogador terá uma pontuação e uma classificação.
- Classe Pinos - cor -métodos: getCor, voltarBase, moverPino, retirarPinoBase, entrarFim;
- Classe CasaEspecial – define o formato dos métodos entrarCasaEspecial, sairCasaEspecial;
- Classe Fim implements CasaEspecial – um fim por jogador - métodos: entrarCasaEspecial, sairCasaEspecial (Entra apenas com o número exato no dado, nunca sai);
- Classe Base implements CasaEspecial- uma base por jogador-métodos:entrarCasaEspecial, sairCasaEspecial (Entra apenas quando comido, sai apenas com um número no dado maior que 5);
- Classe Ludo – classe main - será implementado um contador que muda de jogador no fim do turno, métodos: fimJogo entre outras;
- Classe Classificação - será implementado arquivos que guardam as pontuações dos jogadores, provavelmente com Arraylist que conterá as posições dos jogadores. Nessa classificação só apareceram as 20 melhores pontuações na tela, porém as outras classificações continuaram no Array;
- Classe Pontuação - cada vez que um jogo termina são somados a pontuação dos jogadores – (quem ganha termina com uma pontuação + as peças que comeu no jogo e os outros jogadores com as peças que foram até o centro + as peças que comeram);
- Classe Tabuleiro – aqui terá um Array com as posições existentes no tabuleiro;
- Classe TelaInicial - nesta classe será implementado métodos para pedir informações iniciais para o usuário. Como, por exemplo, numeroJogadores, nomejogadores,-aqui se o nome digitado equivaler a um nome que já está na tabela de classificação -> o programa utilizará como base sua pontuação antiga e irá somando em cima dela-, e terá um método para saber quem vai começar (quem tirar o maior número de 1 a 6);
- Classe Dado – vai ter um método que cada vez que é chamado retorna o valor de 1 a 6 de forma aleatória;

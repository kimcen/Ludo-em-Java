// Tela Inicial do jogo
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TelaInicial extends JFrame implements ActionListener {

    private JButton começar, avançar, ranking;
    private JPanel panel;
    private JLabel escritaselecionar, escritaselecionar_1, bemvindo, regras, regra1, regra2, regra2_1,
            regra3, regra3_1, regra4, regra4_1, regra5, regra5_1, regra6, regra6_1, regra7, regra7_1, imagem;

    public TelaInicial() {
        super("LUDO - Gustavo Mangold, Kim Colpo Enghusen e Thiago Miorando Tavolara");
        Container container = getContentPane();
        panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(Color.lightGray);

        //BEM-VINDO
        Font fonte = new Font("Times new Roman", Font.BOLD, 50); // altera a fonte e tamanho da letra
        bemvindo = new JLabel("BEM-VINDO AO LUDO!!!");
        bemvindo.setFont(fonte);
        bemvindo.setForeground(Color.black);
        bemvindo.setBounds(100, 30, 700, 50);
        panel.add(bemvindo);

        //regras
        Font fonte1 = new Font("Times new Roman", Font.BOLD, 25); // altera a fonte e tamanho da letra
        regras = new JLabel("REGRAS:");
        regras.setForeground(Color.black);
        regras.setFont(fonte1);
        regras.setBounds(20, 100, 150, 20);
        panel.add(regras);

        //regra 1
        regra1 = new JLabel("- Uma peça só sai da base se tirar o número 5 no dado. ");
        regra1.setForeground(Color.black);
        regra1.setBounds(40, 130, 700, 20);
        panel.add(regra1);

        //regra 2
        regra2 = new JLabel("- Um pino não pode ultrapassar um pino de cor diferente, nessa caso só se pode mover atrás do pino, ou rodar o "); // ajeitar o bounds no que precisar GUI
        regra2.setForeground(Color.black);
        regra2.setBounds(40, 160, 750, 20);
        panel.add(regra2);
        regra2_1 = new JLabel("número exato de casa para comer o pino inimigo. Ao ser comido o pino é movido de volta para a sua base.");
        regra2_1.setForeground(Color.black);
        regra2_1.setBounds(40, 175, 700, 20);
        panel.add(regra2_1);

        //regra 3
        regra3 = new JLabel("- Se um pino coincidir com uma casa já ocupada por outro pino de cor distinta, esta será eliminada (volta para a base).");
        regra3.setForeground(Color.black);
        regra3.setBounds(40, 205, 700, 20);
        panel.add(regra3);


        // regra 4
        regra4 = new JLabel("- Ficam excluídas do caso anterior as peças que, no momento, estiverem ocupando uma casa segura.");
        regra4.setForeground(Color.black);
        regra4.setBounds(40, 250, 700, 20);
        panel.add(regra4);
        regra4_1 = new JLabel("Estas são as casas identificadas por uma estrela e as casas coloridas");  // desenhar as estrelas no tabuleiro (Ou o que tu achar melhor) GUI
        regra4_1.setForeground(Color.black);
        regra4_1.setBounds(40, 265, 700, 20);
        panel.add(regra4_1);

        // regra 5
        regra5 = new JLabel("- Duas peças da mesma cor numa casa formam uma torre. Uma torre só pode se mover inteira no caso em que é possível comer");
        regra5.setForeground(Color.black);
        regra5.setBounds(40, 295, 700, 20);
        panel.add(regra5);
        regra5_1 = new JLabel("outra torre de tamanho menor ou igual. Senão, apenas o pino do topo pode ser movido");
        regra5_1.setForeground(Color.black);
        regra5_1.setBounds(40, 310, 700, 20);
        panel.add(regra5_1);

        // regra 6
        regra6 = new JLabel("- Após um pino completar uma volta, ele entra na reta final. Nela, é preciso que o número tirado no dado seja exatamente quanto falta para entrar na casa final."); // Falta implementar
        regra6.setForeground(Color.black);
        regra6.setBounds(40, 340, 700, 20);
        panel.add(regra6);
        regra6_1 = new JLabel("Caso contrário, o peão irá andar as remanecentes casas ao contrário");
        regra6_1.setForeground(Color.black);
        regra6_1.setBounds(40, 355, 700, 20);
        panel.add(regra6_1);


        //colocando a imagem do tabuleiro
        ImageIcon tabuleiro = new ImageIcon(getClass().getResource("tabuleiro.png"));
        tabuleiro.setImage(tabuleiro.getImage().getScaledInstance(300, 300, 1));
        imagem = new JLabel(tabuleiro);
        imagem.setBounds(400, 400, 400, 400);
        panel.add(imagem);


        //pergunta inicial - selecior um botão

        escritaselecionar = new JLabel("Selecione start se deseja começar");
        escritaselecionar.setForeground(Color.black);
        escritaselecionar.setBounds(58, 320, 300, 300);
        escritaselecionar_1 = new JLabel("ou ranking se deseja ver a classificação:");
        escritaselecionar_1.setForeground(Color.black);
        escritaselecionar_1.setBounds(78, 345, 400, 300);

        Font fonte2 = new Font("Times new Roman", Font.BOLD, 20);
        escritaselecionar.setFont(fonte2);
        escritaselecionar_1.setFont(fonte2);

        panel.add(escritaselecionar);
        panel.add(escritaselecionar_1);

        //botão começar
        ImageIcon start = new ImageIcon(getClass().getResource("start.png"));
        start.setImage(start.getImage().getScaledInstance(120, 120, 1));
        começar = new JButton(start);
        começar.setBackground(Color.lightGray);
        começar.setBounds(90, 550, 120, 120);
        panel.add(começar);
        começar.addActionListener(this);

        //botão ranking
        ImageIcon classificacao = new ImageIcon(getClass().getResource("ranking.png"));
        classificacao.setImage(classificacao.getImage().getScaledInstance(115, 115, 1));
        ranking = new JButton(classificacao);
        ranking.setBackground(Color.lightGray);
        ranking.setBounds(240, 550, 120, 120);
        panel.add(ranking);
        ranking.addActionListener(this);

        ButtonGroup grupo1 = new ButtonGroup();
        grupo1.add(começar);
        grupo1.add(ranking);

        container.add(panel);

        this.setSize(800, 800);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == começar) {
            EscolhaDeJogadores tela2 = new EscolhaDeJogadores();
            dispose();// apaga a primeira tela
        }
        if (e.getSource() == ranking) {
            Ranking rank = new Ranking();
            dispose();
        }
    }
}
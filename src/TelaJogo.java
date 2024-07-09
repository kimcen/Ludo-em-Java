/* Tela para visualizar o Jogo 

Ainda precisa fazer:
- Verificar quantos pinos estão na base com bases.getPinos() e exibir eles na base
- O mesmo para o fim (recomendo posicionar os pinos em formato de losango dentro do fim)

*/
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import java.util.concurrent.TimeUnit;


public class TelaJogo extends JFrame implements ActionListener {

    JPanel panel;
    JLabel imagemTabuleiro, dado1, dado2, dado3, dado4, dado5, dado6;
    JButton jogarDado;
    private Random random = new Random();
    private int Njogadores;
    private Jogador j1, j2, j3, j4;

    // Cuida que j3 e j4 podem ser null se não foram escolhidos
    public TelaJogo(Jogador j1, Jogador j2, Jogador j3, Jogador j4) {
        super("LUDO - Gustavo Mangold, Kim Colpo Enghusen e Thiago Miorando Tavolara");
        Container container = getContentPane();
        panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(Color.lightGray);

        //tabuleiro
        ImageIcon tabuleiro = new ImageIcon(getClass().getResource("tabuleiro.png"));
        tabuleiro.setImage(tabuleiro.getImage().getScaledInstance(600, 600, 1));
        imagemTabuleiro = new JLabel(tabuleiro);
        imagemTabuleiro.setBounds(1, 1, 600, 600);
        panel.add(imagemTabuleiro);

        //Botão jogar Dado
        jogarDado = new JButton("Jogar Dado");
        jogarDado.setBounds(650, 200, 100, 30);
        panel.add(jogarDado);
        jogarDado.addActionListener(this);

        ImageIcon dado_1 = new ImageIcon(getClass().getResource("Dado1.png"));
        dado_1.setImage(dado_1.getImage().getScaledInstance(80, 80, 1));
        dado1 = new JLabel(dado_1);
        dado1.setBounds(400, 70, 80, 80);
        panel.add(dado1);


        ImageIcon dado_2 = new ImageIcon(getClass().getResource("Dado2.png"));
        dado_2.setImage(dado_2.getImage().getScaledInstance(80, 80, 1));
        dado2 = new JLabel(dado_2);
        dado2.setBounds(400, 70, 80, 80);
        panel.add(dado2);


        ImageIcon dado_3 = new ImageIcon(getClass().getResource("Dado3.png"));
        dado_3.setImage(dado_3.getImage().getScaledInstance(80, 80, 1));
        dado3 = new JLabel(dado_3);
        dado3.setBounds(400, 70, 80, 80);
        panel.add(dado3);

        ImageIcon dado_4 = new ImageIcon(getClass().getResource("Dado4.png"));
        dado_4.setImage(dado_4.getImage().getScaledInstance(80, 80, 1));
        dado4 = new JLabel(dado_4);
        dado4.setBounds(400, 70, 80, 80);
        panel.add(dado4);


        ImageIcon dado_5 = new ImageIcon(getClass().getResource("Dado5.png"));
        dado_5.setImage(dado_5.getImage().getScaledInstance(80, 80, 1));
        dado5 = new JLabel(dado_5);
        dado5.setBounds(400, 70, 80, 80);
        panel.add(dado5);


        ImageIcon dado_6 = new ImageIcon(getClass().getResource("Dado6.png"));
        dado_6.setImage(dado_6.getImage().getScaledInstance(80, 80, 1));
        dado6 = new JLabel(dado_6);
        dado6.setBounds(400, 70, 80, 80);
        panel.add(dado6);


        container.add(panel);

        this.setSize(800, 800);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == jogarDado) {
            int numero = random.nextInt(6) + 1;

            if (numero == 1) {
                //imagem medalhas
                dado1.setBounds(650, 70, 80, 80);
                dado2.setBounds(400, 70, 80, 80);
                dado3.setBounds(400, 70, 80, 80);
                dado4.setBounds(400, 70, 80, 80);
                dado5.setBounds(400, 70, 80, 80);
                dado6.setBounds(400, 70, 80, 80);
            }

            if (numero == 2) {
                //imagem medalhas
                dado1.setBounds(400, 70, 80, 80);
                dado2.setBounds(650, 70, 80, 80);
                dado3.setBounds(400, 70, 80, 80);
                dado4.setBounds(400, 70, 80, 80);
                dado5.setBounds(400, 70, 80, 80);
                dado6.setBounds(400, 70, 80, 80);
            }
            if (numero == 3) {
                //imagem medalhas
                dado1.setBounds(400, 70, 80, 80);
                dado2.setBounds(400, 70, 80, 80);
                dado3.setBounds(650, 70, 80, 80);
                dado4.setBounds(400, 70, 80, 80);
                dado5.setBounds(400, 70, 80, 80);
                dado6.setBounds(400, 70, 80, 80);
            }
            if (numero == 4) {
                //imagem medalhas
                dado1.setBounds(400, 70, 80, 80);
                dado2.setBounds(400, 70, 80, 80);
                dado3.setBounds(400, 70, 80, 80);
                dado4.setBounds(650, 70, 80, 80);
                dado5.setBounds(400, 70, 80, 80);
                dado6.setBounds(400, 70, 80, 80);
            }

            if (numero == 5) {
                //imagem medalhas
                dado1.setBounds(400, 70, 80, 80);
                dado2.setBounds(400, 70, 80, 80);
                dado3.setBounds(400, 70, 80, 80);
                dado4.setBounds(400, 70, 80, 80);
                dado5.setBounds(650, 70, 80, 80);
                dado6.setBounds(400, 70, 80, 80);

            }
            if (numero == 6) {
                //imagem medalhas
                dado1.setBounds(400, 70, 80, 80);
                dado2.setBounds(400, 70, 80, 80);
                dado3.setBounds(400, 70, 80, 80);
                dado4.setBounds(400, 70, 80, 80);
                dado5.setBounds(400, 70, 80, 80);
                dado6.setBounds(650, 70, 80, 80);
            }

        }
    }
}

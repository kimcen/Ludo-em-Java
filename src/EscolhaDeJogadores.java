// Tela com a escolha do número nome e cores dos jogadores. 
// Acionada ao clicar em "start" na Tela Inicial.
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;


public class EscolhaDeJogadores extends JFrame implements ActionListener {


    public static boolean ForamJogadoresEscolhidos;
    private JButton avançar, voltar, botao2, botao3, botao4;
    private JPanel panel;
    private JLabel escritaVoltar, escritatopo, nomej1, nomej2, nomej3, nomej4, vermelho1, azul2, amarelo4, verde3, escritaavançar;
    private JTextField preencherjogador1, preencherjogador2, preencherjogador3, preencherjogador4;
    private int numeroJogadores = 0;
    private String jogador1, jogador2, jogador3, jogador4;
    private static ArrayList<Jogador> jogadores;
    private boolean jogadoresEscolhidos = false; //boolean para checar se já se escolheram jogadores (Gustavo)

    public EscolhaDeJogadores() {
        super("LUDO - Gustavo Mangold, Kim Colpo Enghusen e Thiago Miorando Tavolara");
        Container container = getContentPane();
        panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(Color.lightGray);

        ///////// TOPO /////////
        //ESCRITA
        escritatopo = new JLabel("SELECIONE O NÚMERO DE JOGADORES:");
        escritatopo.setForeground(Color.black);
        escritatopo.setBounds(280, 30, 250, 50);
        panel.add(escritatopo);

        //BOTÕES
        botao2 = new JButton("2");
        botao3 = new JButton("3");
        botao4 = new JButton("4");

        //cores
        botao2.setForeground(Color.white);
        botao2.setBackground(Color.gray);
        botao3.setForeground(Color.white);
        botao3.setBackground(Color.gray);
        botao4.setForeground(Color.white);
        botao4.setBackground(Color.gray);

        //posição
        botao2.setBounds(250, 80, 80, 50);
        botao3.setBounds(350, 80, 80, 50);
        botao4.setBounds(450, 80, 80, 50);

        //adiciona os botões ao painel1
        panel.add(botao2);
        panel.add(botao3);
        panel.add(botao4);

        //agrupa os botões
        ButtonGroup grupo2 = new ButtonGroup();
        grupo2.add(botao2);
        grupo2.add(botao3);
        grupo2.add(botao4);

        botao2.addActionListener(this);
        botao3.addActionListener(this);
        botao4.addActionListener(this);


        //NOME DOS JOGADORES
        ImageIcon quadradovermelho = new ImageIcon(getClass().getResource("quadradovermelho.png"));
        ImageIcon quadradoazul = new ImageIcon(getClass().getResource("quadradoazul.png"));
        ImageIcon quadradoverde = new ImageIcon(getClass().getResource("quadradoverde.png"));
        ImageIcon quadradoamarelo = new ImageIcon(getClass().getResource("quadradoamarelo.png"));


        Font fonte3 = new Font("Times new Roman", Font.BOLD, 17);

        //jogador1
        nomej1 = new JLabel("Nome jogador 1:");
        nomej1.setForeground(Color.black);
        nomej1.setFont(fonte3);
        preencherjogador1 = new JTextField();
        nomej1.setBounds(195, 170, 150, 20);
        preencherjogador1.setBounds(335, 170, 200, 20);
        panel.add(nomej1);
        panel.add(preencherjogador1);

        vermelho1 = new JLabel(quadradovermelho);
        vermelho1.setBounds(565, 170, 20, 20);
        panel.add(vermelho1);

        //jogador2
        nomej2 = new JLabel("Nome jogador 2:");
        nomej2.setForeground(Color.black);
        nomej2.setFont(fonte3);
        preencherjogador2 = new JTextField();
        nomej2.setBounds(195, 220, 150, 20);
        preencherjogador2.setBounds(335, 220, 200, 20);
        panel.add(nomej2);
        panel.add(preencherjogador2);

        azul2 = new JLabel(quadradoazul);
        azul2.setBounds(565, 220, 20, 20);
        panel.add(azul2);

        //jogador3
        nomej3 = new JLabel("Nome jogador 3:");
        nomej3.setForeground(Color.black);
        nomej3.setFont(fonte3);
        preencherjogador3 = new JTextField();
        nomej3.setBounds(195, 270, 150, 20);
        preencherjogador3.setBounds(335, 270, 200, 20);
        panel.add(nomej3);
        panel.add(preencherjogador3);


        verde3 = new JLabel(quadradoverde);
        verde3.setBounds(565, 270, 20, 20);
        panel.add(verde3);


        //jogador4
        nomej4 = new JLabel("Nome jogador 4:");
        nomej4.setForeground(Color.black);
        preencherjogador4 = new JTextField();
        nomej4.setFont(fonte3);
        nomej4.setBounds(195, 320, 150, 20);
        preencherjogador4.setBounds(335, 320, 200, 20);
        panel.add(nomej4);
        panel.add(preencherjogador4);
        amarelo4 = new JLabel(quadradoamarelo);
        amarelo4.setBounds(565, 320, 20, 20);
        panel.add(amarelo4);


        preencherjogador1.setEditable(false);
        preencherjogador2.setEditable(false);
        preencherjogador3.setEditable(false);
        preencherjogador4.setEditable(false);


        ///limita caracteres dos campos de preencher os nomes
        preencherjogador1.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                if (preencherjogador1.getText().length() >= 50) {
                    e.consume();
                    Toolkit.getDefaultToolkit().beep();
                }
            }
        });
        preencherjogador2.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                if (preencherjogador2.getText().length() >= 50) {
                    e.consume();
                    Toolkit.getDefaultToolkit().beep();
                }
            }
        });
        preencherjogador3.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                if (preencherjogador3.getText().length() >= 50) {
                    e.consume();
                    Toolkit.getDefaultToolkit().beep();
                }
            }
        });
        preencherjogador4.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                if (preencherjogador4.getText().length() >= 50) {
                    e.consume();
                    Toolkit.getDefaultToolkit().beep();
                }
            }
        });

        //escrita avançar
        escritaavançar = new JLabel("Após preencher os nomes, clique no botão abaixo!!");
        escritaavançar.setForeground(Color.black);
        Font fonte4 = new Font("Times new Roman", Font.BOLD, 22);
        escritaavançar.setFont(fonte4);
        escritaavançar.setBounds(160, 420, 500, 30);
        panel.add(escritaavançar);

        //botão avançar
        ImageIcon avance = new ImageIcon(getClass().getResource("avançar.png"));
        avance.setImage(avance.getImage().getScaledInstance(130, 130, 1));
        avançar = new JButton(avance);
        avançar.setBounds(320, 470, 130, 130);
        avançar.setBackground(Color.LIGHT_GRAY);
        avançar.setEnabled(false);
        panel.add(avançar);
        avançar.addActionListener(this);

        //botão voltar
        ImageIcon imagemvoltar = new ImageIcon(getClass().getResource("voltar.png"));
        imagemvoltar.setImage(imagemvoltar.getImage().getScaledInstance(60, 60, 1));
        voltar = new JButton(imagemvoltar);
        voltar.setBounds(30, 650, 70, 70);
        voltar.setBackground(Color.lightGray);
        panel.add(voltar);
        voltar.addActionListener(this);

        //escrita voltar
        Font fonte2 = new Font("Times new Roman", Font.BOLD, 16);
        escritaVoltar = new JLabel("VOLTAR PARA A TELA INICIAL");
        escritaVoltar.setFont(fonte2);
        escritaVoltar.setForeground(Color.black);
        escritaVoltar.setBounds(110, 670, 300, 30);
        panel.add(escritaVoltar);


        container.add(panel);

        this.setSize(800, 800);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //achar um jeito de passar a quantidade os nomes dos jogadores (Acho que por set na classe jogador da para fazer isso)
        // implementar o selecionamento de cores para os jogadores
        if (e.getSource() == botao2) {
            avançar.setEnabled(true);
            numeroJogadores = 2;
            preencherjogador1.setEditable(true);
            preencherjogador2.setEditable(true);
            botao3.setEnabled(false);
            botao4.setEnabled(false);
        }
        if (e.getSource() == botao3) {
            avançar.setEnabled(true);
            numeroJogadores = 3;
            preencherjogador1.setEditable(true);
            preencherjogador2.setEditable(true);
            preencherjogador3.setEditable(true);
            botao2.setEnabled(false);
            botao4.setEnabled(false);
        }
        if (e.getSource() == botao4) {
            avançar.setEnabled(true);
            numeroJogadores = 4;
            preencherjogador1.setEditable(true);
            preencherjogador2.setEditable(true);
            preencherjogador3.setEditable(true);
            preencherjogador4.setEditable(true);
            botao2.setEnabled(false);
            botao3.setEnabled(false);
        }

        if (e.getSource() == avançar) {

            jogadores = new ArrayList<Jogador>();
            //booleano para avisa que foram escolhidos (G)
            jogadoresEscolhidos = true;

            if (numeroJogadores >= 2) {
                jogadores.add(0, new Jogador(preencherjogador1.getText(), "Azul"));
                jogadores.add(1, new Jogador(preencherjogador2.getText(), "Vermelho"));

            }
            if (numeroJogadores >= 3) {
                jogadores.add(2, new Jogador(preencherjogador3.getText(), "Verde"));
            }
            if (numeroJogadores == 4) {
                jogadores.add(3, new Jogador(preencherjogador4.getText(), "Amarelo"));
            }

            dispose();
        }
        if (e.getSource() == voltar) {
            TelaInicial tela1 = new TelaInicial();
            dispose();
        }
    }

    // método para dizer se os jogadores ja foram escolhidos (G)
    public boolean ForamJogadoresEscolhidos() {
        return jogadoresEscolhidos;
    }

    public int getNumeroJogadores() {
        return numeroJogadores;
    }


    public static ArrayList<Jogador> getJogadores() {
        return jogadores;
    }
}

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;


public class Ranking extends JFrame implements ActionListener {
    JPanel panel;
    JLabel escritaRanking, escritaRanking1, imagemMedalhas, escritaVoltar;
    JButton voltar;

    public Ranking() {

        super("LUDO - Gustavo Mangold, Kim Colpo Enghusen e Thiago Miorando Tavolara");
        Container container = getContentPane();
        panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(Color.lightGray);


        Font fonte1 = new Font("Times new Roman", Font.BOLD, 25);

        escritaRanking = new JLabel("RANKING");
        escritaRanking.setForeground(Color.black);
        escritaRanking.setFont(fonte1);
        escritaRanking.setBounds(220, 68, 150, 30);
        panel.add(escritaRanking);

        //imagem medalhas
        ImageIcon medalhas = new ImageIcon(getClass().getResource("medalhas.png"));
        medalhas.setImage(medalhas.getImage().getScaledInstance(200, 77, 1));
        imagemMedalhas = new JLabel(medalhas);
        imagemMedalhas.setBounds(360, 30, 200, 77);
        panel.add(imagemMedalhas);


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
        if (e.getSource() == voltar) {
            TelaInicial tela1 = new TelaInicial();
            dispose();
        }
    }


    public void lerArquivoRanking() {
        ArrayList<String> jogadores = (ArrayList<String>) ManipuladorSerializáveis.desserializa("ranking.poo");
    }

}


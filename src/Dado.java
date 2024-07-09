import javax.swing.*;

public class Dado extends TelaJogo {
    public Dado(int numero) {
        if(numero == 1){
            //imagem medalhas
            ImageIcon dado_1 = new ImageIcon(getClass().getResource("Dado1.png"));
            dado_1.setImage(dado_1.getImage().getScaledInstance(80, 80, 1));
            dado1 = new JLabel(dado_1);
            dado1.setBounds(650, 70, 80, 80);
            panel.add(dado1);
        }

        if(numero == 2){
            //imagem medalhas
            ImageIcon dado_2 = new ImageIcon(getClass().getResource("Dado2.png"));
            dado_2.setImage(dado_2.getImage().getScaledInstance(80, 80, 1));
            dado2 = new JLabel(dado_2);
            dado2.setBounds(650, 70, 80, 80);
            panel.add(dado2);
        }
        if(numero == 3){
            //imagem medalhas
            ImageIcon dado_3 = new ImageIcon(getClass().getResource("Dado3.png"));
            dado_3.setImage(dado_3.getImage().getScaledInstance(80, 80, 1));
            dado3 = new JLabel(dado_3);
            dado3.setBounds(650, 70, 80, 80);
            panel.add(dado3);
        }
        if(numero == 4){
            //imagem medalhas
            ImageIcon dado_4 = new ImageIcon(getClass().getResource("Dado4.png"));
            dado_4.setImage(dado_4.getImage().getScaledInstance(80, 80, 1));
            dado4 = new JLabel(dado_4);
            dado4.setBounds(650, 70, 80, 80);
            panel.add(dado4);
        }

        if(numero == 5){
            //imagem medalhas
            ImageIcon dado_5 = new ImageIcon(getClass().getResource("Dado5.png"));
            dado_5.setImage(dado_5.getImage().getScaledInstance(80, 80, 1));
            dado5 = new JLabel(dado_5);
            dado5.setBounds(650, 70, 80, 80);
            panel.add(dado5);
        }
        if(numero == 6){
            //imagem medalhas
            ImageIcon dado_6 = new ImageIcon(getClass().getResource("Dado6.png"));
            dado_6.setImage(dado_6.getImage().getScaledInstance(80, 80, 1));
            dado6 = new JLabel(dado_6);
            dado6.setBounds(650, 70, 80, 80);
            panel.add(dado6);

        }

    }

}

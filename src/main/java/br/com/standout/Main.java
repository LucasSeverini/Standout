package br.com.standout;

import br.com.standout.frame.TelaComparadora;

import javax.swing.*;
import java.awt.*;

public class Main {

    // ponto de entrada

    public static void main(String[] args) {

        // cria uma nova TelaComparadora
        // caso for mudar a tela inicial, que irá chamar a comparadora
        // a tela inicial deve ser chamada aqui, em vez dessa tela comparadora

        JFrame frame = new TelaComparadora("Comparador de Preços");
        frame.setResizable(false);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setSize(dim.width / 3, dim.height / 2);
        frame.setVisible(true);
    }
}

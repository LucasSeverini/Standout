package br.com.standout.frame;

import javax.swing.*;

public class TelaPrincipal extends JFrame {
    private JPanel panelPrincipal;

    // criar a tela principal aqui, que irá chamar
    // as outras telas

    public TelaPrincipal(String title) {
        super(title);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(panelPrincipal);
        this.pack();



    }
}

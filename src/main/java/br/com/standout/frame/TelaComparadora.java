package br.com.standout.frame;

import br.com.standout.model.MercadoEnum;
import br.com.standout.model.Produto;
import br.com.standout.model.TipoProdutoEnum;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;


public class TelaComparadora extends JFrame {
    private JPanel panelComparador;
    private JButton pesquisarBtn;
    private JComboBox<String> tiposComboBox;
    private JTextArea resultadoTextArea;

    public TelaComparadora(String title) {
        super(title);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(panelComparador);
        this.pack();


        popularComboBoxComTiposDeProdutos();

        pesquisarBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String tipoBuscado = tiposComboBox.getSelectedItem().toString();
                List<Produto> listaDeProdutosPopulada = popularListaDeProdutos();
                Produto produtoMaisBarato = filtrarProdutoMaisBaratoPorTipo(listaDeProdutosPopulada, tipoBuscado);
                printarResultado(produtoMaisBarato);
            }
        });
    }



    private void popularComboBoxComTiposDeProdutos() {
        // caso adicionar mais tipos de alimentos ao Enum,
        // precisa incluir os tipos aqui também, para conseguir escolher na tela depois

        tiposComboBox.addItem(TipoProdutoEnum.ARROZ.name());
        tiposComboBox.addItem(TipoProdutoEnum.FEIJAO.name());
        tiposComboBox.addItem(TipoProdutoEnum.MACARRAO.name());
    }


    private List<Produto> popularListaDeProdutos() {
        // aqui são "cadastrados" os produtos que serão comparados na tela
        // caso queira alterar o preco de algum, adicionar outros, deve ser feito aqui

        List<Produto> listaPopulada = new ArrayList<>();

        Produto arroz1 = new Produto();
        arroz1.setPreco(9.90);
        arroz1.setMercado(MercadoEnum.ALVORADA.name());
        arroz1.setTipo(TipoProdutoEnum.ARROZ.name());

        Produto arroz2 = new Produto();
        arroz2.setPreco(6.90);
        arroz2.setMercado(MercadoEnum.MARISTELA.name());
        arroz2.setTipo(TipoProdutoEnum.ARROZ.name());

        Produto arroz3 = new Produto();
        arroz3.setPreco(3.90);
        arroz3.setMercado(MercadoEnum.AVENIDA.name());
        arroz3.setTipo(TipoProdutoEnum.ARROZ.name());

        listaPopulada.add(arroz1);
        listaPopulada.add(arroz2);
        listaPopulada.add(arroz3);

        return listaPopulada;
    }


    private Produto filtrarProdutoMaisBaratoPorTipo(List<Produto> listaDeProdutos, String tipoBuscado) {
        // aqui está a lógica de pegar todos os produtos cadastrados
        // recebe a lista de produtos (total) e o tipoBuscado como parâmetro
        // retorna o mais barato daquele tipo
        // ex: arroz mais barato

        Produto produtoMaisBarato = new Produto();
        Double menorPreco = 99999.0;

        for (int i = 0; i < listaDeProdutos.size(); i++) {
            Produto produtoChecado = listaDeProdutos.get(i);
            if (produtoChecado.getTipo().equals(tipoBuscado)) {

                if (produtoChecado.getPreco() < menorPreco) {
                    menorPreco = produtoChecado.getPreco();
                    produtoMaisBarato = produtoChecado;
                }

            }
        }

        return produtoMaisBarato;
    }


    private void printarResultado(Produto produtoMaisBarato) {
        // responsavel por preencher na tela o resultado final

        resultadoTextArea.setText("************************** \n");
        resultadoTextArea.append("Resultado: \n");
        resultadoTextArea.append("\n");
        resultadoTextArea.append("Você buscou por: " + produtoMaisBarato.getTipo() + "\n");
        resultadoTextArea.append("Onde esse produto está mais barato: " + "SUPERMERCADO " + produtoMaisBarato.getMercado() + "\n");
        resultadoTextArea.append("Preço do Produto: " + "R$ " + String.format("%.2f", produtoMaisBarato.getPreco()));
    }
}

package br.com.standout.model;

public enum TipoProdutoEnum {

    // aqui estão todas as opções possíveis de produto
    // ao cadastrar um novo produto, basta selecionar uma dessas opções
    // ao setar o tipo daquele produto
    // ex: arroz1.setTipo(TipoProdutoEnum.ARROZ.name()); -> para pegar o Enum como string
    // IMPORTANTE: caso for adicionar um novo tipo aqui, precisa também atualizar a tela comparadora
    // para que seja possível pesquisar o mais barato para esse novo tipo

    ARROZ,
    FEIJAO,
    MACARRAO,
    OLEO
}

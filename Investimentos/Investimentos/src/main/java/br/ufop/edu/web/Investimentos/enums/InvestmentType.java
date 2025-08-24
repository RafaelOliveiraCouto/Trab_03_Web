package br.ufop.edu.web.Investimentos.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum InvestmentType {

    ACAO(0, "Ações da bolsa"),
    CRIPTO(1,"Criptomoedas"),
    FUNDO(2, "Fundos de Investimento"),
    RENDA_FIXA(3, "Títulos de renda fixa"),
    OUTRO(4, "Outros");


    //id - descrição
    private Integer id;
    private String description;

}

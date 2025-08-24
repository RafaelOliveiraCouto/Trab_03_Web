package br.ufop.edu.web.Investimentos.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum UserType {
    
    CUSTOMER(0, "Customer"),
    ENTERPRISE(1,"Enterprise"),
    ADMINISTRADOR(2, "Administrador");
    
    //id - descrição
    private Integer id;
    private String description;
}

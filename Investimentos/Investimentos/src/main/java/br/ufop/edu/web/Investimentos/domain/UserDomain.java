package br.ufop.edu.web.Investimentos.domain;

import java.util.List;
import java.util.UUID;

import br.ufop.edu.web.Investimentos.enums.UserType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDomain {
    private UUID id;
    private String name;
    private String email;
    private String password;
    private UserType userType;
    private List<InvestmentDomain> investments;
}

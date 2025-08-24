package br.ufop.edu.web.Investimentos.dtos.user;

import br.ufop.edu.web.Investimentos.enums.UserType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreateUserDTO {
    private String name;
    private String email;
    private String password;
    private UserType userType;
}

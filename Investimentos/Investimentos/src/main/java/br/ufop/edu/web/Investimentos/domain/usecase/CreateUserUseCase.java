package br.ufop.edu.web.Investimentos.domain.usecase;

import java.util.List;

import br.ufop.edu.web.Investimentos.domain.UserDomain;
import br.ufop.edu.web.Investimentos.enums.UserType;
import br.ufop.edu.web.Investimentos.models.UserModel;
import br.ufop.edu.web.Investimentos.repositories.UserRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@AllArgsConstructor
public class CreateUserUseCase {
    private UserDomain userDomain;
    private final UserRepository userRepository;

    public void validade(){
        validateStatus();
        validateEmail();
    }

    private void validateStatus() {
        if (userDomain.getUserType() == null) {
            userDomain.setUserType(UserType.CUSTOMER);
        }
    }

    private void validateEmail() {
        if (this.userDomain.getEmail() == null || this.userDomain.getEmail().isBlank()) {
            throw new RuntimeException("Email is null or blank.");
        }

        // Busca todos os usuários
        List<UserModel> allUsers = userRepository.findAll();

        // Verifica se já existe algum usuário com o mesmo e-mail
        boolean exists = allUsers.stream().anyMatch(user -> user.getEmail().equalsIgnoreCase(this.userDomain.getEmail()));

        if (exists) {throw new RuntimeException("Email already exists.");}
    }
}

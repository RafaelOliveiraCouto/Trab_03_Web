package br.ufop.edu.web.Investimentos.converter;

import br.ufop.edu.web.Investimentos.domain.UserDomain;
import br.ufop.edu.web.Investimentos.dtos.user.CreateUserDTO;
import br.ufop.edu.web.Investimentos.dtos.user.UpdateUserDTO;
import br.ufop.edu.web.Investimentos.dtos.user.UserDTO;
import br.ufop.edu.web.Investimentos.models.UserModel;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class UserConverter {
// CRU + Domain->Model
    // Create -> C
    public static UserDomain toUserDomain(CreateUserDTO createUserDTO){
        return UserDomain.builder()
                            .name(createUserDTO.getName())
                            .email(createUserDTO.getEmail())
                            .password(createUserDTO.getPassword())
                            .userType(createUserDTO.getUserType())
                            .build();
    }

    // Read -> R
    public static UserDTO toUserDTO(UserModel userModel){
        return new UserDTO(
                userModel.getId(),
                userModel.getName(),
                userModel.getEmail(),
                userModel.getPassword(),
                userModel.getUserType(),
                userModel.getInvestments() != null ?
                    userModel.getInvestments().stream().map(InvestimentosConverter::toInvestmentDTO).toList(): null
        );
    }

    // Update -> U
    public static UserDomain toUserDomain(UpdateUserDTO updateUserDTO){
        return UserDomain.builder()
                            .id(updateUserDTO.getId())
                            .name(updateUserDTO.getName())
                            .email(updateUserDTO.getEmail())
                            .password(updateUserDTO.getPassword())
                            .userType(updateUserDTO.getUserType())
                            .build();
    }

    // Domain->Model
    public static UserModel toUserModel(UserDomain userDomain){
        return UserModel.builder()
                            .id(userDomain.getId())
                            .name(userDomain.getName())
                            .email(userDomain.getEmail())
                            .password(userDomain.getPassword())
                            .userType(userDomain.getUserType())
                            .build();
    }
}

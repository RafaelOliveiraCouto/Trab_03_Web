package br.ufop.edu.web.Investimentos.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Service;

import br.ufop.edu.web.Investimentos.converter.UserConverter;
import br.ufop.edu.web.Investimentos.domain.UserDomain;
import br.ufop.edu.web.Investimentos.domain.usecase.CreateUserUseCase;
import br.ufop.edu.web.Investimentos.dtos.user.CreateUserDTO;
import br.ufop.edu.web.Investimentos.dtos.user.DeleteUserDTO;
import br.ufop.edu.web.Investimentos.dtos.user.UpdateUserDTO;
import br.ufop.edu.web.Investimentos.dtos.user.UserDTO;
import br.ufop.edu.web.Investimentos.models.UserModel;
import br.ufop.edu.web.Investimentos.repositories.UserRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    // Create -----------------------------------------------------------------------------------------------     C
    public UserDTO createUser(CreateUserDTO createUserDTO){
        UserDomain userDomain = UserConverter.toUserDomain(createUserDTO);
        CreateUserUseCase useCase = new CreateUserUseCase(userDomain, userRepository);
        useCase.validade();

        UserModel userModel = UserConverter.toUserModel(userDomain);
        return UserConverter.toUserDTO(userRepository.save(userModel));
    }

    // Read -------------------------------------------------------------------------------------------------     R
    public List<UserDTO> getAllUser(){
        return userRepository.findAll().stream().map(UserConverter::toUserDTO).toList();
    }

    public UserDTO getUserById(String userId){
        UUID id = UUID.fromString(userId);
        Optional<UserModel> optionalUserModel = userRepository.findById(id);

        if(optionalUserModel.isEmpty()) {return null;}

        UserModel userModel = optionalUserModel.get();
        return UserConverter.toUserDTO(userModel);
    }

    // Update -----------------------------------------------------------------------------------------------     U
    public UserDTO updateUser(UpdateUserDTO updateUserDTO){
        UserDomain userDomain = UserConverter.toUserDomain(updateUserDTO);
        //Validações...
        Optional<UserModel> optionalUserModel = userRepository.findById(updateUserDTO.getId());

        if (optionalUserModel.isEmpty()) {throw new RuntimeException("Event not found.");}

        UserModel userModel = UserConverter.toUserModel(userDomain);
        return UserConverter.toUserDTO(userRepository.save(userModel));
    }

    // Delete -----------------------------------------------------------------------------------------------     D
    public void deleteUser(DeleteUserDTO deleteUserDTO){
        Optional<UserModel> optionalUserModel = userRepository.findById(deleteUserDTO.id());

        if (optionalUserModel.isEmpty()) {throw new RuntimeException("Event not found.");}

        userRepository.delete(optionalUserModel.get());
    }
}

package br.ufop.edu.web.Investimentos.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.ufop.edu.web.Investimentos.dtos.user.CreateUserDTO;
import br.ufop.edu.web.Investimentos.dtos.user.DeleteUserDTO;
import br.ufop.edu.web.Investimentos.dtos.user.UpdateUserDTO;
import br.ufop.edu.web.Investimentos.dtos.user.UserDTO;
import br.ufop.edu.web.Investimentos.service.UserService;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/user")
@AllArgsConstructor
public class UserController {
    private final UserService userService;

    // Create ------------------------------------------------------- C
    @PostMapping
    public ResponseEntity<UserDTO> createUser(@RequestBody CreateUserDTO createUserDTO){
        UserDTO userDTO = userService.createUser(createUserDTO);

        if (userDTO == null) {return ResponseEntity.badRequest().build();}

        return ResponseEntity.ok(userDTO);
    }

    // Read --------------------------------------------------------- R
    @GetMapping
    public ResponseEntity<List<UserDTO>> getAllUser(){
        return ResponseEntity.ok(userService.getAllUser());
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> getUserBtId(@PathVariable String id){
        UserDTO userDTO = userService.getUserById(id);

        if (userDTO == null) {return ResponseEntity.badRequest().build();}

        return ResponseEntity.ok(userDTO);
    }

    // Update ------------------------------------------------------- U
    @PutMapping
    public ResponseEntity<UserDTO> updateUser(@RequestBody UpdateUserDTO updateEventDTO){
        UserDTO userDTO = userService.updateUser(updateEventDTO);

        if (userDTO == null) {return ResponseEntity.badRequest().build();}

        return ResponseEntity.ok(userDTO);
    }

    // Delete ------------------------------------------------------- D
    @DeleteMapping("/remove")
    public ResponseEntity<Object> deleteUser(@RequestBody DeleteUserDTO deleteEventDTO){
        userService.deleteUser(deleteEventDTO);
        return ResponseEntity.ok("Event has been deleted.");
    }
}

// @PostMapping     -> Create   |   C
// @GetMapping      -> Read     |   R
// @PutMapping      -> Upadate  |   U
// @DeleteMapping   -> Delete   |   D
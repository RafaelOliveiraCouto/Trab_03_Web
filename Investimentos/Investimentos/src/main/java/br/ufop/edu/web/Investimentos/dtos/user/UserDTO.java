package br.ufop.edu.web.Investimentos.dtos.user;

import java.util.List;
import java.util.UUID;

import br.ufop.edu.web.Investimentos.dtos.Investment.InvestmentDTO;
import br.ufop.edu.web.Investimentos.enums.UserType;

public record UserDTO(
    UUID id,
    String name,
    String email,
    String password,
    UserType userType,
    List<InvestmentDTO> investments
) {}

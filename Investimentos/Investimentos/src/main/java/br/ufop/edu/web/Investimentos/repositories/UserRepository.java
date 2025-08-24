package br.ufop.edu.web.Investimentos.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import br.ufop.edu.web.Investimentos.models.UserModel;

public interface UserRepository extends JpaRepository<UserModel, UUID>{}

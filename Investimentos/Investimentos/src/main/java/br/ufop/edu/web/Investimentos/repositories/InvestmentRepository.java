package br.ufop.edu.web.Investimentos.repositories;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import br.ufop.edu.web.Investimentos.models.InvestmentModel;
import br.ufop.edu.web.Investimentos.enums.InvestmentType;


public interface InvestmentRepository extends JpaRepository<InvestmentModel, UUID>{
    List<InvestmentModel> findByType(InvestmentType type);
}

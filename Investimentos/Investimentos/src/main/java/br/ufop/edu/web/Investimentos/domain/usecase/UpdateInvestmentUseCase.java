package br.ufop.edu.web.Investimentos.domain.usecase;

import br.ufop.edu.web.Investimentos.domain.InvestmentDomain;
import br.ufop.edu.web.Investimentos.models.InvestmentModel;
import br.ufop.edu.web.Investimentos.repositories.InvestmentRepository;
import br.ufop.edu.web.Investimentos.repositories.UserRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@AllArgsConstructor
public class UpdateInvestmentUseCase {
    private InvestmentDomain investmentDomain;
    private final InvestmentRepository investmentRepository;
    private final UserRepository userRepository;

    public void validade(){
        validadeUser();
    }

    private void validadeUser(){
        if (investmentDomain.getUserId() == null) {
            // buscar o investimento existente pelo ID
            InvestmentModel existingInvestment = investmentRepository.findById(investmentDomain.getId()).orElseThrow(() -> new RuntimeException("Investimento não encontrado"));
            // setar o userId do investimento existente
            investmentDomain.setUserId(existingInvestment.getUser().getId());
        }

        // validar se o usuário realmente existe
        if (!userRepository.existsById(investmentDomain.getUserId())) {
            throw new RuntimeException("Usuário não encontrado");
        }
    }
}

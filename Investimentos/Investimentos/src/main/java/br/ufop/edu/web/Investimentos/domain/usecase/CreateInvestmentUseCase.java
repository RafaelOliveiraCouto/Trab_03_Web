package br.ufop.edu.web.Investimentos.domain.usecase;

import java.time.LocalDateTime;

import br.ufop.edu.web.Investimentos.domain.InvestmentDomain;
import br.ufop.edu.web.Investimentos.enums.InvestmentType;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@AllArgsConstructor
public class CreateInvestmentUseCase {
    private InvestmentDomain investmentDomain;

    public void validade(){
        validateType();
        validatePurchaseDate();
    }

    private void validateType() {
        if (investmentDomain.getType() == null) {
            investmentDomain.setType(InvestmentType.OUTRO);
        }
    }

    private void validatePurchaseDate() {
        if (investmentDomain.getPurchaseDate() == null) {
            investmentDomain.setPurchaseDate(LocalDateTime.now());
        }
    }
}

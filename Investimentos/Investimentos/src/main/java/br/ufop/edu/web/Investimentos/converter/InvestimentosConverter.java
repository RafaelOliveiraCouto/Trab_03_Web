package br.ufop.edu.web.Investimentos.converter;

import br.ufop.edu.web.Investimentos.domain.InvestmentDomain;
import br.ufop.edu.web.Investimentos.dtos.Investment.CreateInvestmentDTO;
import br.ufop.edu.web.Investimentos.dtos.Investment.InvestmentDTO;
import br.ufop.edu.web.Investimentos.dtos.Investment.UpdateInvestmentDTO;
import br.ufop.edu.web.Investimentos.models.InvestmentModel;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class InvestimentosConverter {
// CRU + Domain->Model
    // Create -> C
    public static InvestmentDomain toInvestmentDomain(CreateInvestmentDTO createInvestmentDTO){
        return InvestmentDomain.builder()
                                .type(createInvestmentDTO.getType())
                                .symbol(createInvestmentDTO.getSymbol())
                                .quantity(createInvestmentDTO.getQuantity())
                                .purchasePrice(createInvestmentDTO.getPurchasePrice())
                                .purchaseDate(createInvestmentDTO.getPurchaseDate())
                                .userId(createInvestmentDTO.getUserId())
                                .build();
    }

    // Read -> R
    public static InvestmentDTO toInvestmentDTO(InvestmentModel investmentModel){
        return new InvestmentDTO(
            investmentModel.getId(),
            investmentModel.getType(),
            investmentModel.getSymbol(),
            investmentModel.getQuantity(),
            investmentModel.getPurchasePrice(),
            investmentModel.getPurchaseDate()
        );
    }

    // Update -> U
    public static InvestmentDomain toInvestmentDomain(UpdateInvestmentDTO updateInvestmentDTO){
        return InvestmentDomain.builder()
                                .id(updateInvestmentDTO.getId())
                                .type(updateInvestmentDTO.getType())
                                .symbol(updateInvestmentDTO.getSymbol())
                                .quantity(updateInvestmentDTO.getQuantity())
                                .purchasePrice(updateInvestmentDTO.getPurchasePrice())
                                .purchaseDate(updateInvestmentDTO.getPurchaseDate())
                                .build();
    }

    // Domain->Model
    public static InvestmentModel toInvestmentModel(InvestmentDomain investmentDomain){
        return InvestmentModel.builder()
                                .id(investmentDomain.getId())
                                .type(investmentDomain.getType())
                                .symbol(investmentDomain.getSymbol())
                                .quantity(investmentDomain.getQuantity())
                                .purchasePrice(investmentDomain.getPurchasePrice())
                                .purchaseDate(investmentDomain.getPurchaseDate())
                                .build();
    }
}

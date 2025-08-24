package br.ufop.edu.web.Investimentos.dtos.Investment;

import java.time.LocalDateTime;
import java.util.UUID;

import br.ufop.edu.web.Investimentos.enums.InvestmentType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreateInvestmentDTO {
    private InvestmentType type;
    private String symbol;
    private Float quantity;
    private Float purchasePrice;
    private LocalDateTime purchaseDate;
    private UUID userId;
}

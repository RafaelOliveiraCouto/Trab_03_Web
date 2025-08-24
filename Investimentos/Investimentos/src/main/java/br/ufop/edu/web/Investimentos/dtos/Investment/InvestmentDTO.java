package br.ufop.edu.web.Investimentos.dtos.Investment;

import java.time.LocalDateTime;
import java.util.UUID;

import br.ufop.edu.web.Investimentos.enums.InvestmentType;

public record InvestmentDTO(
    UUID id,
    InvestmentType type,
    String symbol,
    Float quantity,
    Float purchasePrice,
    LocalDateTime purchaseDate
) {}

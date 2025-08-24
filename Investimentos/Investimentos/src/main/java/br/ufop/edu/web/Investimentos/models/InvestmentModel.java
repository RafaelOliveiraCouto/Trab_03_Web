package br.ufop.edu.web.Investimentos.models;

import java.time.LocalDateTime;
import java.util.UUID;

import br.ufop.edu.web.Investimentos.enums.InvestmentType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tb_ivestimento")

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class InvestmentModel {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;        // Chave primaria e automatica
    @Column(nullable = false)
    private InvestmentType type;
    @Column(nullable = false)
    private String symbol;
    @Column(nullable = false)
    private Float quantity; 
    @Column(nullable = false)
    private Float purchasePrice;
    @Column(nullable = false)
    private LocalDateTime purchaseDate;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private UserModel user;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    @PrePersist             
    public void AfterGravar(){
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

    @PreUpdate
    public void AfterAtualizar(){
        this.updatedAt = LocalDateTime.now();
    }

}

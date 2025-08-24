package br.ufop.edu.web.Investimentos.controllers;

import java.util.List;
import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.ufop.edu.web.Investimentos.dtos.Investment.CreateInvestmentDTO;
import br.ufop.edu.web.Investimentos.dtos.Investment.DeleteInvestmentDTO;
import br.ufop.edu.web.Investimentos.dtos.Investment.InvestmentDTO;
import br.ufop.edu.web.Investimentos.dtos.Investment.UpdateInvestmentDTO;
import br.ufop.edu.web.Investimentos.service.InvestimentosService;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/investments")
@AllArgsConstructor
public class InvestmentController {
    private final InvestimentosService investimentosService;

    // Create ------------------------------------------------------- C
    @PostMapping
    public ResponseEntity<InvestmentDTO> createInvestimento(@RequestBody CreateInvestmentDTO createInvestmentDTO){
        InvestmentDTO investmentDTO = investimentosService.creaInvestment(createInvestmentDTO);

        if (investmentDTO == null) {return ResponseEntity.badRequest().build();}

        return ResponseEntity.ok(investmentDTO);
    }

    // Read --------------------------------------------------------- R
    @GetMapping
    public ResponseEntity<List<InvestmentDTO>> getAllInvestment(){
        return ResponseEntity.ok(investimentosService.getAllInvestment());
    }

    @GetMapping("/{type}")
    public ResponseEntity<List<InvestmentDTO>> getAllInvestmentType(@PathVariable String type){
        List<InvestmentDTO> listInvestmentDTO = investimentosService.getAllInvestmentType(type);
        return ResponseEntity.ok(listInvestmentDTO);
    }

    // Update ------------------------------------------------------- U
    @PutMapping("/{id}")
    public ResponseEntity<InvestmentDTO> updateInvestment(@RequestBody UpdateInvestmentDTO updateInvestmentDTO, @PathVariable String id){
        // Certificando que o DTO tem o id correto
        UUID uuid = UUID.fromString(id);
        updateInvestmentDTO.setId(uuid);
        InvestmentDTO investmentDTO = investimentosService.upInvestmentDTO(updateInvestmentDTO);

        if (investmentDTO == null) {return ResponseEntity.badRequest().build();}

        return ResponseEntity.ok(investmentDTO);
    }

    // Delete ------------------------------------------------------- D
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteInvestment(@PathVariable String id){
        UUID uuid = UUID.fromString(id);
        DeleteInvestmentDTO deleteInvestmentDTO = new DeleteInvestmentDTO(uuid);

        investimentosService.deleteInvestment(deleteInvestmentDTO);
        return ResponseEntity.ok("Event has been deleted.");
    }
}

// @PostMapping     -> Create   |   C
// @GetMapping      -> Read     |   R
// @PutMapping      -> Upadate  |   U
// @DeleteMapping   -> Delete   |   D
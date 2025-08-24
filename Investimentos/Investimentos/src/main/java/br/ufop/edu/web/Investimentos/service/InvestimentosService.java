package br.ufop.edu.web.Investimentos.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.ufop.edu.web.Investimentos.converter.InvestimentosConverter;
import br.ufop.edu.web.Investimentos.domain.InvestmentDomain;
import br.ufop.edu.web.Investimentos.domain.usecase.CreateInvestmentUseCase;
import br.ufop.edu.web.Investimentos.domain.usecase.UpdateInvestmentUseCase;
import br.ufop.edu.web.Investimentos.dtos.Investment.CreateInvestmentDTO;
import br.ufop.edu.web.Investimentos.dtos.Investment.DeleteInvestmentDTO;
import br.ufop.edu.web.Investimentos.dtos.Investment.InvestmentDTO;
import br.ufop.edu.web.Investimentos.dtos.Investment.UpdateInvestmentDTO;
import br.ufop.edu.web.Investimentos.enums.InvestmentType;
import br.ufop.edu.web.Investimentos.models.InvestmentModel;
import br.ufop.edu.web.Investimentos.models.UserModel;
import br.ufop.edu.web.Investimentos.repositories.InvestmentRepository;
import br.ufop.edu.web.Investimentos.repositories.UserRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class InvestimentosService {
    private final InvestmentRepository investmentRepository;
    private final UserRepository userRepository;

    // Create -----------------------------------------------------------------------------------------------     C
    public InvestmentDTO creaInvestment(CreateInvestmentDTO createInvestmentDTO){
        InvestmentDomain investmentDomain = InvestimentosConverter.toInvestmentDomain(createInvestmentDTO);
        CreateInvestmentUseCase createInvestmentUseCase = new CreateInvestmentUseCase(investmentDomain);
        createInvestmentUseCase.validade();

        UserModel user = userRepository.findById(createInvestmentDTO.getUserId()).orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
        
        InvestmentModel investmentModel = InvestimentosConverter.toInvestmentModel(investmentDomain);
        investmentModel.setUser(user);
        return InvestimentosConverter.toInvestmentDTO(investmentRepository.save(investmentModel));
    }

    // Read -------------------------------------------------------------------------------------------------     R
    public List<InvestmentDTO> getAllInvestment(){
        return investmentRepository.findAll().stream().map(InvestimentosConverter::toInvestmentDTO).toList();
    }

    public List<InvestmentDTO> getAllInvestmentType(String type){
        InvestmentType enumType = InvestmentType.valueOf(type.toUpperCase());
        List<InvestmentModel> investmentModelsList = investmentRepository.findByType(enumType);
        return investmentModelsList.stream().map(InvestimentosConverter::toInvestmentDTO).toList();
    }

    // Update -----------------------------------------------------------------------------------------------     U
    public InvestmentDTO upInvestmentDTO(UpdateInvestmentDTO updateInvestmentDTO){
        InvestmentDomain investmentDomain = InvestimentosConverter.toInvestmentDomain(updateInvestmentDTO);
        UpdateInvestmentUseCase updateInvestmentUseCase = new UpdateInvestmentUseCase(investmentDomain, investmentRepository, userRepository);
        updateInvestmentUseCase.validade();
        Optional<InvestmentModel> optionalInvestmentModel = investmentRepository.findById(updateInvestmentDTO.getId());

        if (optionalInvestmentModel.isEmpty()) {throw new RuntimeException("Event not found.");}

        // Associa o UserModel completo antes de salvar
        UserModel user = userRepository.findById(investmentDomain.getUserId()).orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
        
        InvestmentModel investmentModel = InvestimentosConverter.toInvestmentModel(investmentDomain);
        investmentModel.setUser(user);
        return InvestimentosConverter.toInvestmentDTO(investmentRepository.save(investmentModel));
    }

    // Delete -----------------------------------------------------------------------------------------------     D
    public void deleteInvestment(DeleteInvestmentDTO deleteInvestmentDTO){
        Optional<InvestmentModel> optionalInvestmentModel = investmentRepository.findById(deleteInvestmentDTO.id());

        if (optionalInvestmentModel.isEmpty()) {throw new RuntimeException("Sales not found.");}

        investmentRepository.delete(optionalInvestmentModel.get());
    }
}

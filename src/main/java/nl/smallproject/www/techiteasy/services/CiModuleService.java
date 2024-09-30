package nl.smallproject.www.techiteasy.services;

import nl.smallproject.www.techiteasy.dtos.CiModuleOutputDto;
import nl.smallproject.www.techiteasy.exceptions.RecordNotFoundException;
import nl.smallproject.www.techiteasy.mappers.CiModuleMapper;
import nl.smallproject.www.techiteasy.models.CiModule;
import nl.smallproject.www.techiteasy.repositories.CiModuleRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CiModuleService {
    private final CiModuleRepository ciModuleRepository;
    private final CiModuleMapper ciModuleMapper;

    public CiModuleService(CiModuleRepository ciModuleRepository, CiModuleMapper ciModuleMapper) {
        this.ciModuleRepository = ciModuleRepository;
        this.ciModuleMapper = ciModuleMapper;
    }

    public CiModuleOutputDto getCiModuleById(Long id) {
        Optional<CiModule> ciModuleOptional = Optional.ofNullable(ciModuleRepository.findById(id)
                .orElseThrow(() -> new RecordNotFoundException("CiModule not found with this id: " + id)));

        if (ciModuleOptional.isPresent()) {
            CiModule ciModule = ciModuleOptional.get();
            return ciModuleMapper.ciModuleEntityToOutputDto(ciModule);
        } else {
            throw new RecordNotFoundException("CiModule not found with this id: " + id);
        }
    }

}

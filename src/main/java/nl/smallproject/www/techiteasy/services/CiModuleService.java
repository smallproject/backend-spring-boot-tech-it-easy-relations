package nl.smallproject.www.techiteasy.services;

import nl.smallproject.www.techiteasy.dtos.CiModule.CiModuleInputDto;
import nl.smallproject.www.techiteasy.dtos.CiModule.CiModuleOutputDto;
import nl.smallproject.www.techiteasy.dtos.CiModule.CiModuleUpdateDto;
import nl.smallproject.www.techiteasy.exceptions.RecordNotFoundException;
import nl.smallproject.www.techiteasy.mappers.CiModuleMapper;
import nl.smallproject.www.techiteasy.models.CiModule;
import nl.smallproject.www.techiteasy.repositories.CiModuleRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CiModuleService {
    private final CiModuleRepository ciModuleRepository;
    private final CiModuleMapper ciModuleMapper;

    public CiModuleService(CiModuleRepository ciModuleRepository, CiModuleMapper ciModuleMapper) {
        this.ciModuleRepository = ciModuleRepository;
        this.ciModuleMapper = ciModuleMapper;
    }

    public List<CiModuleOutputDto> getAllCiModules() {
        List<CiModule> ciModules = ciModuleRepository.findAll();
        List<CiModuleOutputDto> ciModuleOutputDtos = new ArrayList<>();

        for (CiModule ciModule : ciModules) {
            ciModuleOutputDtos.add(ciModuleMapper.ciModuleEntityToOutputDto(ciModule));
        }

        return ciModuleOutputDtos;
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

    public CiModule createCiModule(CiModuleInputDto ciModuleInputDto) {
        CiModule ciModule = ciModuleMapper.ciModuleInputDtoToEntity(ciModuleInputDto);
        ciModuleRepository.save(ciModule);
        return ciModule;
    }

    public void updateCiModule(Long id, CiModuleUpdateDto ciModuleUpdateDto) {
        CiModule existingCiModule = ciModuleRepository.getReferenceById(id);
        CiModule updatedCiModule = ciModuleMapper.ciModuleUpdateDtoToEntity(ciModuleUpdateDto);

        BeanUtils.copyProperties(updatedCiModule, existingCiModule, "id");
        ciModuleRepository.save(existingCiModule);
    }

    public void deleteCiModule(Long id) {
        ciModuleRepository.deleteById(id);
    }

}

package nl.smallproject.www.techiteasy.mappers;

import nl.smallproject.www.techiteasy.dtos.CiModule.CiModuleInputDto;
import nl.smallproject.www.techiteasy.dtos.CiModule.CiModuleOutputDto;
import nl.smallproject.www.techiteasy.dtos.CiModule.CiModuleUpdateDto;
import nl.smallproject.www.techiteasy.models.CiModule;
import org.springframework.stereotype.Component;

@Component
public class CiModuleMapper {
    public CiModule ciModuleInputDtoToEntity(CiModuleInputDto ciModuleInputDto) {
        CiModule ciModule = new CiModule();
        ciModule.setName(ciModuleInputDto.getName());
        ciModule.setType(ciModuleInputDto.getType());
        ciModule.setPrice(ciModuleInputDto.getPrice());
        return ciModule;
    }

    public CiModuleOutputDto ciModuleEntityToOutputDto(CiModule ciModule) {
        CiModuleOutputDto ciModuleOutputDto = new CiModuleOutputDto();
        ciModuleOutputDto.setId(ciModule.getId());
        ciModuleOutputDto.setName(ciModule.getName());
        ciModuleOutputDto.setType(ciModule.getType());
        ciModuleOutputDto.setPrice(ciModule.getPrice());
        return ciModuleOutputDto;
    }

    public CiModule ciModuleUpdateDtoToEntity(CiModuleUpdateDto ciModuleUpdateDto) {
        CiModule ciModule = new CiModule();
        ciModule.setName(ciModuleUpdateDto.getName());
        ciModule.setType(ciModuleUpdateDto.getType());
        ciModule.setPrice(ciModuleUpdateDto.getPrice());
        return ciModule;
    }
}

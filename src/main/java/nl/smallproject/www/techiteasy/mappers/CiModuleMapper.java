package nl.smallproject.www.techiteasy.mappers;

import nl.smallproject.www.techiteasy.dtos.CiModuleInputDto;
import nl.smallproject.www.techiteasy.dtos.CiModuleOutputDto;
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
}

package nl.smallproject.www.techiteasy.mappers;

import nl.smallproject.www.techiteasy.dtos.RemoteControllerInputDto;
import nl.smallproject.www.techiteasy.dtos.RemoteControllerOutputDto;
import nl.smallproject.www.techiteasy.models.RemoteController;
import org.springframework.stereotype.Component;

@Component
public class RemoteControllerMapper {
    public RemoteControllerOutputDto remoteControllerEntityToOutputDto(RemoteController remoteController) {
        RemoteControllerOutputDto remoteControllerOutputDto = new RemoteControllerOutputDto();
        remoteControllerOutputDto.setId(remoteController.getId());
        remoteControllerOutputDto.setCompatibleWith(remoteController.getCompatibleWith());
        remoteControllerOutputDto.setBatteryType(remoteController.getBatteryType());
        remoteControllerOutputDto.setName(remoteController.getName());
        remoteControllerOutputDto.setBrand(remoteController.getBrand());
        remoteControllerOutputDto.setPrice(remoteController.getPrice());
        remoteControllerOutputDto.setOriginalStock(remoteController.getOriginalStock());
        return remoteControllerOutputDto;
    }

    public RemoteController remoteControllerInputDtoToEntity(RemoteControllerInputDto remoteControllerInputDto) {
        RemoteController remoteController = new RemoteController();
        remoteController.setCompatibleWith(remoteControllerInputDto.getCompatibleWith());
        remoteController.setBatteryType(remoteControllerInputDto.getBatteryType());
        remoteController.setName(remoteControllerInputDto.getName());
        remoteController.setBrand(remoteControllerInputDto.getBrand());
        remoteController.setPrice(remoteControllerInputDto.getPrice());
        remoteController.setOriginalStock(remoteControllerInputDto.getOriginalStock());
        return remoteController;
    }
}

package nl.smallproject.www.techiteasy.mappers;

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
}

package nl.smallproject.www.techiteasy.mappers;

import nl.smallproject.www.techiteasy.dtos.RemoteController.RemoteControllerInputDto;
import nl.smallproject.www.techiteasy.dtos.RemoteController.RemoteControllerOutputDto;
import nl.smallproject.www.techiteasy.dtos.RemoteController.RemoteControllerUpdateDto;
import nl.smallproject.www.techiteasy.models.RemoteController;
import org.springframework.stereotype.Component;

@Component
public class RemoteControllerMapper {

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

    public RemoteControllerOutputDto remoteControllerEntityToOutputDto(RemoteController remoteController) {
        RemoteControllerOutputDto remoteControllerOutputDto = new RemoteControllerOutputDto();
        remoteControllerOutputDto.setId(remoteController.getId());
        remoteControllerOutputDto.setCompatibleWith(remoteController.getCompatibleWith());
        remoteControllerOutputDto.setBatteryType(remoteController.getBatteryType());
        remoteControllerOutputDto.setName(remoteController.getName());
        remoteControllerOutputDto.setBrand(remoteController.getBrand());
        remoteControllerOutputDto.setPrice(remoteController.getPrice());
        remoteControllerOutputDto.setOriginalStock(remoteController.getOriginalStock());
//        remoteControllerOutputDto.setTelevisionOutputDto(televisionMapper.televisionEntityToOutputDto(remoteController.getTelevision()));
        return remoteControllerOutputDto;
    }

    public RemoteController remoteControllerUpdateDtoToEntity(RemoteControllerUpdateDto remoteControllerUpdateDto) {
        RemoteController remoteController = new RemoteController();
        remoteController.setCompatibleWith(remoteControllerUpdateDto.getCompatibleWith());
        remoteController.setBatteryType(remoteControllerUpdateDto.getBatteryType());
        remoteController.setName(remoteControllerUpdateDto.getName());
        remoteController.setBrand(remoteControllerUpdateDto.getBrand());
        remoteController.setPrice(remoteControllerUpdateDto.getPrice());
        remoteController.setOriginalStock(remoteControllerUpdateDto.getOriginalStock());
        return remoteController;
    }
}

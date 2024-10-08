package nl.smallproject.www.techiteasy.mappers;

import nl.smallproject.www.techiteasy.models.Television;
import nl.smallproject.www.techiteasy.dtos.Television.TelevisionInputDto;
import nl.smallproject.www.techiteasy.dtos.Television.TelevisionOutputDto;
import nl.smallproject.www.techiteasy.dtos.Television.TelevisionUpdateDto;
import org.springframework.stereotype.Component;

@Component
public class TelevisionMapper {

    private final RemoteControllerMapper remoteControllerMapper;

    public TelevisionMapper(RemoteControllerMapper remoteControllerMapper) {
        this.remoteControllerMapper = remoteControllerMapper;
    }

    public Television televisionInputDtoToEntity(TelevisionInputDto televisionInputDto) {
        Television television = new Television();
        television.setName(televisionInputDto.getName());
        television.setBrand(televisionInputDto.getBrand());
        television.setPrice(televisionInputDto.getPrice());
        television.setCurrentStock(televisionInputDto.getCurrentStock());
        television.setHeight(televisionInputDto.getHeight());
        television.setWidth(televisionInputDto.getWidth());
        television.setScreenQuality(televisionInputDto.getScreenQuality());
        television.setScreenType(televisionInputDto.getScreenType());
        television.setWifi(televisionInputDto.getWifi());
        television.setSmartTv(televisionInputDto.getSmartTv());
        television.setVoiceControl(televisionInputDto.getVoiceControl());
        television.setHdr(televisionInputDto.getHdr());

        if (televisionInputDto.getRemoteControllerInputDto() != null)
        {
            television.setRemoteController(remoteControllerMapper.remoteControllerInputDtoToEntity(televisionInputDto.getRemoteControllerInputDto()));
        }

        return television;
    }

    public TelevisionOutputDto televisionEntityToOutputDto(Television television) {
        TelevisionOutputDto televisionOutputDto = new TelevisionOutputDto();
        televisionOutputDto.setId(television.getId());
        televisionOutputDto.setName(television.getName());
        televisionOutputDto.setBrand(television.getBrand());
        televisionOutputDto.setPrice(television.getPrice());
        televisionOutputDto.setCurrentStock(television.getCurrentStock());
        televisionOutputDto.setHeight(television.getHeight());
        televisionOutputDto.setWidth(television.getWidth());
        televisionOutputDto.setScreenQuality(television.getScreenQuality());
        televisionOutputDto.setScreenType(television.getScreenType());
        televisionOutputDto.setWifi(television.getWifi());
        televisionOutputDto.setSmartTv(television.getSmartTv());
        televisionOutputDto.setVoiceControl(television.getVoiceControl());
        televisionOutputDto.setHdr(television.getHdr());

        if (television.getRemoteController() != null)
        {
            televisionOutputDto.setRemoteControllerOutputDto(remoteControllerMapper.remoteControllerEntityToOutputDto(television.getRemoteController()));
        }


        return televisionOutputDto;
    }

    public Television televisionUpdateDtoToEntity(TelevisionUpdateDto televisionUpdateDto) {
        Television television = new Television();
        television.setName(televisionUpdateDto.getName());
        television.setBrand(televisionUpdateDto.getBrand());
        television.setPrice(televisionUpdateDto.getPrice());
        television.setCurrentStock(televisionUpdateDto.getCurrentStock());
        television.setHeight(televisionUpdateDto.getHeight());
        television.setWidth(televisionUpdateDto.getWidth());
        television.setScreenQuality(televisionUpdateDto.getScreenQuality());
        television.setScreenType(televisionUpdateDto.getScreenType());
        television.setWifi(televisionUpdateDto.getWifi());
        television.setSmartTv(televisionUpdateDto.getSmartTv());
        television.setVoiceControl(televisionUpdateDto.getVoiceControl());
        television.setHdr(televisionUpdateDto.getHdr());

        return television;
    }

}

package nl.smallproject.www.techiteasy.mappers;

import nl.smallproject.www.techiteasy.dtos.WallBracketInputDto;
import nl.smallproject.www.techiteasy.dtos.WallBracketOutputDto;
import nl.smallproject.www.techiteasy.dtos.WallBracketUpdateDto;
import nl.smallproject.www.techiteasy.models.WallBracket;
import org.springframework.stereotype.Component;

@Component
public class WallBracketMapper {

    public WallBracket wallBracketInputDtoToEntity(WallBracketInputDto wallBracketInputDto) {
        WallBracket wallBracket = new WallBracket();
        wallBracket.setSize(wallBracketInputDto.getSize());
        wallBracket.setAdjustable(wallBracketInputDto.getAdjustable());
        wallBracket.setName(wallBracketInputDto.getName());
        wallBracket.setPrice(wallBracketInputDto.getPrice());
        return wallBracket;
    }

    public WallBracketOutputDto wallBracketEntityToOutputDto(WallBracket wallBracket) {
        WallBracketOutputDto wallBracketOutputDto = new WallBracketOutputDto();
        wallBracketOutputDto.setId(wallBracket.getId());
        wallBracketOutputDto.setSize(wallBracket.getSize());
        wallBracketOutputDto.setAdjustable(wallBracket.getAdjustable());
        wallBracketOutputDto.setName(wallBracket.getName());
        wallBracketOutputDto.setPrice(wallBracket.getPrice());
        return wallBracketOutputDto;
    }

    public WallBracket wallBracketUpdateDtoToEntity(WallBracketUpdateDto wallBracketUpdateDto) {
        WallBracket wallBracket = new WallBracket();
        wallBracket.setSize(wallBracketUpdateDto.getSize());
        wallBracket.setAdjustable(wallBracketUpdateDto.getAdjustable());
        wallBracket.setName(wallBracketUpdateDto.getName());
        wallBracket.setPrice(wallBracketUpdateDto.getPrice());
        return wallBracket;
    }
}

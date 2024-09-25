package nl.smallproject.www.techiteasy.mappers;

import nl.smallproject.www.techiteasy.dtos.TelevisionSalesOutputDto;
import nl.smallproject.www.techiteasy.dtos.TelevisionSalesUpdateDto;
import nl.smallproject.www.techiteasy.models.Television;
import org.springframework.stereotype.Component;

@Component
public class TelevisionSalesMapper {
    public TelevisionSalesOutputDto televisionSalesEntityToOutputDto(Television television) {
        TelevisionSalesOutputDto televisionSalesOutputDto = new TelevisionSalesOutputDto();
        televisionSalesOutputDto.setId(television.getId());
        televisionSalesOutputDto.setPrice(television.getPrice());
        televisionSalesOutputDto.setOriginalStock(television.getCurrentStock());
        televisionSalesOutputDto.setSold(television.getSold());
        return televisionSalesOutputDto;
    }

    public Television televisionSalesUpdateDtoToEntity(TelevisionSalesUpdateDto televisionSalesUpdateDto) {
        Television television = new Television();
        television.setPrice(televisionSalesUpdateDto.getPrice());
        television.setCurrentStock(televisionSalesUpdateDto.getOriginalStock());
        television.setSold(televisionSalesUpdateDto.getSold());
        return television;
    }
}

package nl.smallproject.www.techiteasy.services;

import nl.smallproject.www.techiteasy.dtos.TelevisionOutputDto;
import nl.smallproject.www.techiteasy.dtos.TelevisionSalesOutputDto;
import nl.smallproject.www.techiteasy.dtos.TelevisionSalesUpdateDto;
import nl.smallproject.www.techiteasy.mappers.TelevisionSalesMapper;
import nl.smallproject.www.techiteasy.models.Television;
import nl.smallproject.www.techiteasy.repositories.TelevisionRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TelevisionSalesService {

    private final TelevisionRepository televisionRepository;
    private final TelevisionSalesMapper televisionSalesMapper;

    public TelevisionSalesService(TelevisionRepository televisionRepository, TelevisionSalesMapper televisionSalesMapper) {
        this.televisionRepository = televisionRepository;
        this.televisionSalesMapper = televisionSalesMapper;
    }

    public List<TelevisionSalesOutputDto> getAllTelevisionSales() {
        List<Television> televisions = televisionRepository.findAll();
        List<TelevisionSalesOutputDto> televisionSalesOutputDtos = new ArrayList<>();

        for (var television: televisions) {
            televisionSalesOutputDtos.add(televisionSalesMapper.televisionSalesEntityToOutputDto(television));
        }

        return televisionSalesOutputDtos;
    }

    public TelevisionSalesOutputDto getTelevisionById(Long id) {
        Optional<Television> televisionOptional = televisionRepository.findById(id);

        if (televisionOptional.isPresent()) {
            Television television = televisionOptional.get();
            return televisionSalesMapper.televisionSalesEntityToOutputDto(television);
        } else {
            throw new RuntimeException("Television not found");
        }
    }

    public void patchTelevisionSales(Long id, TelevisionSalesUpdateDto televisionSalesUpdateDto) {
        Television existingTelevision = televisionRepository.getReferenceById(id);
        Television updatedTelevision = televisionSalesMapper.televisionSalesUpdateDtoToEntity(televisionSalesUpdateDto);
//
        if (updatedTelevision.getPrice() != 0) {
            existingTelevision.setPrice(updatedTelevision.getPrice());
        }
        if (updatedTelevision.getCurrentStock() != 0) {
            existingTelevision.setCurrentStock(updatedTelevision.getCurrentStock());
        }
        if (updatedTelevision.getSold() != 0) {
            existingTelevision.setSold(updatedTelevision.getSold());
        }

        televisionRepository.save(existingTelevision);

////        BeanUtils.copyProperties(updatedTelevision, existingTelevision, "id");
//        televisionRepository.save(existingTelevision);

        // needs to be studied
//        PropertyDescriptor[] propertyDescriptors = BeanUtils.getPropertyDescriptors(source.getClass());
//
//        List<String> nullPropertyNames = new ArrayList<>();

        // Iterate over all properties and find out which ones are null
//        for (PropertyDescriptor pd : propertyDescriptors) {
//            try {
//                Method getter = pd.getReadMethod();
//                if (getter != null) {
//                    Object value = getter.invoke(source);
//                    if (value == null) {
//                        nullPropertyNames.add(pd.getName());
//                    }
//                }
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }

        // Now copy properties, ignoring the null properties
//        BeanUtils.copyProperties(source, target, nullPropertyNames.toArray(new String[0]));

    }
}

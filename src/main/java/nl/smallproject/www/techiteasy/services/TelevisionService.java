package nl.smallproject.www.techiteasy.services;

import nl.smallproject.www.techiteasy.dtos.RemoteController.RemoteControllerInputDto;
import nl.smallproject.www.techiteasy.exceptions.RecordNotFoundException;
import nl.smallproject.www.techiteasy.mappers.RemoteControllerMapper;
import nl.smallproject.www.techiteasy.mappers.TelevisionMapper;
import nl.smallproject.www.techiteasy.models.Television;
import nl.smallproject.www.techiteasy.dtos.Television.TelevisionInputDto;
import nl.smallproject.www.techiteasy.dtos.Television.TelevisionOutputDto;
import nl.smallproject.www.techiteasy.dtos.Television.TelevisionUpdateDto;
import nl.smallproject.www.techiteasy.repositories.TelevisionRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TelevisionService {
    private final TelevisionRepository televisionRepository;
    private final TelevisionMapper televisionMapper;

    public TelevisionService(TelevisionRepository televisionRepository, TelevisionMapper televisionMapper) {
        this.televisionRepository = televisionRepository;
        this.televisionMapper = televisionMapper;
    }

    public List<TelevisionOutputDto> getAllTelevision() {
        List<Television> televisions = televisionRepository.findAll();
        List<TelevisionOutputDto> televisionOutputDtos = new ArrayList<>();

        for (var television: televisions) {
            televisionOutputDtos.add(televisionMapper.televisionEntityToOutputDto(television));
        }

        return televisionOutputDtos;
    }

    public TelevisionOutputDto getTelevisionById(Long id) {
        Optional<Television> televisionOptional = televisionRepository.findById(id);

        if (televisionOptional.isPresent()) {
            Television television = televisionOptional.get();
            return televisionMapper.televisionEntityToOutputDto(television);
        } else {
            throw new RuntimeException("Television not found");
        }
    }

    public Television createTelevision(TelevisionInputDto televisionInputDto) {
        Television television = televisionMapper.televisionInputDtoToEntity(televisionInputDto);
        televisionRepository.save(television);
        return television;
    }

    public void updateTelevision(Long id, TelevisionUpdateDto televisionUpdateDto) {
        Television existingTelevision = televisionRepository.getReferenceById(id);
        Television updatedTelevision = televisionMapper.televisionUpdateDtoToEntity(televisionUpdateDto);

        BeanUtils.copyProperties(updatedTelevision, existingTelevision, "id");
        televisionRepository.save(existingTelevision);
    }

    public void deleteTelevision(Long id) {
        televisionRepository.deleteById(id);
    }
}

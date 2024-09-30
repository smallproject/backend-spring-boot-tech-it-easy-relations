package nl.smallproject.www.techiteasy.services;

import nl.smallproject.www.techiteasy.dtos.RemoteControllerInputDto;
import nl.smallproject.www.techiteasy.dtos.RemoteControllerOutputDto;
import nl.smallproject.www.techiteasy.dtos.RemoteControllerUpdateDto;
import nl.smallproject.www.techiteasy.exceptions.RecordNotFoundException;
import nl.smallproject.www.techiteasy.mappers.RemoteControllerMapper;
import nl.smallproject.www.techiteasy.models.RemoteController;
import nl.smallproject.www.techiteasy.repositories.RemoteControllerRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class RemoteControllerService {
    private final RemoteControllerRepository remoteControllerRepository;
    private final RemoteControllerMapper remoteControllerMapper;

    public RemoteControllerService(RemoteControllerRepository remoteControllerRepository, RemoteControllerMapper remoteControllerMapper) {
        this.remoteControllerRepository = remoteControllerRepository;
        this.remoteControllerMapper = remoteControllerMapper;
    }

    public List<RemoteControllerOutputDto> getAllRemoteControllers() {
        List<RemoteController> remoteControllers = remoteControllerRepository.findAll();
        List<RemoteControllerOutputDto> remoteControllerOutputDtos = new ArrayList<>();

        for (var remoteController : remoteControllers) {
            remoteControllerOutputDtos.add(remoteControllerMapper.remoteControllerEntityToOutputDto(remoteController));
        }

        return remoteControllerOutputDtos;
    }

    public RemoteControllerOutputDto getRemoteControllerById(Long id) {
        Optional<RemoteController> remoteControllerOptional = Optional.ofNullable(remoteControllerRepository.findById(id)
                .orElseThrow(() -> new RecordNotFoundException("Remote controller not found with this id: " + id)));

        if (remoteControllerOptional.isPresent()) {
            RemoteController remoteController = remoteControllerOptional.get();
            return remoteControllerMapper.remoteControllerEntityToOutputDto(remoteController);
        } else {
            throw new RecordNotFoundException("Remote controller not found with this id: " +id);
        }
    }

    public RemoteController createRemoteController(RemoteControllerInputDto remoteControllerInputDto) {
        RemoteController remoteController = remoteControllerMapper.remoteControllerInputDtoToEntity(remoteControllerInputDto);
        remoteControllerRepository.save(remoteController);
        return remoteController;
    }

    public void updateRemoteController(Long id, RemoteControllerUpdateDto remoteControllerUpdateDto) {
        RemoteController existingRemoteController = remoteControllerRepository.getReferenceById(id);
        RemoteController updatedRemoteController = remoteControllerMapper.remoteControllerUpdateDtoToEntity(remoteControllerUpdateDto);

        BeanUtils.copyProperties(updatedRemoteController, existingRemoteController, "id");
        remoteControllerRepository.save(existingRemoteController);
    }

    public void deleteRemoteController(Long id) {
        remoteControllerRepository.deleteById(id);
    }
}

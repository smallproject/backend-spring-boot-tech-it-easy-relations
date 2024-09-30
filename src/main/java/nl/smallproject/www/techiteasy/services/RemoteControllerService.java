package nl.smallproject.www.techiteasy.services;

import nl.smallproject.www.techiteasy.dtos.RemoteControllerOutputDto;
import nl.smallproject.www.techiteasy.exceptions.RecordNotFoundException;
import nl.smallproject.www.techiteasy.mappers.RemoteControllerMapper;
import nl.smallproject.www.techiteasy.models.RemoteController;
import nl.smallproject.www.techiteasy.repositories.RemoteControllerRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RemoteControllerService {
    private final RemoteControllerRepository remoteControllerRepository;
    private final RemoteControllerMapper remoteControllerMapper;

    public RemoteControllerService(RemoteControllerRepository remoteControllerRepository, RemoteControllerMapper remoteControllerMapper) {
        this.remoteControllerRepository = remoteControllerRepository;
        this.remoteControllerMapper = remoteControllerMapper;
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
}

package nl.smallproject.www.techiteasy.services;

import nl.smallproject.www.techiteasy.dtos.RemoteController.RemoteControllerInputDto;
import nl.smallproject.www.techiteasy.exceptions.RecordNotFoundException;
import nl.smallproject.www.techiteasy.mappers.RemoteControllerMapper;
import nl.smallproject.www.techiteasy.mappers.TelevisionMapper;
import nl.smallproject.www.techiteasy.models.CiModule;
import nl.smallproject.www.techiteasy.models.RemoteController;
import nl.smallproject.www.techiteasy.models.Television;
import nl.smallproject.www.techiteasy.dtos.Television.TelevisionInputDto;
import nl.smallproject.www.techiteasy.dtos.Television.TelevisionOutputDto;
import nl.smallproject.www.techiteasy.dtos.Television.TelevisionUpdateDto;
import nl.smallproject.www.techiteasy.models.WallBracket;
import nl.smallproject.www.techiteasy.repositories.CiModuleRepository;
import nl.smallproject.www.techiteasy.repositories.RemoteControllerRepository;
import nl.smallproject.www.techiteasy.repositories.TelevisionRepository;
import nl.smallproject.www.techiteasy.repositories.WallBracketRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TelevisionService {
    private final TelevisionRepository televisionRepository;
    private final TelevisionMapper televisionMapper;
    private final RemoteControllerService remoteControllerService;
    private final RemoteControllerRepository remoteControllerRepository;
    private final CiModuleRepository ciModuleRepository;
    private final WallBracketRepository wallBracketRepository;

    public TelevisionService(TelevisionRepository televisionRepository, TelevisionMapper televisionMapper, RemoteControllerMapper remoteControllerMapper, RemoteControllerService remoteControllerService, RemoteControllerRepository remoteControllerRepository, CiModuleRepository ciModuleRepository, WallBracketRepository wallBracketRepository) {
        this.televisionRepository = televisionRepository;
        this.televisionMapper = televisionMapper;
        this.remoteControllerService = remoteControllerService;
        this.remoteControllerRepository = remoteControllerRepository;
        this.ciModuleRepository = ciModuleRepository;
        this.wallBracketRepository = wallBracketRepository;
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

        if (televisionInputDto.getRemoteControllerInputDto() != null) {
            RemoteController remoteController = remoteControllerService.createRemoteController(televisionInputDto.getRemoteControllerInputDto());
            television.setRemoteController(remoteController);
            remoteController.setTelevision(television); //bi-directional
        }

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

    public void assignRemoteControllerToTelevision(Long televisionId, Long remoteControllerId) {
        Optional<Television> televisionOptional = Optional.ofNullable(televisionRepository.findById(televisionId)
                .orElseThrow(() -> new RecordNotFoundException("Television not found with this id: " + televisionId)));

        Optional<RemoteController> remoteControllerOptional = Optional.ofNullable(remoteControllerRepository.findById(remoteControllerId)
                .orElseThrow(() -> new RecordNotFoundException("Remote controller not found with this id: " + remoteControllerId)));

        if (televisionOptional.isPresent()) {
            Television existingTelevision = televisionOptional.get();

            if (remoteControllerOptional.isPresent()){
                RemoteController existingRemoteController = remoteControllerOptional.get();
                existingTelevision.setRemoteController(existingRemoteController);
                existingRemoteController.setTelevision(existingTelevision); //Bi-directional
            }

            //updateTelevision(id, televisionMapper.televisionUpdateDtoToEntity((TelevisionUpdateDto)existingTelevision));
            televisionRepository.save(existingTelevision);
        } else {
            throw new RecordNotFoundException("Television not found with this id: " +televisionId);
        }
    }

    public void assignCiModuleToTelevision(Long televisionId, Long ciModuleId) {
        Optional<Television> televisionOptional = Optional.ofNullable(televisionRepository.findById(televisionId)
                .orElseThrow(() -> new RecordNotFoundException("Television not found with this id: " + televisionId)));

        Optional<CiModule> ciModuleOptional = Optional.ofNullable(ciModuleRepository.findById(ciModuleId)
                .orElseThrow(() -> new RecordNotFoundException("CiModule not found with this id: " + ciModuleId)));

        if (televisionOptional.isPresent()) {
            Television existingTelevision = televisionOptional.get();

            if (ciModuleOptional.isPresent()) {
                CiModule existingCiModule = ciModuleOptional.get();
                List<CiModule> CiModules = new ArrayList<>();
                CiModules.add(existingCiModule);
                existingTelevision.setCiModule(CiModules);
                existingCiModule.setTelevision(existingTelevision); //Bi-directional
            } else {
                throw new RecordNotFoundException("CiModule not found with this id: " +ciModuleId);
            }
            televisionRepository.save(existingTelevision);
        } else {
            throw new RecordNotFoundException("Television not found with this id: " + televisionId);
        }
    }

    public void assignWallBracketToTelevision(Long televisionId, Long wallBracketId) {
        Optional<Television> televisonOptional = Optional.ofNullable(televisionRepository.findById(televisionId)
                .orElseThrow(() -> new RecordNotFoundException("Television not found with this id: " + televisionId)));

        Optional<WallBracket> wallBracketOptional = Optional.ofNullable(wallBracketRepository.findById(wallBracketId)
                .orElseThrow(() -> new RecordNotFoundException("Wall Bracket not found with this id: " + wallBracketId)));

        if (televisonOptional.isPresent()) {
            Television existingTelevision = televisonOptional.get();

            if (wallBracketOptional.isPresent()) {
                WallBracket existingWallBracket = wallBracketOptional.get();
                List<WallBracket> wallBrackets = new ArrayList<>();
                wallBrackets.add(existingWallBracket);

                List<Television> televisions = new ArrayList<>();
                televisions.add(existingTelevision);
                existingTelevision.setWallBrackets(wallBrackets);
                existingWallBracket.setTelevisions(televisions); //Bi-directional
            } else {
                throw new RecordNotFoundException("Wall Bracket not found with this id: " +wallBracketId);
            }
            televisionRepository.save(existingTelevision);
        } else {
            throw new RecordNotFoundException("Television not found with this id: " +televisionId);
        }
    }
}

package nl.smallproject.www.techiteasy.services;

import nl.smallproject.www.techiteasy.dtos.WallBracketInputDto;
import nl.smallproject.www.techiteasy.dtos.WallBracketOutputDto;
import nl.smallproject.www.techiteasy.dtos.WallBracketUpdateDto;
import nl.smallproject.www.techiteasy.exceptions.RecordNotFoundException;
import nl.smallproject.www.techiteasy.mappers.WallBracketMapper;
import nl.smallproject.www.techiteasy.models.WallBracket;
import nl.smallproject.www.techiteasy.repositories.WallBracketRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class WallBracketService {
    private final WallBracketRepository wallBracketRepository;
    private final WallBracketMapper wallBracketMapper;

    public WallBracketService(WallBracketRepository wallBracketRepository, WallBracketMapper wallBracketMapper) {
        this.wallBracketRepository = wallBracketRepository;
        this.wallBracketMapper = wallBracketMapper;
    }

    public List<WallBracketOutputDto> getAllWallBrackets() {
        List<WallBracket> wallBrackets = wallBracketRepository.findAll();
        List<WallBracketOutputDto> wallBracketOutputDtos = new ArrayList<>();

        for (var wallBracket : wallBrackets) {
            wallBracketOutputDtos.add(wallBracketMapper.wallBracketEntityToOutputDto(wallBracket));
        }

        return wallBracketOutputDtos;
    }

    public WallBracketOutputDto getWallBracketById(Long id) {
        Optional<WallBracket> wallBracketOptional = Optional.ofNullable(wallBracketRepository.findById(id)
                .orElseThrow(() -> new RecordNotFoundException("Wall bracket is not found with this id: " + id)));

        if (wallBracketOptional.isPresent()) {
            WallBracket wallBracket = wallBracketOptional.get();
            return wallBracketMapper.wallBracketEntityToOutputDto(wallBracket);
        } else {
            throw new RecordNotFoundException("Wall bracket is not found with this id: " + id);
        }
    }

    public WallBracket createWallBracket(WallBracketInputDto wallBracketInputDto) {
        WallBracket wallBracket = wallBracketMapper.wallBracketInputDtoToEntity(wallBracketInputDto);
        wallBracketRepository.save(wallBracket);
        return wallBracket;
    }

    public void updateWallBracket(Long id, WallBracketUpdateDto wallBracketUpdateDto) {
        WallBracket existingWallBracket = wallBracketRepository.getReferenceById(id);
        WallBracket updatedWallBracket = wallBracketMapper.wallBracketUpdateDtoToEntity(wallBracketUpdateDto);

        BeanUtils.copyProperties(updatedWallBracket, existingWallBracket, "id");
        wallBracketRepository.save(existingWallBracket);
    }

    public void deleteWallBracket(Long id) {
        wallBracketRepository.deleteById(id);
    }
}

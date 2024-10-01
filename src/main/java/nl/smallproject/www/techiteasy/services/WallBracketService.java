package nl.smallproject.www.techiteasy.services;

import nl.smallproject.www.techiteasy.dtos.WallBracketInputDto;
import nl.smallproject.www.techiteasy.dtos.WallBracketOutputDto;
import nl.smallproject.www.techiteasy.exceptions.RecordNotFoundException;
import nl.smallproject.www.techiteasy.mappers.WallBracketMapper;
import nl.smallproject.www.techiteasy.models.WallBracket;
import nl.smallproject.www.techiteasy.repositories.WallBracketRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class WallBracketService {
    private final WallBracketRepository wallBracketRepository;
    private final WallBracketMapper wallBracketMapper;

    public WallBracketService(WallBracketRepository wallBracketRepository, WallBracketMapper wallBracketMapper) {
        this.wallBracketRepository = wallBracketRepository;
        this.wallBracketMapper = wallBracketMapper;
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
}

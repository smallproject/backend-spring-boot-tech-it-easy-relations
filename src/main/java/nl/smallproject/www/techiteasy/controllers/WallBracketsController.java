package nl.smallproject.www.techiteasy.controllers;

import jakarta.validation.Valid;
import nl.smallproject.www.techiteasy.dtos.WallBracketInputDto;
import nl.smallproject.www.techiteasy.dtos.WallBracketOutputDto;
import nl.smallproject.www.techiteasy.models.WallBracket;
import nl.smallproject.www.techiteasy.services.WallBracketService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/api/v1/wallbracket")
public class WallBracketsController {
    private final WallBracketService wallBracketService;

    public WallBracketsController(WallBracketService wallBracketService) {
        this.wallBracketService = wallBracketService;
    }

    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    public ResponseEntity<WallBracketOutputDto> getWallBracketById(@PathVariable Long id) {
        WallBracketOutputDto wallBracketOutputDto = wallBracketService.getWallBracketById(id);
        return ResponseEntity.ok(wallBracketOutputDto);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Object> createWallBracket(@Valid @RequestBody WallBracketInputDto wallBracketInputDto) {
        WallBracket newWallBracket = wallBracketService.createWallBracket(wallBracketInputDto);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/" + newWallBracket.getId())
                .buildAndExpand(newWallBracket)
                .toUri();

        return ResponseEntity.created(location).build();
    }
}

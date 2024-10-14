package nl.smallproject.www.techiteasy.controllers;

import jakarta.validation.Valid;
import nl.smallproject.www.techiteasy.dtos.WallBracket.WallBracketInputDto;
import nl.smallproject.www.techiteasy.dtos.WallBracket.WallBracketOutputDto;
import nl.smallproject.www.techiteasy.dtos.WallBracket.WallBracketUpdateDto;
import nl.smallproject.www.techiteasy.models.WallBracket;
import nl.smallproject.www.techiteasy.services.WallBracketService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/v1/wallbracket")
public class WallBracketsController {
    private final WallBracketService wallBracketService;

    public WallBracketsController(WallBracketService wallBracketService) {
        this.wallBracketService = wallBracketService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<WallBracketOutputDto>> getAllWallBrackets() {
        List<WallBracketOutputDto> allWallBrackets = wallBracketService.getAllWallBrackets();
        return ResponseEntity.ok(allWallBrackets);
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

    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    public ResponseEntity<Object> updateWallBracket(@PathVariable Long id, @Valid @RequestBody WallBracketUpdateDto wallBracketUpdateDto) {
        wallBracketService.updateWallBracket(id, wallBracketUpdateDto);
        return ResponseEntity.noContent().build();
    }

    @RequestMapping(value = "{id}")
    public ResponseEntity<Object> deleteWallBracket(@PathVariable Long id) {
        wallBracketService.deleteWallBracket(id);
        return ResponseEntity.noContent().build();
    }
}

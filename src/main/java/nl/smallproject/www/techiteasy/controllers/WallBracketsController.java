package nl.smallproject.www.techiteasy.controllers;

import nl.smallproject.www.techiteasy.dtos.WallBracketOutputDto;
import nl.smallproject.www.techiteasy.services.WallBracketService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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
}

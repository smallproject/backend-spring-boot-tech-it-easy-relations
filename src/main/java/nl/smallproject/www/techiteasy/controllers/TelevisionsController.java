package nl.smallproject.www.techiteasy.controllers;

import jakarta.validation.Valid;
import nl.smallproject.www.techiteasy.dtos.RemoteController.RemoteControllerInputDto;
import nl.smallproject.www.techiteasy.dtos.Television.TelevisionInputDto;
import nl.smallproject.www.techiteasy.dtos.Television.TelevisionOutputDto;
import nl.smallproject.www.techiteasy.dtos.Television.TelevisionUpdateDto;
import nl.smallproject.www.techiteasy.services.TelevisionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/v1/television")
public class TelevisionsController {
    private final TelevisionService televisionService;

    public TelevisionsController(TelevisionService televisionService) {
        this.televisionService = televisionService;
    }

//    //moet zometeen verwijderen
//    @GetMapping
//    public ResponseEntity<Television> getTelevisionById(@PathVariable long id) {
//        Television television = televisionService.getTelevisionById(id);
//        return ResponseEntity.ok(television);
//    }
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<TelevisionOutputDto>> getAllTelevisions() {

        List<TelevisionOutputDto> televisionOutputDtos = televisionService.getAllTelevision();
        return ResponseEntity.ok(televisionOutputDtos);
    }

    @RequestMapping(value ="/{id}", method = RequestMethod.GET)
    public ResponseEntity<TelevisionOutputDto> getTelevisionById(@PathVariable Long id) {
        TelevisionOutputDto televisionOutputDto = televisionService.getTelevisionById(id);
        return ResponseEntity.ok(televisionOutputDto);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Object> createTelevision(@Valid @RequestBody TelevisionInputDto televisionInputDto) {
//        moet aanpassen
//        want die moet je van elke exception schrijven
//        dat is geen DRY principe


//        if (bindingResult.hasFieldErrors()) {
//            StringBuilder sb = new StringBuilder();
//            for (FieldError fe : bindingResult.getFieldErrors()) {
//                sb.append(fe.getField()).append(": ");
//                sb.append(fe.getDefaultMessage()).append("\n");
//            }
//            return new ResponseEntity<>(sb.toString(), HttpStatus.BAD_REQUEST);
//        }

        var newTelevision = televisionService.createTelevision(televisionInputDto);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/" + newTelevision.getId())
                .buildAndExpand(newTelevision)
                .toUri();

        return ResponseEntity.created(location).body("television");
    }

    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    public ResponseEntity<Object> updateTelevision(@PathVariable Long id , @Valid @RequestBody TelevisionUpdateDto televisionUpdateDto) {
        televisionService.updateTelevision(id,televisionUpdateDto);
        return ResponseEntity.noContent().build();
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> deleteTelevision(@PathVariable Long id) {
        televisionService.deleteTelevision(id);
        return ResponseEntity.noContent().build();
    }
}

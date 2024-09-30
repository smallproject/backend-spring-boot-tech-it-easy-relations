package nl.smallproject.www.techiteasy.controllers;

import jakarta.validation.Valid;
import nl.smallproject.www.techiteasy.dtos.RemoteControllerInputDto;
import nl.smallproject.www.techiteasy.dtos.RemoteControllerOutputDto;
import nl.smallproject.www.techiteasy.dtos.RemoteControllerUpdateDto;
import nl.smallproject.www.techiteasy.models.RemoteController;
import nl.smallproject.www.techiteasy.services.RemoteControllerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/api/v1/remotecontroller")
public class RemoteControllersController {
    private final RemoteControllerService remoteControllerService;

    public RemoteControllersController(RemoteControllerService remoteControllerService) {
        this.remoteControllerService = remoteControllerService;
    }

    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    public ResponseEntity<RemoteControllerOutputDto> getRemoteControllerById(@PathVariable Long id) {
        RemoteControllerOutputDto remoteControllerOutputDto = remoteControllerService.getRemoteControllerById(id);
        return ResponseEntity.ok(remoteControllerOutputDto);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Object> createRemoteController(@Valid @RequestBody RemoteControllerInputDto remoteControllerInputDto) {
        RemoteController newRemoteController = remoteControllerService.createRemoteController(remoteControllerInputDto);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/" + newRemoteController.getId())
                .buildAndExpand(newRemoteController)
                .toUri();

        return ResponseEntity.created(location).build();
    }

    @RequestMapping(value = "{id}",method = RequestMethod.PUT)
    public ResponseEntity<Object> updateRemoteController(@PathVariable Long id, @Valid @RequestBody RemoteControllerUpdateDto remoteControllerUpdateDto) {
        remoteControllerService.updateRemoteController(id, remoteControllerUpdateDto);
        return ResponseEntity.noContent().build();
    }
}

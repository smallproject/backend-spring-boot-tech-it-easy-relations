package nl.smallproject.www.techiteasy.controllers;

import nl.smallproject.www.techiteasy.dtos.RemoteControllerOutputDto;
import nl.smallproject.www.techiteasy.services.RemoteControllerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/remotecontroller")
public class RemoteControllersController {
    private final RemoteControllerService remoteControllerService;

    public RemoteControllersController(RemoteControllerService remoteControllerService) {
        this.remoteControllerService = remoteControllerService;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<RemoteControllerOutputDto> getRemoteControllerById(@PathVariable Long id) {
        RemoteControllerOutputDto remoteControllerOutputDto = remoteControllerService.getRemoteControllerById(id);
        return ResponseEntity.ok(remoteControllerOutputDto);
    }
}

package nl.smallproject.www.techiteasy.controllers;

import jakarta.validation.Valid;
import nl.smallproject.www.techiteasy.dtos.CiModuleInputDto;
import nl.smallproject.www.techiteasy.dtos.CiModuleOutputDto;
import nl.smallproject.www.techiteasy.dtos.CiModuleUpdateDto;
import nl.smallproject.www.techiteasy.services.CiModuleService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/v1/cimodule")
public class CiModulesController {
    private final CiModuleService ciModuleService;

    public CiModulesController(CiModuleService ciModuleService) {
        this.ciModuleService = ciModuleService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<CiModuleOutputDto>> getAllCiModules() {
        List<CiModuleOutputDto> ciModuleOutputDtos = ciModuleService.getAllCiModules();
        return ResponseEntity.ok(ciModuleOutputDtos);
    }

    @RequestMapping(value ="/{id}", method = RequestMethod.GET)
    public ResponseEntity<CiModuleOutputDto> getCiModuleById(@PathVariable Long id) {
        CiModuleOutputDto ciModuleOutputDto = ciModuleService.getCiModuleById(id);
        return ResponseEntity.ok(ciModuleOutputDto);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Object> createCiModule(@Valid @RequestBody CiModuleInputDto ciModuleInputDto) {
        var newCiModule = ciModuleService.createCiModule(ciModuleInputDto);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/" + newCiModule.getId())
                .buildAndExpand(newCiModule)
                .toUri();

        return ResponseEntity.created(location).build();
    }

    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    public ResponseEntity<Object> updateCiModule(@PathVariable Long id, @Valid @RequestBody CiModuleUpdateDto ciModuleUpdateDto) {
        ciModuleService.updateCiModule(id, ciModuleUpdateDto);
        return ResponseEntity.noContent().build();
    }
}

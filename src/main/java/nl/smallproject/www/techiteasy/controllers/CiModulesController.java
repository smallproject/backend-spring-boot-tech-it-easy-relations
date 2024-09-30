package nl.smallproject.www.techiteasy.controllers;

import nl.smallproject.www.techiteasy.dtos.CiModuleOutputDto;
import nl.smallproject.www.techiteasy.models.CiModule;
import nl.smallproject.www.techiteasy.services.CiModuleService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/cimodule")
public class CiModulesController {
    private final CiModuleService ciModuleService;

    public CiModulesController(CiModuleService ciModuleService) {
        this.ciModuleService = ciModuleService;
    }

    @RequestMapping(value ="/{id}", method = RequestMethod.GET)
    public ResponseEntity<CiModuleOutputDto> getCiModuleById(@PathVariable Long id) {
        CiModuleOutputDto ciModuleOutputDto = ciModuleService.getCiModuleById(id);
        return ResponseEntity.ok(ciModuleOutputDto);
    }
}

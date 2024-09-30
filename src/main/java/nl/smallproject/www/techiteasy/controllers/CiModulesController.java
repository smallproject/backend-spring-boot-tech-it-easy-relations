package nl.smallproject.www.techiteasy.controllers;

import nl.smallproject.www.techiteasy.dtos.CiModuleOutputDto;
import nl.smallproject.www.techiteasy.services.CiModuleService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
}

package nl.smallproject.www.techiteasy.controllers;

import jakarta.validation.Valid;
import nl.smallproject.www.techiteasy.dtos.Television.TelevisionSalesOutputDto;
import nl.smallproject.www.techiteasy.dtos.Television.TelevisionSalesUpdateDto;
import nl.smallproject.www.techiteasy.services.TelevisionSalesService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/sales/television")
public class TelevisionsSalesController {
    private final TelevisionSalesService televisionSalesService;

    public TelevisionsSalesController(TelevisionSalesService televisionSalesService) {
        this.televisionSalesService = televisionSalesService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<TelevisionSalesOutputDto>> getAllTelevisionSales() {
        List<TelevisionSalesOutputDto> televisionSalesOutputDtos = televisionSalesService.getAllTelevisionSales();
        return ResponseEntity.ok(televisionSalesOutputDtos);
    }

    @RequestMapping(value ="{id}", method = RequestMethod.GET)
    public ResponseEntity<TelevisionSalesOutputDto> getTelevisionById(@PathVariable Long id) {
        TelevisionSalesOutputDto televisionSalesOutputDto = televisionSalesService.getTelevisionById(id);
        return ResponseEntity.ok(televisionSalesOutputDto);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.PATCH)
    public ResponseEntity<Object> updateTelevisionSales(@PathVariable Long id,@Valid @RequestBody TelevisionSalesUpdateDto televisionSalesUpdateDto) {
        televisionSalesService.patchTelevisionSales(id, televisionSalesUpdateDto);
        return ResponseEntity.noContent().build();
    }
}

package com.mesttra.pecasapi.controller;

import com.mesttra.pecasapi.dto.CreatePartDTO;
import com.mesttra.pecasapi.dto.GetPartDTO;
import com.mesttra.pecasapi.dto.UpdatePartDTO;
import com.mesttra.pecasapi.entity.Part;
import com.mesttra.pecasapi.enums.Category;
import com.mesttra.pecasapi.exception.BusinessRuleException;
import com.mesttra.pecasapi.service.PartService;
import jakarta.validation.Valid;
import org.springframework.http.MediaType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/parts")
public class PartController {
    @Autowired
    PartService partService;

    @PostMapping(produces = { MediaType.APPLICATION_JSON_VALUE})
    public Part registerNewPart(@Valid @RequestBody CreatePartDTO part) {
        return partService.insertNewPart(part);
    }

    @GetMapping(path = "/{barCode}", produces = { MediaType.APPLICATION_JSON_VALUE })
    public Optional<GetPartDTO> getPartByBarCode(@PathVariable Long barCode) {
        return partService.getPart(barCode);
    }

    @GetMapping(produces = { MediaType.APPLICATION_JSON_VALUE })
    public List<GetPartDTO> getAllParts() {
        return partService.getParts();
    }

    @PutMapping(path = "/{barCode}", produces = { MediaType.APPLICATION_JSON_VALUE })
    public GetPartDTO updatePartByBarCode(@PathVariable Long barCode, @Valid @RequestBody UpdatePartDTO part) throws BusinessRuleException {
        return partService.updatePart(barCode, part);
    }

    @DeleteMapping(path = "/{barCode}", produces = { MediaType.APPLICATION_JSON_VALUE })
    public boolean removePartByBarCode(@PathVariable Long barCode) {
        return partService.deletePart(barCode);
    }


    @GetMapping(path = "/{startName}/start", produces = { MediaType.APPLICATION_JSON_VALUE })
    public List<GetPartDTO> getPartByStartText(@PathVariable String startName) {
        return partService.getPartByStartName(startName);
    }

    @GetMapping(path = "/{modelName}/model", produces = { MediaType.APPLICATION_JSON_VALUE })
    public List<GetPartDTO> getAllPartsByModel(@PathVariable String modelName) {
        return partService.getAllPartByModelName(modelName);
    }

    @GetMapping(path = "/{category}/category", produces = { MediaType.APPLICATION_JSON_VALUE })
    public List<GetPartDTO> getAllPartsByCategory(@PathVariable Category category) {
        return partService.getAllPartByCategory(category);
    }
}
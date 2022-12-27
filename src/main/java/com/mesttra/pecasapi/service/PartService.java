package com.mesttra.pecasapi.service;

import com.mesttra.pecasapi.dto.CreatePartDTO;
import com.mesttra.pecasapi.dto.GetPartDTO;
import com.mesttra.pecasapi.dto.UpdatePartDTO;
import com.mesttra.pecasapi.entity.Part;
import com.mesttra.pecasapi.enums.Category;
import com.mesttra.pecasapi.exception.BusinessRuleException;
import com.mesttra.pecasapi.repository.PartRepository;
import com.mesttra.pecasapi.specification.PartSpecification;
import com.mesttra.pecasapi.specification.SearchCriteria;
import jakarta.persistence.Enumerated;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PartService {
    @Autowired
    PartRepository partRepository;

    public Part insertNewPart(CreatePartDTO partDTO) {
        Part part = partDTO.toEntity();
        partRepository.save(part);
        return part;
    }

    public Optional<GetPartDTO> getPart(Long barCode) {
        Optional<Part> part = partRepository.findByBarCode(barCode);
        if (part.isEmpty()) {
            return Optional.empty();
        }
        Optional<GetPartDTO> partDTO = Optional.of(new GetPartDTO());
        BeanUtils.copyProperties(part.get(), partDTO.get());
        return partDTO;
    }

    public List<GetPartDTO> getParts() {
        List<Part> parts = partRepository.findAllByOrderByBarCodeAsc();
        List<GetPartDTO> partsDTO = new ArrayList<>();

        for (Part part : parts) {
            GetPartDTO partDTO = new GetPartDTO();
            BeanUtils.copyProperties(part, partDTO);
            partsDTO.add(partDTO);
        }
        return partsDTO;
    }

    public List<GetPartDTO> getPartByStartName(String startName) {
        PartSpecification spec = new PartSpecification(new SearchCriteria("name", ":", startName));

        List<Part> parts = partRepository.findAll(spec);

        List<GetPartDTO> partsDTO = new ArrayList<>();

        for (Part part : parts) {
            GetPartDTO partDTO = new GetPartDTO();
            BeanUtils.copyProperties(part, partDTO);
            partsDTO.add(partDTO);
        }

        return partsDTO;
    }

    public List<GetPartDTO> getAllPartByModelName(String modelName) {
        PartSpecification spec = new PartSpecification(new SearchCriteria("carModel", ":", modelName));

        List<Part> parts = partRepository.findAll(spec);

        List<GetPartDTO> partsDTO = new ArrayList<>();

        for (Part part : parts) {
            GetPartDTO partDTO = new GetPartDTO();
            BeanUtils.copyProperties(part, partDTO);
            partsDTO.add(partDTO);
        }

        return partsDTO;
    }

    public List<GetPartDTO> getAllPartByCategory(Category category) {
        PartSpecification spec = new PartSpecification(new SearchCriteria("category", ":", category));

        List<Part> parts = partRepository.findAll(spec);

        List<GetPartDTO> partsDTO = new ArrayList<>();

        for (Part part : parts) {
            GetPartDTO partDTO = new GetPartDTO();
            BeanUtils.copyProperties(part, partDTO);
            partsDTO.add(partDTO);
        }

        return partsDTO;
    }

    public GetPartDTO updatePart(Long barCode, UpdatePartDTO partDTO) throws BusinessRuleException {
        Optional<Part> searchedPart = partRepository.findByBarCode(barCode);
        if (searchedPart.isEmpty()) {
            throw new BusinessRuleException("O codigo de barras é inexistente");
        }
        searchedPart.get().setCostPrice(partDTO.getCostPrice());
        searchedPart.get().setSellPrice(partDTO.getSellPrice());
        searchedPart.get().setStockQuantity(partDTO.getStockQuantity());
        partRepository.save(searchedPart.get());

        GetPartDTO part = new GetPartDTO();
        BeanUtils.copyProperties(searchedPart.get(), part);
        return part;
    }

    public boolean deletePart(Long barCode) {
        if (!partRepository.existsById(barCode)) {
            return false;
        }

        partRepository.deleteById(barCode);
        return true;
    }
}
package com.mesttra.pecasapi.repository;

import com.mesttra.pecasapi.entity.Part;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;
import java.util.Optional;

public interface PartRepository extends JpaRepository<Part, Long>, JpaSpecificationExecutor<Part> {
    Optional<Part> findByBarCode(Long barCode);

    List<Part> findAllByOrderByBarCodeAsc();
}

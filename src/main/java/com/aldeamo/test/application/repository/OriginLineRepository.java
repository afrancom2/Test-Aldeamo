package com.aldeamo.test.application.repository;

import com.aldeamo.test.domain.entity.Message;
import com.aldeamo.test.domain.entity.OriginLine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OriginLineRepository extends JpaRepository<OriginLine, Long> {
    Optional<OriginLine> findAllBy();
}


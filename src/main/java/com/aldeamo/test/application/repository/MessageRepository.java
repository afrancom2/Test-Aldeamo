package com.aldeamo.test.application.repository;

import com.aldeamo.test.domain.entity.Message;
import com.aldeamo.test.domain.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MessageRepository extends JpaRepository<Message, Long> {
    Optional<Message> findByOrigin(Integer origin);
}


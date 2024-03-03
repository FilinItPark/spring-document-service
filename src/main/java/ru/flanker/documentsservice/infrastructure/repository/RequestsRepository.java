package ru.flanker.documentsservice.infrastructure.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.flanker.documentsservice.domain.entity.Requests;

public interface RequestsRepository extends JpaRepository<Requests, Long> {
}
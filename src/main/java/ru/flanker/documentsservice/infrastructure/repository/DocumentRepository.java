package ru.flanker.documentsservice.infrastructure.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.flanker.documentsservice.domain.entity.Document;

public interface DocumentRepository extends JpaRepository<Document, Long> {

}
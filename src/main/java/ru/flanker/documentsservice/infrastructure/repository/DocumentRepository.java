package ru.flanker.documentsservice.infrastructure.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.flanker.documentsservice.domain.entity.Document;

import java.util.List;

public interface DocumentRepository extends JpaRepository<Document, Long> {

    List<Document> findByCategory_Id(Long id);
}
package ru.flanker.documentsservice.application.document;

import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.flanker.documentsservice.application.category.CategoryService;
import ru.flanker.documentsservice.domain.entity.Document;
import ru.flanker.documentsservice.infrastructure.repository.CategoryRepository;
import ru.flanker.documentsservice.infrastructure.repository.DocumentRepository;

import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class DocumentService {
    private final CategoryService categoryService;
    private final DocumentRepository documentRepository;

    public List<Document> findAll() {
        log.debug("Пытаемся получить все документы");

        return documentRepository.findAll();
    }

    public Long create(Document document) {
        log.debug("Пытаемся сохранить документ с названием" + document.getName());

        var category = categoryService.findById(document.getCategory().getId());

        document.setCategory(category);

        return documentRepository.save(document).getId();
    }

    public Document findById(Long id) {
        return documentRepository.findById(id).orElseThrow(() -> {
            log.error("Документ с id={} не найден", id);
            return new EntityNotFoundException("Документ не найден");
        });
    }

    public List<Document> findByIds(List<Long> documentIds) {
        return documentRepository.findAllById(documentIds);
    }

    public List<Document> getDocumentsInCategory(Long categoryId) {
        log.debug("Пытаемся получить документы в категории с id={}", categoryId);

        return documentRepository.findByCategory_Id(categoryId);
    }
}

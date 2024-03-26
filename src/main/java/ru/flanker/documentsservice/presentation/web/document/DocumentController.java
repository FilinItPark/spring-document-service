package ru.flanker.documentsservice.presentation.web.document;


import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.flanker.documentsservice.application.document.DocumentService;
import ru.flanker.documentsservice.application.document.mappers.DocumentMapper;
import ru.flanker.documentsservice.domain.entity.Document;
import ru.flanker.documentsservice.presentation.web.category.dto.queries.GetDocumentsInCategoryResponse;
import ru.flanker.documentsservice.presentation.web.document.dto.commands.CreateDocumentCommand;
import ru.flanker.documentsservice.presentation.web.document.dto.queries.GetDocumentQuery;

import java.util.List;

import static ru.flanker.documentsservice.infrastructure.routes.DocumentsRoutes.BASE;
import static ru.flanker.documentsservice.infrastructure.routes.DocumentsRoutes.DOCUMENTS_IN_CATEGORY_BY_CATEGORY_ID;

@RestController
@AllArgsConstructor
@RequestMapping(BASE)
@CrossOrigin(origins = "*")
public class DocumentController {
    private final DocumentMapper mapper;
    private final DocumentService service;


    @GetMapping
    public List<GetDocumentQuery> findAll() {
        final var documents = service.findAll();
        return mapper.toListQuery(documents);
    }

    @GetMapping(DOCUMENTS_IN_CATEGORY_BY_CATEGORY_ID)
    public GetDocumentsInCategoryResponse getDocuments(@PathVariable Long categoryId) {
        final List<Document> documents = service.getDocumentsInCategory(categoryId);

        return new GetDocumentsInCategoryResponse(
                categoryId,
                mapper.toListQuery(documents)
        );
    }

    /**
     * @param command - запрос на создание нового документа
     * @return ID созданной записи
     */
    @PostMapping
    public Long create(@RequestBody CreateDocumentCommand command) {
        final var document = mapper.toEntity(command);

        return service.create(document);
    }

    @GetMapping("/{id}")
    public GetDocumentQuery findById(@PathVariable Long id) {
        return mapper.toQuery(service.findById(id));
    }

}
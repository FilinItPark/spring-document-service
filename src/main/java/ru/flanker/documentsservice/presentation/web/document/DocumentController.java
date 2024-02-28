package ru.flanker.documentsservice.presentation.web.document;


import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.flanker.documentsservice.application.document.DocumentService;
import ru.flanker.documentsservice.application.document.mappers.DocumentMapper;
import ru.flanker.documentsservice.domain.entity.Document;
import ru.flanker.documentsservice.presentation.web.document.dto.commands.CreateDocumentCommand;
import ru.flanker.documentsservice.presentation.web.document.dto.queries.DocumentQuery;

import javax.print.Doc;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/document")
public class DocumentController {
    private final DocumentMapper mapper;
    private final DocumentService service;


    @GetMapping
    public List<DocumentQuery> findAll() {
        final var documents = service.findAll();
        return mapper.toListQuery(documents);
    }

    /**
     *
     * @param command - запрос на создание нового документа
     * @return ID созданной записи
     */
    @PostMapping
    public Long create(@RequestBody CreateDocumentCommand command) {
        final var document = mapper.toEntity(command);

        return service.create(document);
    }

    @GetMapping("/{id}")
    public DocumentQuery findById(@PathVariable Long id) {
        return mapper.toQuery(service.findById(id));
    }

}
package ru.flanker.documentsservice.application.document.mappers;

import org.mapstruct.Mapper;
import ru.flanker.documentsservice.domain.entity.Document;
import ru.flanker.documentsservice.presentation.web.document.dto.commands.CreateDocumentCommand;
import ru.flanker.documentsservice.presentation.web.document.dto.commands.UpdateDocumentCommand;
import ru.flanker.documentsservice.presentation.web.document.dto.queries.DocumentQuery;

import javax.print.Doc;
import java.util.List;

@Mapper(componentModel = "spring")
public interface DocumentMapper {
    DocumentQuery toQuery(Document document);
    Document toEntity(CreateDocumentCommand command);
    Document toEntity(UpdateDocumentCommand command);

    List<DocumentQuery> toListQuery(List<Document> documentList);
}

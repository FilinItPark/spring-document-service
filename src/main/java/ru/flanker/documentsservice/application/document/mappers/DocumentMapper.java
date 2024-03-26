package ru.flanker.documentsservice.application.document.mappers;

import org.mapstruct.Mapper;
import ru.flanker.documentsservice.domain.entity.Document;
import ru.flanker.documentsservice.presentation.web.document.dto.commands.CreateDocumentCommand;
import ru.flanker.documentsservice.presentation.web.document.dto.commands.UpdateDocumentCommand;
import ru.flanker.documentsservice.presentation.web.document.dto.queries.GetDocumentQuery;

import java.util.List;

@Mapper(componentModel = "spring")
public interface DocumentMapper {
    GetDocumentQuery toQuery(Document document);
    Document toEntity(CreateDocumentCommand command);
    Document toEntity(UpdateDocumentCommand command);

    List<GetDocumentQuery> toListQuery(List<Document> documentList);
}

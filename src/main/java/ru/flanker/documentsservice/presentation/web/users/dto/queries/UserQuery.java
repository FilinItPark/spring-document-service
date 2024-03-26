package ru.flanker.documentsservice.presentation.web.users.dto.queries;

import lombok.Data;
import ru.flanker.documentsservice.domain.valueobject.TimeInfo;
import ru.flanker.documentsservice.presentation.web.document.dto.queries.GetDocumentQuery;

import java.util.List;

@Data
public class UserQuery {
    Long id;
    String name;
    String email;
    TimeInfo timeInfo;
    List<GetDocumentQuery> documents;
}

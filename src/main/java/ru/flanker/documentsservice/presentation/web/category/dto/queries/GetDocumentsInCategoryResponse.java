package ru.flanker.documentsservice.presentation.web.category.dto.queries;

import ru.flanker.documentsservice.presentation.web.document.dto.queries.GetDocumentQuery;

import java.util.List;

public record GetDocumentsInCategoryResponse(
        Long categoryId,
        List<GetDocumentQuery> documents
) {
}

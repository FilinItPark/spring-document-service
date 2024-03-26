package ru.flanker.documentsservice.presentation.web.document.dto.queries;

import ru.flanker.documentsservice.presentation.web.category.dto.queries.GetCategoryResponse;

public record GetDocumentQuery(
    Long id,
    String name,
    String description,
    GetCategoryResponse category
) {

}

package ru.flanker.documentsservice.presentation.web.document.dto.queries;

import ru.flanker.documentsservice.presentation.web.category.dto.queries.CategoryQuery;

public record DocumentQuery(
    Long id,
    String name,
    String description,
    CategoryQuery category
) {

}

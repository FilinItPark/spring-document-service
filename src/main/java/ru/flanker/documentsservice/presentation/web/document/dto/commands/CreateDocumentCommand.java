package ru.flanker.documentsservice.presentation.web.document.dto.commands;

import lombok.Data;
import ru.flanker.documentsservice.presentation.web.category.dto.queries.CategoryQuery;
import ru.flanker.documentsservice.presentation.web.category.dto.queries.GetCategoryByIdQuery;

@Data
public class CreateDocumentCommand {
    private String name;
    private String description;
    private GetCategoryByIdQuery category;
}

package ru.flanker.documentsservice.presentation.web.document.dto.commands;

import lombok.Data;
import ru.flanker.documentsservice.presentation.web.category.dto.queries.GetCategoryByIdQuery;

@Data
public class UpdateDocumentCommand {
    private Integer id;
    private String name;
    private String description;
    private GetCategoryByIdQuery category;
}

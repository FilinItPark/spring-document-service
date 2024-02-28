package ru.flanker.documentsservice.presentation.web.category.dto.commands;

import org.hibernate.validator.constraints.Length;

public record UpdateCategoryCommand(
        @Length(min = 3, max = 150, message = "Название категории должно быть не менее 3 сиимволов и не более 150")
        String name
) {
}

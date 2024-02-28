package ru.flanker.documentsservice.application.category.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.flanker.documentsservice.domain.entity.Category;
import ru.flanker.documentsservice.presentation.web.category.dto.commands.CreateCategoryCommand;
import ru.flanker.documentsservice.presentation.web.category.dto.commands.UpdateCategoryCommand;
import ru.flanker.documentsservice.presentation.web.category.dto.queries.CategoryQuery;

import java.util.List;

@Mapper(componentModel = "spring",
        suppressTimestampInGenerated = true,
        unmappedTargetPolicy = org.mapstruct.ReportingPolicy.IGNORE)
public interface CategoryMapper {

    List<CategoryQuery> fromCategoriesToQueries(List<Category> categories);

    CategoryQuery fromCategoryToQuery(Category category);

    Category fromCommandToCategory(CreateCategoryCommand command);

    Category fromCommandToCategory(UpdateCategoryCommand command);
}

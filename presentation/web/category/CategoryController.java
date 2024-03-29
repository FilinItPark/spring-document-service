package ru.flanker.documentsservice.presentation.web.category;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.flanker.documentsservice.application.category.CategoryService;
import ru.flanker.documentsservice.application.mappers.CategoryMapper;
import ru.flanker.documentsservice.presentation.web.category.dto.commands.CreateCategoryCommand;
import ru.flanker.documentsservice.presentation.web.category.dto.queries.CategoryQuery;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/category")
@Validated
public class CategoryController {
    private final CategoryMapper mapper;
    private final CategoryService service;

    @GetMapping
    public List<CategoryQuery> findAll() {
        final var categories = service.findAll();

        return mapper.fromCategoriesToQueries(categories);
    }

    @PostMapping
    public CategoryQuery create(@RequestBody @Valid CreateCategoryCommand command) {
        final var category = mapper.fromCommandToCategory(command);

        final var created = service.createCategory(category);

        return mapper.fromCategoryToQuery(created);
    }

}
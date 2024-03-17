package ru.flanker.documentsservice.presentation.web.category;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.flanker.documentsservice.application.category.CategoryService;
import ru.flanker.documentsservice.application.category.mappers.CategoryMapper;
import ru.flanker.documentsservice.presentation.web.category.dto.commands.CreateCategoryCommand;
import ru.flanker.documentsservice.presentation.web.category.dto.queries.CategoryQuery;
import static ru.flanker.documentsservice.infrastructure.routes.CategoryRoutes.*;
import java.util.List;

/*
1) migrations (liquibase)
2) test (unit + testcontainers-integration tests)
3) swagger
4) Pagination
5) auth/signup
6) jwt + spring security
*/

@RestController
@RequiredArgsConstructor
@RequestMapping(BASE)
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

    @GetMapping(FIND_BY_ID)
    public CategoryQuery findById(@PathVariable Long id) {
        final var category = service.findById(id);

        return mapper.fromCategoryToQuery(category);
    }
}
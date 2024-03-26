package ru.flanker.documentsservice.presentation.web.category;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.flanker.documentsservice.application.category.CategoryService;
import ru.flanker.documentsservice.application.category.mappers.CategoryMapper;
import ru.flanker.documentsservice.presentation.web.category.dto.commands.CreateCategoryCommand;
import ru.flanker.documentsservice.presentation.web.category.dto.queries.GetCategoryResponse;
import ru.flanker.documentsservice.presentation.web.category.dto.queries.GetDocumentsInCategoryResponse;

import java.util.List;

import static ru.flanker.documentsservice.infrastructure.routes.CategoryRoutes.*;

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
@CrossOrigin(origins = "*", allowedHeaders = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.OPTIONS, RequestMethod.HEAD})
@RequestMapping(BASE)
@Validated
public class CategoryController {
    private final CategoryMapper mapper;
    private final CategoryService service;

    @GetMapping
    public List<GetCategoryResponse> findAll() {
        final var categories = service.findAll();

        return mapper.fromCategoriesToQueries(categories);
    }

    @PostMapping
    public GetCategoryResponse create(@RequestBody @Valid CreateCategoryCommand command) {
        final var category = mapper.fromCommandToCategory(command);

        final var created = service.createCategory(category);

        return mapper.fromCategoryToQuery(created);
    }

    @GetMapping(FIND_BY_ID)
    public GetCategoryResponse findById(@PathVariable Long id) {
        final var category = service.findById(id);

        return mapper.fromCategoryToQuery(category);
    }


}
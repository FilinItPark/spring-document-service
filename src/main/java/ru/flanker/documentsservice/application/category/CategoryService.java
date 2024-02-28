package ru.flanker.documentsservice.application.category;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.flanker.documentsservice.domain.entity.Category;
import ru.flanker.documentsservice.domain.exception.CategoryAlreadyExistsException;
import ru.flanker.documentsservice.infrastructure.repository.CategoryRepository;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class CategoryService {
    private final CategoryRepository categoryRepository;

    public List<Category> findAll() {
        log.info("CategoryService.Category | Find all categories");
        return categoryRepository.findAll();
    }

    public Category createCategory(Category category) {
        var isExists = categoryRepository.existsByName(category.getName());

        if (isExists) {
            throw new CategoryAlreadyExistsException("категория с таким названием уже существует");
        }

        log.info("CategoryService.Category | save category with title = {}", category.getName());
        return categoryRepository.save(category);
    }

    public Category findById(Long id) {
        return categoryRepository.findById(id)
                .orElseThrow(() -> {
                    log.error("Категория с id={} не найдена", id);
                    return new EntityNotFoundException("Категория не найдена");
                });
    }
}

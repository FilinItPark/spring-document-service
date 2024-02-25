package ru.flanker.documentsservice.infrastructure.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.flanker.documentsservice.domain.entity.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    boolean existsByName(String name);
}
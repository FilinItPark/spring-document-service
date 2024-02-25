package ru.flanker.documentsservice.infrastructure.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.flanker.documentsservice.domain.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
}
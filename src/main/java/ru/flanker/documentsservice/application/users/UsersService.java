package ru.flanker.documentsservice.application.users;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.flanker.documentsservice.application.document.DocumentService;
import ru.flanker.documentsservice.domain.entity.Document;
import ru.flanker.documentsservice.domain.entity.User;
import ru.flanker.documentsservice.infrastructure.repository.UserRepository;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class UsersService {
    private final UserRepository userRepository;
    private final DocumentService documentService;

    public List<User> getUsers() {
        return userRepository.findAll();
    }

    public Long create(User user) {
        return userRepository.save(user).getId();
    }

    public User findById(Long id) {
        return userRepository.findById(id).orElseThrow(() -> {
            log.error("Пользователь с id={} не найден", id);
            return new EntityNotFoundException("Пользователь не найден");
        });

    }


    public User attachDocuments(Long userId, List<Long> documentIds) {
        User user = findById(userId);

        attachDocuments(user, documentIds);

        return userRepository.save(user);
    }

    private void attachDocuments(User user, List<Long> documentIds) {
        List<Document> documents = documentService.findByIds(documentIds);

        final List<Document> currentDocs = user.getDocuments();

        for (var newDoc : documents) {
            if (!currentDocs.contains(newDoc)) {
                currentDocs.add(newDoc);
            }
        }

        user.setDocuments(currentDocs);

    }

}

package ru.flanker.documentsservice.application.requests;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.flanker.documentsservice.domain.entity.Requests;
import ru.flanker.documentsservice.infrastructure.repository.RequestsRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RequestsService {
    private final RequestsRepository repository;

    public List<Requests> findAll() {
        return repository.findAll();
    }

    public Requests create(Requests requests) {
        return repository.save(requests);
    }

    public void delete(Requests requests) {
        repository.delete(requests);
    }

    public Requests findById(Long id) {
        return repository.findById(id).orElseThrow(EntityNotFoundException::new);
    }
}

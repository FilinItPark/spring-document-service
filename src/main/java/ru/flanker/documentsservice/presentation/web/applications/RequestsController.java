package ru.flanker.documentsservice.presentation.web.applications;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.flanker.documentsservice.application.requests.RequestsService;
import ru.flanker.documentsservice.application.requests.mappers.RequestsMapper;
import ru.flanker.documentsservice.domain.entity.Requests;
import ru.flanker.documentsservice.infrastructure.routes.RequestsRoutes;
import ru.flanker.documentsservice.presentation.web.applications.dto.queries.RequestsQuery;
import ru.flanker.documentsservice.presentation.web.applications.dto.queries.commands.CreateRequestCommand;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping(RequestsRoutes.BASE)
public class RequestsController {
    private final RequestsService service;
    private final RequestsMapper mapper;

    @GetMapping
    public List<RequestsQuery> findAll() {
        final var requests = service.findAll();

        return mapper.toListQuery(requests);
    }

    @GetMapping(value = RequestsRoutes.FIND_BY_ID)
    public RequestsQuery findById(Long id) {
        return mapper.fromEntityToQuery(service.findById(id));
    }

    @PostMapping
    public Long create(@RequestBody CreateRequestCommand command) {
        Requests requests = mapper.fromCommandToEntity(command);

        return service.create(requests).getId();
    }
}

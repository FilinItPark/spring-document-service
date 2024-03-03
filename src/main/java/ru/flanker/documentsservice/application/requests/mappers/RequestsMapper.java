package ru.flanker.documentsservice.application.requests.mappers;

import org.mapstruct.Mapper;
import ru.flanker.documentsservice.domain.entity.Requests;
import ru.flanker.documentsservice.presentation.web.applications.dto.queries.RequestsQuery;
import ru.flanker.documentsservice.presentation.web.applications.dto.queries.commands.CreateRequestCommand;

import java.util.List;

@Mapper(componentModel = "spring")
public interface RequestsMapper {
    List<RequestsQuery> toListQuery(List<Requests> requests);

    Requests fromCommandToEntity(CreateRequestCommand requests);

    RequestsQuery fromEntityToQuery(Requests requests);

    Requests fromQueryToEntity(RequestsQuery requestsQuery);

    List<Requests> fromListQueryToEntity(List<RequestsQuery> requestsQuery);
}

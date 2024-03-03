package ru.flanker.documentsservice.presentation.web.applications.dto.queries;

import ru.flanker.documentsservice.domain.valueobject.TimeInfo;

public record RequestsQuery(
        Long id,
        String name,
        String description,
        TimeInfo timeInfo
) {
}

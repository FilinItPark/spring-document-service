package ru.flanker.documentsservice.domain.exception;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum ApiErrorType {

    @JsonProperty("validation")
    VALIDATION,
    @JsonProperty("business")
    BUSINESS,
    @JsonProperty("system")
    SYSTEM;

    private ApiErrorType() {
    }


}

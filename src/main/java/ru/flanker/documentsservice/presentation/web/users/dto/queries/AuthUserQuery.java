package ru.flanker.documentsservice.presentation.web.users.dto.queries;

import lombok.Data;

@Data
public class AuthUserQuery {

    private String email;
    private String password;

}

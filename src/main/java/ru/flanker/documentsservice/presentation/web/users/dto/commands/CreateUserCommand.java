package ru.flanker.documentsservice.presentation.web.users.dto.commands;

import lombok.Data;

@Data
public class CreateUserCommand {

    private String name;
    private String email;
    private String password;

}

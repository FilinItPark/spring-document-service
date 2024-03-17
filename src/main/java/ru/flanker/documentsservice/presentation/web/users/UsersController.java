package ru.flanker.documentsservice.presentation.web.users;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.flanker.documentsservice.application.users.mappers.UserMapper;
import ru.flanker.documentsservice.application.users.UsersService;
import ru.flanker.documentsservice.domain.entity.User;
import ru.flanker.documentsservice.presentation.web.document.dto.commands.AttachDocumentsUserCommand;
import ru.flanker.documentsservice.presentation.web.document.dto.queries.DocumentQuery;
import ru.flanker.documentsservice.presentation.web.users.dto.commands.CreateUserCommand;
import ru.flanker.documentsservice.presentation.web.users.dto.queries.AuthUserQuery;
import ru.flanker.documentsservice.presentation.web.users.dto.queries.UserQuery;

import java.util.List;

@RestController
@AllArgsConstructor
@CrossOrigin(origins = "*")
@RequestMapping("api/users")
public class UsersController {
    private final UsersService usersService;
    private final UserMapper mapper;

    @GetMapping
    public List<UserQuery> getUsers() {
        final var users = usersService.getUsers();

        return mapper.fromUsersToQueries(users);
    }

    @PostMapping("/auth")
    public UserQuery auth(@RequestBody AuthUserQuery query) {
        final var user = usersService.auth(query.getEmail(), query.getPassword());

        return mapper.fromUserToQuery(user);
    }


    /**
     * @param command - запрос на создание нового пользователя
     * @return ID созданной записи
     */
    @PostMapping
    public Long create(@RequestBody CreateUserCommand command) {
        final var user = mapper.fromCommandToUser(command);

        return usersService.create(user);
    }

    @PutMapping
    public UserQuery attachDocuments(@RequestBody AttachDocumentsUserCommand command) {
        final var updatedUser = usersService.attachDocuments(command.getUserId(), command.getDocumentIds());

        return mapper.fromUserToQuery(updatedUser);
    }
}

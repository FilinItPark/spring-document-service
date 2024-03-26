package ru.flanker.documentsservice.presentation.web.users;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.flanker.documentsservice.application.users.mappers.UserMapper;
import ru.flanker.documentsservice.application.users.UsersService;
import ru.flanker.documentsservice.presentation.web.document.dto.commands.AttachDocumentsUserCommand;
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
    @Operation(summary = "Авторизация пользователя",
            description = "Принимает почта и пароля пользователя и возвращает объект",
            tags = {"Auth&Signup"},
            responses = {
                    @ApiResponse(
                            description = "OK",
                            responseCode = "200",
                            content = @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = UserQuery.class)
                            )
                    ),
                    @ApiResponse(description = "Неверные данные", responseCode = "400", content = @Content(mediaType = "application/json"))
            })
    public UserQuery auth(@RequestBody AuthUserQuery query) {
        final var user = usersService.auth(query.getEmail(), query.getPassword());

        return mapper.fromUserToQuery(user);
    }


    /**
     * @param command - запрос на создание нового пользователя
     * @return ID созданной записи
     */
    @PostMapping
    @Operation(summary = "Регистрация пользователя",
            description = "Принимает информацию о пользователе и возвращает информацию о нем",
            tags = {"Auth&Signup"},
            responses = {
                    @ApiResponse(description = "OK", responseCode = "200", content = @Content(mediaType = "application/json")),
                    @ApiResponse(description = "User Already Exists", responseCode = "400", content = @Content(mediaType = "application/json"))
            })
    public UserQuery create(@RequestBody CreateUserCommand command) {
        final var user = mapper.fromCommandToUser(command);

        return mapper.fromUserToQuery(usersService.create(user));
    }

    @PutMapping
    public UserQuery attachDocuments(@RequestBody AttachDocumentsUserCommand command) {
        final var updatedUser = usersService.attachDocuments(command.getUserId(), command.getDocumentIds());

        return mapper.fromUserToQuery(updatedUser);
    }
}

package ru.flanker.documentsservice.presentation.web.users;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.flanker.documentsservice.application.mappers.UserMapper;
import ru.flanker.documentsservice.application.users.UsersService;
import ru.flanker.documentsservice.presentation.web.users.dto.queries.UserQuery;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/users")
public class UsersController {
    private final UsersService usersService;
    private final UserMapper mapper;

    @GetMapping
    public List<UserQuery> getUsers() {
        final var users = usersService.getUsers();

        return mapper.fromUsersToQueries(users);
    }
}

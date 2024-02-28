package ru.flanker.documentsservice.application.users.mappers;

import org.mapstruct.Mapper;
import ru.flanker.documentsservice.domain.entity.User;
import ru.flanker.documentsservice.presentation.web.users.dto.commands.CreateUserCommand;
import ru.flanker.documentsservice.presentation.web.users.dto.commands.UpdateUserCommand;
import ru.flanker.documentsservice.presentation.web.users.dto.queries.UserQuery;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserQuery fromUserToQuery(User user);

    User fromCommandToUser(CreateUserCommand command);
    User fromCommandToUser(UpdateUserCommand command);

    List<UserQuery> fromUsersToQueries(List<User> users);
}

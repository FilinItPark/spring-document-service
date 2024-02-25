package ru.flanker.documentsservice.application.users;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.flanker.documentsservice.domain.entity.User;
import ru.flanker.documentsservice.infrastructure.repository.UserRepository;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class UsersService {
    private final UserRepository userRepository;

    public List<User> getUsers() {
        return userRepository.findAll();
    }
}

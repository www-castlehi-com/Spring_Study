package io.security.springsecuritymaster.users.service;

import io.security.springsecuritymaster.domain.entity.Account;
import io.security.springsecuritymaster.users.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    @Transactional
    public void createUser(Account account) {
        userRepository.save(account);
    }

}

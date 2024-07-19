package org.pktstore.cambodia;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public void createUser(UserCreateRequest request) {

        User userfound = userRepository.findByUsername(request.username());

        if (userfound != null) {
            log.error("User already exists: {}", request);
            throw new ResponseStatusException(HttpStatus.CONFLICT,"User already exists");
        }

        log.info("Creating user: {}", request);

        User user = new User();
        user.setName(request.name());
        user.setUsername(request.username());

        userRepository.save(user);

        log.info("User created: {}", user);
    }

    @Override
    public List<User> getAllUser() {
        return userRepository.findAll();
    }

    @Override
    public String getTotalUserJoinGiveaway() {
        List<User> users = userRepository.findAll();

        return "Total User Join Giveaway : " + users.size();
    }

    @Override
    public List<User> getUsersByUsernamePrefix(String prefix) {
        return userRepository.findByUsernameStartingWith(prefix);
    }
}

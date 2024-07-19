package org.pktstore.cambodia;


import jakarta.validation.Valid;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    @PostMapping("/create")
    public void createUser(@Valid @RequestBody UserCreateRequest request) {
        userService.createUser(request);
    }

    @GetMapping("/all")
    public List<User> getAllUser() {
        return userService.getAllUser();
    }

    @GetMapping("/total")
    public String getTotalUserJoinGiveaway() {
        return userService.getTotalUserJoinGiveaway();
    }

    @GetMapping("/prefix")
    public List<User> getUsersByUsername(@RequestParam String prefix) {
        return userService.getUsersByUsernamePrefix(prefix);
    }
}

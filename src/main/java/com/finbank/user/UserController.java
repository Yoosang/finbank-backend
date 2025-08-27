package com.finbank.user;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    @RequestMapping("/register")
    public User register(@RequestParam String username, @RequestParam String password) {
        return userService.register(username, password);
    }

}

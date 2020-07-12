package com.example.Library.user;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(path = "/{id}")
    public void getUser(@PathVariable("id") String keycloakUserId) {
        userService.getUserEmail(keycloakUserId);
    }

    @PostMapping
    public void createUser(@RequestBody User user) {
        System.out.println("posting user");
        userService.createUser(user);
    }

    @PutMapping(path = "/{id}")
    public void updateUser(@PathVariable("id") String keycloakUserId, @RequestBody User user) {
        userService.updateUser(keycloakUserId, user);
    }

    @PostMapping(path = "/reset-password/{id}")
    public ResponseEntity<?> resetPassword(@PathVariable("id") String keycloakUserId, @RequestBody Map<String, Object> payload) {
        userService.resetPassword(keycloakUserId, payload);
        return ResponseEntity.ok("OK");
    }

    @DeleteMapping(path = "/{id}")
    public void deleteUser(@PathVariable("id") String keycloakUserId) {
        userService.deleteUser(keycloakUserId);
    }
}

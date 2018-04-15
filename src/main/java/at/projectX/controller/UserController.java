package at.projectX.controller;

import at.projectX.domain.User;
import at.projectX.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/users")
    @PreAuthorize("hasAuthority('ADMIN_USER')")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @RequestMapping("/users/{id}")
    public User getUser(@PathVariable Long id) {
        return userService.getUser(id);
    }

    @RequestMapping(method = RequestMethod.POST, value="/users")
    public void addUser(@RequestBody User user) {
        userService.addUser(user);
    }

    @RequestMapping(method = RequestMethod.PUT, value="/users/{id}")
    public void updateUser(@RequestBody User user, @PathVariable String id) {
        userService.updateUser(user);
    }

    @RequestMapping(method = RequestMethod.DELETE, value="/users/{id}")
    public void deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
    }
}

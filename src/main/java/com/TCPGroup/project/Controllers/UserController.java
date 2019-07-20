package com.TCPGroup.project.Controllers;

import com.TCPGroup.project.Models.Channel;
import com.TCPGroup.project.Models.User;
import com.TCPGroup.project.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class UserController {

    @Autowired
    UserService userService;

    public UserController(UserService userService) {
        this.userService=userService;
    }

    @GetMapping("/users")
    public List<User> getAllUsers(){
        return this.userService.getAllUsers();
    }

    @GetMapping("/users/{id}")
    public User getUserById(@PathVariable Integer id){
        return this.userService.getById(id);
    }

    @GetMapping("/users/auth/{username}/{password}")
    public User authenticateUser(@PathVariable String password, @PathVariable String username) {
        return this.userService.authenticateUser(username, password);
    }

    @GetMapping("/users/{id}/channels")
    public List<Channel> getChannelsByUserId(@PathVariable Integer id){
        return this.userService.getChannelsByUserId(id);
    }

    @PostMapping("/users")
    public User createNewUser(@RequestBody User newUser){
        return this.userService.createUser(newUser);
    }

}

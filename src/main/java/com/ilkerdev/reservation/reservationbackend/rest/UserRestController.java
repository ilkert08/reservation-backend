package com.ilkerdev.reservation.reservationbackend.rest;

import com.ilkerdev.reservation.reservationbackend.service.UserServiceImpl;
import com.ilkerdev.reservation.reservationbackend.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping("/api")
public class UserRestController {
    private UserServiceImpl userService;

    @Autowired
    public UserRestController(UserServiceImpl userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public List<User> findAll(){
        return userService.findAll();
    }

    @PostMapping("/users")
    public User addUser(@RequestBody User user){
        // user.setId("");
        userService.save(user, 0);
        return user;
    }

    @PutMapping("/users")
    public User updateUser(@RequestBody User user){
        userService.save(user , 1); // 0 = add , else = update
        return user;
    }

    @DeleteMapping("/users/{userId}")
    public String deleteUser(@PathVariable String userId){
        User user = userService.findById(userId);
        if(user == null){
            throw new RuntimeException("User not found.");
        }
        userService.deleteById(userId);
        return "User " + userId + " is deleted.";
    }

    @GetMapping("/users/{userId}")
    public User findById(@PathVariable String userId){
        User user = userService.findById(userId);
        if (user == null){
            throw new RuntimeException("User not found");
        }
        return  user;

    }
}

package com.cergy.javaav.controllers;

import com.cergy.javaav.Services.UserDao;
import com.cergy.javaav.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/users")
public class ApiUsersController {
    @Autowired
    private UserDao userDAO;

    /**
     * Get all users list.
     *
     * @return the list
     */
    @GetMapping("")
    public List<User> getAllUsers() {
        return userDAO.listAll();
    }

    /**
     * Gets users by id.
     *
     * @param userId the user id
     * @return the users by id
     * @throws org.springframework.data.rest.webmvc.ResourceNotFoundException the resource not found exception
     */
    @GetMapping("/{id}")
    public ResponseEntity<User> getUsersById(@PathVariable(value = "id") int userId)
            throws ResourceNotFoundException {
        User user = userDAO.findById(userId);
        if(user == null) {
            throw  new ResourceNotFoundException("User not found on :: " + userId);
        }
        return ResponseEntity.ok().body(user);
    }

    /**
     * Create user user.
     *
     * @param user the user
     * @return the user
     */
    @PostMapping("")
    public ResponseEntity.BodyBuilder createUser(@RequestBody User user) {
        int res = userDAO.add(user);
        if(res == 1) {
            return ResponseEntity.created(URI.create("/api/users"));
        }else{
            return ResponseEntity.badRequest();
        }
    }

}

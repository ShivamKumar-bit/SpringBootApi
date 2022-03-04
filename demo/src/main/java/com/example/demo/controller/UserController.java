package com.example.demo.controller;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.User;
import com.example.demo.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	UserService userService;
	
	@GetMapping("")
	public List<User> list() {
        return userService.listAllUser();
    }
	
	@GetMapping("/{id}")
    public ResponseEntity<User> get(@PathVariable Integer id) {
        try {
            User user = userService.getUser(id);
            return new ResponseEntity<User>(user, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
        }
    }
	
	@PostMapping("/")
    public ResponseEntity<?> add(@RequestBody User user) {
        try
        {
        	userService.saveUser(user);
        	 return new ResponseEntity<>(HttpStatus.OK);
        
        }
        catch(Exception e)
        {
        	System.out.println("Enter a unique user name");
        	return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
        
	
	@PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody User user, @PathVariable Integer id) {
        try {
            User existUser = userService.getUser(id);
            user.setId(id);    
            try {
            userService.saveUser(user);
            return new ResponseEntity<>(HttpStatus.OK);
            }
            catch(Exception e)
            {
            	System.out.println("Enter a unique user name");
        	    return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        	
            }
        }
        catch (NoSuchElementException e)
        {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
	}  
        
        @DeleteMapping("/{id}")
        public void delete(@PathVariable Integer id) {

            userService.deleteUser(id);
        }

}

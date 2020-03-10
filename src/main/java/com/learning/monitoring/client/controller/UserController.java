package com.learning.monitoring.client.controller;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.apache.tomcat.util.json.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learning.monitoring.client.modal.User;
import com.learning.monitoring.client.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {
	 
	@Autowired UserService userService;

	@PostMapping(value = "/save", consumes = "application/json", produces = "application/json")
    public ResponseEntity<User> save(@RequestBody User user) {
        user = userService.save(user);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @GetMapping(value = "/list")
    public ResponseEntity<List<User>> findAll() {
        List<User> users = userService.findAll();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }
    
    @GetMapping(value = "/user/{id}")
    public ResponseEntity<Optional<User>> findUserById(@PathVariable Long id) {
    	Optional<User> user = userService.findById(id); 
    	if(user.isPresent())
    		return new ResponseEntity<Optional<User>>(user, HttpStatus.OK);
    	else 
    		return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id) {
        userService.delete(id);
    }
    
    @GetMapping("/exception/parse")
    public void generateParseException() throws ParseException {
        throw new ParseException("We can see this generated exception in 'http.server.requests' using '/metrics' endpoint");
    }
    
    @GetMapping("/exception/io")
    public void generateIOException() throws IOException {
        throw new IOException("We can see this generated exception in 'http.server.requests' using '/metrics' endpoint");
    }

}

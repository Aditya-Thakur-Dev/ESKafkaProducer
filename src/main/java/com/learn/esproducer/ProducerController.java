package com.learn.esproducer;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProducerController {

    private final ProducerService service;

    public ProducerController(ProducerService service) {
        this.service = service;
    }

    @RequestMapping(value = "/user", method = RequestMethod.POST)
    public ResponseEntity<String> postUser(@RequestBody User user){
    service.singleUser(user);
    return ResponseEntity.ok("Message Produced");
    }

    @RequestMapping("/multiUsers")
    public ResponseEntity<String> postMultipleUsers(@RequestBody List<User> users){
        service.multipleUsers(users);
        return ResponseEntity.ok("Message Produced");
    }
}

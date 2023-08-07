package com.springboot.rest.webservices.restfulwebservice.user;

import org.springframework.web.bind.annotation.*;

import java.util.List;



//RestAPI구현
@RestController
public class UserResource {
    private UserDaoService service;
    public UserResource(UserDaoService service){
        this.service=service;
    }

    //GET/users
    @GetMapping("/users")
    public List<User> retrieveAllUsers(){
        return service.findAll();
    }
    @GetMapping("/users/{id}")
    public User retrieveUser(@PathVariable int id){
        return service.findOne(id);
    }

    //post
    @PostMapping("/users")
    public void createUser(@RequestBody User user){
        //request body: 사용자의 정보를 담음,user bean과 매핑
        service.save(user);

    }
}

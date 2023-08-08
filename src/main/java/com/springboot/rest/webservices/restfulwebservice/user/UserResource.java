package com.springboot.rest.webservices.restfulwebservice.user;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
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
        User user=service.findOne(id);
        if(user==null){
            throw new UserNotFoundException("id:"+id);
        }
        return user;
    }
    //delete user

    @DeleteMapping("/users/{id}")
    public void deleteUser(@PathVariable int id){
      service.deleteById(id);
    }


    //post
    @PostMapping("/users")
    public ResponseEntity<User> createUser (@Valid @RequestBody User user){
        //request body: 사용자의 정보를 담음,user bean과 매핑
        User savedUser=service.save(user);
        //201요청 받기
        //location-/users/4
        URI location= ServletUriComponentsBuilder.fromCurrentRequest()
                //요청 url에 추가하고 싶은 내용
                .path("/{id}")
                //생성된 사용자의 아이디로 바꿔줌
                .buildAndExpand(savedUser.getId())
                .toUri();
        return ResponseEntity.created(location).build();

    }
}

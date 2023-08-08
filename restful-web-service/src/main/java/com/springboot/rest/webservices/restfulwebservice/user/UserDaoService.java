package com.springboot.rest.webservices.restfulwebservice.user;

import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

@Component
public class UserDaoService {
    //모든 사용자를 검색, 특정 사용자의 상세 정보를 저장, 검색할 수 있도록 메서드를 실행
    //정적 리스트 만들기
    private static List<User> users=new ArrayList<>();
    private static int userCount=0;
    static {
        users.add(new User(++userCount,"Adam", LocalDate.now().minusYears(30)));
        users.add(new User(++userCount,"YJ", LocalDate.now().minusYears(25)));
        users.add(new User(++userCount,"DF", LocalDate.now().minusYears(14)));
    }
    public List<User> findAll(){
        return users;
    }
    //특정 사용자
    public User findOne(int id){
        Predicate<? super User> predicate =user->user.getId().equals(id);
        return users.stream().filter(predicate).findFirst().orElse(null);
    }
    //삭제 메소드
    public void deleteById(int id){
        Predicate<? super User> predicate =user->user.getId().equals(id);
        users.removeIf(predicate);
    }

    public User save(User user){
        user.setId(++userCount);
        users.add(user);
        return user;

    }
}

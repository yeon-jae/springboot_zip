package com.in28minutes.learnspringframework.game;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

//특정 클래스의 인스턴스 생성을 spring에 요청하려면 바로 어노테이션을 추가해야함
@Component
@ComponentScan("com.in28minutes.learnspringframework.game")
public class PackMan implements GamingConsole{
    public void up(){
        System.out.println("go to the sky");
    }
    public void down(){
        System.out.println("hide from enemy");
    }

    @Override
    public void left() {
        System.out.println("backward");
    }

    @Override
    public void right() {
        System.out.println("fight!");
    }
}

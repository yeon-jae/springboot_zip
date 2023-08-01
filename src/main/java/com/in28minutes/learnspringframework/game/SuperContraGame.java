package com.in28minutes.learnspringframework.game;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Qualifier("SuperContraGameQualifier")
public class SuperContraGame implements GamingConsole{
    public void up(){
        System.out.println("jump higher");
    }
    public void down(){
        System.out.println("go in to a hole");
    }
    public void left(){
        System.out.println("go left side");
    }
    public void right(){
        System.out.println("accelerate!!");
    }
}

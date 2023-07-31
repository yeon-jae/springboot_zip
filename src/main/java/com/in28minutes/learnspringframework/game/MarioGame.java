package com.in28minutes.learnspringframework.game;

public class MarioGame implements GamingConsole {
    public void up(){
        System.out.println("jump");
    }
    public void down(){
        System.out.println("go in to a hole");
    }
    public void left(){
        System.out.println("go back");
    }
    public void right(){
        System.out.println("accelerate");
    }
}

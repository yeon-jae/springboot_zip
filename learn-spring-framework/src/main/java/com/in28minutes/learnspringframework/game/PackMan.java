package com.in28minutes.learnspringframework.game;

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

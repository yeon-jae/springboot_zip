package com.in28minutes.learnspringframework.game;

public class GameRunner {
    private  GamingConsole game;
    //생성자 만들기
    public GameRunner(GamingConsole game) {
        this.game=game;
    }

    public void run() {
        System.out.println("Running game:"+game);
        game.up();
        game.down();
        game.left();
        game.right();
    }
}

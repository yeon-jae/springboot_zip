package com.in28minutes.learnspringframework;

import com.in28minutes.learnspringframework.game.GameRunner;
import com.in28minutes.learnspringframework.game.GamingConsole;
import com.in28minutes.learnspringframework.game.PackMan;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App03GamingSpringBeans {
    public static  void main(String[] args){

        var context=new AnnotationConfigApplicationContext(GamingConfiguration.class);
        context.getBean(GamingConsole.class).up();
        //gamerRunner클래스 생성
        //var game= new MarioGame();
        //var game =new SuperContraGame();
        var game= new PackMan();  //1. 객체 생성
        var gameRunner= new GameRunner(game); //2.겍체 생성 +writing of dependencies
        //GameConsole은 GameRunner클래스의 의존성
        gameRunner.run();
    }
}

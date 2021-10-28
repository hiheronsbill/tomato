package com.mk.java.entity;

import java.util.Arrays;

/**
 * @Desc TODO
 * @Author zhxy
 * @Date 2021/9/14 11:12
 * @Version V1.0
 **/
public class TestForeach {

    public static void main(String[] args) {

        Student student = new Student();
        student.setName("z3");
        student.setGames(Arrays.asList(new Game(),new Game()));

        for (Game game : student.getGames()) {
            System.out.println(game.getName());
        }


    }
}

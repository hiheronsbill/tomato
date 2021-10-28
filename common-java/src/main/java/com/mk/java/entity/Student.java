package com.mk.java.entity;

import lombok.Data;

import java.util.List;

/**
 * @Desc TODO
 * @Author zhxy
 * @Date 2021/9/14 11:11
 * @Version V1.0
 **/

public class Student {
    private String name;

    private List<Game> games;


    public String getName() {
        return name;
    }

    public List<Game> getGames() {
        return games;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGames(List<Game> games) {
        this.games = games;
    }
}

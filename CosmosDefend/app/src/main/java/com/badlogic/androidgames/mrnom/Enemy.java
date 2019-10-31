package com.badlogic.androidgames.mrnom;

import java.util.Random;

public class Enemy {
    public int x, y;

    private int mSpeed = 3;
    public int LifeSpawn = 150;
    public int shootTimer = 0;
    public int sTime = 40;

    public Enemy() {

        Random rad = new Random();

        this.x = rad.nextInt(280);
        this.y = 0;

        //Speed = rad.nextInt(7);
        //shootTimer = sTime;
    }

    public void update(float deltaTime){
        LifeSpawn -= deltaTime;
        shootTimer -= deltaTime;
        y += mSpeed;
    }
}

package com.badlogic.androidgames.mrnom;

public class Bullet {
    public int x, y;

    public int LifeSpawn = 100;
    private int mSpeed = 5;

    public Bullet(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void update(float deltaTime){
        LifeSpawn -=deltaTime;
        y -= mSpeed;
    }
}

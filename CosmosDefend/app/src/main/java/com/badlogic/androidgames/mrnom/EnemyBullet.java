package com.badlogic.androidgames.mrnom;

public class EnemyBullet {

    public int x, y;

    public int LifeSpawn = 100;
    private int mSpeed = 6;

    public EnemyBullet(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void update(float deltaTime){
        LifeSpawn -=deltaTime;
        y += mSpeed;
    }

}

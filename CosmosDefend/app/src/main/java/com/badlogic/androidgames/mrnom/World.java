package com.badlogic.androidgames.mrnom;

import android.content.Context;
import android.util.Log;

import com.badlogic.androidgames.framework.impl.AccelerometerHandler;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class World {

    static final int SCORE_INCREMENT = 10;
    static final int SCORE_DECREMENT = 20;

    public boolean gameOver = false;
    public int score = 0;
    public Ship Player;

    AccelerometerHandler acc;
    float Xspeed;
    float YSpeed;
    int width = 320;
    int height = 480;
    int spawnTimer;
    int TimeWait = 80;

    public List<Bullet> bullet = new ArrayList<>();
    public List<Enemy> enemies = new ArrayList<>();
    public List<EnemyBullet> Enemybullets = new ArrayList<>();

    public World(AccelerometerHandler acc_) {
        Player = new Ship(150,360);
        acc = acc_;
        spawnEnemies();
    }

    public void shoot(){
        bullet.add(new Bullet( Player.x,  Player.y));
    }
    public void enemyShoot(int x, int y){
        Enemybullets.add(new EnemyBullet(x, y));
    }

    public void spawnEnemies(){
        enemies.add(new Enemy());
        spawnTimer = TimeWait;
    }

    public void checkCollision(){

        // Complete your code below :
        // if bullet hits the enemy,
        for(int i = bullet.size() - 1; i >= 0; i--){
            for(int j = enemies.size() - 1; j >= 0; j--){
                if(bullet.get(i).x < enemies.get(j).x + Assets.enemy.getWidth()&&
                        bullet.get(i).x + Assets.playerBullet.getWidth() > enemies.get(j).x &&
                        bullet.get(i).y < enemies.get(j).y + Assets.enemy.getHeight() &&
                        bullet.get(i).y + Assets.playerBullet.getHeight() > enemies.get(j).y)
                {
                    score += 10;
                    // 1. the enemy should be disappear
                    enemies.remove(enemies.get(j));
                    // 2. the bullet should be disappear
                    bullet.remove(bullet.get(i));
                    // 3. a short sound should be played
                }
            }
        }

        for(int j = enemies.size() - 1; j >= 0; j--){
            if(Player.x < enemies.get(j).x + Assets.enemy.getWidth() &&
                    Player.x + Assets.spaceship.getWidth() > enemies.get(j).x &&
                    Player.y < enemies.get(j).y + Assets.enemy.getHeight() &&
                    Player.y + Assets.spaceship.getHeight() > enemies.get(j).y)
            {
                //Player = null;
                gameOver = true;
            }
        }

        // spawn enemy bullet
        for(int i = Enemybullets.size() - 1; i >= 0; i--){
            if(Enemybullets.get(i).x < Player.x + Assets.spaceship.getWidth()&&
                    Enemybullets.get(i).x + Assets.EnemuBullets.getWidth() > Player.x &&
                    Enemybullets.get(i).y < Player.y + Assets.spaceship.getHeight() &&
                    Enemybullets.get(i).y + Assets.EnemuBullets.getHeight() > Player.y)
            {
                gameOver = true;
            }
        }

    }

    public void update(float deltaTime) {
        if (gameOver)
            return;

        Xspeed = acc.getAccelX();
        YSpeed = acc.getAccelY();

        Player.x-= Xspeed ;
        Player.y+= YSpeed;

        // x axis
        if(Player.x > (width - Assets.spaceship.getWidth())){
            Player.x = width - Assets.spaceship.getWidth();
            Xspeed = 0;
        }
        else if (Player.x  < 0){
            Player.x  = 0;
            Xspeed = 0;
        }
        // y axis
        if(Player.y > (height -Assets.spaceship.getHeight())){
            Player.y = height - Assets.spaceship.getHeight();
            YSpeed = 0;
        }
        else if (Player.y < 0){
            Player.y = 0;
            YSpeed = 0;
        }
        checkCollision();
        if(!bullet.isEmpty()) {
            for(int j = 0; j < bullet.size(); j++){
                bullet.get(j).update(deltaTime);
                if(bullet.get(j).LifeSpawn <= 0){
                    bullet.remove(bullet.get(j));
                }
            }
        }

        spawnTimer -= deltaTime;
        if(spawnTimer <=0){
            spawnEnemies();
        }

        if(!enemies.isEmpty()) {
            for(int j = 0; j < enemies.size(); j++){
                enemies.get(j).update(deltaTime);
                if(enemies.get(j).shootTimer <=0){
                    enemyShoot(enemies.get(j).x, enemies.get(j).y);
                    enemies.get(j).shootTimer = enemies.get(j).sTime;
                }
                if(enemies.get(j).LifeSpawn <= 0){
                    enemies.remove(enemies.get(j));
                }
            }
        }

        if(!Enemybullets.isEmpty()) {
            for(int j = 0; j < Enemybullets.size(); j++){
                Enemybullets.get(j).update(deltaTime);
                if(Enemybullets.get(j).LifeSpawn <= 0){
                    Enemybullets.remove(Enemybullets.get(j));
                }
            }
        }

    }
}

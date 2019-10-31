package com.badlogic.androidgames.mrnom;

import com.badlogic.androidgames.framework.Game;
import com.badlogic.androidgames.framework.Graphics;
import com.badlogic.androidgames.framework.Screen;
import com.badlogic.androidgames.framework.Graphics.PixmapFormat;
import com.badlogic.androidgames.framework.impl.AccelerometerHandler;

public class LoadingScreen extends Screen {

    AccelerometerHandler acc;
    public LoadingScreen(Game game, AccelerometerHandler acc_) {
        super(game);
        acc = acc_;
    }

    @Override
    public void update(float deltaTime) {
        Graphics g = game.getGraphics();
        Assets.background = g.newPixmap("background.png", PixmapFormat.RGB565);
        Assets.logo = g.newPixmap("logo.png", PixmapFormat.ARGB4444);
        Assets.logo1 = g.newPixmap("logo1.JPG", PixmapFormat.ARGB4444);
        Assets.mainMenu = g.newPixmap("mainmenu.JPG", PixmapFormat.ARGB4444);
        Assets.buttons = g.newPixmap("buttons.png", PixmapFormat.ARGB4444);
        Assets.help1 = g.newPixmap("help1.png", PixmapFormat.ARGB4444);
        Assets.help2 = g.newPixmap("help2.png", PixmapFormat.ARGB4444);
        Assets.help3 = g.newPixmap("help3.png", PixmapFormat.ARGB4444);
        Assets.numbers = g.newPixmap("numbers.png", PixmapFormat.ARGB4444);
        Assets.ready = g.newPixmap("ready.png", PixmapFormat.ARGB4444);
        Assets.pause = g.newPixmap("pausemenu.png", PixmapFormat.ARGB4444);
        Assets.gameOver = g.newPixmap("gameover.png", PixmapFormat.ARGB4444);
        Assets.headUp = g.newPixmap("headup.png", PixmapFormat.ARGB4444);
        Assets.headLeft = g.newPixmap("headleft.png", PixmapFormat.ARGB4444);
        Assets.headDown = g.newPixmap("headdown.png", PixmapFormat.ARGB4444);
        Assets.headRight = g.newPixmap("headright.png", PixmapFormat.ARGB4444);
        Assets.tail = g.newPixmap("tail.png", PixmapFormat.ARGB4444);
        Assets.stain1 = g.newPixmap("stain1.png", PixmapFormat.ARGB4444);
        Assets.stain2 = g.newPixmap("stain2.png", PixmapFormat.ARGB4444);
        Assets.stain3 = g.newPixmap("stain3.png", PixmapFormat.ARGB4444);
        Assets.wall = g.newPixmap("wall.png", PixmapFormat.ARGB4444);
        Assets.enemy = g.newPixmap("shipenemy.png", PixmapFormat.ARGB4444);
        Assets.heart = g.newPixmap("heart.png", PixmapFormat.ARGB4444);
        Assets.spaceship = g.newPixmap("ship.png", PixmapFormat.ARGB4444);
        Assets.playerBullet = g.newPixmap("playerbullet.png", PixmapFormat.ARGB4444);
        Assets.EnemuBullets = g.newPixmap("enemybullet.png", PixmapFormat.ARGB4444);

        Assets.click = game.getAudio().newSound("click.wav");
        Assets.eat = game.getAudio().newSound("eat.wav");
        Assets.bitten = game.getAudio().newSound("bitten.ogg");
        Assets.shoot = game.getAudio().newSound("shoot.wav");
        Assets.gameEnd = game.getAudio().newSound("end.wav");


        Settings.load(game.getFileIO());
        game.setScreen(new MainMenuScreen(game, acc));
    }

    @Override
    public void present(float deltaTime) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void dispose() {

    }
}
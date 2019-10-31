package com.badlogic.androidgames.mrnom;

import com.badlogic.androidgames.framework.Screen;
import com.badlogic.androidgames.framework.impl.AccelerometerHandler;
import com.badlogic.androidgames.framework.impl.AndroidGame;

public class CosmosDefendGame extends AndroidGame {

    AccelerometerHandler acc;
    @Override
    public Screen getStartScreen() {
        acc = new AccelerometerHandler(this);
        return new LoadingScreen(this, acc);
    }
}
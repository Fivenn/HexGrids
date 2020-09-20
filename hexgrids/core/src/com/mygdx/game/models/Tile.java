package com.mygdx.game.models;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;

public abstract class Tile extends Hexagon {

    public Tile(Vector3 position) {
        super(position);
    }

    public Tile(int x, int y, int z) {
        super(x, y, z);
    }

    public Tile(Vector2 position2) {
        super(position2);
    }

    public Tile(int x, int y) {
        super(x, y);
    }
}
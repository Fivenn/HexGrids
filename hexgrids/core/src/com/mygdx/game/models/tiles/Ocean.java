package com.mygdx.game.models.tiles;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.mygdx.game.models.Tile;

public class Ocean extends Tile {
    public Ocean(Vector3 position) {
        super(position);
    }

    public Ocean(int x, int y, int z) {
        super(x, y, z);
    }

    public Ocean(Vector2 position2) {
        super(position2);
    }

    public Ocean(int x, int y) {
        super(x, y);
    }
}

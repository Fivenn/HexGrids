package com.mygdx.game.models.tiles;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.mygdx.game.models.Tile;

public class Plain extends Tile {
    public Plain(Vector3 position) {
        super(position);
    }

    public Plain(int x, int y, int z) {
        super(x, y, z);
    }

    public Plain(Vector2 position2) {
        super(position2);
    }

    public Plain(int x, int y) {
        super(x, y);
    }
}

package com.mygdx.game.models;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;

public class Hexagon {
    public final Vector3 position;
    public final Vector2 position2;
    public final Vector2 position2f;

    public Hexagon(Vector3 position) {
        this.position = position;

        if (position.x + position.y + position.z != 0)
            throw new Error("Coordinates must add up to 0");

        this.position2 = new Vector2(position.x, position.y);
        this.position2f = position2;
    }

    public Hexagon(int x, int y, int z) {
        this(new Vector3(x, y, z));
    }

    public Hexagon(Vector2 position2) {
        this.position2 = position2;
        this.position = new Vector3(position2.x, position2.y, -position2.x - position2.y);
        this.position2f = position2;
    }

    public Hexagon(int x, int y) {
        this(new Vector2(x, y));
    }

    @Override
    public boolean equals(Object b) {
        return this.position.equals(((Hexagon) b).position);
    }

    @Override
    public int hashCode() {
        return position.hashCode();
    }
}
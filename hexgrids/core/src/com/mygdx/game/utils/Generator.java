package com.mygdx.game.utils;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector3;
import com.mygdx.game.models.Map;
import com.mygdx.game.models.Tile;
import com.mygdx.game.models.tiles.Ocean;
import com.mygdx.game.models.tiles.Plain;

public class Generator {
    public static Map random(int width, int height) {
        Tile[][] grid = new Tile[height][width];
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                int id = (int)(Math.random() * 2);
                if(id == 0) {
                    grid[y][x] = new Plain(new Vector3(x, y, -x - y));
                } else {
                    grid[y][x] = new Ocean(new Vector3(x, y, -x - y));
                }
            }
        }
        return new Map(grid);
    }
}
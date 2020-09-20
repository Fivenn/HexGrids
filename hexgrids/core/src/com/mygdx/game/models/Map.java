package com.mygdx.game.models;

public class Map {
    private final Tile[][] grid;
    public final int height;
    public final int width;

    public Map(Tile[][] grid) {
        this.grid = grid;
        width = grid[0].length;
        height = grid.length;
    }

    public Tile get(int x, int y) {
        return grid[y][x];
    }
}
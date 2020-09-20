package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.mygdx.game.models.Map;
import com.mygdx.game.utils.Generator;

public class MyGdxGame extends ApplicationAdapter {
    Renderer renderer;
    Map map;

    @Override
    public void create() {
        int size  = 100;
        float scale =1/5f;
        map = Generator.random(8, 16);
        renderer = new Renderer(size * scale, size * scale);
    }

    @Override
    public void render() {
        renderer.render(map);
    }
}

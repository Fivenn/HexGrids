package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.ObjectMap;
import com.mygdx.game.models.Map;
import com.mygdx.game.models.Tile;
import com.mygdx.game.models.tiles.Ocean;
import com.mygdx.game.models.tiles.Plain;

public class Renderer {
    public static final float FIFTH = (float) Math.sqrt(3/2);
    public static final float HEIGHT = 1f;
    public static final float WIDTH = FIFTH * HEIGHT;

    private ShapeRenderer shapeBatch;
    private SpriteBatch batch;
    private OrthographicCamera camera;
    private ObjectMap<Class, TextureRegion> tileTextures;
    private Vector2 tileDrawingPos;
    private InputManager inputManager;

    public Renderer(float width, float height) {
        camera = new OrthographicCamera(width, height);
        camera.translate(width / 2f, height / 2f);
        camera.update();
        inputManager = new InputManager(camera);
        Gdx.input.setInputProcessor(inputManager);
        batch = new SpriteBatch();
        batch.setProjectionMatrix(camera.combined);
        shapeBatch = new ShapeRenderer();
        shapeBatch.setProjectionMatrix(camera.combined);
        shapeBatch.setColor(Color.GREEN);
        Texture tileset = new Texture("topTiles.png");
        tileTextures = new ObjectMap<>();
        tileTextures.put(Plain.class, new TextureRegion(tileset, 110, 0, 55, 57));
        tileTextures.put(Ocean.class, new TextureRegion(tileset, 0, 57, 55, 57));
        tileDrawingPos = new Vector2();
    }

    public void render(Map map) {
        camera.update();
        Gdx.gl.glClearColor(0.25f, 0.25f, 0.25f, 1f);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.setProjectionMatrix(camera.combined);
        batch.begin();
        for (int y = 0; y <= map.height - 1; y++) {
            for (int x = 0; x <= map.width - 1; x++) {
                Tile tile = map.get(x, y);
                if (y % 2 != 0)
                    tileDrawingPos.set(x, y);
                else
                    tileDrawingPos.set(x + 0.5f, y);
                toHex(tileDrawingPos);
                batch.draw(tileTextures.get(tile.getClass()), tileDrawingPos.x, tileDrawingPos.y, WIDTH, HEIGHT);
            }
        }
        batch.end();
    }

    public float pixelWidth() {
        return 2 * camera.viewportWidth / (float) Gdx.graphics.getWidth();
    }

    public float pixelHeight() {
        return 2 * camera.viewportHeight / (float) Gdx.graphics.getHeight();
    }

    public void toHex(Vector2 vector) {
        vector.x *= 1 - pixelWidth() * 2f;
        vector.y *= (3f / 4f);
        vector.y *= 1f - pixelHeight() * 2f;
    }
}

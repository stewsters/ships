package com.stewsters.ships;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;

public class ShipsGame extends ApplicationAdapter {
//	SpriteBatch batch;
//	Texture img;

    ShapeRenderer shapeRenderer;
    Ship ship;

    @Override
    public void create() {
//		batch = new SpriteBatch();
//		img = new Texture("badlogic.jpg");

        shapeRenderer = new ShapeRenderer();
        ship = new Ship(new Vector2(10, 10), 0, 10, 2);
    }

    @Override
    public void render() {
        float dt = Gdx.graphics.getDeltaTime();

        // Control
        if (Gdx.input.isKeyPressed(Input.Keys.LEFT_BRACKET)) {
            ship.speedInKnots = Math.max(ship.speedInKnots - dt * ship.accelerationInKnots, ship.maxReverseSpeedInKnots);
        } else if (Gdx.input.isKeyPressed(Input.Keys.RIGHT_BRACKET)) {
            ship.speedInKnots = Math.min(ship.speedInKnots + dt * ship.accelerationInKnots, ship.maxForwardSpeedInKnots);
        }

        if (Gdx.input.isKeyPressed(Input.Keys.APOSTROPHE)) {
            ship.facingInRadians = ship.facingInRadians - dt * ship.maxRotationInRadians;
        } else if (Gdx.input.isKeyPressed(Input.Keys.SEMICOLON)) {
            ship.facingInRadians = ship.facingInRadians + dt * ship.maxRotationInRadians;
        }

        //move ship
        float xVec = ship.speedInKnots * MathUtils.cos(ship.facingInRadians);
        float yVec = ship.speedInKnots * MathUtils.sin(ship.facingInRadians);
        ship.pos.x += dt * xVec;
        ship.pos.y += dt * yVec;


        // Render ship
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
        shapeRenderer.setColor(0.5f, 1f, 0.5f, 1f);
        shapeRenderer.circle(ship.pos.x, ship.pos.y, ship.radius);
        shapeRenderer.end();

        shapeRenderer.begin(ShapeRenderer.ShapeType.Line);
        shapeRenderer.line(ship.pos.x, ship.pos.y, ship.pos.x + xVec, ship.pos.y + yVec);
        shapeRenderer.end();


    }
}

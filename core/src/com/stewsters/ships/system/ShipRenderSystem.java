package com.stewsters.ships.system;

import com.artemis.Aspect;
import com.artemis.ComponentMapper;
import com.artemis.Entity;
import com.artemis.annotations.Mapper;
import com.artemis.systems.EntityProcessingSystem;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.MathUtils;
import com.stewsters.ships.component.Ship;


public class ShipRenderSystem extends EntityProcessingSystem {

    @Mapper
    ComponentMapper<Ship> shipComponentMapper;
    ShapeRenderer shapeRenderer;

    public ShipRenderSystem() {
        super(Aspect.getAspectForAll(Ship.class));

        shapeRenderer = new ShapeRenderer();

    }

    @Override
    protected void begin(){
        // Render ship
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
    }

    @Override
    protected void process(Entity e) {
        Ship ship = shipComponentMapper.get(e);

        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
        shapeRenderer.setColor(0.5f, 1f, 0.5f, 1f);
        shapeRenderer.circle(ship.pos.x, ship.pos.y, ship.radius);
        shapeRenderer.end();

        shapeRenderer.begin(ShapeRenderer.ShapeType.Line);
        float xVec = ship.speedInKnots * MathUtils.cos(ship.facingInRadians);
        float yVec = ship.speedInKnots * MathUtils.sin(ship.facingInRadians);
        shapeRenderer.line(ship.pos.x, ship.pos.y, ship.pos.x + xVec, ship.pos.y + yVec);
        shapeRenderer.end();
    }
}

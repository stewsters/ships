package com.stewsters.ships.system;

import com.artemis.Aspect;
import com.artemis.ComponentMapper;
import com.artemis.Entity;
import com.artemis.annotations.Mapper;
import com.artemis.systems.EntityProcessingSystem;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.math.Vector2;
import com.stewsters.ships.component.Player;
import com.stewsters.ships.component.Ship;

public class ControlSystem extends EntityProcessingSystem {

    @Mapper
    ComponentMapper<Ship> shipComponentMapper;

    public ControlSystem() {
        super(Aspect.getAspectForAll(Player.class));
    }

    @Override
    protected void process(Entity e) {
        Ship ship = shipComponentMapper.get(e);
        float dt = world.getDelta();

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

        if (Gdx.input.isKeyPressed(Input.Keys.SPACE)) {
            // if we have a torpedo in the current slot, fire

            Vector2 launchLocation = ship.pos.cpy();

            Entity torpedo = world.createEntity();
            torpedo.addComponent(new Ship(launchLocation, ship.facingInRadians, 20, 1));
            world.addEntity(torpedo);
        }
        e.changedInWorld();

    }
}

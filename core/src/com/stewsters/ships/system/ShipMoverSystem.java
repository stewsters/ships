package com.stewsters.ships.system;

import com.artemis.Aspect;
import com.artemis.ComponentMapper;
import com.artemis.Entity;
import com.artemis.annotations.Mapper;
import com.artemis.systems.EntityProcessingSystem;
import com.badlogic.gdx.math.MathUtils;
import com.stewsters.ships.component.Ship;


public class ShipMoverSystem extends EntityProcessingSystem {

    @Mapper
    ComponentMapper<Ship> shipComponentMapper;

    @SuppressWarnings("Unchecked")
    public ShipMoverSystem() {
        super(Aspect.getAspectForAll(Ship.class));
    }

    @Override
    protected void process(Entity e) {
        Ship ship = shipComponentMapper.get(e);
        float dt = world.getDelta();

        //move ship
        float xVec = ship.speedInKnots * MathUtils.cos(ship.facingInRadians);
        float yVec = ship.speedInKnots * MathUtils.sin(ship.facingInRadians);
        ship.pos.x += dt * xVec;
        ship.pos.y += dt * yVec;
        e.changedInWorld();
    }
}

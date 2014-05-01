package com.stewsters.ships;

import com.artemis.Entity;
import com.artemis.World;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;
import com.stewsters.ships.component.Engine;
import com.stewsters.ships.component.Player;
import com.stewsters.ships.component.Ship;
import com.stewsters.ships.system.ControlSystem;
import com.stewsters.ships.system.LifeSpanSystem;
import com.stewsters.ships.system.ShipMoverSystem;
import com.stewsters.ships.system.ShipRenderSystem;

public class ShipsGame extends ApplicationAdapter {

    World world;

    @Override
    public void create() {

        world = new World();
        world.setSystem(new LifeSpanSystem());
        world.setSystem(new ControlSystem());
        world.setSystem(new ShipMoverSystem());
        world.setSystem(new ShipRenderSystem());

        world.initialize();

        Entity player = world.createEntity();
        player.addComponent(new Ship(new Vector2(10, 10), 0, 10, 2));

        Engine torpedoEngine = player.createComponent(Engine.class);
        torpedoEngine.accelerationInKnots = 2f;
        torpedoEngine.maxForwardSpeedInKnots = 15f;
        torpedoEngine.maxReverseSpeedInKnots = 4f;
        torpedoEngine.maxRotationInRadians = 0.5f;

        player.createComponent(Player.class);


        world.addEntity(player);


    }

    @Override
    public void render() {
        float dt = Gdx.graphics.getDeltaTime();

        world.setDelta(dt);
        world.process();

    }
}

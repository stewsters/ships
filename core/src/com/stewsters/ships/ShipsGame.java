package com.stewsters.ships;

import com.artemis.Entity;
import com.artemis.World;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;
import com.stewsters.ships.component.Engine;
import com.stewsters.ships.component.Player;
import com.stewsters.ships.component.Ship;
import com.stewsters.ships.system.ControlSystem;
import com.stewsters.ships.system.ShipMoverSystem;
import com.stewsters.ships.system.ShipRenderSystem;

public class ShipsGame extends ApplicationAdapter {

    World world;

    @Override
    public void create() {

        world = new World();
        world.setSystem(new ControlSystem());
        world.setSystem(new ShipMoverSystem());
        world.setSystem(new ShipRenderSystem());

        world.initialize();

        Entity player = world.createEntity();
        player.addComponent(new Ship(new Vector2(10, 10), 0, 10, 2));
        player.addComponent(new Engine(2f,20f,4f, 0.5f));
        player.addComponent(new Player());
        world.addEntity(player);


    }

    @Override
    public void render() {
        float dt = Gdx.graphics.getDeltaTime();

        world.setDelta(dt);
        world.process();

    }
}

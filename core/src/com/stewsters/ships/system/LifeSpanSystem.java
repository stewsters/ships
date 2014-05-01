package com.stewsters.ships.system;

import com.artemis.Aspect;
import com.artemis.ComponentMapper;
import com.artemis.Entity;
import com.artemis.annotations.Mapper;
import com.artemis.systems.EntityProcessingSystem;
import com.stewsters.ships.component.LifeSpan;

public class LifeSpanSystem extends EntityProcessingSystem {

    @Mapper
    ComponentMapper<LifeSpan> lifeSpanComponentMapper;

    @SuppressWarnings("Unchecked")
    public LifeSpanSystem() {
        super(Aspect.getAspectForAll(LifeSpan.class));
    }

    @Override
    protected void process(Entity e) {

        float dt = world.getDelta();

        LifeSpan lifeSpan = lifeSpanComponentMapper.get(e);

        lifeSpan.timeLeft -= dt;
        if (lifeSpan.timeLeft <= 0) {
            e.deleteFromWorld();
        } else {
            e.changedInWorld();
        }

    }
}

package com.stewsters.ships.component;

import com.artemis.PooledComponent;

public class LifeSpan extends PooledComponent {

    public float timeLeft = 0;


    @Override
    protected void reset() {
        timeLeft = 0;
    }
}

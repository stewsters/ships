package com.stewsters.ships.component;


import com.artemis.PooledComponent;

public class Engine extends PooledComponent {


    public float accelerationInKnots;
    public float maxForwardSpeedInKnots;
    public float maxReverseSpeedInKnots;
    public float maxRotationInRadians;

    @Override
    protected void reset() {
        accelerationInKnots = 0;
        maxForwardSpeedInKnots = 0;
        maxReverseSpeedInKnots = 0;
        maxRotationInRadians = 0;

    }
}

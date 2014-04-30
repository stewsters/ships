package com.stewsters.ships.component;

import com.artemis.Component;
import com.badlogic.gdx.math.Vector2;


public class Ship extends Component {

    public Vector2 pos;
    public float facingInRadians;
    public float speedInKnots;
    public float radius;


    public float maxForwardSpeedInKnots;
    public float maxReverseSpeedInKnots;

    public float maxRotationInRadians;
    public float accelerationInKnots;


    public Ship(Vector2 pos, float facingInRadians, float speedInKnots, float radius) {
        this.pos = pos;
        this.facingInRadians = facingInRadians;
        this.speedInKnots = speedInKnots;
        this.radius = radius;

        this.maxForwardSpeedInKnots = 20f;
        this.maxReverseSpeedInKnots = 4f;

        this.maxRotationInRadians = 0.5f;

        this.accelerationInKnots = 2f;
    }
}

package com.stewsters.ships.component;

import com.artemis.Component;
import com.badlogic.gdx.math.Vector2;


public class Ship extends Component {

    public Vector2 pos;
    public float facingInRadians; // newtonian physics are for suckers
    public float speedInKnots;
    public float radius;

    public Ship(Vector2 pos, float facingInRadians, float speedInKnots, float radius) {
        this.pos = pos;
        this.facingInRadians = facingInRadians;
        this.speedInKnots = speedInKnots;
        this.radius = radius;
    }
}

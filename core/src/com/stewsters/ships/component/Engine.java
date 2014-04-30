package com.stewsters.ships.component;


import com.artemis.Component;

public class Engine extends Component {


    public float accelerationInKnots;
    public float maxForwardSpeedInKnots;
    public float maxReverseSpeedInKnots;
    public float maxRotationInRadians;

    public Engine(float accelerationInKnots,float  maxForwardSpeedInKnots, float maxReverseSpeedInKnots, float maxRotationInRadians){
        this.accelerationInKnots = 2f;
        this.maxForwardSpeedInKnots = 20f;
        this.maxReverseSpeedInKnots = 4f;
        this.maxRotationInRadians = 0.5f;
    }
}

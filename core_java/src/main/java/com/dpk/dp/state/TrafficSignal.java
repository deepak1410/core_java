package com.dpk.dp.state;

public class TrafficSignal {
    TrafficSignalState state;

    public TrafficSignal() {
        this.state = new GreenSignalState();
    }

    public void setState(TrafficSignalState state) {
        this.state = state;
    }

    public void performAction() {
        state.display();
        state.setNextSignal(this);
    }
}

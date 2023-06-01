package com.dpk.dp.state;

public interface TrafficSignalState {
    public void display();
    public void setNextSignal(TrafficSignal trafficSignal);
}

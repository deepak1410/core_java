package com.dpk.dp.state;

public class RedSignalState implements TrafficSignalState {

    @Override
    public void display() {
        System.out.println("Red signal");
        try{
            Thread.sleep(500);
        } catch (InterruptedException ex) {

        }
    }

    @Override
    public void setNextSignal(TrafficSignal trafficSignal) {
        trafficSignal.setState(new GreenSignalState());
    }
}

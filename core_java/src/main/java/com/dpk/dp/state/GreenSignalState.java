package com.dpk.dp.state;

public class GreenSignalState implements TrafficSignalState {

    @Override
    public void display() {
        System.out.println("Green signal");

        try{
            Thread.sleep(500);
        } catch (InterruptedException ex) {

        }
    }

    @Override
    public void setNextSignal(TrafficSignal trafficSignal) {
        trafficSignal.setState(new YellowSignalState());
    }
}

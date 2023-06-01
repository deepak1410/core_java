package com.dpk.dp.state;

public class YellowSignalState implements TrafficSignalState {

    @Override
    public void display() {
        System.out.println("Yellow signal");
        try{
            Thread.sleep(500);
        } catch (InterruptedException ex) {

        }
    }

    @Override
    public void setNextSignal(TrafficSignal trafficSignal) {
        trafficSignal.setState(new RedSignalState());
    }
}

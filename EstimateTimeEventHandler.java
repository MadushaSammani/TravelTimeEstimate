package org.matsim.codeexamples.project;

import org.matsim.api.core.v01.events.PersonArrivalEvent;
import org.matsim.api.core.v01.events.handler.PersonArrivalEventHandler;
import org.matsim.core.utils.collections.Tuple;

import java.util.ArrayList;
import java.util.List;

public class EstimateTimeEventHandler implements PersonArrivalEventHandler {
    int arrival =0;
    List<Tuple<Double, Integer>> arrivalTimes = new ArrayList<Tuple<Double, Integer>>();

    @Override
    public void handleEvent(PersonArrivalEvent personArrivalEvent) {
        arrival++;
        arrivalTimes.add(new Tuple<Double, Integer>(personArrivalEvent.getTime(), arrival));
    }
    public List<Tuple<Double, Integer>> getVehicleLeave() {
        return arrivalTimes;
    }
}

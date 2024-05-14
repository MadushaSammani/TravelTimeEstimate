package org.matsim.codeexamples.project;

import org.matsim.api.core.v01.network.Network;
import org.matsim.core.events.EventsUtils;
import org.matsim.core.network.NetworkUtils;
import org.matsim.core.network.io.MatsimNetworkReader;
import org.matsim.core.utils.collections.Tuple;

import java.io.IOException;
import java.util.List;


public class EstimateTime {
    private final static String INPUTTING = "C:/Matsim";
    public static void main(String[] args) throws IOException {
        String inputFile = INPUTTING + "/output/ITERS/it.10/10.events.xml.gz";
        String networkFile = INPUTTING + "/scenarios/project/network.xml";
        Network network = NetworkUtils.createNetwork();
        new MatsimNetworkReader(network).readFile(networkFile);
        var handler = new EstimateTimeEventHandler();
        var manager = EventsUtils.createEventsManager();
        manager.addHandler(handler);
        EventsUtils.readEvents(manager, inputFile);
        final List<Tuple<Double, Integer>> timeMap = handler.getVehicleLeave();
        int n = timeMap.size();
        int nPersons = timeMap.get(n - 1).getSecond();
        for (Tuple<Double, Integer> t : timeMap) {
            if (t.getSecond() == nPersons) {
                double ETE=  t.getFirst() ;
                System.out.println("Estimated Travel Time: " + ETE + " seconds");
            }
        }
    }
}

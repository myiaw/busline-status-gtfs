package org.example;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

final public class Parser {
    // Used only needed fields from the files to save memory.
    public static Map<Integer,Stop> parseStops() {
        File stopsFile = new File("src/main/resources/stops.txt");
        Map<Integer, Stop> stops = new HashMap<>();

        if (stopsFile.exists()) {
            try(BufferedReader br = new BufferedReader(new FileReader(stopsFile))) {
                String line = br.readLine(); // Skip first line
                while ((line = br.readLine()) != null) {
                    String[] values = line.split(",", -1); // -1 means unlimited splits
                    Stop stop = new Stop(values[0], values[2]); // Only need stop_id and stop_name
                    stops.put(stop.getStopId(), stop);
                }
            } catch(IOException ex) {
                System.out.println(ex.getMessage());
            }
        } else {
            System.out.println("Stops file not found");
        }

        return stops;
    }

    public static Map<String,Trip> parseTrips(){
        File tripsFile = new File("src/main/resources/trips.txt");
        Map<String, Trip> trips = new HashMap<>();

        if (tripsFile.exists()) {
            try(BufferedReader br = new BufferedReader(new FileReader(tripsFile))) {
                String line = br.readLine();
                while ((line = br.readLine()) != null) {
                    String[] values = line.split(",", -1);
                    Trip trip = new Trip(values[0], values[2]); // need route_id and trip_id
                    trips.put(trip.getTripId(), trip);
                }
            } catch(IOException ex) {
                System.out.println(ex.getMessage());
            }
        }

        return trips;
    }

    public static List<StopTime> parseStopTimes(){
        File stopTimesFile = new File("src/main/resources/stop_times.txt");
        List<StopTime> stopTimes = new ArrayList<>();

        if (stopTimesFile.exists()) {
            try(BufferedReader br = new BufferedReader(new FileReader(stopTimesFile))) {
                String line = br.readLine();
                while ((line = br.readLine()) != null) {
                    String[] values = line.split(",", -1);
                    StopTime stopTime = new StopTime(values[0], values[1], values[3]); // need trip_id, arrival time and stop_id;
                    stopTimes.add(stopTime);
                }
            } catch(IOException ex) {
                System.out.println(ex.getMessage());
            }
        }

        return stopTimes;
    }
}

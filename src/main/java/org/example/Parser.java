package org.example;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Parser {

    public static Map<Integer,Stop> ParseStops() {
        File stopsFile = new File("src/main/resources/stops.txt");
        Map<Integer, Stop> stops = new HashMap<>();

        if (stopsFile.exists()) {
            try(BufferedReader br = new BufferedReader(new FileReader(stopsFile))) {
                String line = br.readLine(); // Skip first line
                while ((line = br.readLine()) != null) {
                    String[] values = line.split(",", -1);
                    Stop stop = new Stop(values[0], values[2]);
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

    public static Map<String,Trip> ParseTrips(){
        File tripsFile = new File("src/main/resources/trips.txt");
        Map<String, Trip> trips = new HashMap<>();

        if (tripsFile.exists()) {
            try(BufferedReader br = new BufferedReader(new FileReader(tripsFile))) {
                String line = br.readLine();
                while ((line = br.readLine()) != null) {
                    String[] values = line.split(",", -1);
                    Trip trip = new Trip(values[0], values[2]);
                    trips.put(trip.getTripId(), trip);
                }
            } catch(IOException ex) {
                System.out.println(ex.getMessage());
            }
        }

        return trips;
    }

    public static List<StopTime> ParseStopTimes(){
        File stopTimesFile = new File("src/main/resources/stop_times.txt");
        List<StopTime> stopTimes = new ArrayList<>();

        if (stopTimesFile.exists()) {
            try(BufferedReader br = new BufferedReader(new FileReader(stopTimesFile))) {
                String line = br.readLine();
                while ((line = br.readLine()) != null) {
                    String[] values = line.split(",", -1);
                    StopTime stopTime = new StopTime(values[0], values[1], values[3]);
                    stopTimes.add(stopTime);
                }
            } catch(IOException ex) {
                System.out.println(ex.getMessage());
            }
        }

        return stopTimes;
    }
}

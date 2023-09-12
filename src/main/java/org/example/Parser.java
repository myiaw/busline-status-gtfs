package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Parser {
    public static Map<Integer,Stop> ParseStops() {
       Map<Integer, Stop> stops = new HashMap<>();
        try(BufferedReader br = new BufferedReader(new FileReader("src/main/resources/stops.txt"))) {
            String line = br.readLine(); // Skip first line
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",", -1);
                Stop stop = new Stop(values[0], values[2]); // Made constructor for parsing
                stops.put(stop.getStopId(), stop);
            }

        } catch(IOException ex) {
            System.out.println(ex.getMessage());
        }

        return stops;
    }

    public static Map<String,Trip> ParseTrips(){
        Map<String, Trip> trips = new HashMap<>();

        try(BufferedReader br = new BufferedReader(new FileReader("src/main/resources/trips.txt"))) {
            String line = br.readLine();

            while ((line = br.readLine()) != null) {
                String[] values = line.split(",", -1);
                Trip trip = new Trip(values[0],values[2]); // Made constructor for parsing
                trips.put(trip.getTripId(),trip);
            }

        } catch(IOException ex) {
            System.out.println(ex.getMessage());
        }

        return trips;

    }

    public static List<StopTime> ParseStopTimes(){
        List<StopTime> stopTimes = new ArrayList<>();

        try(BufferedReader br = new BufferedReader(new FileReader("src/main/resources/stop_times.txt"))) {
            String line = br.readLine();

            while ((line = br.readLine()) != null) {
                String[] values = line.split(",", -1); // No limit on split
                StopTime stopTime = new StopTime();
                stopTime.setTripId(values[0]);
                stopTime.setArrivalTime(values[1]);
                stopTime.setStopTimeId(Integer.parseInt(values[3]));
                stopTimes.add(stopTime);
            }

        } catch(IOException ex) {
            System.out.println(ex.getMessage());
        }

        return stopTimes;
    }

}

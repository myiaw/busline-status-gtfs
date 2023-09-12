package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Parser {

    public static boolean parseArguments(String[] args) {
        if (args.length != 3 ) {
            System.out.println("Invalid amount of arguments.");
            return false;
        }
        if (!args[2].equals("relative") && !args[2].equals("absolute")) {
            System.out.println("Invalid time format");
            return false;
        }
        try{
            Integer.parseInt(args[0]);
            Integer.parseInt(args[1]);
        } catch (NumberFormatException e) {
            System.out.println("Invalid station id or number of buses");
            return false;
        }
        return true;
    }
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
                StopTime stopTime = new StopTime(values[0], values[1],values[3]);
                stopTimes.add(stopTime);
            }

        } catch(IOException ex) {
            System.out.println(ex.getMessage());
        }

        return stopTimes;
    }

}

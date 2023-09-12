package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Parser {
    Parser() {}

    public static Map<Integer,Stop> ParseStops() {
       Map<Integer, Stop> stops = new HashMap<>();

        try(BufferedReader br = new BufferedReader(new FileReader("src/main/resources/stops.txt"))) {
            String line = br.readLine();

            while ((line = br.readLine()) != null) {
                String[] values = line.split(",", -1);
                Stop stop = new Stop();
                stop.setStopId(Integer.parseInt(values[0]));
                stop.setStopName(values[2]);
                stops.put(stop.getStopId(), stop);
            }

        } catch(IOException ex) {
            System.out.println(ex.getMessage());
        }

        return stops;
    }

    public static Map<Integer,Route> ParseRoutes(){
        Map<Integer, Route> routes = new HashMap<>();

        try(BufferedReader br = new BufferedReader(new FileReader("src/main/resources/routes.txt"))) {
            String line = br.readLine();

            while ((line = br.readLine()) != null) {
                String[] values = line.split(",", -1);
                Route route = new Route();
                route.setRouteId(Integer.parseInt(values[0]));
                routes.put(route.getRouteId(),route);
            }

        } catch(IOException ex) {
            System.out.println(ex.getMessage());
        }

        return routes;
    }

    public static Map<String,Trip> ParseTrips(){
        Map<String, Trip> trips = new HashMap<>();

        try(BufferedReader br = new BufferedReader(new FileReader("src/main/resources/trips.txt"))) {
            String line = br.readLine();

            while ((line = br.readLine()) != null) {
                String[] values = line.split(",", -1);
                Trip trip = new Trip();
                trip.setRouteId(Integer.parseInt(values[0]));
                trip.setTripId(values[2]);
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
                String[] values = line.split(",", -1);
                StopTime stopTime = new StopTime();
                stopTime.setTripId(values[0]);
                stopTime.setArrivalTime(values[1]);
                stopTime.setStopId(Integer.parseInt(values[3]));
                stopTimes.add(stopTime);
            }

        } catch(IOException ex) {
            System.out.println(ex.getMessage());
        }

        return stopTimes;

    }

}

package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Parser {
    Parser() {}

    public static void parseArguments(String[] args, List<Stop> stops, List<Route> routes, List<Trip> trips, List<StopTime> stopTimes) {
        if (args.length != 3) {
            System.out.println("Invalid");
            System.exit(1);
        }
        String id = args[0];
        String busNum = args[1];
        String type = args[2];
        System.out.println("id: " + id + " busNum: " + busNum + " type: " + type);
    }

    public static List<Stop> ParseStops() {
        List<Stop> stops = new ArrayList<>();

        try(BufferedReader br = new BufferedReader(new FileReader("src/main/resources/stops.txt"))) {
            String line = br.readLine();

            while ((line = br.readLine()) != null) {
                String[] values = line.split(",", -1);
                Stop stop = new Stop();
                stop.setStopId(Integer.parseInt(values[0]));
                stops.add(stop);
            }

        } catch(IOException ex) {
            System.out.println(ex.getMessage());
        }

        return stops;
    }

    public static List<Route> ParseRoutes(){
        List<Route> routes = new ArrayList<>();

        try(BufferedReader br = new BufferedReader(new FileReader("src/main/resources/routes.txt"))) {
            String line = br.readLine();

            while ((line = br.readLine()) != null) {
                String[] values = line.split(",", -1);
                Route route = new Route();
                route.setRouteId(Integer.parseInt(values[0]));
                routes.add(route);
            }

        } catch(IOException ex) {
            System.out.println(ex.getMessage());
        }

        return routes;
    }

    public static List<Trip> ParseTrips(){
        List<Trip> trips = new ArrayList<>();

        try(BufferedReader br = new BufferedReader(new FileReader("src/main/resources/trips.txt"))) {
            String line = br.readLine();

            while ((line = br.readLine()) != null) {
                String[] values = line.split(",", -1);
                Trip trip = new Trip();
                trip.setRouteId(Integer.parseInt(values[0]));
                trip.setTripId(values[2]);
                trips.add(trip);
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

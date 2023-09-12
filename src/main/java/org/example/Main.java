package org.example;

import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.Map;

import static org.example.Parser.*;

public class Main {


    public static void main(String[] args) {

        if (args.length != 3) {
            System.out.println("Invalid argument count");
            System.exit(1);
        }
        if (!args[2].equals("relative") && !args[2].equals("absolute")) {
            System.out.println("Invalid time format");
            System.exit(1);
        }

        try {
            int stationId = Integer.parseInt(args[0]);
            int numOfBuses = Integer.parseInt(args[1]);
            getData(stationId, numOfBuses, args[2]);
        } catch (NumberFormatException e) {
            System.out.println("Invalid station id or number of buses");
            System.exit(1);
        }


    }

    private static void getData(int stationId, int numOfBuses, String timeFormat) {
        //Map<Integer, Route> routes = ParseRoutes(); // Not needed because we have route_id in Trip

        Map<Integer, Stop> stops = parseStops();
        List<StopTime> stopTimes = parseStopTimes();
        Map<String, Trip> trips = parseTrips();


        // Because I use map, I can use key to get name easily.
        Stop stop = stops.get(stationId);
        if (stop != null) {
            System.out.println("Stop: " + stop.getStopName());
        } else {
            System.out.println("Not Found!");
            System.exit(0);
        }

        // Filter to match stationId and within 2h.
//        List<StopTime> filteredStopTimes = stopTimes.stream()
//                .filter(stopTime -> stopTime.getStopId() == stationId)
//                .filter(StopTime::isWithinTwoHours)
//                .collect(Collectors.toList());

        // Sort it from closest to furthest, reduce memory usage by not storing it in an extra list (above)
        List<StopTime> sortedTimes = stopTimes.stream()
                .filter(stopTime -> stopTime.getStopId() == stationId)
                .filter(StopTime::isWithinTwoHours)
                .sorted(Comparator.comparing(StopTime::getArrivalTime)) // Sort by arrival time
                .collect(Collectors.toList());


        // Connect times with Route names, could be done in one step, but I think this is more readable.
        Map<Integer, List<LocalTime>> timesGroupedByRouteId = sortedTimes.stream()
                .collect(Collectors.groupingBy(
                        stopTime -> {
                            Trip trip = trips.get(stopTime.getTripId()); // Retrieve the trip using its trip_id. If the trip doesn't exist, it means the stopTime isn't connected to any route.
                            return (trip != null) ? trip.getRouteId() : null;
                        },
                        Collectors.mapping(StopTime::getArrivalTime, Collectors.toList()) // For each StopTime object that share same route_id, assign it to the key.
                ));

        // For each route print all its times (limited to numOfBuses) and format it according to timeFormat
        timesGroupedByRouteId.forEach((routeId, times) -> {
            if (routeId != null) {
                System.out.print(routeId + ": ");
                if (timeFormat.equals("relative")) {
                    LocalTime now = LocalTime.now();
                    times.stream().limit(numOfBuses).forEach(time -> {
                        System.out.print(ChronoUnit.MINUTES.between(now, time) + "m ");
                    });
                } else {
                    times.stream().limit(numOfBuses).forEach(time -> System.out.print(time + " "));
                }

                System.out.println();
            }
        });
    }

}




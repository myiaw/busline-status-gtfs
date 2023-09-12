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
//        while (!parseArguments(args)) {
//            System.out.println("Please enter valid arguments.");
//            return;
//        }
        int stationId = 3;
        int numOfBuses = 5;
        String timeFormat = "relative";



        getData(stationId, numOfBuses, timeFormat);
    }

    private static void getData(int stationId, int numOfBuses, String timeFormat) {
        //Map<Integer, Route> routes = ParseRoutes(); // Not needed because we have route_id in Trip

        Map<Integer, Stop> stops = ParseStops();
        List<StopTime> stopTimes = ParseStopTimes();
        Map<String, Trip> trips = ParseTrips();


        // Because I switched to map, I can use key to get the stop and then its name.
        Stop stop = stops.get(stationId);
        if (stop != null) {
            System.out.println("Stop: " + stop.getStopName());
        } else {
            System.out.println("Not Found!");
        }

        // Filter to match stationId and within 2h.
        List<StopTime> filteredStopTimes = stopTimes.stream()
                .filter(stopTime -> stopTime.getStopId() == stationId)
                .filter(StopTime::isWithinTwoHours)
                .collect(Collectors.toList());


        // Sort it from closest to furthest
        List<StopTime> sortedTimes = filteredStopTimes.stream()
                .sorted(Comparator.comparing(StopTime::getArrivalTime))
                .collect(Collectors.toList());


        // Connect times with Route names
        Map<Integer, List<LocalTime>> timesGroupedByRouteId = sortedTimes.stream()
                .collect(Collectors.groupingBy(
                        stopTime -> {
                            Trip trip = trips.get(stopTime.getTripId());
                            return (trip != null) ? trip.getRouteId() : null;
                        },
                        Collectors.mapping(StopTime::getArrivalTime, Collectors.toList())
                ));

        // Find routes and print them with their times (limited to numOfBuses)
        timesGroupedByRouteId.forEach((routeId, times) -> {
            if (routeId != null) {
                System.out.print(routeId + ": ");
                if(timeFormat.equals("relative")) {
                    LocalTime now = LocalTime.now();
                    times.stream().limit(numOfBuses).forEach(time -> {
                        System.out.print(ChronoUnit.MINUTES.between(now, time) + "m ");
                    });
                } else  {
                    times.stream().limit(numOfBuses).forEach(time -> System.out.print(time + " "));
                }

                System.out.println();
            }
        });
            }

    }




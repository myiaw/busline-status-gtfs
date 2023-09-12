package org.example;

import org.example.*;

import java.io.FileNotFoundException;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.Map;

import static org.example.Parser.ParseRoutes;
import static org.example.Parser.ParseStops;

public class Main {




    public static void main(String[] args) throws FileNotFoundException {
//        if (args.length != 3) {
//            System.out.println("Invalid arguments");
//            System.exit(1);
//        }

//        int stationId = Integer.parseInt(args[0]);
//        int numOfBuses = Integer.parseInt(args[1]);
//        String timeFormat = args[2];
        int stationId = 3;
        int numOfBuses = 5;
        String timeFormat = "absolute";



        getData(stationId, numOfBuses, timeFormat);
    }

    private static void getData(int stationId, int numOfBuses, String timeFormat) {
        Map<Integer,Stop> stops = ParseStops();
        Map<Integer,Route> routes = ParseRoutes();
        List<StopTime> stopTimes = Parser.ParseStopTimes();
        Map<String, Trip> trips = Parser.ParseTrips();

        Stop stop = stops.get(stationId);
        if (stop != null) {
            System.out.println("Postajalisce: " + stop.getStopName());
        } else {
            System.out.println("Not Found!");
        }

        // Filter to match stationId and within 2h.
        List<StopTime> filteredStopTimes = stopTimes.stream()
                .filter(stopTime -> stopTime.getStopId() == stationId)
                .filter(StopTime::isWithinTwoHours)
                .collect(Collectors.toList());


        List<StopTime> sortedTimes = filteredStopTimes.stream()
                .sorted(Comparator.comparing(StopTime::getArrivalTime))
                .collect(Collectors.toList());

//


        }
    }


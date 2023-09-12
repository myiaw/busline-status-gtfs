package org.example;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collection;
import java.util.List;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import static org.example.Parser.ParseRoutes;
import static org.example.Parser.ParseStops;


public class Main {
    private static void getData(){
        List<Stop> stops = ParseStops();
        List<Route> routes = ParseRoutes();
        List<StopTime> stopTimes = Parser.ParseStopTimes();
        List<Trip> trips = Parser.ParseTrips();

        for(Stop stop : stops) {
            System.out.println("STOP" + stop.getStopId());
        }

        for(Route route : routes) {
            System.out.println("ROUTE" + route.getRouteId());
        }
        for(StopTime stopTime : stopTimes) {
            System.out.println("STOPTIME TRIP ID: " + stopTime.getTripId());
            System.out.println("STOPTIME STOP ID: " +stopTime.getStopId());
            System.out.println("STOPTIME ARRIVAL TIME: " + stopTime.getArrivalTime());
        }
        for(Trip trip : trips) {
            System.out.println("TRIP ID" + trip.getTripId());
            System.out.println("TRIP ROUTE ID" + trip.getRouteId());
        }
        int count = 0;
        for(StopTime stopTime : stopTimes) {
                if(stopTime.isWithinTwoHours() && stopTime.getStopId() == 1 && count < 5) {
                    count++;
                    System.out.println("")
                }
            }
        }





    }




    public static void main(String[] args) throws FileNotFoundException {
    getData();




    }


}
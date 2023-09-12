package org.example;


import com.opencsv.bean.CsvToBeanBuilder;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collection;
import java.util.List;




public class Main {

    private static void getData() throws FileNotFoundException{
        String stopTimesPath = "src/main/resources/stop_times.txt";
        String stopsPath = "src/main/resources/stops.txt";
        String tripsPath = "src/main/resources/trips.txt";
        String routesPath = "src/main/resources/routes.txt";

        List<Stop> stops = new CsvToBeanBuilder<Stop>(new FileReader(stopsPath))
                .withType(Stop.class)
                .build()
                .parse();

        List<Route> routes = new CsvToBeanBuilder<Route>(new FileReader(routesPath))
                .withType(Route.class)
                .build()
                .parse();

        List<Trip> trips = new CsvToBeanBuilder<Trip>(new FileReader(tripsPath))
                .withType(Trip.class)
                .build()
                .parse();

        List<StopTime> stopTimes = new CsvToBeanBuilder<StopTime>(new FileReader(stopTimesPath))
                .withType(StopTime.class)
                .build()
                .parse();
    }




    public static void main(String[] args) throws FileNotFoundException {

        if (args.length != 3) {
            System.out.println("Invalid");
            System.exit(1);
        }
        String id = args[0];
        String busNum = args[1];
        String type = args[2];
        System.out.println("id: " + id + " busNum: " + busNum + " type: " + type);
        getData();







    }


}
package org.example;

public class Trip implements java.io.Serializable {
    private final int route_id;
    private final String trip_id;

    // Constructor for parsing the trips.txt file
    // This way I can use final variables and not have to use getters/setters.
    public Trip(String route_id,String trip_id) {
        this.route_id = Integer.parseInt(route_id);
        this.trip_id = trip_id;
    }

    public int getRouteId() {
        return route_id;
    }
    public String getTripId() {
        return trip_id;
    }

    @Override
    public String toString() {
        return "Trip{" +
                "route_id=" + route_id +
                ", trip_id='" + trip_id + '\'' +
                '}';
    }
}

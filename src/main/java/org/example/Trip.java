package org.example;

public class Trip implements java.io.Serializable {
    private int route_id;
    private String trip_id;

    //    private int service_id;
    //    private String trip_headsign;
    //    private String trip_short_name;
    //    private int direction_id;
    //    private String block_id;
    //    private int shape_id;
    //    private Integer wheelchair_accessible;
    //    private Integer bikes_allowed;
    //    private String duty;
    //    private int duty_sequence_number;
    //    private int run_sequence_number;
    public Trip() {}

    public int getRouteId() {
        return route_id;
    }
    public void setRouteId(int route_id) {
        this.route_id = route_id;
    }
    public void setTripId(String trip_id) {
        this.trip_id = trip_id;
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

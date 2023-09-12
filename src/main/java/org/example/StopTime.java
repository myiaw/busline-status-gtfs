package org.example;

public class StopTime implements java.io.Serializable{

    private String trip_id;
    private String arrival_time; // Maybe date format?
    private String departure_time; // Maybe date format?
    private int stop_id;
    private int stop_sequence;
    private String stop_headsign;

    // No data for these fields
    private String pickup_type;
    private String drop_off_type;
    private String shape_dist_traveled;
    private String timepoint;

    public StopTime() {}

    @Override
    public String toString() {
        return "StopTime{" +
                "trip_id='" + trip_id + '\'' +
                ", arrival_time='" + arrival_time + '\'' +
                ", departure_time='" + departure_time + '\'' +
                ", stop_id=" + stop_id +
                ", stop_sequence=" + stop_sequence +
                ", stop_headsign='" + stop_headsign + '\'' +
                ", pickup_type='" + pickup_type + '\'' +
                ", drop_off_type='" + drop_off_type + '\'' +
                ", shape_dist_traveled='" + shape_dist_traveled + '\'' +
                ", timepoint='" + timepoint + '\'' +
                '}';
    }
}

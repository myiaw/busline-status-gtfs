package org.example;

public class Trip implements java.io.Serializable {
    private int route_id;
    private int service_id;
    private String trip_id;
    private String trip_headsign;
    private String trip_short_name;
    private int direction_id;
    private String block_id;
    private int shape_id;
    private Integer wheelchair_accessible;
    private Integer bikes_allowed;
    private String duty;
    private int duty_sequence_number;
    private int run_sequence_number;
    public Trip() {}

    @Override
    public String toString() {
        return "Trip{" +
                "route_id=" + route_id +
                ", service_id=" + service_id +
                ", trip_id='" + trip_id + '\'' +
                ", trip_headsign='" + trip_headsign + '\'' +
                ", trip_short_name='" + trip_short_name + '\'' +
                ", direction_id=" + direction_id +
                ", block_id='" + block_id + '\'' +
                ", shape_id=" + shape_id +
                ", wheelchair_accessible=" + wheelchair_accessible +
                ", bikes_allowed=" + bikes_allowed +
                ", duty='" + duty + '\'' +
                ", duty_sequence_number=" + duty_sequence_number +
                ", run_sequence_number=" + run_sequence_number +
                '}';
    }
}

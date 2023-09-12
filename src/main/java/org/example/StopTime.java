package org.example;

import java.time.LocalTime;

public class StopTime implements java.io.Serializable{

    private String trip_id;
    private LocalTime arrival_time;
    private int stop_id;


    public StopTime() {}

    public String getTripId() {
        return trip_id;
    }
    public void setTripId(String trip_id) {
        this.trip_id = trip_id;
    }
    public LocalTime getArrivalTime() {
        return arrival_time;
    }
    public void setArrivalTime(String arrival_time) {
        this.arrival_time = LocalTime.parse(arrival_time);
    }
    public void setStopId (int stop_id) {
        this.stop_id = stop_id;
    }
    public int getStopId() {
        return stop_id;
    }


    @Override
    public String toString() {
        return "StopTime{" +
                "trip_id='" + trip_id + '\'' +
                ", arrival_time=" + arrival_time +
                ", stop_id=" + stop_id +
                '}';
    }

    public boolean isWithinTwoHours() {
        LocalTime now = LocalTime.now();
        LocalTime twoHours = now.plusHours(2);
        return !arrival_time.isBefore(now) && !arrival_time.isAfter(twoHours);
    }

}

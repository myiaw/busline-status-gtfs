package org.example;

import java.time.LocalTime;

public class StopTime implements java.io.Serializable{

    private String trip_id;
    private LocalTime arrival_time;
    private int stopTime_id;


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
    public void setStopTimeId (int stop_id) {
        this.stopTime_id = stop_id;
    }
    public int getStopId() {
        return stopTime_id;
    }


    @Override
    public String toString() {
        return "StopTime{" +
                "trip_id='" + trip_id + '\'' +
                ", arrival_time=" + arrival_time +
                ", stop_id=" + stopTime_id +
                '}';
    }

    public boolean isWithinTwoHours() {
        LocalTime now = LocalTime.now();
        LocalTime twoHours = now.plusHours(2);
        return !arrival_time.isBefore(now) && !arrival_time.isAfter(twoHours);
    }

}

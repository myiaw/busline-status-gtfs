package org.example;

import java.time.LocalTime;

public class StopTime implements java.io.Serializable{

    private final String trip_id;
    private final LocalTime arrival_time;
    private final int stopTime_id;


    public StopTime(String trip_id, String arrival_time, String stopTime_id) {
        this.trip_id = trip_id;
        this.arrival_time = LocalTime.parse(arrival_time);
        this.stopTime_id = Integer.parseInt(stopTime_id);
    }


    public String getTripId() {
        return trip_id;
    }
    public LocalTime getArrivalTime() {
        return arrival_time;
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
        LocalTime now = LocalTime.now().minusHours(4);
        LocalTime twoHours = now.plusHours(2);
        return !arrival_time.isBefore(now) && !arrival_time.isAfter(twoHours);
    }

}

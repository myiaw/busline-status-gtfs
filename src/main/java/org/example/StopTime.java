package org.example;

import java.time.LocalTime;

final public class StopTime {

    private final String trip_id;
    private final LocalTime arrival_time;
    private final int stop_id;


    public StopTime(String trip_id, String arrival_time, String stop_id) {
        this.trip_id = trip_id;
        this.arrival_time = LocalTime.parse(arrival_time);
        this.stop_id = Integer.parseInt(stop_id);
    }


    public String getTripId() {
        return trip_id;
    }
    public LocalTime getArrivalTime() {
        return arrival_time;
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

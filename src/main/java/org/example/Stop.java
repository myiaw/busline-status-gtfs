package org.example;



// Integer on values that are null, maybe getters/setters if needed.
final public class Stop {
    private final int stopId;
    private final String stopName;

    // Constructor for parsing the stop.txt file, this way I can use final variable
    public Stop(String stopId, String stopName) {
        this.stopId = Integer.parseInt(String.valueOf(stopId));
        this.stopName = stopName;
    }
    public int getStopId() {return stopId;}
    public String getStopName() {return stopName;}

    @Override
    public String toString() {
        return "Stop{" +
                "stopId=" + stopId +
                ", stopName='" + stopName + '\'' +
                '}';
    }
}

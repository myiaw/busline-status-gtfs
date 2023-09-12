package org.example;



// Integer on values that are null, maybe getters/setters if needed.
public class Stop implements java.io.Serializable {
    private int stopId;
    private String stopName;


    // Default constructor
    public Stop() {}


    public void setStopId(int stopId) {
        this.stopId = stopId;
    }

    public int getStopId() {return stopId;}
    public String getStopName() {return stopName;}

    public void setStopName(String stopName) {
        this.stopName = stopName;
    }


    @Override
    public String toString() {
        return "Stop{" +
                "stopId=" + stopId +
                ", stopName='" + stopName + '\'' +
                '}';
    }
}

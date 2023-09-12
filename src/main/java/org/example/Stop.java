package org.example;



// Integer on values that are null, maybe getters/setters if needed.
public class Stop implements java.io.Serializable {
    private int stopId;

    private String stopCode;

    private String stopName;

    private String stopDesc;

    private double stopLat;
    private double stopLon;

    private Integer zoneId;

    private String stopUrl;

    private Integer locationType;


    private Integer parentStation;

    private String stopTimezone;

    private Integer wheelchairBoarding;

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
                ", stopCode='" + stopCode + '\'' +
                ", stopName='" + stopName + '\'' +
                ", stopDesc='" + stopDesc + '\'' +
                ", stopLat=" + stopLat +
                ", stopLon=" + stopLon +
                ", zoneId=" + zoneId +
                ", stopUrl='" + stopUrl + '\'' +
                ", locationType=" + locationType +
                ", parentStation=" + parentStation +
                ", stopTimezone='" + stopTimezone + '\'' +
                ", wheelchairBoarding=" + wheelchairBoarding +
                '}';
    }
}

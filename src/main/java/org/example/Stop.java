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

    public int getStopId() {
        return stopId;
    }

    public void setStopId(int stopId) {
        this.stopId = stopId;
    }

    public String getStopCode() {
        return stopCode;
    }

    public void setStopCode(String stopCode) {
        this.stopCode = stopCode;
    }

    public String getStopName() {
        return stopName;
    }

    public void setStopName(String stopName) {
        this.stopName = stopName;
    }

    public String getStopDesc() {
        return stopDesc;
    }

    public void setStopDesc(String stopDesc) {
        this.stopDesc = stopDesc;
    }

    public double getStopLat() {
        return stopLat;
    }

    public void setStopLat(double stopLat) {
        this.stopLat = stopLat;
    }

    public double getStopLon() {
        return stopLon;
    }

    public void setStopLon(double stopLon) {
        this.stopLon = stopLon;
    }

    public Integer getZoneId() {
        return zoneId;
    }

    public void setZoneId(Integer zoneId) {
        this.zoneId = zoneId;
    }

    public String getStopUrl() {
        return stopUrl;
    }

    public void setStopUrl(String stopUrl) {
        this.stopUrl = stopUrl;
    }

    public Integer getLocationType() {
        return locationType;
    }

    public void setLocationType(Integer locationType) {
        this.locationType = locationType;
    }

    public Integer getParentStation() {
        return parentStation;
    }

    public void setParentStation(Integer parentStation) {
        this.parentStation = parentStation;
    }

    public String getStopTimezone() {
        return stopTimezone;
    }

    public void setStopTimezone(String stopTimezone) {
        this.stopTimezone = stopTimezone;
    }

    public Integer getWheelchairBoarding() {
        return wheelchairBoarding;
    }

    public void setWheelchairBoarding(Integer wheelchairBoarding) {
        this.wheelchairBoarding = wheelchairBoarding;
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

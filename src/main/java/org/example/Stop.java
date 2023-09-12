package org.example;


// Integer on values that are null, maybe getters/setters if needed.
public class Stop implements java.io.Serializable {
    private int stop_id;
    private String stop_code;
    private String stop_name;
    private String stop_desc;
    private double stop_lat;
    private double stop_lon;
    private Integer zone_id;
    private String stop_url;
    private Integer location_type;
    private Integer parent_station;
    private String stop_timezone;
    private Integer wheelchair_boarding;

    // Default constructor
    public Stop() {}

    @Override
    public String toString() {
        return "Stop{" +
                "stop_id=" + stop_id +
                ", stop_code='" + stop_code + '\'' +
                ", stop_name='" + stop_name + '\'' +
                ", stop_desc='" + stop_desc + '\'' +
                ", stop_lat=" + stop_lat +
                ", stop_lon=" + stop_lon +
                ", zone_id=" + zone_id +
                ", stop_url='" + stop_url + '\'' +
                ", location_type=" + location_type +
                ", parent_station=" + parent_station +
                ", stop_timezone='" + stop_timezone + '\'' +
                ", wheelchair_boarding=" + wheelchair_boarding +
                '}';
    }
}

package org.example;

public class Route implements java.io.Serializable {
    private int route_id;
    private String agency_id;
    private String route_short_name;
    private String route_long_name;
    private String route_desc;
    private int route_type;
    private String route_url;
    private String route_color;
    private String route_text_color;

    // Default constructor
    public Route() {}

    public int getRouteId() {
        return route_id;
    }
    public void setRouteId(int route_id) {
        this.route_id = route_id;
    }
    @Override
    public String toString() {
        return "Route{" +
                "route_id='" + route_id + '\'' +
                ", agency_id='" + agency_id + '\'' +
                ", route_short_name='" + route_short_name + '\'' +
                ", route_long_name='" + route_long_name + '\'' +
                ", route_desc='" + route_desc + '\'' +
                ", route_type=" + route_type +
                ", route_url='" + route_url + '\'' +
                ", route_color='" + route_color + '\'' +
                ", route_text_color='" + route_text_color + '\'' +
                '}';
    }
}

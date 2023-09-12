package org.example;

public class Route implements java.io.Serializable {
    private int route_id;

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
                "route_id=" + route_id +
                '}';
    }
}

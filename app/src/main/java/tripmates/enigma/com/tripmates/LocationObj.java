package tripmates.enigma.com.tripmates;

import android.graphics.drawable.Drawable;

/**
 * Created by dnish on 11/29/2016.
 */

public class LocationObj {
    private String locName;
    private LocType type;
    private int rating;
    int openHrs;
    int closeHrs;
    int locImage;
    String description = null;
    int crowdDensity;
    public double getDist() {
        return dist;
    }

    public void setDist(double dist) {
        this.dist = dist;
    }

    Double lat,lon;

    //temporary distance
    double dist;

    public LocationObj(String locName, int locImage, LocType type, int rating, int openHrs, int closeHrs, double lat, double lon, int crowdDensity, double distance) {
        this.locName = locName;
        this.locImage = locImage;
        this.type = type;
        this.rating = rating;
        this.closeHrs = closeHrs;
        this.openHrs = openHrs;
        this.lat = lat;
        this.lon = lon;
        this.crowdDensity = crowdDensity;
        this.dist = distance;
    }

    public double getDistance() {
        return dist;
    }
    public int getCrowdDensity() {
        return crowdDensity;
    }

    public int getLocImage() {
        return locImage;
    }

    public Double getLat() {
        return lat;
    }

    public Double getLon() {
        return lon;
    }

    public void setLocImage(int locImage) {
        this.locImage = locImage;
    }

    public String getLocName() {
        return locName;
    }

    public void setLocName(String locName) {
        this.locName = locName;
    }

    public LocType getType() {
        return type;
    }

    public void setType(LocType type) {
        this.type = type;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public int getOpenHrs() {
        return openHrs;
    }

    public void setOpenHrs(int openHrs) {
        this.openHrs = openHrs;
    }

    public int getCloseHrs() {
        return closeHrs;
    }

    public void setCloseHrs(int closeHrs) {
        this.closeHrs = closeHrs;
    }


}

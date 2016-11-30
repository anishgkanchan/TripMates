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
    public double getDist() {
        return dist;
    }

    public void setDist(double dist) {
        this.dist = dist;
    }

    //temporary distance
    double dist;

    public LocationObj(String locName, int locImage, LocType type, int rating, int openHrs, int closeHrs, double dist) {
        this.locName = locName;
        this.locImage = locImage;
        this.type = type;
        this.rating = rating;
        this.closeHrs = closeHrs;
        this.openHrs = openHrs;
        this.dist = dist;
    }

    public int getLocImage() {
        return locImage;
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

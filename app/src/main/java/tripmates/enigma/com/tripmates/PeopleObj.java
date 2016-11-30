package tripmates.enigma.com.tripmates;

import java.util.List;

/**
 * Created by dnish on 11/29/2016.
 */
public class PeopleObj {
    String name;
    Integer lat,lon;

    public int getUserImage() {
        return userImage;
    }

    public void setUserImage(int userImage) {
        this.userImage = userImage;
    }

    int userImage;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    int age;
    //temporary
    double distance;


    public PeopleObj(String name, Integer lat, Integer lon, double distance, int usrImage,int age) {
        this.name = name;
        this.lat = lat;
        this.lon = lon;
        this.distance = distance;
        this.userImage = usrImage;
        this.age = age;
    }


    List<LocationObj> interested;
    List<String> testimonials;
    boolean likeUser;

    public boolean isLikeUser() {
        return likeUser;
    }

    public void setLikeUser(boolean likeUser) {
        this.likeUser = likeUser;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<LocationObj> getInterested() {
        return interested;
    }

    public void setInterested(List<LocationObj> interested) {
        this.interested = interested;
    }

    public Integer getLat() {
        return lat;
    }

    public void setLat(Integer lat) {
        this.lat = lat;
    }

    public Integer getLon() {
        return lon;
    }

    public void setLon(Integer lon) {
        this.lon = lon;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

}

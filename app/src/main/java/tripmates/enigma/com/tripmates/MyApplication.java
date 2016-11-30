package tripmates.enigma.com.tripmates;

import android.app.Application;

import com.google.android.gms.plus.People;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dnish on 11/29/2016.
 */
public class MyApplication extends Application {
    private static MyApplication application ;
    static List<LocationObj> placeList = new ArrayList<LocationObj>();
    static List<PeopleObj> peopleList = new ArrayList<PeopleObj>();
    public static String profileImg = null;
    @Override
    public void onCreate() {
        super.onCreate();
        application = this;
        //location data
        LocationObj l = new LocationObj("Panda Express",R.drawable.foodmarker,LocType.RESTAURANT,3,10,20,0.1);
        placeList.add(l);
        l = new LocationObj("California African-American Museum",R.drawable.add_person,LocType.MUSEUM, 5, 9, 18, 0.3);
        placeList.add(l);
        l = new LocationObj("Sports Museum of LA",R.drawable.add_person,LocType.MUSEUM, 5, 9, 18, 0.4);
        placeList.add(l);
        l = new LocationObj("Starbucks",R.drawable.foodmarker,LocType.RESTAURANT,4,8,24,0.5);
        placeList.add(l);
        l = new LocationObj("Fisher Museum of Arts ",R.drawable.add_person,LocType.MUSEUM, 4, 9, 17, 0.9);
        placeList.add(l);
        l = new LocationObj("Pasta Roma",R.drawable.foodmarker,LocType.RESTAURANT,3,9,22,1.3);
        placeList.add(l);
        l = new LocationObj("Natural History Museum ",R.drawable.nhmuseum,LocType.MUSEUM, 5, 9, 17, 1.4);
        placeList.add(l);
        l.description = "Natural History Museum of Los Angeles County. NHM has amassed one of the world's most extensive and valuable collections of natural and cultural history - more than 35 million objects, some as old as 4.5 billion years.";
        l = new LocationObj("Grinder",R.drawable.foodmarker,LocType.RESTAURANT,2,10,22,1.6);
        placeList.add(l);
        l = new LocationObj("Exposition Rose Garden",R.drawable.parkmarker,LocType.PARK, 4, 8, 17, 2.3);
        placeList.add(l);
        l = new LocationObj("Hawaiin BBQ ",R.drawable.foodmarker,LocType.RESTAURANT,3,11,22,2.9);
        placeList.add(l);
        l = new LocationObj("Hoover Recreational Center",R.drawable.parkmarker,LocType.PARK, 3, 8, 18, 3.1);
        placeList.add(l);
        l = new LocationObj("Elysian Hike",R.drawable.trekmarker,LocType.HIKE, 4, 7, 17, 4.3);
        placeList.add(l);
        l = new LocationObj("Jeese Brewer Jr Park",R.drawable.parkmarker, LocType.PARK, 4, 9, 17, 4.8);
        placeList.add(l);
        l = new LocationObj("Richardson Family Park",R.drawable.parkmarker, LocType.PARK, 3, 8, 18, 5.5);
        placeList.add(l);
        l = new LocationObj("Griffith Park",R.drawable.trekmarker,LocType.HIKE, 5, 7, 22, 5.9);
        placeList.add(l);
        l = new LocationObj("Santa Monica",R.drawable.beachmarker,LocType.BEACH,5, 11, 19,7.2);
        placeList.add(l);
        l = new LocationObj("Hollywood Sign",R.drawable.trekmarker,LocType.HIKE, 5, 7, 17, 7.6);
        placeList.add(l);
        l = new LocationObj("Venice Beach",R.drawable.beachmarker,LocType.BEACH,4, 9, 19,8.9);
        placeList.add(l);
        l = new LocationObj("Ascot Hills Park",R.drawable.trekmarker,LocType.HIKE, 3, 7, 17, 10.3);
        placeList.add(l);
        l = new LocationObj("Marina Beach",R.drawable.beachmarker,LocType.BEACH,5, 11, 19,12.3);
        placeList.add(l);
        l = new LocationObj("Topanga Beach",R.drawable.beachmarker,LocType.BEACH,3, 11, 19,14.8);
        placeList.add(l);

        //people data
        PeopleObj p = new PeopleObj("John Hetherman",null,null,4.20, R.drawable.add_person,21);
        peopleList.add(p);
        p = new PeopleObj("William Travis",null,null,4.70, R.drawable.add_person,28);
        peopleList.add(p);
        p = new PeopleObj("Robin Taylor",null,null,5.20, R.drawable.add_person,33);
        peopleList.add(p);
        p = new PeopleObj("Ravi Bajpai",null,null,1.80, R.drawable.add_person,17);
        peopleList.add(p);
        p = new PeopleObj("Kiley Moore",null,null,3.50, R.drawable.add_person,21);
        peopleList.add(p);
        p = new PeopleObj("Ireene Soo",null,null,0.90, R.drawable.add_person,19);
        peopleList.add(p);
        p = new PeopleObj("John Hetherman",null,null,2.70, R.drawable.add_person, 20);
        peopleList.add(p);
        p = new PeopleObj("Jason Texado",null,null,1.10, R.drawable.add_person,23);
        peopleList.add(p);
        p = new PeopleObj("Ricky Wally",null,null,7.30, R.drawable.add_person, 25);
        peopleList.add(p);


    }

    public static MyApplication getInstance(){
        return application;
    }


}

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
    public static List<LocationObj> placeList = new ArrayList<LocationObj>();
    static List<PeopleObj> peopleList = new ArrayList<PeopleObj>();
    public static String profileImg = null;
    @Override
    public void onCreate() {
        super.onCreate();
        application = this;
        //location data
        LocationObj l = new LocationObj("Panda Express",R.drawable.foodmarker,LocType.RESTAURANT,3,10,20,34.024318, -118.294820);
        placeList.add(l);
        l = new LocationObj("California African-American Museum",R.drawable.museummarker,LocType.MUSEUM, 5, 9, 18, 34.0219394,-118.2822027);
        placeList.add(l);
        l = new LocationObj("Sports Museum of LA",R.drawable.museummarker,LocType.MUSEUM, 5, 9, 18, 34.0201964,-118.2858617);
        placeList.add(l);
        l = new LocationObj("Starbucks",R.drawable.foodmarker,LocType.RESTAURANT,4,8,24,34.027305, -118.283962);
        placeList.add(l);
        l = new LocationObj("Fisher Museum of Arts ",R.drawable.museummarker,LocType.MUSEUM, 4, 9, 17, 34.024211, -118.273834);
        placeList.add(l);
        l = new LocationObj("Pasta Roma",R.drawable.foodmarker,LocType.RESTAURANT,3,9,22,34.011903, -118.277697);
        placeList.add(l);
        l = new LocationObj("Natural History Museum ",R.drawable.nhmuseum,LocType.MUSEUM, 5, 9, 17, 34.034169, -118.284263);
        placeList.add(l);
        l.description = "Natural History Museum of Los Angeles County. NHM has amassed one of the world's most extensive and valuable collections of natural and cultural history - more than 35 million objects, some as old as 4.5 billion years.";
        l = new LocationObj("Grinder",R.drawable.foodmarker,LocType.RESTAURANT,2,10,22,34.032711, 118.298682);
        placeList.add(l);
        l = new LocationObj("Exposition Rose Garden",R.drawable.parkmarker,LocType.PARK, 4, 8, 17, 34.025029, -118.306192);
        placeList.add(l);
        l = new LocationObj("Hawaiin BBQ ",R.drawable.foodmarker,LocType.RESTAURANT,3,11,22,34.012295,-118.306579);
        placeList.add(l);
        l = new LocationObj("Hoover Recreational Center",R.drawable.parkmarker,LocType.PARK, 3, 8, 18, 34.006247, -118.302630);
        placeList.add(l);
        l = new LocationObj("Elysian Hike",R.drawable.trekmarker,LocType.HIKE, 4, 7, 17, 34.004543, -118.304066);
        placeList.add(l);
        l = new LocationObj("Jeese Brewer Jr Park",R.drawable.parkmarker, LocType.PARK, 4, 9, 17, 33.994595, -118.299415);
        placeList.add(l);
        l = new LocationObj("Richardson Family Park",R.drawable.parkmarker, LocType.PARK, 3, 8, 18, 33.990929, -118.284716);
        placeList.add(l);
        l = new LocationObj("Griffith Park",R.drawable.trekmarker,LocType.HIKE, 5, 7, 22, 34.150092, -118.286131);
        placeList.add(l);
        l = new LocationObj("Santa Monica",R.drawable.beachmarker,LocType.BEACH,5, 11, 19,34.010731, -118.500676);
        placeList.add(l);
        l = new LocationObj("Hollywood Sign",R.drawable.trekmarker,LocType.HIKE, 5, 7, 17, 34.133204, -118.315605);
        placeList.add(l);
        l = new LocationObj("Venice Beach",R.drawable.beachmarker,LocType.BEACH,4, 9, 19,33.923700, -118.431231);
        placeList.add(l);
        l = new LocationObj("Ascot Hills Park",R.drawable.trekmarker,LocType.HIKE, 3, 7, 17, 34.053095, -118.441814);
        placeList.add(l);
        l = new LocationObj("Marina Beach",R.drawable.beachmarker,LocType.BEACH,5, 11, 19,33.838682, -118.389668);
        placeList.add(l);
        l = new LocationObj("Topanga Beach",R.drawable.beachmarker,LocType.BEACH,3, 11, 19,34.038066, -118.617147);
        placeList.add(l);

        //people data
        PeopleObj p = new PeopleObj("John Hetherman",null,null,4.20, R.drawable.prof2,21);
        peopleList.add(p);
        p = new PeopleObj("William Travis",null,null,4.70, R.drawable.pro8,28);
        peopleList.add(p);
        p = new PeopleObj("Robin Taylor",null,null,5.20, R.drawable.prof4,33);
        peopleList.add(p);
        p = new PeopleObj("Ravi Bajpai",null,null,1.80, R.drawable.prof3,17);
        peopleList.add(p);
        p = new PeopleObj("Kiley Moore",null,null,3.50, R.drawable.prof8,21);
        peopleList.add(p);
        p = new PeopleObj("Ireene Soo",null,null,0.90, R.drawable.prof1,19);
        peopleList.add(p);
        p = new PeopleObj("John Hetherman",null,null,2.70, R.drawable.prof6, 20);
        peopleList.add(p);
        p = new PeopleObj("Jason Texado",null,null,1.10, R.drawable.prof7,23);
        peopleList.add(p);
        p = new PeopleObj("Ricky Wally",null,null,7.30, R.drawable.prof5, 25);
        peopleList.add(p);


    }

    public static MyApplication getInstance(){
        return application;
    }


}

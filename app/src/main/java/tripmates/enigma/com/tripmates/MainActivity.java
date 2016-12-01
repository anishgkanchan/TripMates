package tripmates.enigma.com.tripmates;

import android.Manifest;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomSheetBehavior;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;


import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.Circle;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends FragmentActivity implements OnMapReadyCallback, LocationListener {

    private GoogleMap mMap;
    private ImageView imgSwap, imgFilter, imgProfile, imgHistory, imgInfo, imgInterested;
    boolean flag = true;
    private MainActivity mActivity;
    private BottomSheetBehavior behavior;
    private Marker currentMarker;
    private int filter = 0;
    Circle circle;
    MyApplication application;
    List<LocationObj> a;
    BlankFragment fragmentInstance = null;
    static double lat, lon;
    LocationObj selectedLoc = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);


        application = (MyApplication)getApplicationContext();
        a = application.placeList;
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
        Log.i("", "---------- onCreate");
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = new SupportMapFragment();

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.map, mapFragment);
        fragmentTransaction.commit();

        mapFragment.getMapAsync(this);
        mActivity = this;
        imgSwap = (ImageView)findViewById(R.id.imgSwap);
        imgProfile = (ImageView) findViewById(R.id.imgProfile);
        imgHistory = (ImageView) findViewById(R.id.imgHistory);
        imgInfo = (ImageView) findViewById(R.id.imgInfo);
        imgInterested = (ImageView) findViewById(R.id.imgInterested);
        imgInterested.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(application.interestedLocations.contains(selectedLoc.getLocName())) {
                    application.interestedLocations.remove(selectedLoc.getLocName());
                    imgInterested.setImageResource(R.drawable.heart);
                }
                else {
                    application.interestedLocations.add(selectedLoc.getLocName());

                    imgInterested.setImageResource(R.drawable.heart_golden);//setBackgroundResource(R.drawable.heart_golden);
                }
            }
        });
        imgInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mActivity, DetailActivity.class);
                intent.putExtra("name",selectedLoc.getLocName());
                intent.putExtra("distance",selectedLoc.getDist());
                startActivity(intent);
            }
        });

        imgHistory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, HistoryActivity.class);
                startActivity(i);
            }
        });

        imgProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, EditProfile.class);
                startActivity(i);
            }
        });

        imgSwap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (behavior.getState() == BottomSheetBehavior.STATE_EXPANDED) {
                    behavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
                }
                if (flag) {

                    FragmentManager fragmentManager = getSupportFragmentManager();
                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                    fragmentInstance = BlankFragment.newInstance("", "");
                    fragmentTransaction.replace(R.id.map, fragmentInstance);
                    flag = false;
                    fragmentTransaction.commit();
                } else {
                    fragmentInstance = null;
                    FragmentManager fragmentManager = getSupportFragmentManager();
                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                    SupportMapFragment mapFragment = new SupportMapFragment();
                    fragmentTransaction.replace(R.id.map, mapFragment);
                    flag = true;
                    fragmentTransaction.commit();
                    mapFragment.getMapAsync(mActivity);
                    updateMarkers();
                }
            }
        });

        imgFilter = (ImageView)findViewById(R.id.imgFilter);

        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.select_dialog_singlechoice);
        adapter.add("All");
        adapter.add("Restaurants");
        adapter.add("Beaches");
        adapter.add("Parks");
        adapter.add("Hikes");
        adapter.add("Museums");
        final AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Choose a filter");
        builder.setSingleChoiceItems(adapter, filter, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int item) {
                filter = item;
                a = new ArrayList<LocationObj>();
                for(LocationObj obj:application.placeList){
                    if (filter==0) {
                        a.add(obj);
                    } else if (filter == 1 && obj.getType()==LocType.RESTAURANT) {
                        a.add(obj);
                    } else if (filter == 2 && obj.getType()==LocType.BEACH) {
                        a.add(obj);
                    } else if (filter == 3 && obj.getType()==LocType.PARK) {
                        a.add(obj);
                    } else if (filter == 4 && obj.getType()==LocType.HIKE) {
                        a.add(obj);
                    } else if (filter == 5 && obj.getType()==LocType.MUSEUM) {
                        a.add(obj);
                    }
                }
                if(flag)
                    updateMarkers();
                else {
                    fragmentInstance.listAdapter = new LocationListAdapter(fragmentInstance.updateList(a), mActivity);
                    fragmentInstance.listView.setAdapter(fragmentInstance.listAdapter);
                    fragmentInstance.listAdapter.notifyDataSetChanged();
                    Log.d("Testing","---------- control reached here");
                }
                dialog.dismiss();
            }
        });
        final Dialog dialog = builder.create();
        imgFilter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.show();
            }
        });
      //  FragmentManager fragmentManager = getSupportFragmentManager();
      //  FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
      //  fragmentTransaction.replace(R.id.map, new SupportMapFragment());
      //  fragmentTransaction.commit();


        View bottomSheet = findViewById(R.id.design_bottom_sheet);
        behavior = BottomSheetBehavior.from(bottomSheet);
        behavior.setBottomSheetCallback(new BottomSheetBehavior.BottomSheetCallback() {
            @Override
            public void onStateChanged(@NonNull View bottomSheet, int newState) {
                if (newState == BottomSheetBehavior.STATE_COLLAPSED) {
                    circle.remove();
                }
                if(newState == BottomSheetBehavior.STATE_EXPANDED) {
                    if(application.interestedLocations.contains(selectedLoc.getLocName()))
                        imgInterested.setImageResource(R.drawable.heart_golden);
                    else
                        imgInterested.setImageResource(R.drawable.heart);
                }
            }

            @Override
            public void onSlide(@NonNull View bottomSheet, float slideOffset) {
            }
        });
        bottomSheet.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return true;
            }
        });


    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {

        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED
                && ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            return;
        }
        mMap = googleMap;

        mMap.setMyLocationEnabled(true);
        LocationManager locationManager = (LocationManager) getSystemService(LOCATION_SERVICE);
        Criteria criteria = new Criteria();
        String bestProvider = locationManager.getBestProvider(criteria, true);

        Location location = locationManager.getLastKnownLocation(bestProvider);
        if (location != null) {
            onLocationChanged(location);
        }
        locationManager.requestLocationUpdates(bestProvider, 20000, 0, this);


        updateMarkers();


/*
        mMap.addMarker(new MarkerOptions()
                .position(new LatLng(34.0212409, -118.2891549))
                .title("Seeley G Mudd Building")
                .snippet("Our place of study and work")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.beachmarker)));

        mMap.addMarker(new MarkerOptions()
                .position(new LatLng(34.0206579,-118.28207))
                .title("Leavey Library")
                .snippet("USC's largest library")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.trekmarker)));

        mMap.addMarker(new MarkerOptions()
                .position(new LatLng(34.0209185,-118.2877258))
                .title("Bovard Auditorium")
                .snippet("Auditorium for special occasions")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.parkmarker)));

        mMap.addMarker(new MarkerOptions()
                .position(new LatLng(34.0243718,-118.2905299))
                .title("Lyon Centre")
                .snippet("The place where Trojans sweat themselves")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.foodmarker)));

        mMap.addMarker(new MarkerOptions()
                .position(new LatLng(34.0272172, -118.2913882))
                .title("Manas Restaurant")
                .snippet("Best place to try out Indian cuisine near USC")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.beachmarker)));

*/

        mMap.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {
            @Override
            public boolean onMarkerClick(Marker marker) {

                ((TextView)findViewById(R.id.bottomsheet_text)).setText(marker.getTitle());
                if (behavior.getState() == BottomSheetBehavior.STATE_COLLAPSED) {
                    behavior.setState(BottomSheetBehavior.STATE_EXPANDED);

                }

                for (LocationObj obj:a){
                    if (marker.getTitle().equals(obj.getLocName()))
                    {
                        ((RatingBar) findViewById(R.id.ratingBar)).setNumStars(obj.getRating());
                      //  ((TextView) findViewById(R.id.txtHoursValue)).setText(obj.getOpenHrs() + "");
                        ((TextView) findViewById(R.id.txtTypeValue)).setText(obj.getType().toString());
                        selectedLoc = obj;
                        break;
                    }
                }
                if(circle!=null)
                    circle.remove();
                int color = -1;
                if (selectedLoc.getCrowdDensity()==1)
                    color = 0x5500FF00;
                else if (selectedLoc.getCrowdDensity()==2)
                    color = 0x55FFFF00;
                else
                    color = 0x55FF0000;

                circle = mMap.addCircle(new CircleOptions()
                        .center(marker.getPosition())
                        .radius(100)
                        .strokeWidth(0f)
                        .fillColor(color));
                return true;
            }
        });
    }

    void updateMarkers() {
        mMap.clear();
        for (LocationObj obj: a) {

            int image = -1;
            if (obj.getType()==LocType.BEACH)
                image = R.drawable.beachmarker;
            else if (obj.getType()==LocType.MUSEUM)
                image = R.drawable.museummarker;
            else if (obj.getType()==LocType.RESTAURANT)
                image = R.drawable.foodmarker;
            else if (obj.getType()==LocType.PARK)
                image = R.drawable.parkmarker;
            else if (obj.getType()==LocType.HIKE)
                image = R.drawable.trekmarker;
            mMap.addMarker(new MarkerOptions()
                    .position(new LatLng(obj.getLat(), obj.getLon()))
                    .title(obj.getLocName())
                    .icon(BitmapDescriptorFactory.fromResource(image)));

        }
    }
    @Override
    public void onLocationChanged(Location location) {
        Log.i("","---------- onLocationChanged");
      //  TextView locationTv = (TextView) findViewById(R.id.latlongLocation);
        lat = location.getLatitude();
        lon = location.getLongitude();
        LatLng latLng = new LatLng(lat, lon);
        /*
        if(currentMarker==null) {
            currentMarker = mMap.addMarker(new MarkerOptions().position(latLng));
        }
        else {
            currentMarker.setPosition(latLng);
        }
        */
        mMap.moveCamera(CameraUpdateFactory.newLatLng(latLng));
        mMap.animateCamera(CameraUpdateFactory.zoomTo(15));
      //  locationTv.setText("Latitude:" + latitude + ", Longitude:" + longitude);

    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {

    }

    @Override
    public void onProviderEnabled(String provider) {

    }

    @Override
    public void onProviderDisabled(String provider) {

    }
}

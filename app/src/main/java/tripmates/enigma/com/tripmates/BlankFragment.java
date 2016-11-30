package tripmates.enigma.com.tripmates;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.List;


public class BlankFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    MyApplication application;
    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private Activity mActivity;
    LocationListAdapter listAdapter;
    LocationData[] locationDatas;
    ListView listView;
    public BlankFragment() {

    }

    public static BlankFragment newInstance(String param1, String param2) {
        BlankFragment fragment = new BlankFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mActivity = getActivity();
        application = (MyApplication)getActivity().getApplicationContext();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_blank, container, false);
        List<LocationObj> locs = ((MainActivity)getActivity()).a;


        locationDatas = updateList(locs);

        listAdapter = new LocationListAdapter(locationDatas, mActivity);
        listView = (ListView) view.findViewById(R.id.location_list);
        listView.setAdapter(listAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(mActivity, DetailActivity.class);
                intent.putExtra("name",locationDatas[position].name);
                intent.putExtra("distance",locationDatas[position].distance);
                startActivity(intent);
            }
        });

        return view;
    }

    LocationData[] updateList( List<LocationObj> locs){
        LocationData[] locationDatas = new LocationData[locs.size()];
        for (int i = 0; i < locationDatas.length; i++) {
            locationDatas[i] = new LocationData();
            locationDatas[i].name = locs.get(i).getLocName();
            locationDatas[i].distance = (float)locs.get(i).getDist();
            int image = 0;
            if(locs.get(i).getType() == LocType.BEACH)
                image = R.drawable.beachmarker;
            else if(locs.get(i).getType() == LocType.RESTAURANT)
                image = R.drawable.foodmarker;
            else if(locs.get(i).getType() == LocType.HIKE)
                image = R.drawable.trekmarker;
            else if(locs.get(i).getType() == LocType.MUSEUM)
                image = R.drawable.museummarker;
            else if(locs.get(i).getType() == LocType.PARK)
                image = R.drawable.parkmarker;
            locationDatas[i].img =  BitmapFactory.decodeResource(getResources(), image);
        }
        return locationDatas;
    }

}

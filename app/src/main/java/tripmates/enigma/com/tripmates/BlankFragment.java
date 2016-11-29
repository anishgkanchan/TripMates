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


public class BlankFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private Activity mActivity;
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
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_blank, container, false);
        final LocationData[] locationDatas = new LocationData[10];
        String names[] = new String[]{"Venice Canals", "Santa Monica Pier","Hollywood Walk of Fame", "Natural History Museum", "Gryffith Observatory", "Hollywood Sign", "LACMA", "Old Bookstore", "USC Campus", "Colosseum"};

        for (int i = 0; i < locationDatas.length; i++) {
            locationDatas[i] = new LocationData();
            locationDatas[i].name = names[i];
            locationDatas[i].distance = (float)(Math.random()%3);
            locationDatas[i].img =  BitmapFactory.decodeResource(getResources(), R.drawable.location_logo);
        }
        LocationListAdapter listAdapter = new LocationListAdapter(locationDatas, mActivity);
        ListView listView = (ListView) view.findViewById(R.id.location_list);
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


}

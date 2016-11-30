package tripmates.enigma.com.tripmates;

import android.app.Activity;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.provider.Contacts;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.List;

public class FindFriendsActivity extends Activity {
    MyApplication application;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_friends);
        application = (MyApplication)getApplicationContext();
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("TripMates");
        toolbar.setBackgroundColor(getResources().getColor(R.color.appcolor));
        List<PeopleObj> peopleList = application.peopleList;
        ListView list = (ListView) findViewById(R.id.list);
        PersonDetails [] personDetails = new PersonDetails[peopleList.size()];
        for (int i = 0; i < personDetails.length; i++) {
            personDetails[i] = new PersonDetails();
            personDetails[i].personName = peopleList.get(i).getName();
            personDetails[i].personDist = peopleList.get(i).getDistance();
            personDetails[i].personImage =  BitmapFactory.decodeResource(getResources(), peopleList.get(i).getUserImage());
        }
        PeopleListAdapter listAdapter = new PeopleListAdapter(personDetails, this);
        list.setAdapter(listAdapter);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i =new Intent(FindFriendsActivity.this, PeopleProfileActivity.class);
                i.putExtra("position",position);
                startActivity(i);
            }
        });
    }
}

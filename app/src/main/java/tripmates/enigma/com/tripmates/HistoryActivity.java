package tripmates.enigma.com.tripmates;

import android.content.Intent;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.List;

public class HistoryActivity extends AppCompatActivity {
    MyApplication application;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);
        application = (MyApplication)getApplicationContext();
        List<PeopleObj> peopleList = application.peopleList;
        ListView list = (ListView) findViewById(R.id.list);
        PersonDetails [] personDetails = new PersonDetails[2];
        personDetails[0] = new PersonDetails();
        personDetails[0].personName = peopleList.get(3).getName();
        personDetails[0].desc ="You matched for a trip to Griffith Park";
        personDetails[0].personImage =  BitmapFactory.decodeResource(getResources(), peopleList.get(3).getUserImage());
        personDetails[1] = new PersonDetails();
        personDetails[1].personName = peopleList.get(4).getName();
        personDetails[1].desc ="You matched for a trip to Venice Beach";
        personDetails[1].personImage =  BitmapFactory.decodeResource(getResources(), peopleList.get(4).getUserImage());
        HistoryListAdapter listAdapter = new HistoryListAdapter(personDetails, this);
        list.setAdapter(listAdapter);
    }
}

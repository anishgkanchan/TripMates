package tripmates.enigma.com.tripmates;

import android.app.Activity;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.provider.Contacts;
import android.support.v7.widget.Toolbar;
import android.widget.ListView;

import java.util.List;

public class FindFriendsActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_friends);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("TripMates");
        toolbar.setBackgroundColor(getResources().getColor(R.color.appcolor));

        ListView list = (ListView) findViewById(R.id.list);
        PersonDetails [] personDetails = new PersonDetails[10];
        String names[] = new String[] {"Chris Martin", "Genelia D'souza", "Uma Thurman", "Mellisandre", "Slash", "Farhan Akhtar", "Micromax", "Wonder Woman", "Jackie", "Emma"};
        for (int i = 0; i < personDetails.length; i++) {
            personDetails[i] = new PersonDetails();
            personDetails[i].personName = names[i];
            personDetails[i].personDist = (float)Math.random()%5;
            personDetails[i].personImage =  BitmapFactory.decodeResource(getResources(), R.drawable.add_person);
        }
        PeopleListAdapter listAdapter = new PeopleListAdapter(personDetails, this);
        list.setAdapter(listAdapter);
    }
}

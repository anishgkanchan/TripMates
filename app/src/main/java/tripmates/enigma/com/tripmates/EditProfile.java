package tripmates.enigma.com.tripmates;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class EditProfile extends Activity {
    ListView lstInterested;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);
        lstInterested = (ListView) findViewById(R.id.list_interested);
        ArrayList<String> places = new ArrayList<String>();
        places.add("Jhumri Talaya");
        places.add("Bhatladevi");
        places.add("Bablipada");
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,places);
        lstInterested.setAdapter(adapter);
    }
}

package tripmates.enigma.com.tripmates;

import android.app.Activity;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class PeopleProfileActivity extends Activity {
    ListView lstTestimonials;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_people_profile);
        lstTestimonials = (ListView)findViewById(R.id.list_testionials);
        ArrayList<String> values = new ArrayList<String>();
        values.add("He is awesome");
        values.add("Roamed with him, fun to be around");
        values.add("Really funny, eats like a glutton though");
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,values);
        lstTestimonials.setAdapter(adapter);
    }

}

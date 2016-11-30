package tripmates.enigma.com.tripmates;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.makeramen.roundedimageview.RoundedImageView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class PeopleProfileActivity extends Activity {
    ListView lstTestimonials;
    MyApplication app;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_people_profile);
        app = (MyApplication) getApplicationContext();
        List<PeopleObj> people = app.peopleList;
        Intent i = getIntent();
        int pos = i.getIntExtra("position",0);
        lstTestimonials = (ListView)findViewById(R.id.list_testionials);
        ArrayList<String> values = new ArrayList<String>();
        PeopleObj person = people.get(pos);
        RoundedImageView img = (RoundedImageView) findViewById(R.id.img_person);
        img.setImageResource(person.getUserImage());
        TextView txtName = (TextView) findViewById(R.id.name_age);
        txtName.setText(person.getName()+", "+person.getAge());
        values.add("He is awesome");
        values.add("Roamed with him, fun to be around");
        values.add("Really funny, eats like a glutton though");
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,values);
        lstTestimonials.setAdapter(adapter);
    }

}

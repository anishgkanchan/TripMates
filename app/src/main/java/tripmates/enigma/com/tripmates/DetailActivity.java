package tripmates.enigma.com.tripmates;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class DetailActivity extends Activity {
    Context mContext;
    MyApplication application;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        application = (MyApplication)getApplicationContext();
        mContext = this;
        setContentView(R.layout.activity_detail);
        Intent i = getIntent();
        String name = i.getStringExtra("name");
        float dist = i.getFloatExtra("distance",999.9f);
        List<LocationObj> places = application.placeList;
        LocationObj currPlace = null;
        for(LocationObj l: places) {
            if (name.equals(l.getLocName())) {
                currPlace = l;
                break;
            }
        }
        ImageView image = (ImageView)findViewById(R.id.img_detail);
        image.setImageResource(currPlace.getLocImage());
        TextView txtName = (TextView) findViewById(R.id.txt_name);
        TextView txtDist = (TextView) findViewById(R.id.txt_dist);
        TextView txtTiming = (TextView) findViewById(R.id.timings);
        TextView txtDesc = (TextView) findViewById(R.id.desc);
        Resources res = getResources();
        txtTiming.setText(String.format(res.getString(R.string.timing),getTime(currPlace.getOpenHrs()),getTime(currPlace.getCloseHrs())));
        txtName.setText(name);
        txtDist.setText(dist+" miles");
        if(currPlace.description!=null)
            txtDesc.setText(currPlace.description);
        Button btnFind = (Button) findViewById(R.id.btn_find_friends);
        btnFind.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, FindFriendsActivity.class);
                startActivity(intent);
            }
        });
    }

    public String getTime(int a){
        if(a==12)
            return "12:00 pm";
        if(a==24)
            return "00:00 am";
        if(a<12)
            return a+":00 am";
        else
            return (a-12)+":00 pm";

    }
}

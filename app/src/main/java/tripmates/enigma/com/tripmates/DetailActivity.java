package tripmates.enigma.com.tripmates;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailActivity extends Activity {
    Context mContext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = this;
        setContentView(R.layout.activity_detail);
        Intent i = getIntent();
        String name = i.getStringExtra("name");
        float dist = i.getFloatExtra("distance",999.9f);
        ImageView image = (ImageView)findViewById(R.id.img_detail);
        image.setImageResource(R.drawable.location_logo);
        TextView txtName = (TextView) findViewById(R.id.txt_name);
        TextView txtDist = (TextView) findViewById(R.id.txt_dist);
        txtName.setText(name);
        txtDist.setText(dist+" miles");
        Button btnFind = (Button) findViewById(R.id.btn_find_friends);
        btnFind.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, FindFriendsActivity.class);
                startActivity(intent);
            }
        });
    }

}

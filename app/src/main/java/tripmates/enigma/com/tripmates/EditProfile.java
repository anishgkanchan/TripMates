package tripmates.enigma.com.tripmates;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;

import com.makeramen.roundedimageview.RoundedImageView;

import java.util.ArrayList;

public class EditProfile extends Activity {
    ListView lstInterested;
    ImageView btnaddImage;
    RoundedImageView profileImg;
    static final int RESULT_LOAD_IMAGE = 91;
    MyApplication app;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);
        lstInterested = (ListView) findViewById(R.id.list_interested);
        app = (MyApplication)getApplicationContext();
        btnaddImage = (ImageView)findViewById(R.id.btn_add_image);
        profileImg = (RoundedImageView) findViewById(R.id.img_profile);
        if(app.profileImg!=null)
            profileImg.setImageBitmap(BitmapFactory.decodeFile(app.profileImg));
        btnaddImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(intent, RESULT_LOAD_IMAGE);
            }
        });


        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,app.interestedLocations);
        lstInterested.setAdapter(adapter);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == RESULT_LOAD_IMAGE && resultCode == RESULT_OK && null != data) {
            Uri selectedImage = data.getData();
            String[] filePathColumn = { MediaStore.Images.Media.DATA };
            Cursor cursor = getContentResolver().query(selectedImage,filePathColumn, null, null, null);
            cursor.moveToFirst();
            int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
            String picturePath = cursor.getString(columnIndex);
            app.profileImg = picturePath;
            cursor.close();
            profileImg.setImageBitmap(BitmapFactory.decodeFile(picturePath));
        }
    }
}

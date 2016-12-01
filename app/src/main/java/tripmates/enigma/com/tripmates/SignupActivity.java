package tripmates.enigma.com.tripmates;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.makeramen.roundedimageview.RoundedImageView;

public class SignupActivity extends Activity {
    ImageView btnaddImage;
    RoundedImageView profileImg;
    MyApplication application;
    Context context;
    static final int RESULT_LOAD_IMAGE = 91;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = this;
        application = (MyApplication) getApplicationContext();
        setContentView(R.layout.activity_signup);
        btnaddImage = (ImageView)findViewById(R.id.btn_add_image);
        profileImg = (RoundedImageView) findViewById(R.id.imgProfile);
        if(application.profileImg!=null)
            profileImg.setImageBitmap(BitmapFactory.decodeFile(application.profileImg));
        btnaddImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(intent, RESULT_LOAD_IMAGE);
         }
        });
        Button registerButton = (Button)findViewById(R.id.btn_register);
        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
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
            application.profileImg = picturePath;
            cursor.close();
            profileImg.setImageBitmap(BitmapFactory.decodeFile(picturePath));
        }
    }
}

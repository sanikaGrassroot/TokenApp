package com.example.tokenapp.project.UserManagement;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.content.FileProvider;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.tokenapp.R;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static android.app.PendingIntent.getActivity;
import static com.example.tokenapp.R.drawable.ic_token_logo;
import static com.example.tokenapp.R.string.currentPhotoPath;


public class ProfileActivity extends AppCompatActivity {

    private static final int SELECT_FILE = 2;
    private static final int REQUEST_IMAGE_CAPTURE = 3;
    private static final String TAG ="Profile Activity" ;
    TextView name, email, phone, company_name, company_id;
    ImageView photo;
    Toolbar toolbar;
    ActionBar actionBar;
    FloatingActionButton floatingActionButton;
    String userChosenTask;
    String currentPhotoPath;
    SharedPreferences pref;
    SharedPreferences.Editor editor;
    public static final String path = "keyPhoto";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        // setting the UP button
        toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle(R.string.profile);
        setSupportActionBar(toolbar);
        actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        name = findViewById(R.id.nameTextView);
        email = findViewById(R.id.emailTextView);
        phone = findViewById(R.id.phoneTextView);
        company_name = findViewById(R.id.companyTextView);
        company_id = findViewById(R.id.companyIDTextView);
        photo = findViewById(R.id.userPhoto);
        floatingActionButton = findViewById(R.id.fabImage);
        pref = getApplicationContext().getSharedPreferences("MyPref", 0);

        if(pref.contains(path)){
            Glide.with(ProfileActivity.this).load(pref.getString(path,"")).fitCenter().into(photo);
        }else {
           photo.setImageResource(ic_token_logo);
        }

        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODO:add photo from gallery or camera
                selectImage();

            }
        });


    }

    private void selectImage() {
        final CharSequence[] items = { "Take Photo", "Choose from Library",
                "Cancel" };
        AlertDialog.Builder builder = new AlertDialog.Builder(ProfileActivity.this);
        builder.setTitle("Add Photo!");
        builder.setItems(items, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int item) {
                boolean result=Utility.checkPermission(ProfileActivity.this);
                if (items[item].equals("Take Photo")) {
                    userChosenTask="Take Photo";
                    if(result)
                        cameraIntent();
                } else if (items[item].equals("Choose from Library")) {
                    userChosenTask="Choose from Library";
                    if(result)
                        galleryIntent();
                } else if (items[item].equals("Cancel")) {
                    dialog.dismiss();
                }
            }
        });
        builder.show();
    }

    private void galleryIntent() {
        Intent intent = new   Intent(Intent.ACTION_PICK,android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(intent, SELECT_FILE);
    }

    private void cameraIntent() {
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
            File photoFile=null;
            try {
                photoFile=createImageFile();
            }catch (Exception e){
                Log.e(TAG, "cameraIntent: ",e );
            }

            if (photoFile!=null){
                Uri photoUri= FileProvider.getUriForFile(ProfileActivity.this,"com.example.tokenapp.fileprovider",photoFile);
               takePictureIntent.putExtra(MediaStore.EXTRA_OUTPUT, photoUri);
                startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
            }
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {

           /* Bitmap bitmap = BitmapFactory.decodeFile(currentPhotoPath, null);
            photo.setImageBitmap(bitmap);*/
            Glide.with(ProfileActivity.this).load(currentPhotoPath).fitCenter().into(photo);

        } else if (requestCode==SELECT_FILE && resultCode==RESULT_OK){
            Uri selectedImage = data.getData();
            currentPhotoPath= String.valueOf(selectedImage);
            Glide.with(this).load(currentPhotoPath).into(photo);

            /*Cursor c = getContentResolver().query(selectedImage,filePath, null, null, null);
            c.moveToFirst();
            int columnIndex = c.getColumnIndex(filePath[0]);
            String picturePath = c.getString(columnIndex);
            c.close();
            Bitmap thumbnail = (BitmapFactory.decodeFile(picturePath));
            photo.setImageBitmap(thumbnail);*/
        }
    }

    private File createImageFile() throws IOException {
        // Create an image file name
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String imageFileName = "JPEG_" + timeStamp + "_";
        File storageDir = getExternalFilesDir(Environment.DIRECTORY_PICTURES);
        File image = File.createTempFile(
                imageFileName,  /* prefix */
                ".jpg",         /* suffix */
                storageDir      /* directory */
        );

        // Save a file: path for use with ACTION_VIEW intents
        currentPhotoPath = image.getAbsolutePath();
        return image;
    }

    @Override
    protected void onStop() {
        super.onStop();

        editor = pref.edit();
        editor.putString(path,currentPhotoPath);
        editor.apply();
    }
}

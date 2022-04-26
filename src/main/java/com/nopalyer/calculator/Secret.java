package com.nopalyer.calculator;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.squareup.picasso.Picasso;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.LocalDate;

public class Secret extends AppCompatActivity {
private Button BackFromSecret;
private Button PhoneBook;



    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secret);
    }


    public void BackToMenu(View view) {
        BackFromSecret = (Button)findViewById(R.id.button);
        Intent intent=new Intent(Secret.this,MainActivity.class);
        startActivity(intent);
    }

    public void OpenPhoneBook(View view) {
        PhoneBook = (Button)findViewById(R.id.button2);
        Intent intent=new Intent(Secret.this,PhoneBook.class);
        startActivity(intent);
    }

    public void OpenPictures(View view) {
    Intent intent=new Intent(Secret.this,Main2Activity.class);
    startActivity(intent);
    }

    public void OpenPass(View view) {
        Intent intent=new Intent(Secret.this,Pass.class);
        startActivity(intent);
    }
}

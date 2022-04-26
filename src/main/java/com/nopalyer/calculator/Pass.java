package com.nopalyer.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Pass extends AppCompatActivity {
    EditText ed;
    DatabaseHelper MyDb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pass);
        MyDb=new DatabaseHelper(this);
        ed=(EditText)findViewById(R.id.editText3);


    }

    public void BackToMenu(View view) {
        Intent intent = new Intent(Pass.this, Secret.class);
        startActivity(intent);

    }

    public void Change112(View view) {
        ed=(EditText)findViewById(R.id.editText3);
        Log.d("TAG", ed.getText().toString());
        MyDb.DeletePass();
        MyDb.InsertPass(ed.getText().toString()+".0");
        Toast.makeText(getApplicationContext(), "The Pass Change !!",Toast.LENGTH_SHORT).show();


    }
}

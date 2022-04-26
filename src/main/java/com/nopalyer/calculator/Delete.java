package com.nopalyer.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Delete extends AppCompatActivity {
    DatabaseHelper MyDb;
    EditText editText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        MyDb=new DatabaseHelper(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete);
    }

    public void DeleteCon(View view)
    {
        editText=findViewById(R.id.editText);

        if(MyDb.CheckExsist(editText.getText().toString())) {
            MyDb.Delete(editText.getText().toString());
            Toast.makeText(getApplicationContext(), "Delete successfully!!!", Toast.LENGTH_SHORT).show();
        }
        else
            Toast.makeText(getApplicationContext(), "Bad name", Toast.LENGTH_SHORT).show();
    }
    public void BackToPhoneBook(View view) {
        Intent intent=new Intent(Delete.this,PhoneBook.class);
        startActivity(intent);
    }
}

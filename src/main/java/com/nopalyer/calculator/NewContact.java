package com.nopalyer.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class NewContact extends AppCompatActivity {
EditText Name;
EditText Phone;
DatabaseHelper MyDb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_contact);
        MyDb=new DatabaseHelper(this);
    }

    public void MakeNewContact(View view) {
        Name=(EditText) findViewById(R.id.editText);
        Phone=(EditText) findViewById(R.id.editText2);
        if(Phone.getText().length()==10&&Phone.getText().toString().startsWith("05")) {
            MyDb.InsertNum(Phone.getText().toString(), Name.getText().toString());
            Toast.makeText(getApplicationContext(), "Update successfully!!!", Toast.LENGTH_SHORT).show();
        }
        else if(Phone.getText().length()!=10&&Phone.getText().toString().startsWith("05"))
            Toast.makeText(getApplicationContext(), "The number must be 10 digits",Toast.LENGTH_SHORT).show();
        else
            Toast.makeText(getApplicationContext(), "Bad number",Toast.LENGTH_SHORT).show();
    }

    public void BackToPhoneBook(View view) {
        Intent intent=new Intent(NewContact.this,PhoneBook.class);
        startActivity(intent);
    }
}

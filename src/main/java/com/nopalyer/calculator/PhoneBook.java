package com.nopalyer.calculator;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class PhoneBook extends AppCompatActivity {

    DatabaseHelper myDB;
    Button Ncontact;
    Button Back;
    Button call;
    Button delete;
    TextView tv;
    TextView tv1;
    String str2 = "Name\n\n";
    String str = "Number\n\n";



    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phone_book);
        myDB = new DatabaseHelper(this);
        ArrayList<String> Names = new ArrayList<>(myDB.pull("Name"));
        ArrayList<String> Nums = new ArrayList<>(myDB.pull("Phone"));
        ArrayList<String> Cons=new ArrayList<>();
        for(int i=0;i<Names.size();i++)
        {
          Cons.add(Names.get(i));
          Cons.add(Nums.get(i));
        }
        ArrayAdapter<String> adapterNames=new ArrayAdapter<String>(
                this, android.R.layout.simple_list_item_1, Names){

            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                View view =super.getView(position, convertView, parent);

                TextView textView=(TextView) view.findViewById(android.R.id.text1);

                /*YOUR CHOICE OF COLOR*/
                textView.setTextColor(Color.WHITE);

                return view;
            }
        };
        GridView gridView=(GridView)findViewById(R.id.gridi);
        gridView.setAdapter(adapterNames);

        ArrayAdapter<String> adapterNums=new ArrayAdapter<String>(
                this, android.R.layout.simple_list_item_1, Nums){

            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                View view =super.getView(position, convertView, parent);

                TextView textView=(TextView) view.findViewById(android.R.id.text1);

                /*YOUR CHOICE OF COLOR*/
                textView.setTextColor(Color.WHITE);

                return view;
            }
        };

        //ArrayAdapter<String> itemsAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, Nums);
        ListView listView = (ListView) findViewById(R.id.lvitems);
        listView.setAdapter(adapterNums);
       listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
           @Override
           public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

               Intent callIntent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+parent.getItemAtPosition(position)));
               startActivity(callIntent);
           }
       });





        }

    public void MakeNewContact(View view) {
        Ncontact = (Button) findViewById(R.id.button5);
        Intent intent = new Intent(PhoneBook.this, NewContact.class);
        startActivity(intent);

    }

    public void BackToSecret(View view) {
        Back = (Button) findViewById(R.id.button3);
        Intent intent = new Intent(PhoneBook.this, Secret.class);
        startActivity(intent);
    }


    public void Delete(View view) {
        Intent intent = new Intent(PhoneBook.this, Delete.class);
        startActivity(intent);

    }
}

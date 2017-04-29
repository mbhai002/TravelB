package com.example.mohamed.travelb;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import static com.example.mohamed.travelb.R.id.btnRemove;
import static com.example.mohamed.travelb.R.id.imageView;











import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class ContactDtails extends AppCompatActivity {

    ImageView imageView;
    TextView tx_name, tx_username, tx_destination,tx_date,tx_dob,tx_gender;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_dtails);


        final Button remove = (Button) findViewById(R.id.btnRemove);

            imageView=(ImageView) findViewById(R.id.image);
            tx_name=(TextView) findViewById(R.id.name);
            tx_destination=(TextView) findViewById(R.id.destination);
            tx_username=(TextView) findViewById(R.id.username);
        tx_date=(TextView) findViewById(R.id.date);
        tx_dob=(TextView) findViewById(R.id.dob);
        tx_gender=(TextView) findViewById(R.id.gender);




        imageView.setImageResource(getIntent().getIntExtra("img_id",00));
            tx_name.setText("Hi, my name is "+getIntent().getStringExtra("name"));
            tx_username.setText(getIntent().getStringExtra("username"));
            tx_destination.setText("Iwould like to travel in "+getIntent().getStringExtra("destination"));
        tx_date.setText("around "+getIntent().getStringExtra("date"));
        tx_dob.setText("I was born on "+getIntent().getStringExtra("dob"));
        tx_gender.setText(getIntent().getStringExtra("gender"));



        remove.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent registerIntent = new Intent(ContactDtails.this, send_message.class);
                registerIntent.putExtra("username",getIntent().getStringExtra("username"));
                registerIntent.putExtra("my_id",getIntent().getStringExtra("my_id"));
                registerIntent.putExtra("user_id",getIntent().getStringExtra("user_id"));
                ContactDtails.this.startActivity(registerIntent);
            }
        });



/*
        btnRemove.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {

                Intent messaging = new Intent(ContactDtails.this, send_message.class);
              //  messaging.putExtra("my_id",my_id);
                //messaging.putExtra("id_contact",user_id);
                ContactDtails.this.startActivity(messaging);
            }
        });*/


    }
}

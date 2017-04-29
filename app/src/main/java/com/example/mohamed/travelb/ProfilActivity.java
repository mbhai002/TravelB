package com.example.mohamed.travelb;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class ProfilActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profil);

        final EditText etUsername= (EditText) findViewById(R.id.etUsername);
        final EditText etUser= (EditText) findViewById(R.id.etName);
        final Spinner etGender= (Spinner) findViewById(R.id.gSpinner);
        final EditText etDob= (EditText) findViewById(R.id.etDob);
        final EditText etEmail= (EditText) findViewById(R.id.email);
        final Button btnupdate = (Button) findViewById(R.id.update);


        Intent intenti= getIntent();
        String username = intenti.getStringExtra("username");
        String name = intenti.getStringExtra("name");
        String dob = intenti.getStringExtra("dob");
        String gender = intenti.getStringExtra("gender");
        String email = intenti.getStringExtra("email");

        final String user_id=intenti.getStringExtra("user_id");
        final String u=intenti.getStringExtra("username");
        final String n=intenti.getStringExtra("name");
        final String d=intenti.getStringExtra("dob");
        final String em=intenti.getStringExtra("email");
        final String g=intenti.getStringExtra("gender");


        etUsername.setText(username);
        etUser.setText(name);
        etGender.setTag(gender);
        etDob.setText(dob);
        etEmail.setText(email);



        btnupdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 final String id= user_id;
                 String us= etUsername.getText().toString();
                 String na= etUser.getText().toString();
                 String dateob= etDob.getText().toString();
                 String gen= etGender.getAdapter().toString();
                 String email= etEmail.getText().toString();






                Response.Listener<String> responseListener= new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonResponse = new JSONObject(response);

                            Toast.makeText(ProfilActivity.this,"profile updated", Toast.LENGTH_LONG).show();

                            ProfilActivity.this.finish();


                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                };

                updateREQ sr = new updateREQ(id,us,na,dateob,email,responseListener);
                RequestQueue queue = Volley.newRequestQueue(ProfilActivity.this);
                queue.add(sr);
            }
        });


    }
}

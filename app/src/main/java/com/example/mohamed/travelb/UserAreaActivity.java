

package com.example.mohamed.travelb;

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

public class UserAreaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_area);


        final ImageView bProfil = (ImageView) findViewById(R.id.bProfil);
        final ImageView bSearch = (ImageView) findViewById(R.id.bSearch);
        final ImageView bPlans = (ImageView) findViewById(R.id.bPlan);
        final ImageView bMessage = (ImageView) findViewById(R.id.bMessage);
        final Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        final int id = intent.getIntExtra("user_id", -1);
        Log.d("chicooooo",id+"");









        bSearch.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent registerIntent = new Intent(UserAreaActivity.this, SearchActivity.class);
                registerIntent.putExtra("my_id",id+"");
                UserAreaActivity.this.startActivity(registerIntent);
            }
        });








        bMessage.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent messageIntent = new Intent(UserAreaActivity.this, messageMenu.class);
                messageIntent.putExtra("user_id",id+"");
                Log.d("id userAreaActivity",id+"");
                UserAreaActivity.this.startActivity(messageIntent);
            }
        });
















        bProfil.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {
                Response.Listener<String> responseListener = new Response.Listener<String>() {
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonResponse = new JSONObject(response);
                            boolean success = jsonResponse.getBoolean("success");

                            if (success){
                                int user_id=jsonResponse.getInt("user_id");
                                String name = jsonResponse.getString("name");
                                String dob = jsonResponse.getString("dob");
                                String email = jsonResponse.getString("email");
                                String username=jsonResponse.getString("username");
                                String gender=jsonResponse.getString("gender");
                            Intent intenti = new Intent(UserAreaActivity.this, ProfilActivity.class);
                            intenti.putExtra("user_id", id+"");
                                intenti.putExtra("name",name);
                                intenti.putExtra("username",username);
                                intenti.putExtra("dob",dob);
                                intenti.putExtra("email",email);
                                intenti.putExtra("gender",gender);
                            UserAreaActivity.this.startActivity(intenti);}
                            else{
                                AlertDialog.Builder builder= new AlertDialog.Builder(UserAreaActivity.this);
                                builder.setMessage("failed")
                                        .setNegativeButton("retry",null)
                                        .create()
                                        .show();
                            }

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }


                };
                ProfileRequest profilRequest = new ProfileRequest(id, responseListener);
                RequestQueue queue = Volley.newRequestQueue(UserAreaActivity.this);
                queue.add(profilRequest);
            }
        });













        bPlans.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {
                Response.Listener<String> responseListener = new Response.Listener<String>() {
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonResponse = new JSONObject(response);
                            boolean success = jsonResponse.getBoolean("success");
                            if (success){
                                int user_id=jsonResponse.getInt("user_id");
                                //String password = jsonResponse.getString("password");
                                //String username=jsonResponse.getString("username");
                                Intent intent = new Intent(UserAreaActivity.this, PlansActivity.class);
                                intent.putExtra("user_id", id);
                                //intenti.putExtra("password",password);
                                //intenti.putExtra("username",username);
                                UserAreaActivity.this.startActivity(intent);}
                            else{
                                AlertDialog.Builder builder= new AlertDialog.Builder(UserAreaActivity.this);
                                builder.setMessage("failed")
                                        .setNegativeButton("retry",null)
                                        .create()
                                        .show();}} catch (JSONException e) {e.printStackTrace();}}};


                ProfileRequest profilRequest = new ProfileRequest(id, responseListener);
                RequestQueue queue = Volley.newRequestQueue(UserAreaActivity.this);
                queue.add(profilRequest);

            }});





    }
}








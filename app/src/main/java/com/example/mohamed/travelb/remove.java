package com.example.mohamed.travelb;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class remove extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_remove);

        final Intent intent = getIntent();
        final String date=intent.getStringExtra("date");
        final String destination=intent.getStringExtra("destination");
        final String plan_id=intent.getStringExtra("plan_id");
        final int user_id=intent.getIntExtra("user_id",00);




        final TextView etdate = (TextView) findViewById(R.id.name);
        final TextView etdestination = (TextView) findViewById(R.id.username);
        final Button remove = (Button) findViewById(R.id.btnRemove);

        etdate.setText(date);
        etdestination.setText(destination);




        remove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Response.Listener<String> responseListener= new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonResponse = new JSONObject(response);
                            Intent end = new Intent(remove.this, UserAreaActivity.class);
                            end.putExtra("user_id",user_id);
                            Log.d("user_id",user_id+"");



                            Toast.makeText(remove.this,"plan removed ", Toast.LENGTH_LONG).show();
                            //remove.this.finish();

                            remove.this.startActivity(end);



                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                };

                removeRequest sr = new removeRequest(plan_id,responseListener);
                RequestQueue queue = Volley.newRequestQueue(remove.this);
                queue.add(sr);
            }
        });



    }
}

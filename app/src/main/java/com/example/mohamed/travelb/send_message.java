package com.example.mohamed.travelb;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class send_message extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_message);
        final Intent intent = getIntent();
        final String name = intent.getStringExtra("username");
        final String my_id=intent.getStringExtra("my_id");
        final String contact_id=intent.getStringExtra("user_id");


        Log.d("my id",my_id);
        Log.d("contact_id",contact_id);


        final EditText etcontent = (EditText) findViewById(R.id.detail);
        final TextView welcomeMessage = (TextView) findViewById(R.id.tvWelcomeMsg);
        final Button btnSend = (Button) findViewById(R.id.btnSend);

        welcomeMessage.setText("To "+name+" ...");



        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String content= etcontent.getText().toString();

                Response.Listener<String> responseListener= new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonResponse = new JSONObject(response);

                            Toast.makeText(send_message.this,"message sent", Toast.LENGTH_LONG).show();

                            send_message.this.finish();


                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                };

                send_request sr = new send_request(content,my_id,contact_id,responseListener);
                RequestQueue queue = Volley.newRequestQueue(send_message.this);
                queue.add(sr);
            }
        });






    }
}

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

public class MessageDtails extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message_dtails);

        final TextView content = (TextView) findViewById(R.id.detail);
        final Button send= (Button) findViewById(R.id.btnSend);
        final EditText etcontent = (EditText) findViewById(R.id.newmess);



        final Intent intent= getIntent();
        String mess=intent.getStringExtra("content");
        final String my_id=intent.getStringExtra("myid");
        final String sender=intent.getStringExtra("sender");
        Log.d("myid",my_id+"");
        Log.d("senderid",sender+"");


        Log.d("message ", mess);

        content.setText(mess);



        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String content= etcontent.getText().toString();
                String idsender = my_id;
                String idreceiver= sender;

                Response.Listener<String> responseListener= new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonResponse = new JSONObject(response);

                            Toast.makeText(MessageDtails.this,"message sent", Toast.LENGTH_LONG).show();

                            MessageDtails.this.finish();


                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                };

                send_request sr = new send_request(content,idsender,idreceiver,responseListener);
                RequestQueue queue = Volley.newRequestQueue(MessageDtails.this);
                queue.add(sr);
            }
        });


    }
}

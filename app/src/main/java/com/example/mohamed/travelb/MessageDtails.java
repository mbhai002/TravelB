package com.example.mohamed.travelb;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;

public class MessageDtails extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message_dtails);

        final TextView content = (TextView) findViewById(R.id.detail);


        final Intent intent= getIntent();
        String mess=intent.getStringExtra("content");
        Log.d("message ", mess);

        content.setText(mess);



    }
}

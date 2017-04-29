
package com.example.mohamed.travelb;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class SearchActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);




        final EditText etDestination = (EditText) findViewById(R.id.etName);
        final Button bSearch = (Button) findViewById(R.id.bSearch);
        final Intent intent = getIntent();
        final String id = intent.getStringExtra("my_id");
        Log.d("chicooooo",id+"");

        bSearch.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {


                String destination = etDestination.getText().toString();



                Intent intent = new Intent(SearchActivity.this, foundSearch.class);
                intent.putExtra("my_id", id+"");
                intent.putExtra("destination", destination);
                SearchActivity.this.startActivity(intent);



            }
        });





    }
}

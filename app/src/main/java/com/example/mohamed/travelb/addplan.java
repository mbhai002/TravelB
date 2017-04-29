package com.example.mohamed.travelb;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Calendar;

public class addplan extends AppCompatActivity {

    private DatePicker datePicker;
    private Calendar calendar;
    private TextView dateView;
    private int year, month, day;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addplan);

String date;
       // final EditText etDate = (EditText) findViewById(R.id.date);
        final EditText etDestination = (EditText) findViewById(R.id.etName);

        final Button bRegister = (Button) findViewById(R.id.bRegister);

        final Intent intent = getIntent();

        final int id = intent.getIntExtra("user_id", -1);
        Log.d("chicooooo",id+"");


        dateView = (TextView) findViewById(R.id.textView3);
        calendar = Calendar.getInstance();
        year = calendar.get(Calendar.YEAR);

        month = calendar.get(Calendar.MONTH);
        day = calendar.get(Calendar.DAY_OF_MONTH);
        showDate(year, month+1, day);

        bRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String username= etDestination.getText().toString();
                final String date=dateView.getText().toString();
                final int user_id= id;

                Response.Listener<String> responseListener= new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonResponse = new JSONObject(response);





                                Intent intent = new Intent(addplan.this, UserAreaActivity.class);
                                intent.putExtra("user_id", user_id);
                                addplan.this.startActivity(intent);

                            addplan.this.finish();



                        } catch (JSONException e) {
                            e.printStackTrace();
                            Toast.makeText(addplan.this,"remove one plan", Toast.LENGTH_LONG).show();
                        }
                    }
                };

                addRequest arequest = new addRequest(username,date,user_id,responseListener);
                RequestQueue queue = Volley.newRequestQueue(addplan.this);
                queue.add(arequest);
            }
        });
    }


    @SuppressWarnings("deprecation")
    public void setDate(View view) {
        showDialog(999);

    }

    @Override
    protected Dialog onCreateDialog(int id) {
        // TODO Auto-generated method stub
        if (id == 999) {
            return new DatePickerDialog(this,
                    myDateListener, year, month, day);
        }
        return null;
    }

    private DatePickerDialog.OnDateSetListener myDateListener = new
            DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker arg0,
                                      int arg1, int arg2, int arg3) {
                    // TODO Auto-generated method stub
                    // arg1 = year
                    // arg2 = month
                    // arg3 = day
                    showDate(arg1, arg2+1, arg3);
                }
            };

    private void showDate(int year, int month, int day) {
        dateView.setText(new StringBuilder().append(year).append("-")
                .append(month).append("-").append(day));
    }


}
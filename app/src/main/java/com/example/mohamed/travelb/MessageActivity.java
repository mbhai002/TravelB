package com.example.mohamed.travelb;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.jar.Attributes;

public class MessageActivity extends AppCompatActivity {





    RecyclerView recyclerView;
    RecyclerView.Adapter adapter;
    RecyclerView.LayoutManager layoutManager;
    ArrayList<Message> list ;
    int image_id=R.drawable.a;
    String id;


    String GET_JSON_DATA_HTTP_URL = "http://travelb.000webhostapp.com/message.php";
    String JSON_ID = "user_id";
    String JSON_EMAIL = "email";
    String JSON_GENDER = "gender";
    String JSON_NAME="name";
    String JSON_DOB="dob";
    String JSON_PASSWORD="password";
    String JSON_USERNAME="username";
    String JSON_IDMESS="id_mess";
    String JSON_CONTENT="content";
    String JSON_SENDER="sender";
    String JSON_RECEIVER="receiver";
    String JSON_DATER="date";








    RequestQueue requestQueue ;

    String destination ;


    Map<String, String> params = new HashMap<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //final TextView mess= (TextView) findViewById(R.id.message);


        setContentView(R.layout.activity_found_search);
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);

        layoutManager=new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);





        final Intent intent = getIntent();


        list=new ArrayList<>();
        destination = intent.getStringExtra("destination");
        id = intent.getStringExtra("my_id");

        //Log.d("mohamed",destination);


        JSON_DATA_WEB_CALL();

        for(int i=0; i<list.size();i++){
            Log.d("list",list.get(i)+"");
        }



    }




    public void JSON_DATA_WEB_CALL(){

        params.put("user_id", id);

        StringRequest stringRequest = new StringRequest(Request.Method.POST, GET_JSON_DATA_HTTP_URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        // Display the first 500 characters of the response string.
                        JSONArray ja = null;
                        try {
                            ja = new JSONArray(response);
                            Log.d( "onResponse: ",ja+"");

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                        JSON_PARSE_DATA_AFTER_WEBCALL(ja);
                        Log.d("onResponse: ",list.size()+"");

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        }) { protected Map<String, String> getParams() {
            Map<String,String> params = new HashMap<String, String>();
            params.put("user_id",id);
            return params;
        }}
                ;




        requestQueue = Volley.newRequestQueue(this);

        requestQueue.add(stringRequest);
    }

    public void JSON_PARSE_DATA_AFTER_WEBCALL(JSONArray array){
        for(int i = 0; i<array.length(); i++) {
            Message contact = new Message(id);


            Log.d("JSON_P: ",i+"");
            JSONObject json=null ;
            try {
                json = array.getJSONObject(i);



                contact.setUser_id(json.getString(JSON_ID));
                contact.setEmail(json.getString(JSON_EMAIL));
                contact.setGender(json.getString(JSON_GENDER));
                contact.setName(json.getString(JSON_NAME));
                contact.setDob(json.getString(JSON_DOB));
                contact.setPassword(json.getString(JSON_PASSWORD));
                contact.setUsername(json.getString(JSON_USERNAME));
                contact.setIdmess(json.getString(JSON_IDMESS));
                contact.setContent(json.getString(JSON_CONTENT));
                contact.setSender(json.getString(JSON_SENDER));
                contact.setReceiver(json.getString(JSON_RECEIVER));
                contact.setDater(json.getString(JSON_DATER));


                // Log.d("JSON_PHONENUMBER",JSON_PHONE_NUMBER);




                String JSON_ID = "user_id";
                String JSON_EMAIL = "email";
                String JSON_GENDER = "gender";
                String JSON_NAME="name";
                String JSON_DOB="dob";
                String JSON_PASSWORD="password";
                String JSON_USERNAME="username";
                String JSON_IDMESS="id_mess";
                String JSON_CONTENT="content";
                String JSON_SENDER="sender";
                String JSON_RECEIVER="reveiver";
                String JSON_DATER="date";
                contact.setImage_id(R.drawable.a);




                list.add(contact);


                Log.d( "JSONAFTER_WEBCALL: ",list.get(i)+"");


            }
            catch (JSONException e) {

                e.printStackTrace();
                Log.d("R_WEBCALL: ",e+"");
            }
        }
        adapter=new messageAdapter(list,this);
        recyclerView.setAdapter(adapter);

    }
}

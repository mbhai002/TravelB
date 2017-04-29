package com.example.mohamed.travelb;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Button;
import android.widget.ProgressBar;

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

public class foundSearch extends AppCompatActivity {





    RecyclerView recyclerView;
    RecyclerView.Adapter adapter;
    RecyclerView.LayoutManager layoutManager;
    ArrayList<Contact> list ;
    int image_id=R.drawable.a;
    String id;


    String GET_JSON_DATA_HTTP_URL = "http://travelb.000webhostapp.com/found.php";
    String JSON_ID = "user_id";
    String JSON_DESTINATION = "destination";
    String JSON_DATE = "date";
    String JSON_PLANid = "plan_id";
    String JSON_DOB="dob";
    String JSON_GENDER="gender";
    String JSON_USERNAME="username";
    String JSON_NAME="name";



    RequestQueue requestQueue ;

    String destination ;


    Map<String, String> params = new HashMap<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



        setContentView(R.layout.activity_found_search);
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);

        layoutManager=new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);







        final Intent intent = getIntent();


        list=new ArrayList<>();
        destination = intent.getStringExtra("destination");
        id = intent.getStringExtra("my_id");

        Log.d("mohamed",destination);


        JSON_DATA_WEB_CALL();

        for(int i=0; i<list.size();i++){
            Log.d("list",list.get(i)+"");
        }



    }




    public void JSON_DATA_WEB_CALL(){

        params.put("destination", destination);

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
            params.put("destination", destination);
            params.put("user_id",id);
            return params;
        }}
                ;




        requestQueue = Volley.newRequestQueue(this);

        requestQueue.add(stringRequest);
    }

    public void JSON_PARSE_DATA_AFTER_WEBCALL(JSONArray array){
        for(int i = 0; i<array.length(); i++) {
            Contact contact = new Contact(id);


            Log.d("JSON_P: ",i+"");
            JSONObject json=null ;
            try {
                json = array.getJSONObject(i);



                contact.setName(json.getString(JSON_NAME));
                contact.setUsername(json.getString(JSON_USERNAME));
                contact.setDate(json.getString(JSON_DATE));
                contact.setPlan_id(json.getString(JSON_PLANid));
                contact.setDob(json.getString(JSON_DOB));
                contact.setDestination(json.getString(JSON_DESTINATION));
                contact.setUser_id(json.getString(JSON_ID));
                contact.setGender(json.getString(JSON_GENDER));
               // Log.d("JSON_PHONENUMBER",JSON_PHONE_NUMBER);


contact.setImage_id(R.drawable.a);

             /*   Log.d( "JSONAF name: ",contact.getName());
                Log.d( "JSONAFL phone: ",contact.getMobile());
                Log.d( "JSONAFL subject: ",contact.getEmail());
                Log.d( "JSONAFTER_WEBCALL id: ",contact.getImage_id()+"");*/



                list.add(contact);


                Log.d( "JSONAFTER_WEBCALL: ",list.get(i)+"");


            }
                catch (JSONException e) {

                e.printStackTrace();
                    Log.d("R_WEBCALL: ",e+"");
            }
        }
        adapter=new ContactAdapter(list,this);
        recyclerView.setAdapter(adapter);

    }
}

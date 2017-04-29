package com.example.mohamed.travelb;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static android.R.attr.id;

public class PlansActivity extends AppCompatActivity {


    ArrayList<GetDataAdapter> GetDataAdapter1;

    RecyclerView recyclerView;

    RecyclerView.LayoutManager recyclerViewlayoutManager;

    RecyclerView.Adapter recyclerViewadapter;

    ProgressBar progressBar;

    String GET_JSON_DATA_HTTP_URL = "http://travelb.000webhostapp.com/jsonData.php";
    String JSON_PLANID="plan_id";
    String JSON_ID = "user_id";
    String JSON_DESTINATION = "destination";
    String JSON_DATE = "date";

    Button badd;
    Button brem;

    PostJsonArrayRequest jsonArrayRequest ;


    RequestQueue requestQueue ;
    int id;







    Map<String, String> params = new HashMap<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        System.out.print("help");

        setContentView(R.layout.activity_plans);

        GetDataAdapter1 = new ArrayList<>();

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView1);

        progressBar = (ProgressBar) findViewById(R.id.progressBar1);

        badd = (Button)findViewById(R.id.badd) ;


        recyclerView.setHasFixedSize(false);

        recyclerViewlayoutManager = new LinearLayoutManager(this);

        recyclerView.setLayoutManager(recyclerViewlayoutManager);


        final Intent intent = getIntent();

         id = intent.getIntExtra("user_id", -1);
        Log.d("check id", id+"");



        JSON_DATA_WEB_CALL();

        badd.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {

                Intent registerIntent = new Intent(PlansActivity.this, addplan.class);
                registerIntent.putExtra("user_id", id);

                PlansActivity.this.startActivity(registerIntent);
            }
        });

    }
    public void JSON_DATA_WEB_CALL(){

        params.put("user_id", id+"");
        Log.d("mohamedeeeeeeeeee",id+"");

        StringRequest stringRequest = new StringRequest(Request.Method.POST, GET_JSON_DATA_HTTP_URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        // Display the first 500 characters of the response string.
                        JSONArray ja = null;
                        ///JSONObject jo = null;
                        try {
                            ja = new JSONArray(response);
                            Log.d( "onResponse: ",ja+"");
                           // jo = new JSONObject(response);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                        JSON_PARSE_DATA_AFTER_WEBCALL(ja);
                        //JSON_PARSE_DATA_AFTER_WEBCALL(jo);


                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        }) { protected Map<String, String> getParams() {
           Map<String,String> params = new HashMap<String, String>();
            params.put("user_id", id+"");
            return params;
        }}
        ;




        requestQueue = Volley.newRequestQueue(this);

        requestQueue.add(stringRequest);
    }

    public void JSON_PARSE_DATA_AFTER_WEBCALL(JSONArray array){
        for(int i = 0; i<array.length(); i++) {

            GetDataAdapter GetDataAdapter2 = new GetDataAdapter();

            JSONObject json = null;
            try {
                json = array.getJSONObject(i);

                GetDataAdapter2.setDPlanid(json.getString(JSON_PLANID));

                GetDataAdapter2.setId(json.getInt(JSON_ID));

                GetDataAdapter2.setDate(json.getString(JSON_DATE));

                GetDataAdapter2.setDestination(json.getString(JSON_DESTINATION));

            } catch (JSONException e) {

                e.printStackTrace();
            }
            GetDataAdapter1.add(GetDataAdapter2);
        }

        recyclerViewadapter = new RecyclerViewAdapter(GetDataAdapter1, this);

        recyclerView.setAdapter(recyclerViewadapter);
    }






}

package com.example.mohamed.travelb;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;



public class addRequest  extends StringRequest{


    private static final String REGISTER_REQUEST_URL = "http://travelb.000webhostapp.com/addplan.php ";
    private Map<String, String> params;

    public addRequest( String username,String date, int id,  Response.Listener<String> listener){
        super(Method.POST, REGISTER_REQUEST_URL, listener, null);
        params= new HashMap<>();
        params.put("destination", username);
        params.put("date",date);
        params.put("user_id", id+"");
    }

    @Override
    public Map<String, String> getParams() {
        return params;
    }
}

package com.example.mohamed.travelb;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by mohamed on 27/04/2017.
 */

public class updateREQ extends StringRequest{


    private static final String REGISTER_REQUEST_URL = "http://travelb.000webhostapp.com/update.php ";
    private Map<String, String> params;

    public updateREQ( String id,String username,String name,String dob,String email, Response.Listener<String> listener){
        super(Request.Method.POST, REGISTER_REQUEST_URL, listener, null);
        params= new HashMap<>();
        params.put("user_id", id);
        params.put("username", username);
        params.put("name", name);
        params.put("dob", dob);
        params.put("email", email);
    }

    @Override
    public Map<String, String> getParams() {
        return params;
    }
}

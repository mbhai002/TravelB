package com.example.mohamed.travelb;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;
/**
 * Created by mohamed on 26/04/2017.
 */

public class removeRequest extends StringRequest {




    private static final String REGISTER_REQUEST_URL = "http://travelb.000webhostapp.com/remove.php ";
    private Map<String, String> params;

    public removeRequest( String plan_id, Response.Listener<String> listener){
        super(Request.Method.POST, REGISTER_REQUEST_URL, listener, null);
        params= new HashMap<>();
        params.put("plan_id", plan_id);

    }

    @Override
    public Map<String, String> getParams() {
        return params;
    }
}

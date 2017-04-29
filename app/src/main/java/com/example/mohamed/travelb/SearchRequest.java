package com.example.mohamed.travelb;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by mohamed on 24/02/2017.
 */

public class SearchRequest extends StringRequest{

    private static final String LOGIN_REQUEST_URL = "http://travelb.000webhostapp.com/Search.php ";
    private Map<String, String> params;

    public SearchRequest(String destination, Response.Listener<String> listener){
        super(Request.Method.POST, LOGIN_REQUEST_URL, listener, null);
        params= new HashMap<>();
        params.put("destination", destination);
    }

    @Override
    public Map<String, String> getParams() {
        return params;
    }

}

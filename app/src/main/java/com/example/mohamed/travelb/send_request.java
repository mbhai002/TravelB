package com.example.mohamed.travelb;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by mohamed on 24/04/2017.
 */

public class send_request extends StringRequest{




    private static final String REGISTER_REQUEST_URL = "http://travelb.000webhostapp.com/sendMess.php ";
    private Map<String, String> params;

    public send_request( String content,String sender,String receiver, Response.Listener<String> listener){
        super(Method.POST, REGISTER_REQUEST_URL, listener, null);
        params= new HashMap<>();
        params.put("content", content);
        params.put("sender", sender);
        params.put("receiver", receiver);
    }

    @Override
    public Map<String, String> getParams() {
        return params;
    }
}

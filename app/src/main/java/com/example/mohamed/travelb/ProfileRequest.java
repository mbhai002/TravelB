package com.example.mohamed.travelb;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by mohamed on 24/02/2017.
 */


    public class ProfileRequest extends StringRequest {

        private static final String PROFIL_REQUEST_URL = "http://travelb.000webhostapp.com/Profil.php ";
        private Map<String, String> params;

        public ProfileRequest(int user_id,Response.Listener<String> listener){
            super(Request.Method.POST, PROFIL_REQUEST_URL, listener, null);
            params= new HashMap<>();
            params.put("user_id", user_id+"");
        }

    @Override
    public Map<String, String> getParams() {
        return params;
    }
}

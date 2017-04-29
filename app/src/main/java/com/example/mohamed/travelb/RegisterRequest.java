package com.example.mohamed.travelb;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by mohamed on 24/02/2017.
 */

public class RegisterRequest extends StringRequest{

    private static final String REGISTER_REQUEST_URL = "http://travelb.000webhostapp.com/Register.php ";
    private Map<String, String> params;

    public RegisterRequest(String name, String gender, String username, String dob, String email, String password, Response.Listener<String> listener){
        super(Method.POST, REGISTER_REQUEST_URL, listener, null);
        params = new HashMap<>();
        params.put("name", name);
        params.put("username", username);
        params.put("password", password);
        params.put("dob", dob + "");
        params.put("email", email);

        params.put("gender", gender);
    }

    @Override
    public Map<String, String> getParams() {
        return params;
    }
}

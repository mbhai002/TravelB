package com.example.mohamed.travelb;

import com.android.volley.AuthFailureError;
import com.android.volley.Response;
import com.android.volley.toolbox.JsonArrayRequest;

import org.json.JSONArray;

import java.util.Map;

/**
 * Created by mohamed on 16/03/2017.
 */


public class PostJsonArrayRequest extends JsonArrayRequest {



        private Map<String, String> mPostParams;

        @Override
        protected Map<String, String> getParams() throws AuthFailureError {
            return mPostParams;
        }

        public PostJsonArrayRequest(String url, Map<String, String> postParams, Response.Listener<JSONArray> listener, Response.ErrorListener errorListener) {
            super(url, listener, errorListener);

            this.mPostParams = postParams;
            try {
                this.getParams();
            } catch (AuthFailureError authFailureError) {
                authFailureError.printStackTrace();
            }
        }
    }
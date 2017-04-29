package com.example.mohamed.travelb;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class RegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);


        final EditText etDob = (EditText) findViewById(R.id.etDob);
        final EditText etName = (EditText) findViewById(R.id.etName);
        final EditText etUsername = (EditText) findViewById(R.id.etUsername);
        final EditText etPassword = (EditText) findViewById(R.id.etPassword);
        final EditText etEmail = (EditText) findViewById(R.id.gender);
        final Button btnRegister = (Button) findViewById(R.id.btnRegister);

        final Spinner gSpinner = (Spinner) findViewById(R.id.gSpinner);

        final EditText etPasswordAgain = (EditText) findViewById(R.id.etPasswordAgain);

        final CheckBox cbTerms = (CheckBox) findViewById(R.id.cbTerms);


        TextView tvTerms =(TextView)findViewById(R.id.tvTerms);
        tvTerms.setClickable(true);
        tvTerms.setMovementMethod(LinkMovementMethod.getInstance());
        String text = "<a href='http://doc.gold.ac.uk/~thani001/travelpals/termsandcondition.html'> I agree to the terms and conditions </a>";
        tvTerms.setText(Html.fromHtml(text));

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String name = etName.getText().toString();
                final String username = etUsername.getText().toString();
                final String password = etPassword.getText().toString();
                final String dob = etDob.getText().toString();
                final String email = etEmail.getText().toString();

                final String gender = gSpinner.getSelectedItem().toString();

                final String passwordAgain = etPasswordAgain.getText().toString();

                if(name.isEmpty()) {
                    AlertDialog.Builder builder2 = new AlertDialog.Builder(RegisterActivity.this);
                    builder2.setMessage("Name field is empty")
                            .setNegativeButton("OK", null)
                            .create()
                            .show();
                } else if (username.isEmpty()) {
                    AlertDialog.Builder builder2 = new AlertDialog.Builder(RegisterActivity.this);
                    builder2.setMessage("Username field is empty")
                            .setNegativeButton("OK", null)
                            .create()
                            .show();
                } else if (email.isEmpty()){
                    AlertDialog.Builder builder2 = new AlertDialog.Builder(RegisterActivity.this);
                    builder2.setMessage("Email field is empty")
                            .setNegativeButton("OK", null)
                            .create()
                            .show();
                } else if (password.isEmpty()) {
                    AlertDialog.Builder builder2 = new AlertDialog.Builder(RegisterActivity.this);
                    builder2.setMessage("Password field is empty")
                            .setNegativeButton("OK", null)
                            .create()
                            .show();
                } else {
                    if ((password).equals(passwordAgain)) {
                        if (cbTerms.isChecked()) {

                            Response.Listener<String> responseListener = new Response.Listener<String>() {

                                @Override
                                public void onResponse(String response) {
                                    try {
                                        JSONObject jsonResponse = new JSONObject(response);
                                        boolean success = jsonResponse.getBoolean("success");

                                        if (success) {
                                            Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                                            RegisterActivity.this.startActivity(intent);
                                        } else {
                                            AlertDialog.Builder builder = new AlertDialog.Builder(RegisterActivity.this);
                                            builder.setMessage("Username or email may already be in use.")
                                                    .setNegativeButton("Try again", null)
                                                    .create()
                                                    .show();
                                        }

                                    } catch (JSONException e) {
                                        e.printStackTrace();
                                    }
                                }
                            };

                            RegisterRequest registerRequest = new RegisterRequest(name, gender, username, dob, email, password, responseListener);
                            RequestQueue queue = Volley.newRequestQueue(RegisterActivity.this);
                            queue.add(registerRequest);

                        } else {
                            AlertDialog.Builder builder2 = new AlertDialog.Builder(RegisterActivity.this);
                            builder2.setMessage("You have not agreed to the terms and conditions")
                                    .setNegativeButton("OK", null)
                                    .create()
                                    .show();
                        }
                    } else {
                        AlertDialog.Builder builder2 = new AlertDialog.Builder(RegisterActivity.this);
                        builder2.setMessage("Passwords are not the same")
                                .setNegativeButton("Try again", null)
                                .create()
                                .show();
                    }
                }


            }
        });

    }
}

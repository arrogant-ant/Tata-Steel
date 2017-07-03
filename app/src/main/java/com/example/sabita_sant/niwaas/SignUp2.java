package com.example.sabita_sant.niwaas;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class SignUp2 extends AppCompatActivity {

    EditText password_et, confirm_et, answer_et;
    String password, security, answer;
    RadioGroup question;
    private String regURL = "https://niwaas.000webhostapp.com/reg.php";
    Bundle details;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up2);
        password_et = (EditText) findViewById(R.id.password);
        confirm_et = (EditText) findViewById(R.id.confirm_pass);
        answer_et = (EditText) findViewById(R.id.answer);
        question = (RadioGroup) findViewById(R.id.security);
        details = getIntent().getBundleExtra("details");

    }

    public void submit(View view) {
        if (password_et.getText().toString().equals(confirm_et.getText().toString())) {
            password = password_et.getText().toString();
            switch (question.getCheckedRadioButtonId()) {
                case R.id.q1:
                    security = "1";
                    break;

                case R.id.q2:
                    security = "2";
                    break;

                case R.id.q3:
                    security = "3";
                    break;

                case R.id.q4:
                    security = "4";
                    break;
            }
            answer = answer_et.getText().toString();
            register();


        } else {
            Toast.makeText(SignUp2.this, "Invalid password", Toast.LENGTH_SHORT).show();
            onStart();
        }
    }

    private void register() {
        Toast.makeText(SignUp2.this, "adding user", Toast.LENGTH_SHORT).show();

        StringRequest reg_request = new StringRequest(Request.Method.POST, regURL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Toast.makeText(SignUp2.this, "RESPONSE  \n"+response, Toast.LENGTH_LONG).show();


            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(SignUp2.this, "check network connection", Toast.LENGTH_SHORT).show();

            }
        }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                params.put("name", details.getString("name"));
                params.put("ph", details.getString("ph"));
                params.put("p_no", details.getString("p_no"));
                params.put("address", details.getString("address"));
                params.put("password", password);
                params.put("security", security);
                params.put("answer", answer);

                return params;
            }
        };
        VolleySingleton.getInstance(SignUp2.this).addRequest(reg_request);
    }


}

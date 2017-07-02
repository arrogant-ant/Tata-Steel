package com.example.sabita_sant.niwaas;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class SignUp extends AppCompatActivity {

    String name="";
    String ph;
    String email;
    String p_no;
    String address;
    EditText first_name, mid_name,last_name,ph_et,p_no_et,address_et;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        first_name= (EditText) findViewById(R.id.first_name);
        mid_name= (EditText) findViewById(R.id.mid_name);
        last_name= (EditText) findViewById(R.id.last_name);
        ph_et= (EditText) findViewById(R.id.contact_no);
        p_no_et= (EditText) findViewById(R.id.personal);
        address_et= (EditText) findViewById(R.id.address);


    }

    public void nextSignUp(View view) {
        name=name.concat(first_name.getText().toString()).concat(" ")
                .concat(mid_name.getText().toString()).concat(" ")
                .concat(last_name.getText().toString());

        ph=ph_et.getText().toString();
        p_no= p_no_et.getText().toString();
        address=address_et.getText().toString();
        Intent intent=new Intent(SignUp.this,SignUp2.class);
        Bundle user_details= new Bundle();
        user_details.putString("name",name);
        user_details.putString("ph",ph);
        user_details.putString("p_no",p_no);
        user_details.putString("address",address);
        intent.putExtra("details",user_details);
        startActivity(intent);
    }
}

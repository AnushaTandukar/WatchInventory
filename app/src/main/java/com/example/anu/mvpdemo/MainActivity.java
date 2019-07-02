package com.example.anu.mvpdemo;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Spinner spinner;
    TextView t1_username, t2_password, t3_retype, t4_role, t5_division;
    EditText e1_username, e2_password, e3_retype;
    Button b1_save;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinner = (Spinner) findViewById(R.id.sp_role);

        t1_username = (TextView) findViewById(R.id.tv_username);
        t2_password = (TextView) findViewById(R.id.tv_password);
        t3_retype = (TextView) findViewById(R.id.tv_retype);
        t4_role = (TextView) findViewById(R.id.tv_retype);
        t5_division = (TextView) findViewById(R.id.tv_division);

        e1_username = (EditText) findViewById(R.id.et_username);
        e2_password = (EditText) findViewById(R.id.et_password);
        e3_retype = (EditText) findViewById(R.id.et_retype);
        b1_save = (Button) findViewById(R.id.btn1);

        b1_save.setOnClickListener(this);

        try {
            SharedPreferences sharedPref = getSharedPreferences("userInfo", Context.MODE_PRIVATE);
            String username = sharedPref.getString("username", null);
            String pass = sharedPref.getString("password", null);
            if (username != null && pass != null) {
                startActivity(new Intent(getApplicationContext(), MainActivity.class));
            }
        } catch (NullPointerException e) {
            e.printStackTrace();
        }


        ArrayAdapter<String> myAdapter = new ArrayAdapter<String>(MainActivity.this,
                android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.names));

        ArrayAdapter<String> myAdapter1 = new ArrayAdapter<String>(MainActivity.this,
                android.R.layout.simple_list_item_2, getResources().getStringArray(R.array.names1));


        myAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(myAdapter);


    }

    @Override
    public void onClick(View view) {
        if (view==b1_save){
            if (e1_username.getText().toString().equals(""))  {
                Toast.makeText(MainActivity.this, "enter your Username  ", Toast.LENGTH_SHORT).show();
            }
            else if(e2_password.getText().toString().equals("")) {
                Toast.makeText(MainActivity.this, "enter your Password  ", Toast.LENGTH_SHORT).show();
            }
            else if (e3_retype.getText().toString().equals("")) {
                Toast.makeText(MainActivity.this, "enter your Retype Password  ", Toast.LENGTH_SHORT).show();
            }
else if (e1_username.getText().toString().equals("")|| e2_password.getText().toString().equals("")) {
                Toast.makeText(MainActivity.this, "enter your Retype Password  ", Toast.LENGTH_SHORT).show();
            }
            }
            }
             }



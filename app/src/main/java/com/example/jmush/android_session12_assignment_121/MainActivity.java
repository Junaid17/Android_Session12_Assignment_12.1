package com.example.jmush.android_session12_assignment_121;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText etEmail, etPassword;
    Button btnSave;

    SharedPreferences sharedpreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Intializing View
        getViewID();
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = etEmail.getText().toString();
                String password= etPassword.getText().toString();
               // Saving data to preferences
                SharedPreferences.Editor editor = sharedpreferences.edit();
                editor.putString("Email", email);
                editor.putString("Password", password);
                editor.commit();
                Toast.makeText(MainActivity.this, "Saved is Succesfully", Toast.LENGTH_LONG).show();
                // Clearing the edittext details
                etEmail.setText("");
                etPassword.setText("");
                // Getting Data from preferences and displaying in Toast
                getMyPreferences();
            }
        });

    }

    private void getMyPreferences() {
        sharedpreferences = getSharedPreferences("MyPREFERENCES", Context.MODE_PRIVATE);
        String prefEmail=sharedpreferences.getString("Email","");
        String prefPassword=sharedpreferences.getString("Password","");
        String prefDetails= "Email:"+prefEmail+ "/nPassword:"+prefPassword;
        Toast.makeText(MainActivity.this, "My Preferences :"+prefDetails, Toast.LENGTH_LONG).show();

    }


    private void getViewID() {
        etEmail = (EditText) findViewById(R.id.email);
        etPassword = (EditText) findViewById(R.id.password);
        btnSave = (Button) findViewById(R.id.save);
        sharedpreferences = getSharedPreferences("MyPREFERENCES", Context.MODE_PRIVATE);

    }

}

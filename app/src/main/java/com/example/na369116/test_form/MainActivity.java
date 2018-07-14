package com.example.na369116.test_form;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.basgeekball.awesomevalidation.AwesomeValidation;
import com.basgeekball.awesomevalidation.ValidationStyle;
import com.basgeekball.awesomevalidation.utility.RegexTemplate;

import java.util.regex.Pattern;

import static android.view.View.Z;

public class MainActivity extends Activity implements View.OnClickListener {

    private Button submit;
    private Spinner course;
    private TextView f_name,l_name,email,username,phone,password,c_password;
    private AwesomeValidation ad;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        submit = (Button)findViewById(R.id.button);
        submit.setOnClickListener(this);

        f_name = (TextView)findViewById(R.id.First_Name);
        l_name = (TextView)findViewById(R.id.Last_Name);
        email = (TextView)findViewById(R.id.Email);
        username = (TextView)findViewById(R.id.Username);
        phone = (TextView)findViewById(R.id.Phone);
        password = (TextView)findViewById(R.id.Password);
        c_password =(TextView)findViewById(R.id.Confirm_Password);

        course = (Spinner)findViewById(R.id.spinner);

        ad = new AwesomeValidation(ValidationStyle.BASIC);

        ad.addValidation(this,R.id.First_Name,"^[A-Za-z]+$",R.string.name);
        ad.addValidation(this,R.id.Last_Name,"^[A-Za-z]+$",R.string.name);
        ad.addValidation(this, R.id.Email, Patterns.EMAIL_ADDRESS, R.string.erremail);
        ad.addValidation(this,R.id.Username,RegexTemplate.NOT_EMPTY,R.string.empty);
        ad.addValidation(this,R.id.Phone, RegexTemplate.TELEPHONE,R.string.empty);
        ad.addValidation(this,R.id.Password,"(?=^.{8,}$)((?=.*\\d)(?=.*\\W+))(?![.\\n])(?=.*[A-Z])(?=.*[a-z]).*$",R.string.pass);
        ad.addValidation(this,R.id.Confirm_Password,R.id.Password,R.string.confirmerror);

    }

    public void validform(){
        if (ad.validate()) {
            Toast.makeText(this, "Validation Successfull", Toast.LENGTH_LONG).show();

        }
    }


    @Override
    public void onClick(View v) {

        validform();

    }
}

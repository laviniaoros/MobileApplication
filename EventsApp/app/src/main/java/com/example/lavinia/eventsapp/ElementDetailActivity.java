package com.example.lavinia.eventsapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;
import android.widget.TextView;

public class ElementDetailActivity extends AppCompatActivity {

    String passedDetail=null;
    String passedTitle=null;
    private TextView viewTitle=null;
    private EditText viewDetails=null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.element_detail);

        passedTitle=getIntent().getStringExtra("event_title");
       passedDetail=getIntent().getStringExtra("event_details");

        viewTitle=(TextView)findViewById(R.id.textViewTitle);
        viewDetails=(EditText)findViewById(R.id.textViewDetails);

        viewTitle.setText(passedTitle);
        viewDetails.setText(passedDetail);


    }
}

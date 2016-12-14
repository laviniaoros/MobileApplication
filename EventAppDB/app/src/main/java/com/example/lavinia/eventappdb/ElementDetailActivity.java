package com.example.lavinia.eventappdb;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.NumberPicker;
import android.widget.TextView;

import com.example.lavinia.eventappdb.dbUtils.MyEventDataSource;
import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

public class ElementDetailActivity extends AppCompatActivity {

    private MyEventDataSource datasource;

    String passedDetail=null;
    String passedTitle=null;
    String passedId=null;
    private TextView viewTitle=null;
    private EditText viewDetails=null;



    LineGraphSeries<DataPoint> series;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.element_detail);

        datasource=new MyEventDataSource(this);

        passedId=getIntent().getStringExtra("event_Id");
        passedTitle=getIntent().getStringExtra("event_title");
       passedDetail=getIntent().getStringExtra("event_details");

        viewTitle=(TextView)findViewById(R.id.textViewTitle);
        viewDetails=(EditText)findViewById(R.id.textViewDetails);


        viewTitle.setText(passedTitle);
        viewDetails.setText(passedDetail);

//        viewDetails.setOnFocusChangeListener(new View.OnFocusChangeListener() {
//            public void onFocusChange(View arg0, boolean arg1) {
//                if (!arg1) {
//                    String myText = viewDetails.getText().toString();
//                    datasource.updateEvent(Long.valueOf(passedId).longValue(),myText);
//                    viewTitle.setText("jdgs");
//                }
//
//            }});

        viewDetails.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {

                if (actionId == EditorInfo.IME_ACTION_SEND) {

                    String myText = viewDetails.getText().toString();
                    datasource.updateEvent(Long.valueOf(passedId).longValue(),myText);
                    return false;
                }
                return false;
            }
        });
        double y,x;
        x=-5.0;

        GraphView graph= (GraphView) findViewById(R.id.graphId);
        series= new LineGraphSeries<DataPoint>();
        for(int i=0; i<500; i++){
            x=x+0.1;
            y=Math.sin(x);
            series.appendData(new DataPoint(x,y),true, 500);
        }

        graph.addSeries(series);
    }

    public void showDialog(View view) {
        LayoutInflater inflater= ElementDetailActivity.this.getLayoutInflater();
        View content= inflater.inflate(R.layout.number_picker,null);

        final NumberPicker noPicker= (NumberPicker)content.findViewById(R.id.numberPicker);

        noPicker.setMaxValue(10);
        noPicker.setMinValue(0);
        noPicker.setWrapSelectorWheel(false);
        AlertDialog.Builder builder = new AlertDialog.Builder(ElementDetailActivity.this);

        builder.setCancelable(true);
        builder.setPositiveButton("OK",  new DialogInterface.OnClickListener(){
            public void onClick(DialogInterface dialog, int which) {
                TextView text=(TextView)findViewById(R.id.textViewTickets);
                text.setText("You've picked "+String.valueOf(noPicker.getValue())+" tickets");
            }
        });
        builder.setView(content);
        AlertDialog dialog= builder.create();
        dialog.show();
    }
}

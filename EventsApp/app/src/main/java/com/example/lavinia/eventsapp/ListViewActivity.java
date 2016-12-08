package com.example.lavinia.eventsapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.lavinia.eventsapp.dummy.DummyContent;

/**
 * Created by Lavinia on 12/7/2016.
 */

public class ListViewActivity extends AppCompatActivity {
//    @Override
//    public void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//
//        // storing string resources into Array
//        String[] numbers = {"one", "two", "three", "four"};
//        // here you store the array of string you got from the database
//
//        // Binding Array to ListAdapter
//        this.setListAdapter(new ArrayAdapter<String>(this, R.layout.item_list, R.id.label, numbers));
//        // refer the ArrayAdapter Document in developer.android.com
//        ListView lv = getListView();
//
//        // listening to single list item on click
//        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            public void onItemClick(AdapterView<?> parent, View view,
//                                    int position, long id) {
//
//                // selected item
//                String num = ((TextView) view).getText().toString();
//
//                // Launching new Activity on selecting single List Item
//                Intent i = new Intent(getApplicationContext(), ItemDetailActivity.class);
//                // sending data to new activity
//                i.putExtra("number", num);
//                startActivity(i);
//
//            }
//        });
//    }
//}
//
//   public final static String  id_extra="title_event";


    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listView =(ListView) findViewById(R.id.listView);

        final ArrayAdapter adapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1, DummyContent.items);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //String myevent = (String)parent.getItemAtPosition(position);

                Intent i= new Intent(ListViewActivity.this, ElementDetailActivity.class);
                i.putExtra("event_title",DummyContent.getObjectById(position).getTitle());
                i.putExtra("event_details",DummyContent.getObjectById(position).getDetails());
                startActivity(i);
                //DummyContent.getDetailsById(position)
            }
        });

    }


}
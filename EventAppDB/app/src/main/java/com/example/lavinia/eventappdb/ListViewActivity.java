package com.example.lavinia.eventappdb;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import com.example.lavinia.eventappdb.dbUtils.MyEvent;
import com.example.lavinia.eventappdb.dbUtils.MyEventDataSource;

import java.util.List;

public class ListViewActivity extends ListActivity {
    private MyEventDataSource datasource;

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    //private GoogleApiClient client;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        datasource = new MyEventDataSource(this);
        datasource.open();

        List<MyEvent> values = datasource.getAllEvents();


        // use the SimpleCursorAdapter to show the
        // elements in a ListView
        ArrayAdapter<MyEvent> adapter = new ArrayAdapter<MyEvent>(this,
                android.R.layout.simple_list_item_1, values);
       // list1 = getListView();
        setListAdapter(adapter);}

    protected void onListItemClick(ListView l, View v, int position, long id) {
        // TODO Auto-generated method stub
        super.onListItemClick(l, v, position, id);
//        final TextView mTextView = (TextView) findViewById(R.id.textLabelAdd);
//        mTextView.setText(datasource.getObjectById(position).getTitle().toString());

        Intent i= new Intent(ListViewActivity.this, ElementDetailActivity.class);
        i.putExtra("event_Id", (String.valueOf(id+1)));
        i.putExtra("event_title",datasource.getObjectById(id).getTitle());
        i.putExtra("event_details",datasource.getObjectById(id).getDetails());
        startActivity(i);
    }




    // Will be called via the onClick attribute
    // of the buttons in main.xml
    public void onClick(View view) {
        @SuppressWarnings("unchecked")
        ArrayAdapter<MyEvent> adapter = (ArrayAdapter<MyEvent>) getListAdapter();
        MyEvent ev = null;
        switch (view.getId()) {
            case R.id.add:

                EditText edit = (EditText)findViewById(R.id.title);
                String title=edit.getText().toString();
                edit = (EditText) findViewById(R.id.details);
                String details= edit.getText().toString();

                ev= datasource.createEvent(title,details);
                adapter.add(ev);

                break;
            case R.id.delete:
                if (getListAdapter().getCount() > 0) {
                    edit= (EditText)findViewById(R.id.deleteBox);
                    String deleteId=edit.getText().toString();

                    ev = (MyEvent) getListAdapter().getItem(Integer.parseInt(deleteId));
                    datasource.deleteEvent(ev);
                    adapter.remove(ev);
                }
                break;
        }
        adapter.notifyDataSetChanged();
    }

    @Override
    protected void onResume() {
        datasource.open();
        super.onResume();
    }

    @Override
    protected void onPause() {
        datasource.close();
        super.onPause();
    }

}

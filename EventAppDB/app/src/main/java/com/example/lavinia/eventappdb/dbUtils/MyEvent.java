package com.example.lavinia.eventappdb.dbUtils;

/**
 * Created by Lavinia on 12/12/2016.
 */

public class MyEvent {
    private long id;
    private String title;
    private String details;


    public MyEvent(long id, String title, String details) {
        this.id = id;
        this.title = title;
        this.details = details;
    }

    public MyEvent(){}

    public void setId(long newId){
        this.id=newId;
    }
    public void setTitle(String newTitle){
        this.title=newTitle;
    }
    public void setDetails(String newDetails){
        this.details=newDetails;

    }
    public String getDetails(){
        return this.details;
    }
    public String getTitle(){
        return this.title;
    }
    public long getId(){
        return this.id;
    }
    @Override
    public String toString() {
        return title;
    }
}

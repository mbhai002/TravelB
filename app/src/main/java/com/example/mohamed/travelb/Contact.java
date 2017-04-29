


package com.example.mohamed.travelb;

        import android.util.Log;

/**
 * Created by mohamed on 23/04/2017.
 */

public class Contact {



    private int image_id;
    private String name,username,dob,destination,user_id,plan_id,gender,date;
    String my_id;


    public Contact(int image_id, String date,String name, String username, String dob, String destination, String user_id, String plan_id, String gender) {
        this.image_id = image_id;
        this.name = name;
        this.username = username;
        this.dob = dob;
        this.destination = destination;
        this.user_id = user_id;
        this.plan_id = plan_id;
        this.gender = gender;
        this.date=date;
    }

    public Contact(int image_id) {
        this.image_id = image_id;
    }


    public Contact(String id) {
        my_id=id;


    }
    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }









    public int getImage_id() {
        return image_id;
    }

    public void setImage_id(int image_id) {
        this.image_id = image_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getPlan_id() {
        return plan_id;
    }

    public void setPlan_id(String plan_id) {
        this.plan_id = plan_id;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}


package com.example.mohamed.travelb;

/**
 * Created by mohamed on 27/04/2017.
 */

public class Message {


    private int image_id;
    private String User_id,Email,Gender,Name,Dob,Password,Username,Idmess,Content,Sender,Receiver;
    String my_id;

    public Message(int image_id, String user_id, String email, String gender, String name, String dob, String password,
                   String username, String idmess, String content, String sender, String receiver, String my_id) {
        this.image_id = image_id;
        User_id = user_id;
        Email = email;
        Gender = gender;
        Name = name;
        Dob = dob;
        Password = password;
        Username = username;
        Idmess = idmess;
        Content = content;
        Sender = sender;
        Receiver = receiver;
        this.my_id = my_id;
    }

    public Message( String my_id) {

        this.my_id = my_id;
    }

    public int getImage_id() {
        return image_id;
    }

    public void setImage_id(int image_id) {
        this.image_id = image_id;
    }

    public String getUser_id() {
        return User_id;
    }

    public void setUser_id(String user_id) {
        User_id = user_id;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getGender() {
        return Gender;
    }

    public void setGender(String gender) {
        Gender = gender;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getDob() {
        return Dob;
    }

    public void setDob(String dob) {
        Dob = dob;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        Username = username;
    }

    public String getIdmess() {
        return Idmess;
    }

    public void setIdmess(String idmess) {
        Idmess = idmess;
    }

    public String getContent() {
        return Content;
    }

    public void setContent(String content) {
        Content = content;
    }

    public String getSender() {
        return Sender;
    }

    public void setSender(String sender) {
        Sender = sender;
    }

    public String getReceiver() {
        return Receiver;
    }

    public void setReceiver(String receiver) {
        Receiver = receiver;
    }

    public String getMy_id() {
        return my_id;
    }

    public void setMy_id(String my_id) {
        this.my_id = my_id;
    }
}






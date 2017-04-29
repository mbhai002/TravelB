package com.example.mohamed.travelb;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by mohamed on 23/04/2017.
 */



public class messageAdapter extends RecyclerView.Adapter<messageAdapter.ContactViewHolder> {

    ArrayList<Message> contacts = new ArrayList<Message>();
    Context ctx;

    public messageAdapter(ArrayList<Message> contacts, Context ctx){

        this.contacts=contacts;
        this.ctx=ctx;
    }


    @Override
    public ContactViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view_message,parent,false);
        ContactViewHolder contactViewHolder= new ContactViewHolder(view, ctx, contacts);

        return contactViewHolder;
    }

    @Override
    public void onBindViewHolder(ContactViewHolder holder, int position) {

        Message CON =  contacts.get(position);
        holder.person_img.setImageResource(CON.getImage_id());
        holder.person_username.setText(CON.getUsername());


    }

    @Override
    public int getItemCount() {
        return contacts.size();
    }

    public static class ContactViewHolder extends  RecyclerView.ViewHolder implements View.OnClickListener{

        ImageView person_img;
        TextView person_username, person_dob, person_gender,person_date;
        ArrayList<Message> contacts=new ArrayList<Message>();
        Context ctx;



        public ContactViewHolder(View view, Context ctx, ArrayList<Message> contacts){

            super(view);
            this.contacts=contacts;
            this.ctx=ctx;
            view.setOnClickListener(this);
            person_img= (ImageView) view.findViewById(R.id.person_image);
            person_username=(TextView) view.findViewById(R.id.username);
            person_dob=(TextView) view.findViewById(R.id.name);
            person_gender=(TextView) view.findViewById(R.id.gender);
            person_date=(TextView) view.findViewById(R.id.date);

        }

        @Override
        public void onClick(View v) {

            int position = getAdapterPosition();
            Message contact= this.contacts.get(position);
            Intent intent =new Intent(ctx,MessageDtails.class);
            intent.putExtra("content",contact.getContent());

            this.ctx.startActivity(intent);

        }
    }
}





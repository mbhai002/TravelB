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



    public class ContactAdapter extends RecyclerView.Adapter<ContactAdapter.ContactViewHolder> {

        ArrayList<Contact> contacts = new ArrayList<Contact>();
        Context ctx;

        public ContactAdapter(ArrayList<Contact> contacts, Context ctx){

            this.contacts=contacts;
            this.ctx=ctx;
        }


        @Override
        public ContactViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view_layout,parent,false);
            ContactViewHolder contactViewHolder= new ContactViewHolder(view, ctx, contacts);

            return contactViewHolder;
        }

        @Override
        public void onBindViewHolder(ContactViewHolder holder, int position) {

            Contact CON =  contacts.get(position);
            holder.person_img.setImageResource(CON.getImage_id());
            holder.person_username.setText("username: "+CON.getUsername());
            holder.person_dob.setText("date of birth: "+CON.getDob());
            holder.person_gender.setText("sex: "+CON.getGender());
            holder.person_date.setText("departure on: "+CON.getDate());

        }

        @Override
        public int getItemCount() {
            return contacts.size();
        }

        public static class ContactViewHolder extends  RecyclerView.ViewHolder implements View.OnClickListener{

            ImageView person_img;
            TextView person_username, person_dob, person_gender,person_date;
            ArrayList<Contact> contacts=new ArrayList<Contact>();
            Context ctx;



            public ContactViewHolder(View view, Context ctx, ArrayList<Contact> contacts){

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
                Contact contact= this.contacts.get(position);
                Intent intent =new Intent(ctx,ContactDtails.class);
                intent.putExtra("img_id",contact.getImage_id());
                intent.putExtra("name",contact.getName());
                intent.putExtra("username", contact.getUsername());
                intent.putExtra("dob", contact.getDob());
                intent.putExtra("date",contact.getDate());
                intent.putExtra("my_id",contact.my_id);
                intent.putExtra("user_id",contact.getUser_id());
                intent.putExtra("destination",contact.getDestination());
                intent.putExtra("gender",contact.getGender());
                this.ctx.startActivity(intent);

            }
        }
    }





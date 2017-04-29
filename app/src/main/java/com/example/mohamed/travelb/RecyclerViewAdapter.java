package com.example.mohamed.travelb;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    Context ctx;

    ArrayList<GetDataAdapter> contacts = new ArrayList<GetDataAdapter>();

    public RecyclerViewAdapter(ArrayList<GetDataAdapter> contacts, Context ctx){



        this.contacts = contacts;
        this.ctx = ctx;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview, parent, false);
        ViewHolder viewHolder = new ViewHolder(v,ctx,contacts);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        GetDataAdapter CON =  contacts.get(position);
        holder.Destination.setText(CON.getDestination());
        holder.Date.setText(CON.getDate());


    }

    @Override
    public int getItemCount() {

        return contacts.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        public TextView Destination;
        public TextView Date;
        ArrayList<GetDataAdapter> contacts = new ArrayList<GetDataAdapter>();
        Context ctx;

        public ViewHolder(View itemView,Context ctx,ArrayList<GetDataAdapter>contacts) {

            super(itemView);
            this.contacts=contacts;
            this.ctx=ctx;
            itemView.setOnClickListener(this);
            Destination = (TextView) itemView.findViewById(R.id.username) ;
            Date = (TextView) itemView.findViewById(R.id.name) ;


        }

        public void onClick(View v) {

            int position = getAdapterPosition();
            GetDataAdapter contact= this.contacts.get(position);
            Intent intent =new Intent(ctx,remove.class);
            intent.putExtra("plan_id",contact.getPlanid());
            intent.putExtra("user_id",contact.getId());
            intent.putExtra("destination",contact.getDestination());
            intent.putExtra("date",contact.getDate());
            this.ctx.startActivity(intent);

        }
    }
}

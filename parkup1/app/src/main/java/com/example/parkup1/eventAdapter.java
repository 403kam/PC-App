package com.example.parkup1;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

// FirebaseRecyclerAdapter is a class provided by
// FirebaseUI. it provides functions to bind, adapt and show
// database contents in a Recycler View
public class eventAdapter extends FirebaseRecyclerAdapter<
        event, eventAdapter.eventsViewholder> {

    public eventAdapter(
            @NonNull FirebaseRecyclerOptions<event> options)
    {
        super(options);
    }

    // Function to bind the view in Card view(here
    // "person.xml") iwth data in
    // model class(here "person.class")
    @Override
    protected void
    onBindViewHolder(@NonNull eventsViewholder holder,
                     int position, @NonNull event model)
    {

        // Add firstname from model class (here
        // "person.class")to appropriate view in Card
        // view (here "person.xml")
        holder.eventitem.setText(model.getTitle().toString());
        holder.eventlayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast.makeText(view.getContext(),"click on item: "+model.getDescription(),Toast.LENGTH_LONG).show();
                Context context = view.getContext();
                Intent intent = new Intent(context, ViewMeeting.class);
                intent.putExtra("ID_NUMBER", model.getId().toString() );
                context.startActivity(intent);
            }
        });

    }

    // Function to tell the class about the Card view (here
    // "person.xml")in
    // which the data will be shown
    @NonNull
    @Override
    public eventsViewholder
    onCreateViewHolder(@NonNull ViewGroup parent,
                       int viewType)
    {
        View view
                = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.event, parent, false);
        return new eventAdapter.eventsViewholder(view);
    }

    // Sub Class to create references of the views in Crad
    // view (here "person.xml")
    class eventsViewholder
            extends RecyclerView.ViewHolder {
        TextView eventitem;
        CardView eventlayout;
        public eventsViewholder(@NonNull View itemView)
        {
            super(itemView);

            eventitem
                    = itemView.findViewById(R.id.eventitem);
            eventlayout = itemView.findViewById((R.id.eventlayout));
        }
    }
}
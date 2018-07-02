package com.example.android.quakereport;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class EarthquakeAdapter extends ArrayAdapter<Earthquake> {


    public EarthquakeAdapter(@NonNull Context context, @NonNull List<Earthquake> earthquakes) {
        super(context, 0, earthquakes);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        //Check if existing view is being reused if not inflate the view
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.earthquake_list_item, parent, false);
        }
        //Variable for current item in the list
        Earthquake currentQuake = getItem(position);
        //Set magnitude textview
        TextView magnitudeView = (TextView) listItemView.findViewById(R.id.magnitude);
        //Assign magnitude to textview
        magnitudeView.setText(String.valueOf(currentQuake.getmMagnitude()));
        //Textview for location
        TextView locationView = (TextView) listItemView.findViewById(R.id.location);
        //Set location text
        locationView.setText(currentQuake.getmLocation());
        //TextVie for date
        TextView dateView = (TextView) listItemView.findViewById(R.id.date);
        //Set date text
        dateView.setText(currentQuake.getmDate());

        return listItemView;
    }
}

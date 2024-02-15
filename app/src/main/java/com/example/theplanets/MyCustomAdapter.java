package com.example.theplanets;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class MyCustomAdapter extends ArrayAdapter<Planet> {
    private ArrayList<Planet> planetArrayList;
    Context context;

    public MyCustomAdapter(ArrayList<Planet> planetArrayList,Context context) {
        super(context, R.layout.my_list_item,planetArrayList);
        this.planetArrayList = planetArrayList;
        this.context = context;
    }

    static class ViewHolder{
        ImageView planetImage;
        TextView planetName;
        TextView moonCount;
        public ViewHolder(){
        }
    }

    @Override
    public int getCount() {
        return planetArrayList.size();
    }

    @Nullable
    @Override
    public Planet getItem(int position) {
        return planetArrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Planet planet = getItem(position);
        ViewHolder viewHolder;
        final View result;
        if(convertView == null){
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(
                    R.layout.my_list_item,
                    parent,
                    false
            );
            viewHolder = new ViewHolder();
            viewHolder.planetName = (TextView)convertView.findViewById(R.id.planetName);
            viewHolder.planetImage = (ImageView)convertView.findViewById(R.id.planetImage);
            viewHolder.moonCount = (TextView)convertView.findViewById(R.id.moonCount);
            convertView.setTag(viewHolder);
            result = convertView;
        }else{viewHolder = (ViewHolder) convertView.getTag();
            result = convertView;
        }

        viewHolder.planetName.setText(planet.getPlanetName());
        viewHolder.planetImage.setImageResource(planet.getPlanetImage());
        viewHolder.moonCount.setText((planet.getMoonCount()));
        return result;
    }
}

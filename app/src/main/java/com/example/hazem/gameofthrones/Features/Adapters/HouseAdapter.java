package com.example.hazem.gameofthrones.Features.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.hazem.gameofthrones.Models.Houses;
import com.example.hazem.gameofthrones.R;

import java.util.ArrayList;

/**
 * Created by Hazem on 6/15/2017.
 */

public class HouseAdapter extends BaseAdapter {
    ArrayList<Houses> houses=null;
    Context context;
    LayoutInflater inflater;
    HouseHolder houseHolder;
    public HouseAdapter(Context context,ArrayList<Houses> houses) {
        this.houses = houses;
        this.context = context;
        inflater=LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return houses.size();
    }

    @Override
    public Houses getItem(int i) {
        return houses.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if(view==null)
        {
            view=inflater.inflate(R.layout.house_group_layout,viewGroup,false);
            houseHolder=new HouseHolder();
            houseHolder.HouseInclude=view.findViewById(R.id.house_include);
            houseHolder.HouseName= (TextView) houseHolder.HouseInclude.findViewById(R.id.name_data);


            view.setTag(houseHolder);
        }
        else
        {
            houseHolder= (HouseHolder) view.getTag();
        }
        houseHolder.HouseName.setText(houses.get(i).getName());
        return view;
    }
    public static class HouseHolder
    {
        View HouseInclude;
        TextView HouseName;
    }
}

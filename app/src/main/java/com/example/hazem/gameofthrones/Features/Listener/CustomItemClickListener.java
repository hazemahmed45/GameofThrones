package com.example.hazem.gameofthrones.Features.Listener;

import android.util.Log;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;

import com.example.hazem.gameofthrones.Models.Characters;

/**
 * Created by Hazem on 6/23/2017.
 */

public abstract class CustomItemClickListener implements AbsListView.OnItemClickListener
{
    Characters character;
    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        character= (Characters) adapterView.getAdapter().getItem(i);
        //Log.i("NAME",character.getName());
        NavigatTo(character);
    }
    public abstract void NavigatTo(Characters character);
}

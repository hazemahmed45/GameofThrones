package com.example.hazem.gameofthrones.Features.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.hazem.gameofthrones.Models.Books;
import com.example.hazem.gameofthrones.Models.Characters;
import com.example.hazem.gameofthrones.R;

import java.util.ArrayList;

/**
 * Created by Hazem on 6/15/2017.
 */

public class CharacterAdapter  extends BaseAdapter {
    ArrayList<Characters> characters=null;
    Context context;
    LayoutInflater inflater;
    CharactersHolder charactersHolder;
    public CharacterAdapter(Context context,ArrayList<Characters> characters) {
        this.characters = characters;
        this.context = context;
        inflater=LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return characters.size();
    }

    @Override
    public Characters getItem(int i) {
        return characters.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if(view==null)
        {
            view=inflater.inflate(R.layout.character_group_layout,viewGroup,false);
            charactersHolder =new CharactersHolder();
            charactersHolder.CharacterInclude=view.findViewById(R.id.character_include);
            charactersHolder.CharacterName= (TextView) charactersHolder.CharacterInclude.findViewById(R.id.name_data);
            view.setTag(charactersHolder);
        }
        else
        {
            charactersHolder = (CharactersHolder) view.getTag();
        }
        Characters c=characters.get(i);
        charactersHolder.CharacterName.setText(c.getName());
        return view;
    }
    public static class CharactersHolder
    {
        View CharacterInclude;
        TextView CharacterName;
    }

}
package com.example.hazem.gameofthrones.Features.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import com.example.hazem.gameofthrones.Models.Characters;
import com.example.hazem.gameofthrones.R;

import java.util.ArrayList;

/**
 * Created by Hazem on 6/22/2017.
 */

public class CharactersRecyclerAdapter extends RecyclerView.Adapter<CharactersRecyclerAdapter.CharacterHolder> {

    Context context;
    ArrayList<Characters> characters;
    LayoutInflater inflater;

    public CharactersRecyclerAdapter(Context context, ArrayList<Characters> characters) {
        this.context = context;
        this.characters = characters;
        this.inflater =LayoutInflater.from(context);
    }

    @Override
    public CharacterHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view=inflater.inflate(R.layout.book_character_layout,parent,false);
        return new CharacterHolder(view);
    }

    @Override
    public void onBindViewHolder(CharacterHolder holder, int position) {
        Characters character=characters.get(position);
        holder.name.setText(character.getName());
        if(character.getTitles()!=null && character.getTitles().size()>0)
        {
            holder.title.setText(character.getTitles().get(0));
        }
    }

    @Override
    public int getItemCount() {
        return characters.size();
    }

    public class CharacterHolder extends RecyclerView.ViewHolder
    {
        TextView name,title;
        public CharacterHolder(View itemView) {
            super(itemView);
            name= (TextView) itemView.findViewById(R.id.book_character_name);
            title= (TextView) itemView.findViewById(R.id.book_character_first_title);
        }
    }
}

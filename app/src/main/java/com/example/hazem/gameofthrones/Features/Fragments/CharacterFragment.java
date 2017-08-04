package com.example.hazem.gameofthrones.Features.Fragments;


import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ExpandableListView;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.example.hazem.gameofthrones.Base.Constants.APIKeys;
import com.example.hazem.gameofthrones.Base.GOTapplications;
import com.example.hazem.gameofthrones.Features.Adapters.CharacterAdapter;
import com.example.hazem.gameofthrones.Features.Listener.CustomItemClickListener;
import com.example.hazem.gameofthrones.Features.Listener.CustomScrollListener;
import com.example.hazem.gameofthrones.Models.Characters;
import com.example.hazem.gameofthrones.R;
import com.example.hazem.gameofthrones.Utils.NavigatorUtils;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class CharacterFragment extends Fragment {


    public CharacterFragment() {
        // Required empty public constructor
    }

    View view;
    ListView listView;
    ArrayList<Characters> characters;
    SwipeRefreshLayout swipeRefreshLayout;
    CharacterAdapter adapter;
    int page=1;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.character_fragment, container, false);
        SettingIDs();
        GettingData(1,false);
        return view;
    }
    void SettingIDs()
    {
        swipeRefreshLayout= (SwipeRefreshLayout) view.findViewById(R.id.swipe_refresh);
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                page++;
                GettingData(page,true);
            }
        });
        listView= (ListView) view.findViewById(R.id.character_listview);
        listView.setOnScrollListener(new CustomScrollListener() {
            @Override
            public boolean onLoadMore(int page, int totalItemsCount) {
                GettingData(page,false);
                return true;
            }
        });
        listView.setOnItemClickListener(new CustomItemClickListener() {
            @Override
            public void NavigatTo(Characters character) {
                Log.i("NAME",character.getName());
                NavigatorUtils.NavigateToCharactersScreen((AppCompatActivity)CharacterFragment.this.getActivity(),character);
            }
        });
    }
    void GettingData(int index, final boolean check)
    {
        RequestQueue queue= GOTapplications.getmInstance().getQueue(CharacterFragment.this.getContext());
        StringRequest request=new StringRequest(StringRequest.Method.GET, APIKeys.AllCharactersAPI+APIKeys.PAGES+index, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                ArrayList<Characters> c=(GOTapplications.getmInstance().getGson()).fromJson(response,new TypeToken<ArrayList<Characters>>(){}.getType());
                if(characters==null)
                {
                    characters=c;
                    adapter=new CharacterAdapter(CharacterFragment.this.getContext(),characters);
                    listView.setAdapter(adapter);
                }
                else
                {

                    if(check==false)
                    {
                        characters.addAll(c);
                    }
                    else
                    {
                        characters.addAll(0,c);
                        swipeRefreshLayout.setRefreshing(false);
                    }
                    adapter.notifyDataSetChanged();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getContext(), "error", Toast.LENGTH_SHORT).show();
            }
        });
        queue.add(request);
    }

}

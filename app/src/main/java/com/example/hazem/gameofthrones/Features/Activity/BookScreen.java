package com.example.hazem.gameofthrones.Features.Activity;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.example.hazem.gameofthrones.Base.Constants.NavConstants;
import com.example.hazem.gameofthrones.Base.GOTapplications;
import com.example.hazem.gameofthrones.Features.Adapters.CharactersRecyclerAdapter;
import com.example.hazem.gameofthrones.Models.Books;
import com.example.hazem.gameofthrones.Models.Characters;
import com.example.hazem.gameofthrones.R;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;

public class BookScreen extends AppCompatActivity {
    Books book;
    RequestQueue queue;
    ProgressDialog progressDialog;
    TextView author,publisher,mediatype,country,release,pages;
    RecyclerView CharacterrecyclerView,PovcharacterRecyeclerview;
    ArrayList<Characters> characters,Povcharacters;
    CharactersRecyclerAdapter adapter1,adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.book_screen_activity);
        if(getIntent()!=null )
        {
            book= (Books) getIntent().getSerializableExtra(NavConstants.BookKey);
            getSupportActionBar().setTitle(book.getName());
        }
        SettingIDs();
        SettingData();
    }
    void SettingIDs()
    {
        progressDialog=new ProgressDialog(this);
        queue= GOTapplications.getmInstance().getQueue(this);
        author= (TextView) findViewById(R.id.book_auther);
        publisher= (TextView) findViewById(R.id.book_publisher);
        mediatype= (TextView) findViewById(R.id.book_mediatype);
        pages= (TextView) findViewById(R.id.book_pages);
        release= (TextView) findViewById(R.id.book_release);
        country= (TextView) findViewById(R.id.book_country);
        CharacterrecyclerView = (RecyclerView) findViewById(R.id.bookcharacters_recyclerview);
        PovcharacterRecyeclerview = (RecyclerView) findViewById(R.id.bookpovcharacters_recyclerview);

    }
    void SettingData()
    {
        Books b=book;
        progressDialog.setMessage("Loading...");
        progressDialog.show();
        author.setText(GetAuthor(b.getAuthors()));
        publisher.setText(b.getPublisher());
        mediatype.setText(b.getMediaType());
        pages.setText(b.getNumberOfPages()+"");
        release.setText(b.getReleased());
        country.setText(b.getCountry());
        for (String urls:b.getPovCharacters())
        {
            Log.i("PovCharacters",urls);
            StringRequest request=new StringRequest(StringRequest.Method.GET, urls, new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
                    Gson gson=new Gson();
                    Characters c=gson.fromJson(response,new TypeToken<Characters>(){}.getType());
                    Log.i("PovCharacters",c.getName());
                    if(Povcharacters==null)
                    {

                        Povcharacters=new ArrayList<>();
                        Povcharacters.add(c);
                        adapter1=new CharactersRecyclerAdapter(BookScreen.this,Povcharacters);
                        PovcharacterRecyeclerview.setAdapter(adapter1);
                        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(BookScreen.this,LinearLayoutManager.HORIZONTAL,false);
                        PovcharacterRecyeclerview.setLayoutManager(linearLayoutManager);
                    }
                    else
                    {
                        Povcharacters.add(c);
                        adapter1.notifyDataSetChanged();
                    }
                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {

                }
            });
            queue.add(request);
        }
        for (String urls:b.getCharacters())
        {
            StringRequest request=new StringRequest(StringRequest.Method.GET, urls, new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
                    Gson gson=new Gson();
                    Characters c=gson.fromJson(response,new TypeToken<Characters>(){}.getType());

                    if(characters==null)
                    {
                        characters=new ArrayList<>();
                        characters.add(c);
                        adapter=new CharactersRecyclerAdapter(BookScreen.this,characters);
                        CharacterrecyclerView.setAdapter(adapter);
                        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(BookScreen.this,LinearLayoutManager.HORIZONTAL,false);
                        CharacterrecyclerView.setLayoutManager(linearLayoutManager);
                    }
                    else
                    {
                        progressDialog.dismiss();
                        characters.add(c);
                        adapter.notifyDataSetChanged();
                    }
                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {

                }
            });
            queue.add(request);
        }


    }
    String GetAuthor(ArrayList<String> authors)
    {
        String author="";
        StringBuffer stringBuffer=new StringBuffer(author);
        for (String string:authors)
        {
            stringBuffer.append(string+",");
        }
        author=stringBuffer.toString();
        return author;
    }
}

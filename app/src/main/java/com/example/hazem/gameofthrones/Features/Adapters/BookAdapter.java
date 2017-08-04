package com.example.hazem.gameofthrones.Features.Adapters;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.example.hazem.gameofthrones.Base.GOTapplications;
import com.example.hazem.gameofthrones.Models.Books;
import com.example.hazem.gameofthrones.Models.Characters;
import com.example.hazem.gameofthrones.R;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;

/**
 * Created by Hazem on 6/15/2017.
 */

public class BookAdapter extends BaseAdapter {
    ArrayList<Books> books=null;

    Context context;
    LayoutInflater inflater;
    BooksGroupHolder booksGroupHolder;
    int counter=0;
    public BookAdapter(Context context,ArrayList<Books> books) {
        this.books = books;
        this.context = context;
        inflater=LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return books.size();
    }

    @Override
    public Books getItem(int i) {
        return books.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if(view==null)
        {
            view=inflater.inflate(R.layout.book_group_layout,viewGroup,false);
            booksGroupHolder=new BooksGroupHolder();
            booksGroupHolder.BookInclude=  view.findViewById(R.id.book_include);
            booksGroupHolder.BookName= (TextView) booksGroupHolder.BookInclude.findViewById(R.id.name_data);
            view.setTag(booksGroupHolder);
        }
        else
        {
            booksGroupHolder= (BooksGroupHolder) view.getTag();
        }
        booksGroupHolder.BookName.setText(books.get(i).getName());
        return view;
    }


    public static class BooksGroupHolder
    {
        View BookInclude;
        TextView BookName;
    }


}

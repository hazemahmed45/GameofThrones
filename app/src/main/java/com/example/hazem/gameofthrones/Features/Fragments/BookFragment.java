package com.example.hazem.gameofthrones.Features.Fragments;


import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.media.VolumeProviderCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ExpandableListView;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.NetworkResponse;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.ServerError;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.HttpClientStack;
import com.android.volley.toolbox.HttpHeaderParser;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.hazem.gameofthrones.Base.Constants.APIKeys;
import com.example.hazem.gameofthrones.Base.GOTapplications;
import com.example.hazem.gameofthrones.Features.Adapters.BookAdapter;
import com.example.hazem.gameofthrones.Models.Books;
import com.example.hazem.gameofthrones.R;
import com.example.hazem.gameofthrones.Utils.NavigatorUtils;
import com.example.hazem.gameofthrones.Utils.StringUtil;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * A simple {@link Fragment} subclass.
 */
public class BookFragment extends Fragment {


    public BookFragment() {
        // Required empty public constructor
    }
    RequestQueue queue;
    ProgressDialog progressDialog;
    View view;
    ArrayList<Books> books;
    ListView listView;
    BookAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.book_fragment, container, false);
        SettingIDs();
        GettingBooks();
        return view;
    }
    void SettingIDs()
    {
        progressDialog=new ProgressDialog(getContext());
        progressDialog.setMessage("Loading...");
        progressDialog.show();
        queue= GOTapplications.getmInstance().getQueue(BookFragment.this.getContext());
        listView= (ListView) view.findViewById(R.id.book_listview);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Books book=adapter.getItem(i);
                NavigatorUtils.NavigateToBookScreen(getActivity(),book);
            }
        });
    }

    void GettingBooks()
    {
//        HashMap<String, String> params = new HashMap<String, String>();
//        params.put("Accept", "application/vnd.anapioficeandfire+json; version=1");
//        params.put("Content-Type", "application/vnd.anapioficeandfire+json; charset=utf-8");
        StringRequest request=new StringRequest(StringRequest.Method.GET, APIKeys.AllBooksAPI, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Gson gson=new Gson();
                books=gson.fromJson(response,new TypeToken<ArrayList<Books>>(){}.getType());
                adapter=new BookAdapter(BookFragment.this.getContext(),books);
                listView.setAdapter(adapter);
                progressDialog.dismiss();
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

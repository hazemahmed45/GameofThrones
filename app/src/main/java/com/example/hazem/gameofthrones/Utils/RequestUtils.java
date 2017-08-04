package com.example.hazem.gameofthrones.Utils;

import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.example.hazem.gameofthrones.Base.GOTapplications;
import com.example.hazem.gameofthrones.Models.Books;
import com.example.hazem.gameofthrones.Models.Characters;
import com.example.hazem.gameofthrones.Models.Houses;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;

/**
 * Created by Hazem on 6/24/2017.
 */

public class RequestUtils {
    public static void RequestCharacter(String url, View view, final TextView textView, RequestQueue queue)
    {
        Log.i("URL",url);
        if(!url.equals(""))
        {
            StringRequest request=new StringRequest(StringRequest.Method.GET, url, new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
                    Characters character=(GOTapplications.getmInstance().getGson()).fromJson(response,new TypeToken<Characters>(){}.getType());
                    textView.setText(character.getName());
                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {

                }
            });
            queue.add(request);
        }
        else
        {
            view.setVisibility(View.GONE);
        }
    }
    public static void RequestHouse(String url, View view, final TextView textView, RequestQueue queue)
    {
        if(!url.equals(""))
        {
            StringRequest request=new StringRequest(StringRequest.Method.GET, url, new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
                    Houses houses=(GOTapplications.getmInstance().getGson()).fromJson(response,new TypeToken<Houses>(){}.getType());
                    textView.setText(houses.getName());
                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {

                }
            });
            queue.add(request);
        }
        else
        {
            view.setVisibility(View.GONE);
        }
    }
    public static void RequestBook(String url, View view, final TextView textView, RequestQueue queue)
    {
        if(!url.equals(""))
        {
            StringRequest request=new StringRequest(StringRequest.Method.GET, url, new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
                    Books book=(GOTapplications.getmInstance().getGson()).fromJson(response,new TypeToken<Books>(){}.getType());
                    textView.setText(book.getName());
                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {

                }
            });
            queue.add(request);
        }
        else
        {
            view.setVisibility(View.GONE);
        }

    }
    public static void RequestBooks(ArrayList<String> urls, View view, final TextView textView, RequestQueue queue)
    {
        if(urls.size()>0)
        {
            for (String url:urls)
            {
                StringRequest request=new StringRequest(StringRequest.Method.GET, url, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Books book=(GOTapplications.getmInstance().getGson()).fromJson(response,new TypeToken<Books>(){}.getType());
                        textView.setText(textView.getText()+book.getName()+"\n");
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                });
                queue.add(request);
            }
        }
        else
        {
            view.setVisibility(View.GONE);
        }

    }
    public static void RequestHouses(ArrayList<String> urls, View view, final TextView textView, RequestQueue queue)
    {
        if(urls.size()>0)
        {
            for (String url:urls)
            {
                StringRequest request=new StringRequest(StringRequest.Method.GET, url, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Houses house=(GOTapplications.getmInstance().getGson()).fromJson(response,new TypeToken<Houses>(){}.getType());
                        textView.setText(textView.getText()+house.getName()+"\n");
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                });
                queue.add(request);
            }
        }
        else
        {
            view.setVisibility(View.GONE);
        }

    }
    public static void RequestCharacters(ArrayList<String> urls, View view, final TextView textView, RequestQueue queue)
    {
        if(urls.size()>0)
        {
            for (String url:urls)
            {
                StringRequest request=new StringRequest(StringRequest.Method.GET, url, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Characters character=(GOTapplications.getmInstance().getGson()).fromJson(response,new TypeToken<Characters>(){}.getType());
                        textView.setText(textView.getText()+character.getName()+"\n");
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                });
                queue.add(request);
            }
        }
        else
        {
            view.setVisibility(View.GONE);
        }

    }

}

package com.example.hazem.gameofthrones.Base;

import android.app.Application;
import android.content.Context;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;

/**
 * Created by Hazem on 6/15/2017.
 */

public class GOTapplications extends Application {

    private static GOTapplications mInstance;
    private RequestQueue queue;
    private Gson gson;
    public static GOTapplications getmInstance() {
        return mInstance;
    }
    public RequestQueue getQueue(Context context)
    {
        if(queue==null)
        {
            queue= Volley.newRequestQueue(context);
        }
        return queue;
    }
    public Gson getGson()
    {
        if(gson==null)
        {
            gson=new Gson();
        }
        return gson;
    }
    @Override
    public void onCreate() {
        super.onCreate();
        mInstance=this;
    }
}

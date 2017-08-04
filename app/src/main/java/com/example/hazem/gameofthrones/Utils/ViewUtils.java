package com.example.hazem.gameofthrones.Utils;

import android.view.View;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.example.hazem.gameofthrones.Base.GOTapplications;
import com.example.hazem.gameofthrones.Models.Books;
import com.example.hazem.gameofthrones.Models.Characters;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;

/**
 * Created by Hazem on 6/23/2017.
 */

public class ViewUtils {
    public static void CheckView(String string, View view, TextView textView)
    {
        string=string.trim();
        if(!string.equals("") )
        {
            textView.setText(string);
        }
        else
        {
            view.setVisibility(View.GONE);
        }
    }
    public static String getStringFromList(ArrayList<String> list)
    {
        String title="";
        if (list.size()<=0)
        {
            return "";
        }
        StringBuffer buffer=new StringBuffer(title);
        for (String s:list)
        {
            buffer.append(s+"\n");
        }
        title=buffer.toString();
        return title;
    }

}

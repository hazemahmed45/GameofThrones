package com.example.hazem.gameofthrones.Features.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.example.hazem.gameofthrones.Base.Constants.APIKeys;
import com.example.hazem.gameofthrones.Base.GOTapplications;
import com.example.hazem.gameofthrones.Features.Adapters.HouseAdapter;
import com.example.hazem.gameofthrones.Features.Listener.CustomScrollListener;
import com.example.hazem.gameofthrones.Models.Houses;
import com.example.hazem.gameofthrones.R;
import com.example.hazem.gameofthrones.Utils.NavigatorUtils;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class HouseFragment extends Fragment {


    public HouseFragment() {
        // Required empty public constructor
    }
    ListView listView;
    ArrayList<Houses> houses;
    View view;
    HouseAdapter adapter;
    RequestQueue queue;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.house_fragment, container, false);
        SettingsIDs();
        gettingDataPagination(1);
        return view;
    }
    void SettingsIDs()
    {
        queue=GOTapplications.getmInstance().getQueue(HouseFragment.this.getContext());
        listView= (ListView) view.findViewById(R.id.house_listview);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Houses house=adapter.getItem(i);
                NavigatorUtils.NavigateToHouseScreen(HouseFragment.this.getActivity(),house);
            }
        });
        listView.setOnScrollListener(new CustomScrollListener() {
            @Override
            public boolean onLoadMore(int page, int totalItemsCount) {
                gettingDataPagination(page);
                return false;
            }
        });
    }

    @Override
    public void onResume() {
        super.onResume();

    }

    void gettingDataPagination(final int index)
    {

        StringRequest request=new StringRequest(StringRequest.Method.GET, APIKeys.AllHousesAPI+APIKeys.PAGES+index, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                ArrayList<Houses>h=(GOTapplications.getmInstance().getGson()).fromJson(response,new TypeToken<ArrayList<Houses>>(){}.getType());
                if(houses==null && index==1)
                {
                    houses=h;
                    adapter=new HouseAdapter(HouseFragment.this.getContext(),houses);
                    listView.setAdapter(adapter);
                }
                else
                {
                    houses.addAll(h);
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
//    private class CacheRequest extends Request<NetworkResponse> {
//        private final Response.Listener<NetworkResponse> mListener;
//        private final Response.ErrorListener mErrorListener;
//
//        public CacheRequest(int method, String url, Response.Listener<NetworkResponse> listener, Response.ErrorListener errorListener) {
//            super(method, url, errorListener);
//            this.mListener = listener;
//            this.mErrorListener = errorListener;
//        }
//
//
//        @Override
//        protected Response<NetworkResponse> parseNetworkResponse(NetworkResponse response) {
//            Cache.Entry cacheEntry = HttpHeaderParser.parseCacheHeaders(response);
//            if (cacheEntry == null) {
//                cacheEntry = new Cache.Entry();
//            }
//            final long cacheHitButRefreshed = 3 * 60 * 1000; // in 3 minutes cache will be hit, but also refreshed on background
//            final long cacheExpired = 24 * 60 * 60 * 1000; // in 24 hours this cache entry expires completely
//            long now = System.currentTimeMillis();
//            final long softExpire = now + cacheHitButRefreshed;
//            final long ttl = now + cacheExpired;
//            cacheEntry.data = response.data;
//            cacheEntry.softTtl = softExpire;
//            cacheEntry.ttl = ttl;
//            String headerValue;
//            headerValue = response.headers.get("Date");
//            if (headerValue != null)
//            {
//                cacheEntry.serverDate = HttpHeaderParser.parseDateAsEpoch(headerValue);
//            }
//            headerValue = response.headers.get("Last-Modified");
//            if (headerValue != null)
//            {
//                cacheEntry.lastModified = HttpHeaderParser.parseDateAsEpoch(headerValue);
//            }
//            cacheEntry.responseHeaders = response.headers;
//            return Response.success(response, cacheEntry);
//        }
//
//        @Override
//        protected void deliverResponse(NetworkResponse response) {
//            mListener.onResponse(response);
//        }
//
//        @Override
//        protected VolleyError parseNetworkError(VolleyError volleyError) {
//            return super.parseNetworkError(volleyError);
//        }
//
//        @Override
//        public void deliverError(VolleyError error) {
//            mErrorListener.onErrorResponse(error);
//        }
//    }
}

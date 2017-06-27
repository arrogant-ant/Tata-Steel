package com.example.sabita_sant.niwaas;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

/**
 * Created by Sabita_Sant on 6/26/2017.
 */
public class VolleySingleton {
    private static VolleySingleton instance;
    private RequestQueue requestQueue;
    private static Context ctx;
    private VolleySingleton(Context context)
    {
        ctx=context;
        requestQueue=getRequestQueue();
    }

    public  static synchronized VolleySingleton getInstance(Context context) {
        if(instance==null)
            instance=new VolleySingleton(context);
        return instance;
    }

    public RequestQueue getRequestQueue() {
        if (requestQueue==null)
            requestQueue= Volley.newRequestQueue(ctx.getApplicationContext());
        return requestQueue;
    }

    public <T> void addRequest(Request<T> request)
    {
        requestQueue.add(request);
    }
}

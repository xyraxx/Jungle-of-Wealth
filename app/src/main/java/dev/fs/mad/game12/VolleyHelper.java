package dev.fs.mad.game12;

import android.content.Context;

import com.android.volley.RequestQueue;

public class VolleyHelper {

    private static RequestQueue mRequestQueue;
    private VolleyHelper() {}
    public static void init(Context context) {
        mRequestQueue = com.android.volley.toolbox.Volley.newRequestQueue(context);
    }
    public static RequestQueue getRequestQueue() {
        if (mRequestQueue != null) {
            return mRequestQueue;
        } else {
            throw new IllegalStateException("RequestQueue not initialized");
        }
    }

}

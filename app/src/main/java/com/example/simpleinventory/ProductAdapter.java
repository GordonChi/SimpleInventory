package com.example.simpleinventory;

import android.content.Context;

import android.widget.ArrayAdapter;

import androidx.annotation.NonNull;

import java.util.ArrayList;
import java.util.List;
// !!!!!!!!!!!!!!!!!!!!!!!!!!! IMPORTANT !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
// Everything and anything to do with the recyclerview should be done here

public class ProductAdapter extends ArrayAdapter<productInfo> {

    private ArrayList<productInfo> itemList;
    private Context context;

    public ProductAdapter(Context context, ArrayList<productInfo> itemList) {
        super(context, 0, itemList);
        this.context = context;
        this.itemList = itemList;
    }


    public ProductAdapter(@NonNull Context context, int resource) {
        super(context, resource);
    }

    public ProductAdapter(@NonNull Context context, int resource, int textViewResourceId) {
        super(context, resource, textViewResourceId);
    }

    public ProductAdapter(@NonNull Context context, int resource, @NonNull productInfo[] objects) {
        super(context, resource, objects);
    }

    public ProductAdapter(@NonNull Context context, int resource, int textViewResourceId, @NonNull productInfo[] objects) {
        super(context, resource, textViewResourceId, objects);
    }

    public ProductAdapter(@NonNull Context context, int resource, @NonNull List<productInfo> objects) {
        super(context, resource, objects);
    }

    public ProductAdapter(@NonNull Context context, int resource, int textViewResourceId, @NonNull List<productInfo> objects) {
        super(context, resource, textViewResourceId, objects);
    }
}
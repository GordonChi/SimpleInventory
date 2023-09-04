package com.example.simpleinventory;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    // Reference recyclerview and button
    private Button addItem;
    private ListView productsView;
    private ProductAdapter ProductAdapter;
    private ArrayAdapter productArrayAdapter;
    private List<productInfo> productList;
    private int selectedPosition;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        InventoryDbHelper dbHelper = new InventoryDbHelper(this);
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        ArrayList itemList = new ArrayList();
        productList = new ArrayList<>();
        productsView = findViewById(R.id.products);
        /*
        Populate the recyclerview with this list from
        data pulled from database
        */

        itemList =(ArrayList) dbHelper.getAllinfo();
        productArrayAdapter = new ArrayAdapter<productInfo>(MainActivity.this, android.R.layout.simple_list_item_1, productList);
        productsView.setAdapter(productArrayAdapter);
        productsView = findViewById(R.id.products);



        addItem = findViewById(R.id.addItem);
        addItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Opens the addItem activity
                Intent intent = new Intent(MainActivity.this, addItem.class);
                startActivity(intent);
            }
        });


        fetchItemsFromDatabase();

    }

    private void fetchItemsFromDatabase() {
        productList.clear();

        InventoryDbHelper dbHelper = new InventoryDbHelper(this);
        SQLiteDatabase db = dbHelper.getReadableDatabase();

        Cursor cursor = db.rawQuery("SELECT * FROM inventory", null);

        if (cursor.moveToFirst()) {
            do {
                int id = cursor.getInt(0);
                String itemName = cursor.getString(1);
                int lotNumber = cursor.getInt(2);
                int productRcv = cursor.getInt(3);
                int productUsed = cursor.getInt(4);
                int productInv = cursor.getInt(5);
                int productShp = cursor.getInt(6);
                String productDsp = cursor.getString(7);
                String productRwk = cursor.getString(8);

                productInfo productinfo = new productInfo(id, itemName, lotNumber, productRcv, productUsed, productInv, productShp, productDsp, productRwk);
                productList.add(productinfo);
            }   while (cursor.moveToNext());
        }
        cursor.close();
        productArrayAdapter.notifyDataSetChanged();
        db.close();

        //ProductAdapter.updateList(productList); // Update the adapter with new data
    }
}
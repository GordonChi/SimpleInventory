package com.example.simpleinventory;

import androidx.appcompat.app.AppCompatActivity;
import android.database.sqlite.SQLiteDatabase;
import android.content.ContentValues;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class addItem extends AppCompatActivity {

    private EditText ItemName, LotNumber, received, used, inventory, shipped, disposed, reworked;
    private EditText id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_item);
        InventoryDbHelper dbHelper = new InventoryDbHelper(this);
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        int newID = dbHelper.getLargestID();
        String toString = String.valueOf(newID);
        // editText boxes for values
        ItemName = findViewById(R.id.itemName);
        id = findViewById(R.id.itemId);
        id.setText(toString);
        LotNumber = findViewById(R.id.itemLotNum);
        received = findViewById(R.id.itemRecieved);
        used = findViewById(R.id.itemUsed);
        inventory = findViewById(R.id.itemInventory);
        shipped = findViewById(R.id.itemShipped);
        disposed = findViewById(R.id.itemDisposed);
        reworked = findViewById(R.id.itemReworked);

        Button buttonSaveItem = findViewById(R.id.buttonSaveItem);

        buttonSaveItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveItemToDatabase();
                finish(); // Close the addItemActivity and go back to main
            }
        });

    }
    private void saveItemToDatabase() {
        // Get the string value from the editText box
        String itemName = ItemName.getText().toString().trim();

        // Add the item to the database
        InventoryDbHelper dbHelper = new InventoryDbHelper(this);
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(InventoryContract.InventoryEntry.COLUMN_ITEM_NAME, itemName);
        // Put other item properties into the ContentValues if needed

        long newRowId = db.insert(InventoryContract.InventoryEntry.TABLE_NAME, null, values);

        db.close();
    }
}
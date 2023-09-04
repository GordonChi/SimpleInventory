package com.example.simpleinventory;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;


public class InventoryDbHelper extends SQLiteOpenHelper {
    public static final int DATABASE_VERSION = 2;
    public static final String DATABASE_NAME = "Inventory.db";
    final String TABLE_NAME = "inventory";

    private static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE " + InventoryContract.InventoryEntry.TABLE_NAME + " (" +
                    InventoryContract.InventoryEntry.COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    InventoryContract.InventoryEntry.COLUMN_ITEM_NAME + " TEXT," +
                    InventoryContract.InventoryEntry.COLUMN_ITEM_LOT_NUMBER + " INTEGER," +
                    InventoryContract.InventoryEntry.COLUMN_ITEM_RECEIVED + " INTEGER," +
                    InventoryContract.InventoryEntry.COLUMN_ITEM_USED + " INTEGER," +
                    InventoryContract.InventoryEntry.COLUMN_ITEM_INVENTORY + " INTEGER," +
                    InventoryContract.InventoryEntry.COLUMN_ITEM_SHIPPED + " INTEGER," +
                    InventoryContract.InventoryEntry.COLUMN_ITEM_DISPOSED + " TEXT," +
                    InventoryContract.InventoryEntry.COLUMN_ITEM_REWORKED + " TEXT" +
                    // Add other columns for other item properties if needed
                    ")";
    private static final String SQL_DELETE_ENTRIES = "DROP TABLE IF EXISTS " + InventoryContract.InventoryEntry.TABLE_NAME;

    public InventoryDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_ENTRIES);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(SQL_DELETE_ENTRIES);
        onCreate(db);
    }

    // Method to find the newest entry into the database
    public int getLargestID() {
        SQLiteDatabase db = this.getReadableDatabase();
        int largestID = -1;
        // String query = SELECT MAX ID as ID FROM TABLE_NAME
        String selectQuery = "SELECT MAX(ID) FROM inventory";
        Cursor cursor = db.rawQuery(selectQuery, null);
        cursor.moveToFirst();

        int foundID = cursor.getInt(0);
        return foundID;
    }

    public List<productInfo> getAllinfo() {
        List<productInfo> returnList = new ArrayList<>();

        // Get data from database
        String queryString = "SELECT * FROM " + TABLE_NAME;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(queryString, null);
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

                productInfo itemInfo = new productInfo(id, itemName, lotNumber, productRcv, productUsed, productInv, productShp, productDsp, productRwk);
                returnList.add(itemInfo);


            } while (cursor.moveToNext());
        }

        else {
            //no results, don't add anything to list
            }
            // Finished, return list
            cursor.close();
            db.close();
            return returnList;
        }
    }


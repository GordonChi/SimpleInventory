package com.example.simpleinventory;

import android.provider.BaseColumns;

public final class InventoryContract {
    private InventoryContract() {}

    public static class InventoryEntry implements BaseColumns {
        public static final String TABLE_NAME = "inventory";
        public static final String COLUMN_ID = "id";
        public static final String COLUMN_ITEM_NAME = "item_name";
        public static final String COLUMN_ITEM_LOT_NUMBER = "item_lot_number";
        public static final String COLUMN_ITEM_RECEIVED = "item_received";
        public static final String COLUMN_ITEM_USED = "item_used";
        public static final String COLUMN_ITEM_INVENTORY = "item_inventory";
        public static final String COLUMN_ITEM_SHIPPED = "item_shipped";
        public static final String COLUMN_ITEM_DISPOSED = "item_disposed";
        public static final String COLUMN_ITEM_REWORKED = "item_reworked";

        // Add more columns when needed
    }
}

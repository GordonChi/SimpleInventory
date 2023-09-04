package com.example.simpleinventory;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

public class productInfo implements Parcelable {

    private int id;
    private String itemName;
    private int lotNumber;
    private int productReceived;
    private int productUsed;
    private int productInventory;
    private int productShipped;
    private String productDisposed;
    private String productReworked;


    // Constructor methods
    public productInfo(int id, String itemName, int lotNumber, int productReceived, int productUsed, int productInventory, int productShipped, String productDisposed, String productReworked) {
        this.id = id;
        this.itemName = itemName;
        this.lotNumber = lotNumber;
        this.productReceived = productReceived;
        this.productUsed = productUsed;
        this.productInventory = productInventory;
        this.productShipped = productShipped;
        this.productDisposed = productDisposed;
        this.productReworked = productReworked;

    }

    @Override
    public String toString() {
        return "productInfo{" +
                "id=" + id +
                ", itemName='" + itemName + '\'' +
                ", lotNumber=" + lotNumber +
                ", productReceived=" + productReceived +
                ", productUsed=" + productUsed +
                ", productInventory=" + productInventory +
                ", productShipped=" + productShipped +
                ", productDisposed='" + productDisposed + '\'' +
                ", productReworked='" + productReworked + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public int getLotNumber() {
        return lotNumber;
    }

    public void setLotNumber(int lotNumber) {
        this.lotNumber = lotNumber;
    }

    public int getProductReceived() {
        return productReceived;
    }

    public void setProductReceived(int productReceived) {
        this.productReceived = productReceived;
    }

    public int getProductUsed() {
        return productUsed;
    }

    public void setProductUsed(int productUsed) {
        this.productUsed = productUsed;
    }

    public int getProductInventory() {
        return productInventory;
    }

    public void setProductInventory(int productInventory) {
        this.productInventory = productInventory;
    }

    public int getProductShipped() {
        return productShipped;
    }

    public void setProductShipped(int productShipped) {
        this.productShipped = productShipped;
    }

    public String getProductDisposed() {
        return productDisposed;
    }

    public void setProductDisposed(String productDisposed) {
        this.productDisposed = productDisposed;
    }

    public void setProductReworked(String productReworked) {
        this.productReworked = productReworked;
    }
    // End of setter/getter

    protected productInfo(Parcel in) {
    }

    public static final Creator<productInfo> CREATOR = new Creator<productInfo>() {
        @Override
        public productInfo createFromParcel(Parcel in) {
            return new productInfo(in);
        }

        @Override
        public productInfo[] newArray(int size) {
            return new productInfo[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel dest, int flags) {
    }
}

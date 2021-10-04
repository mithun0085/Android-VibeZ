package com.example.weddingdiary;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.TextView;

import com.example.weddingdiary.Database.OrderContract;

public class CartAdapter extends CursorAdapter {


    public CartAdapter(Context context, Cursor cursor) {
        super(context, cursor, 0);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        return LayoutInflater.from(context).inflate(R.layout.cartlist, parent, false);
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {

        // getting theviews

        TextView packageName, yesOther, yesExtra, price, quantity;


        packageName = view.findViewById(R.id.packageNameinOrderSummary);
        price = view.findViewById(R.id.priceinOrderSummary);
        yesOther = view.findViewById(R.id.hasOther);
        yesExtra = view.findViewById(R.id.hasExtra);
        quantity = view.findViewById(R.id.quantityinOrderSummary);

        // getting the values by first getting the position of their columns

        int name = cursor.getColumnIndex(OrderContract.OrderEntry.COLUMN_NAME);
        int priceofpackage = cursor.getColumnIndex(OrderContract.OrderEntry.COLUMN_PRICE);
        int quantityofpackage = cursor.getColumnIndex(OrderContract.OrderEntry.COLUMN_QUANTITY);
        int hasOther = cursor.getColumnIndex(OrderContract.OrderEntry.COLUMN_OTHER);
        int hasExtra = cursor.getColumnIndex(OrderContract.OrderEntry.COLUMN_HASEXTRA);


        String nameofpackage = cursor.getString(name);
        String pricesofpackage = cursor.getString(priceofpackage);
        String quantitysofpackage = cursor.getString(quantityofpackage);
        String yeshasOther = cursor.getString(hasOther);
        String yeshasextra = cursor.getString(hasExtra);



        packageName.setText(nameofpackage);
        price.setText(pricesofpackage);
        yesOther.setText(yeshasOther);
        yesExtra.setText(yeshasextra);
        quantity.setText(quantitysofpackage);





    }
}

package com.example.weddingdiary;

import android.app.LoaderManager;
import android.content.ContentValues;
import android.content.CursorLoader;
import android.content.Intent;
import android.content.Loader;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.weddingdiary.Database.OrderContract;

public class LatteActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<Cursor> {

    // first of all we will get the views that are  present in the layout of info

    ImageView imageView;
    ImageButton plusquantity, minusquantity;
    TextView quantitynumber, packaageName, packagePrice;
    CheckBox addExtras, addExtraOther;
    Button addtoCart;
    int quantity;
    public Uri mCurrentCartUri;
    boolean hasAllRequiredValues = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        imageView = findViewById(R.id.imageViewInfo);
        plusquantity = findViewById(R.id.addquantity);
        minusquantity  = findViewById(R.id.subquantity);
        quantitynumber = findViewById(R.id.quantity);
        packaageName = findViewById(R.id.packageNameinInfo);
        packagePrice = findViewById(R.id.packagePrice);
        addExtras = findViewById(R.id.addExtras);
        addtoCart = findViewById(R.id.addtocart);
        addExtraOther = findViewById(R.id.addOther);

        // setting the name of drink

        packaageName.setText("Semi Luxury");
        imageView.setImageResource(R.drawable.invi1);

        addtoCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LatteActivity.this, SummaryActivity.class);
                startActivity(intent);
                // once this button is clicked we want to save our values in the database and send those values
                // right away to summary activity where we display the order info

                SaveCart();
            }
        });

        plusquantity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // coffee price
                int basePrice = 5;
                quantity++;
                displayQuantity();
                int packagPrice = basePrice * quantity;
                String setnewPrice = String.valueOf(packagPrice);
                packagePrice.setText(setnewPrice);


                // checkBoxes functionality

                int ifCheckBox = CalculatePrice(addExtraOther, addExtras);
                packagePrice.setText("$ " + ifCheckBox);

            }
        });

        minusquantity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int basePrice = 5;
                // because we dont want the quantity go less than 0
                if (quantity == 0) {
                    Toast.makeText(LatteActivity.this, "Cant decrease quantity < 0", Toast.LENGTH_SHORT).show();
                } else {
                    quantity--;
                    displayQuantity();
                    int packagPrice = basePrice * quantity;
                    String setnewPrice = String.valueOf(packagPrice);
                    packagePrice.setText(setnewPrice);


                    // checkBoxes functionality

                    int ifCheckBox = CalculatePrice(addExtraOther, addExtras);
                    packagePrice.setText("$ " + ifCheckBox);
                }
            }
        });



    }

    private boolean SaveCart() {

        // getting the values from our views
        String name = packaageName.getText().toString();
        String price = packagePrice.getText().toString();
        String quantity = quantitynumber.getText().toString();

        ContentValues values = new ContentValues();
        values.put(OrderContract.OrderEntry.COLUMN_NAME, name);
        values.put(OrderContract.OrderEntry.COLUMN_PRICE, price);
        values.put(OrderContract.OrderEntry.COLUMN_QUANTITY, quantity);

        if (addExtraOther.isChecked()) {
            values.put(OrderContract.OrderEntry.COLUMN_OTHER, "Satisfied");
        } else {
            values.put(OrderContract.OrderEntry.COLUMN_OTHER, "Not Satisfied");

        }

        if (addExtras.isChecked()) {
            values.put(OrderContract.OrderEntry.COLUMN_HASEXTRA, "Satisfied");
        } else {
            values.put(OrderContract.OrderEntry.COLUMN_HASEXTRA, "Not Satisfied");

        }

        if (mCurrentCartUri == null) {
            Uri newUri = getContentResolver().insert(OrderContract.OrderEntry.CONTENT_URI, values);
            if (newUri==null) {
                Toast.makeText(this, "Failed to add to Cart", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Success  adding to Cart", Toast.LENGTH_SHORT).show();

            }
        }

        hasAllRequiredValues = true;
        return hasAllRequiredValues;

    }

    private int CalculatePrice(CheckBox addExtraOther, CheckBox addExtras) {

        int basePrice = 5;

        if (addExtraOther.isChecked()) {
            // add the cream cost $2
            basePrice = basePrice + 2;
        }

        if (addExtras.isChecked()) {
            // topping cost is $3
            basePrice = basePrice + 3;
        }

        return basePrice * quantity;
    }

    private void displayQuantity() {
        quantitynumber.setText(String.valueOf(quantity));
    }

    @Override
    public Loader<Cursor> onCreateLoader(int id, Bundle args) {
        String[] projection = {OrderContract.OrderEntry._ID,
                OrderContract.OrderEntry.COLUMN_NAME,
                OrderContract.OrderEntry.COLUMN_PRICE,
                OrderContract.OrderEntry.COLUMN_QUANTITY,
                OrderContract.OrderEntry.COLUMN_OTHER,
                OrderContract.OrderEntry.COLUMN_HASEXTRA
        };

        return new CursorLoader(this, mCurrentCartUri,
                projection,
                null,
                null,
                null);
    }

    @Override
    public void onLoadFinished(Loader<Cursor> loader, Cursor cursor) {

        if (cursor == null || cursor.getCount() < 1) {
            return;
        }

        if (cursor.moveToFirst()) {

            int name = cursor.getColumnIndex(OrderContract.OrderEntry.COLUMN_NAME);
            int price = cursor.getColumnIndex(OrderContract.OrderEntry.COLUMN_PRICE);
            int quantity = cursor.getColumnIndex(OrderContract.OrderEntry.COLUMN_QUANTITY);
            int hasOther = cursor.getColumnIndex(OrderContract.OrderEntry.COLUMN_OTHER);
            int hasExtra = cursor.getColumnIndex(OrderContract.OrderEntry.COLUMN_HASEXTRA);


            String nameofpackage = cursor.getString(name);
            String priceofpackage = cursor.getString(price);
            String quantityofpackage = cursor.getString(quantity);
            String yeshasOther = cursor.getString(hasOther);
            String yeshasExtra = cursor.getString(hasExtra);

            packaageName.setText(nameofpackage);
            packagePrice.setText(priceofpackage);
            quantitynumber.setText(quantityofpackage);
        }


    }

    @Override
    public void onLoaderReset(Loader<Cursor> loader) {


        packaageName.setText("");
        packagePrice.setText("");
        quantitynumber.setText("");

    }
}
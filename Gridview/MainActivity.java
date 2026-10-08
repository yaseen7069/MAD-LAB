package com.example.gridview;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    GridView gridView;

    int[] images = {
            R.drawable.apple,
            R.drawable.banana,
            R.drawable.mango,
            R.drawable.orange,
            R.drawable.strawberry,
            R.drawable.watermelon
    };

    String[] names = {
            "Apple",
            "Banana",
            "Mango",
            "Orange",
            "Strawberry",
            "Watermelon"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        gridView = findViewById(R.id.gridview);

        imageadapter adapter = new imageadapter(this, images);
        gridView.setAdapter(adapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                showAlertDialog(i);
            }

        });
    }

    private void showAlertDialog(int position) {

        ImageView imageView = new ImageView(this);
        imageView.setImageResource(images[position]);

        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setTitle(names[position]);
        builder.setMessage("You selected " + names[position]);
        builder.setIcon(images[position]);

        builder.setPositiveButton("OK", null);

        builder.show();
    }
}
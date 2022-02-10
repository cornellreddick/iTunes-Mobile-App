package com.example.ituneapps;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.ituneapps.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;
    ListView listView;
    ArrayAdapter<String> arrayAdapter;
    DataServices dataServices;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        setTitle("App Categories");

        getSupportFragmentManager().beginTransaction()
                .add(R.id.containerView, new AppCategoriesFragment())
                .addToBackStack(null)
                .commit();

//        ArrayList<String> data = DataServices.getAppCategories();
//        arrayAdapter = new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_list_item_1, data);
//        listView.setAdapter(arrayAdapter);



    }
}
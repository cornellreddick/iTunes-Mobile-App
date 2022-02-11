package com.example.ituneapps;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.ituneapps.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements AppCategoriesFragment.PassData {
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

    @Override
    public void sendFrag() {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.containerView, new AppListFragment())
                .addToBackStack(null)
                .commit();
    }
    @Override
    public void sendAccount(DataServices.App app){

    }

    @Override
    public void createListExTendedView() {

    }

    ;

}
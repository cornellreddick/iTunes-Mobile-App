package com.example.ituneapps;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.ituneapps.databinding.FragmentAppCategoriesBinding;
import com.example.ituneapps.databinding.FragmentAppListBinding;

import java.util.ArrayList;
import java.util.List;


public class AppListFragment extends Fragment implements AppCategoriesFragment.PassData {
    FragmentAppListBinding binding;
    ListView listView;
    //ArrayAdapter arrayAdapter;
    DataServices dataServices;
    AppAdapter appAdapter;
    ArrayAdapter arrayAdapter;

    private String catGroupName;


    public AppListFragment() {
        // Required empty public constructor
    }

   ArrayList<String> data = DataServices.getAppCategories();
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {

        }
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentAppListBinding.inflate(inflater, container, false);
        binding.appListButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                passData.sendFrag();
                getParentFragmentManager().beginTransaction()
                        .replace(R.id.containerView, new AppDetailsFragment())
                        .addToBackStack(null)
                        .commit();
            }
        });


        return binding.getRoot();
    }

    AppCategoriesFragment.PassData passData;

    @Override
    public void sendFrag() {
        getParentFragmentManager().beginTransaction()
                .replace(R.id.containerView, new AppCategoriesFragment())
                .addToBackStack(null)
                .commit();
    }
}
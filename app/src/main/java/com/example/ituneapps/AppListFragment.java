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
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class AppListFragment extends Fragment implements AppCategoriesFragment.PassData {
    FragmentAppListBinding binding;
    DataServices dataServices;
    AppAdapter appAdapter;
    ListView listView;
    ArrayAdapter arrayAdapter;
    ArrayList<DataServices.App> app;
    ArrayList<String> appCategories = DataServices.getAppCategories();
    ArrayList<DataServices.App> appArrayList = DataServices.getAppsByCategory(appCategories);
    private String catGroupName;
    String myString;

    public AppListFragment() {
        // Required empty public constructor
    }

   ArrayList<String> data = DataServices.getAppCategories();
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       // appArrayList = (ArrayList<DataServices.App>) getArguments().getSerializable("data");

    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = FragmentAppListBinding.inflate(inflater, container, false);

        createListExTendedView();
       // createListView();
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

    @Override
    public void sendAccount(DataServices.App app) {

    }


    public void createListView(){
//        listView = binding.appListView;
//        arrayAdapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1, DataServices.getAppCategories());
//        listView.setAdapter(arrayAdapter);
    }
//    @Override
   public void createListExTendedView() {
        listView = binding.appListView;
        appAdapter = new AppAdapter(getActivity(), R.layout.app_list_layout, DataServices.getAppsByCategory(appCategories));
        listView.setAdapter(appAdapter);
   }
}
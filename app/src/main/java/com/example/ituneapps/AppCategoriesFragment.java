package com.example.ituneapps;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.ituneapps.databinding.FragmentAppCategoriesBinding;

import java.util.ArrayList;


public class AppCategoriesFragment extends Fragment {
    FragmentAppCategoriesBinding binding;
    ListView listView;
    ArrayAdapter arrayAdapter;
    ArrayList<String> data = DataServices.getAppCategories();
    public static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";



    public AppCategoriesFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = FragmentAppCategoriesBinding.inflate(inflater, container, false);
        createListView();
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

                passData.sendFrag();
            }
        });

      return binding.getRoot();
    }

    public void createListView(){
        listView = binding.appCatListView;
        arrayAdapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1, data);
        listView.setAdapter(arrayAdapter);
    }

    PassData passData;

    @Override
    public  void onAttach(@NonNull Context context){
        super.onAttach(context);
        passData = (PassData) context;
    }
    interface PassData{
        void sendFrag();
    }
}
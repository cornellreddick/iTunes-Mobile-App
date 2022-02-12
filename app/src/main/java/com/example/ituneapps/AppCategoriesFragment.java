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
import android.widget.Toast;

import com.example.ituneapps.databinding.FragmentAppCategoriesBinding;

import java.io.Serializable;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class AppCategoriesFragment extends Fragment implements Serializable {
    FragmentAppCategoriesBinding binding;
    ListView listView;
    ArrayAdapter arrayAdapter;
    ArrayList<String> appCategories = DataServices.getAppCategories();

    ArrayList<String> list;




    //Test App Adapter
    AppAdapter appAdapter;
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

        list = new ArrayList<>();
        list =  DataServices.getAppCategories();



        binding = FragmentAppCategoriesBinding.inflate(inflater, container, false);
        createListView();
        //createListExTendedView();
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                String test = list.get(position);


                AppListFragment appListFragment = new AppListFragment(); //where data needs to be pass
                Bundle bundle = new Bundle();
                bundle.putSerializable("data", test);
                appListFragment.setArguments(bundle);
                //Toast.makeText(getContext(), test, Toast.LENGTH_SHORT).show();

                arrayAdapter.notifyDataSetChanged();
                getParentFragmentManager().beginTransaction()
                        .replace(R.id.containerView, new AppListFragment())
                        .addToBackStack(null)
                        .commit();
                //passData.sendFrag();

            }
        });
      return binding.getRoot();
    }

    public void createListView(){
        listView = binding.appCatListView;
        arrayAdapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1, list);
        listView.setAdapter(arrayAdapter);
    }

    public void createListExTendedView(){
//        listView = binding.appCatListView;
//        appAdapter = new AppAdapter(getActivity(), R.layout.app_list_layout, apps);
//        listView.setAdapter(appAdapter);
    }

    PassData passData;

    @Override
    public  void onAttach(@NonNull Context context){
        super.onAttach(context);
        passData = (PassData) context;
    }
    interface PassData{
        void sendFrag();
        void sendAccount(DataServices.App app);
        void createListExTendedView();
    }
}
package com.example.ituneapps;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.ituneapps.databinding.FragmentAppDetailsBinding;
import com.example.ituneapps.databinding.FragmentAppListBinding;

import java.util.ArrayList;

public class AppDetailsFragment extends Fragment implements AppCategoriesFragment.PassData {
    String items [] = new String[]{"one", "two", "three", "four", "five"};
    AppAdapter appAdapter;
    ArrayList<String> appCategories = DataServices.getAppCategories();
    ArrayList<DataServices.App> appArrayList = DataServices.getAppsByCategory(appCategories);
    ListView listView;
    FragmentAppDetailsBinding binding;
    public AppDetailsFragment() {
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

        binding = FragmentAppDetailsBinding.inflate(inflater, container, false);
        listView = binding.appListView;

        ArrayAdapter<String> myAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, items);
        listView.setAdapter(myAdapter);

        binding.appDetialButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //passData.sendFrag();
                getParentFragmentManager().beginTransaction()
                        .replace(R.id.containerView, new AppCategoriesFragment())
                        .addToBackStack(null)
                        .commit();
            }
        });

        return  binding.getRoot();
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

    @Override
    public void createListExTendedView() {
        listView = binding.appListView;
        appAdapter = new AppAdapter(getActivity(), R.layout.app_list_layout, appArrayList);
        listView.setAdapter(appAdapter);
    }
}
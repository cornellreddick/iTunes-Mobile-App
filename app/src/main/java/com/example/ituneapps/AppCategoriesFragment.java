package com.example.ituneapps;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

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
    DataServices dataServices;

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";


//    private String mParam1;
//    private String mParam2;

    public AppCategoriesFragment() {
        // Required empty public constructor
    }


//    public static AppCategoriesFragment newInstance(String param1, String param2) {
//        AppCategoriesFragment fragment = new AppCategoriesFragment();
//        Bundle args = new Bundle();
//        args.putString(ARG_PARAM1, param1);
//        args.putString(ARG_PARAM2, param2);
//        fragment.setArguments(args);
//        return fragment;
//    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {

//            mParam1 = getArguments().getString(ARG_PARAM1);
//            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ArrayList<String> data = DataServices.getAppCategories();
        binding = FragmentAppCategoriesBinding.inflate(inflater, container, false);

        listView = binding.appCatListView;
        arrayAdapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1, data);
        listView.setAdapter(arrayAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

            }
        });

      return binding.getRoot();
    }
}
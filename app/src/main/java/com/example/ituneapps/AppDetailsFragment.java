package com.example.ituneapps;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ituneapps.databinding.FragmentAppDetailsBinding;
import com.example.ituneapps.databinding.FragmentAppListBinding;

public class AppDetailsFragment extends Fragment implements AppCategoriesFragment.PassData {
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
}
package com.example.ituneapps;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class AppAdapter extends ArrayAdapter<DataServices.App> {

    public AppAdapter(@NonNull Context context, int resource, @NonNull List<DataServices.App> objects) {
        super(context, resource, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        if (convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.app_list_layout, parent, false);
        }
        DataServices.App app = getItem(position);

        TextView textViewName = convertView.findViewById(R.id.textViewAppName);
        TextView textViewArtist = convertView.findViewById(R.id.textViewArtistName);
        TextView textViewReleaseDate = convertView.findViewById(R.id.textViewReleaseDate);

        textViewName.setText(app.name);
        textViewArtist.setText(app.artistName);
        textViewReleaseDate.setText(app.releaseDate);



        return super.getView(position, convertView, parent);
    }
}

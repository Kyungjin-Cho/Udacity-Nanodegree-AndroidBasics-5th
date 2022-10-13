package com.example.android.tourguide;

import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.fragment.app.Fragment;

import java.util.ArrayList;

public class AccommodationFragment extends Fragment {
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_local_attraction, container, false);

        final ArrayList<LocalAttraction> accommodations = new ArrayList<>();

        final String[] accommodationNames = getResources().getStringArray(R.array.list_accommodation_names);
        final String[] accommodationAddresses = getResources().getStringArray(R.array.list_accommodation_addresses);
        final String[] accommodationOpeningHours = getResources().getStringArray(R.array.list_accommodation_opening_hours);
        final TypedArray accommodationImages = getResources().obtainTypedArray(R.array.list_accommodation_images);

        for  (int id = 0; id != accommodationNames.length; ++id) {
            LocalAttraction newLocalAttraction = new LocalAttraction(accommodationNames[id], accommodationAddresses[id],
                    accommodationOpeningHours[id], accommodationImages.getDrawable(id));
            accommodations.add(newLocalAttraction);
        }

        LocalAttractionAdapter adapter = new LocalAttractionAdapter(getActivity(), accommodations);

        ListView listView = (ListView) rootView.findViewById(R.id.list_local_attraction);

        listView.setAdapter(adapter);

        return rootView;
    }
}

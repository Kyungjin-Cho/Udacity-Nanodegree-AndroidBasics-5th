package com.example.android.tourguide;

import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.fragment.app.Fragment;

import java.util.ArrayList;

public class ShoppingFragment extends Fragment {
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_local_attraction, container, false);

        final ArrayList<LocalAttraction> events = new ArrayList<>();

        final String[] eventsNames = getResources().getStringArray(R.array.list_shopping_names);
        final String[] eventsAddresses = getResources().getStringArray(R.array.list_shopping_addresses);
        final String[] eventsOpeningHours = getResources().getStringArray(R.array.list_shopping_opening_hours);
        final TypedArray eventsImages = getResources().obtainTypedArray(R.array.list_shopping_images);

        for  (int id = 0; id != eventsNames.length; ++id) {
            LocalAttraction newLocalAttraction = new LocalAttraction(eventsNames[id], eventsAddresses[id],
                    eventsOpeningHours[id], eventsImages.getDrawable(id));
            events.add(newLocalAttraction);
        }

        LocalAttractionAdapter adapter = new LocalAttractionAdapter(getActivity(), events);

        ListView listView = (ListView) rootView.findViewById(R.id.list_local_attraction);

        listView.setAdapter(adapter);

        return rootView;
    }
}

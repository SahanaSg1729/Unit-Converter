package com.example.unit_converter.fragments;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.unit_converter.FavoritesActivity;
import com.example.unit_converter.R;
import com.example.unit_converter.adapters.QuantitiesAdapter;
import com.example.unit_converter.database.DataSource;
import com.example.unit_converter.models.DataItemQuantities;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.Collections;
import java.util.List;

public class FavoritesFragment extends Fragment {

    private View view;
    private Context context;
    private DataSource mDataSource;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_favorites, container, false);
        context = view.getContext();
        mDataSource = new DataSource(context);
        mDataSource.open();
        favoritesRecyclerViews();
        favoritesFAB();

        return view;
    }

    private void favoritesRecyclerViews() {
        List<DataItemQuantities> dataItemQuantitiesList = mDataSource.getAllItems(true);

        Collections.sort(dataItemQuantitiesList, (o1, o2) ->
                getString(o1.getTitle()).compareTo(getString(o2.getTitle())));

        QuantitiesAdapter quantitiesAdapter = new QuantitiesAdapter(context, dataItemQuantitiesList);
        RecyclerView favoriteQuantitiesRV = view.findViewById(R.id.rv_favorite_units);
        favoriteQuantitiesRV.setLayoutManager(new GridLayoutManager(context, 3));
        favoriteQuantitiesRV.setAdapter(quantitiesAdapter);
    }

    private void favoritesFAB() {
        FloatingActionButton favoritesFAB = view.findViewById(R.id.fab_favorites);
        favoritesFAB.setOnClickListener(v ->
                startActivity(new Intent(context, FavoritesActivity.class)));
    }
}
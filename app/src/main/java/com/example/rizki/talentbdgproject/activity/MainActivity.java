package com.example.rizki.talentbdgproject.activity;

import android.content.Intent;
import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.SearchView;

import com.bumptech.glide.Glide;
import com.example.rizki.talentbdgproject.classes.Place;
import com.example.rizki.talentbdgproject.adapter.PlaceAdapter;
import com.example.rizki.talentbdgproject.R;
import com.example.rizki.talentbdgproject.classes.PlaceList;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private PlaceAdapter placeAdapter;
    private ArrayList<Place> placeList = new ArrayList<>();
    Bundle bundle;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bundle = getIntent().getExtras();

        PlaceList placeList1 = new PlaceList(getBaseContext(), placeList);
        placeList = placeList1.getPlaceList();

        recyclerView = findViewById(R.id.recycler_view);
        SearchView searchView = findViewById(R.id.search_view);
        ImageView profile = findViewById(R.id.profile1);
        Glide.with(this).load(bundle.getString("img_url")).into(profile);

        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(), ProfileActivity.class);
                intent.putExtra("name", bundle.getString("name"));
                intent.putExtra("email", bundle.getString("email"));
                intent.putExtra("img_url", bundle.getString("img_url"));
                startActivity(intent);
            }
        });

        placeAdapter = new PlaceAdapter(this, placeList, bundle);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                callSearch(query);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                callSearch(newText);
                return false;
            }

            public void callSearch(String query) {
                //Do searching
                filter(query, placeList, placeAdapter);
            }
        });

        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(this, 1);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(placeAdapter);
    }

    private void filter(String text, ArrayList<Place> chats, PlaceAdapter adapter) {
        //new array list that will hold the filtered data
        ArrayList<Place> filterdNames = new ArrayList<>();

        //looping through existing elements
        for (Place s : chats) {
            //if the existing elements contains the search input
            if (s.getNama().toLowerCase().contains(text.toLowerCase())) {
                //adding the element to filtered list
                filterdNames.add(s);
            }
        }

        //calling a method of the adapter class and passing the filtered list
        adapter.filterList(filterdNames);
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }
}

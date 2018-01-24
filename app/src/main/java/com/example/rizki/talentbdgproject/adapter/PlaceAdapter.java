package com.example.rizki.talentbdgproject.adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.PopupMenu;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.rizki.talentbdgproject.classes.CustomTextView;
import com.example.rizki.talentbdgproject.classes.DistanceFix;
import com.example.rizki.talentbdgproject.classes.Place;
import com.example.rizki.talentbdgproject.R;
import com.example.rizki.talentbdgproject.activity.DetailActivity;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import Modules.Distance;
import Modules.FarFinder;
import Modules.FarFinderListener;

/**
 * Created by Rizki on 11/4/2017.
 */

public class PlaceAdapter extends RecyclerView.Adapter<PlaceAdapter.MyViewHolder>{

    private Context context;
    private List<Place> placeList = Collections.emptyList();
    private Bundle bundle;
    private String name, email, img_url;

    class MyViewHolder extends RecyclerView.ViewHolder {
        CustomTextView nama, lokasi, telp, jam, harga, deskripsi, judul;
        ImageView thumbnail;
        CardView cardView;

        MyViewHolder(View view){
            super(view);

            cardView = view.findViewById(R.id.card_view);
            judul = view.findViewById(R.id.title);
            nama = view.findViewById(R.id.isiNama);
            lokasi = view.findViewById(R.id.isiLokasi);
            telp = view.findViewById(R.id.isiTelp);
            jam = view.findViewById(R.id.isiJam);
            harga = view.findViewById(R.id.isiHarga);
            deskripsi = view.findViewById(R.id.isiDeskripsi);
            thumbnail = view.findViewById(R.id.thumbnail);

            name = bundle.getString("name");
            email = bundle.getString("email");
            img_url = bundle.getString("img_url");
        }
    }

    public PlaceAdapter(Context context, List<Place> placeList, Bundle bundle) {
        this.context = context;
        this.placeList = placeList;
        this.bundle = bundle;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.place_card, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {
        final Place place = placeList.get(position);

        holder.judul.setText(place.getNama());
        Glide.with(context).load(place.getThumbnail()).into(holder.thumbnail);

        holder.thumbnail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, DetailActivity.class);
                intent.putExtra("nama", place.getNama());
                intent.putExtra("lokasi", place.getLokasi());
                intent.putExtra("jam", place.getJam());
                intent.putExtra("telp", place.getTelp());
                intent.putExtra("harga", place.getHarga());
                intent.putExtra("deskripsi", place.getDeskripsi());
                intent.putExtra("thumbnail", place.getThumbnail());
                intent.putExtra("lat", place.getLat());
                intent.putExtra("lng", place.getLng());
                intent.putExtra("int", place.getArrInt());
                intent.putExtra("nameid", name);
                intent.putExtra("emailid", email);
                intent.putExtra("img_url", img_url);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);
            }
        });

        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, DetailActivity.class);
                intent.putExtra("nama", place.getNama());
                intent.putExtra("lokasi", place.getLokasi());
                intent.putExtra("telp", place.getTelp());
                intent.putExtra("jam", place.getJam());
                intent.putExtra("harga", place.getHarga());
                intent.putExtra("deskripsi", place.getDeskripsi());
                intent.putExtra("thumbnail", place.getThumbnail());
                intent.putExtra("lat", place.getLat());
                intent.putExtra("lng", place.getLng());
                intent.putExtra("int", place.getArrInt());
                intent.putExtra("nameid", name);
                intent.putExtra("emailid", email);
                intent.putExtra("img_url", img_url);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return placeList.size();
    }

    public void filterList(ArrayList<Place> filterdNames) {
        this.placeList = filterdNames;
        notifyDataSetChanged();
    }

}

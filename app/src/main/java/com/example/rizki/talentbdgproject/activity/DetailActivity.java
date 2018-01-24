package com.example.rizki.talentbdgproject.activity;

import android.content.Intent;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.rizki.talentbdgproject.R;
import com.example.rizki.talentbdgproject.classes.CustomTextView;

public class DetailActivity extends AppCompatActivity {

    private CustomTextView judul, isiNama, isiLokasi, isiTelp, isiJam, isiHarga, isiDeskripsi;
    private ImageView profile;
    private Button maps;
    private Toolbar mToolbar;
    private ViewPager viewPager;

    private String name, email, img_url;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        final Bundle bundle = getIntent().getExtras();

        mToolbar = findViewById(R.id.toolbar);
        judul = findViewById(R.id.titleToolbar);

        setSupportActionBar(mToolbar);
        mToolbar.setNavigationIcon(android.support.v7.appcompat.R.drawable.abc_ic_ab_back_material);

        if (getSupportActionBar() != null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }

        isiNama = findViewById(R.id.isiNama);
        isiLokasi = findViewById(R.id.isiLokasi);
        isiTelp = findViewById(R.id.isiTelp);
        isiJam = findViewById(R.id.isiJam);
        isiHarga = findViewById(R.id.isiHarga);
        isiDeskripsi = findViewById(R.id.isiDeskripsi);
        maps = findViewById(R.id.maps);

        PagerAdapter pagerAdapter = new com.example.rizki.talentbdgproject.adapter.PagerAdapter(this, bundle.getIntArray("int"));
        viewPager = findViewById(R.id.pager);
        viewPager.setAdapter(pagerAdapter);

        name = bundle.getString("nameid");
        email = bundle.getString("emailid");
        img_url = bundle.getString("img_url");

        profile = findViewById(R.id.profile2);
        Glide.with(this).load(img_url).into(profile);
        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(), ProfileActivity.class);
                intent.putExtra("name", name);
                intent.putExtra("email", email);
                intent.putExtra("img_url", img_url);
                startActivity(intent);
            }
        });

        maps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(), MapsActivity.class);
                intent.putExtra("lat", bundle.getDouble("lat"));
                intent.putExtra("lng", bundle.getDouble("lng"));
                intent.putExtra("lokasi", bundle.getString("nama"));
                startActivity(intent);
            }
        });

        if (bundle != null){
            judul.setText(bundle.getString("nama"));
            isiNama.setText(bundle.getString("nama"));
            isiLokasi.setText(bundle.getString("lokasi"));
            isiTelp.setText(bundle.getString("telp"));
            isiJam.setText(bundle.getString("jam"));
            isiHarga.setText(bundle.getString("harga"));
            isiDeskripsi.setText(bundle.getString("deskripsi"));
        }
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // handle arrow click here
        if (item.getItemId() == android.R.id.home) {
            finish(); // close this activity and return to preview activity (if there is any)
        }

        return super.onOptionsItemSelected(item);
    }
}
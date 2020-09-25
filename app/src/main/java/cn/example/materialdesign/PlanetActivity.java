package cn.example.materialdesign;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;


import com.bumptech.glide.Glide;
import com.google.android.material.appbar.CollapsingToolbarLayout;

public class PlanetActivity extends AppCompatActivity {
    public static final String PLANET_NAME = "planet_name";
    public static final String PLANET_IMAGE_ID = "planet_image";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_planet);
        Intent intent = getIntent();
        String planetName = intent.getStringExtra(PLANET_NAME);
        int planetImageId = intent.getIntExtra(PLANET_IMAGE_ID,0);
        Toolbar toolbar = findViewById(R.id.toolbar);
        CollapsingToolbarLayout collapsingToolbarLayout = findViewById(R.id.collapsing_toolbar);
        ImageView planetImageView = findViewById(R.id.planets_image_view);
        TextView planetContentText = findViewById(R.id.planets_content_text);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null){
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
        collapsingToolbarLayout.setTitle(planetName);
        Glide.with(this).load(planetImageId).into(planetImageView);
        String planetContent = generatePlanetContent(planetName);
        planetContentText.setText(planetContent);
    }

    private String generatePlanetContent(String planetName){
        StringBuilder planetContent = new StringBuilder();
        for (int i = 0; i < 500; i++) {
            planetContent.append(planetName);
        }
        return  planetContent.toString();
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
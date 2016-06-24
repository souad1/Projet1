package com.example.dktique.shoppingstore1;

import android.app.Activity;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.content.res.Configuration;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;

public class DetailActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Configuration config = getResources().getConfiguration();
        if ((config.orientation ==
                Configuration.ORIENTATION_LANDSCAPE)
                &&(config.smallestScreenWidthDp>=600))
        {
            finish();
        }
        else {
            setContentView(R.layout.activity_detail);
            Produit produit = (Produit) getIntent().getSerializableExtra("produit");
            DetailFragment detailFragment = new DetailFragment();
            Bundle bundle = new Bundle();
            bundle.putSerializable("produit", produit);
            detailFragment.setArguments(bundle);
            FragmentTransaction ft = getFragmentManager().beginTransaction();
            ft.replace(R.id.frameLayout,detailFragment);
            ft.commit();
        }
        ActionBar ab = getSupportActionBar();
        ab.setDisplayHomeAsUpEnabled(true);


    }



    public void AddToPanier(View v) {

        Toast.makeText(DetailActivity.this, "Produit ajouté au panier", Toast.LENGTH_SHORT).show();
        Intent intent2=new Intent(DetailActivity.this, MainActivity.class);
        startActivity(intent2);


    }



}

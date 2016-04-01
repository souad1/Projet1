package com.example.dktique.shoppingstore1;

import android.app.FragmentTransaction;
import android.content.Intent;
import android.content.res.Configuration;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class DetailActivity extends AppCompatActivity {

    Button btnAjouter;

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

        Toast.makeText(DetailActivity.this, "Welcome to panier", Toast.LENGTH_SHORT).show();

        Produit produit1 = (Produit) getIntent().getSerializableExtra("produit");
        Intent intent1=new Intent(DetailActivity.this, AuthentificationPanier.class);
        intent1.putExtra("produit", produit1);
        startActivity(intent1);


    }

}

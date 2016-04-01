package com.example.dktique.shoppingstore1;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;


public class Panier extends AppCompatActivity {
    CustomAdapterPanier customAdapterPanier;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_panier);

        //Bundle bundle = getArguments();

        Produit produit3 = (Produit) getIntent().getSerializableExtra("produit");
        List<Produit> produitListP = new ArrayList<Produit>();
        produitListP.add(produit3);
        produitListP.add(produit3);

        customAdapterPanier = new CustomAdapterPanier(this,produitListP);
       /* TextView textTitle = (TextView) findViewById(R.id.Prix);
        TextView textAuthors = (TextView) findViewById(R.id.Nom);

        textTitle.setText( produit3.getNom());
        textAuthors.setText(produit3.getPrix());*/

        ListView listView1 = (ListView) findViewById(R.id.listView2);



        // Bundle bundle = getArguments();
        listView1.setAdapter(customAdapterPanier);
        customAdapterPanier.notifyDataSetChanged();

        //adapter.notifyDataSetChanged().



        // EditText edttxt1= (EditText )findViewById(R.id.editText2);
        // edttxt1.setText(produit3.getNom());

        // ImageView imgView= (ImageView)findViewById(R.id.imageView2);
        // imgView.setImageResource(produit3.getCover());

    }
}

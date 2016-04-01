package com.example.dktique.shoppingstore1;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;



public class AuthentificationPanier extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_authentification_panier);
    }


    public void AddingToPanier(View v) {

        Toast.makeText(AuthentificationPanier.this, "Wadd sucessr", Toast.LENGTH_SHORT).show();
        Produit produit2 = (Produit) getIntent().getSerializableExtra("produit");



        EditText edtView= (EditText)findViewById(R.id.editText);
        edtView.setText(produit2.getNom());

        //changer le panier

        Intent intent2=new Intent(AuthentificationPanier.this, Panier.class);
        intent2.putExtra("produit", produit2);
        startActivity(intent2);


    }
}

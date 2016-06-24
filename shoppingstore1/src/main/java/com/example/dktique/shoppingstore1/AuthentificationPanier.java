package com.example.dktique.shoppingstore1;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


public class AuthentificationPanier extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       // requestWindowFeature(Window.FEATURE_NO_TITLE);

       // this.requestWindowFeature(Window.FEATURE_NO_TITLE); //before


        setContentView(R.layout.activity_authentification_panier);

    }
    public void OkAuthentif(View view){
        Toast.makeText(this,"Votre commande a été envoyée avec succés",Toast.LENGTH_LONG).show();
        /*Intent intent=new Intent(this,Panier.class);
        startActivity(intent);*/
        finish();


     }

    public void AnnulerAuthentif(View view){
        /*Intent intent1=new Intent(this,Panier.class);
        startActivity(intent1);*/

        finish();

    }

}

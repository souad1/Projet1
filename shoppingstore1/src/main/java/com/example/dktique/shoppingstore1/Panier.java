package com.example.dktique.shoppingstore1;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.dktique.shoppingstore1.service.DataBaseService;

import java.util.ArrayList;
import java.util.List;


public class Panier extends AppCompatActivity {
    CustomAdapterPanier customAdapterPanier;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Toast.makeText(this, "Bienvenue au Panier", Toast.LENGTH_SHORT);
        setContentView(R.layout.activity_panier);


        DataBaseService dbs=new DataBaseService(this);
///        int k= dbs.getProductQuantity("Jupe");
      //  Toast.makeText(this,"Nombre produit"+k,Toast.LENGTH_SHORT).show();


        // List<Produit>  ll =new ArrayList<Produit>();
       // ll=dbs.getCartProduct();

        List<Produit>  ll=dbs.getCartProduct();



        customAdapterPanier = new CustomAdapterPanier(this,ll);
        ListView listView1 = (ListView) findViewById(R.id.listView2);
        listView1.setAdapter(customAdapterPanier);
        customAdapterPanier.notifyDataSetChanged();

        Button  commander =(Button)findViewById(R.id.commander1);
        commander.setOnClickListener(new View.OnClickListener() {
                                         @Override
                                         public void onClick(View v) {

                                             Intent intent1 = new Intent(Panier.this, AuthentificationPanier.class);
                                             startActivity(intent1);
                                         }
                                     }
        );

    }




    public List<Produit> getProduitList2() {
        String[] listSummary = getResources().getStringArray(R.array.summary);
        List<Produit> produitList = new ArrayList<Produit>();


       /* String Tailles = "38, 40, 42";

        Produit produit = new Produit();
        produit.setNom("Chemise");
        produit.setTaille(Tailles);
        produit.setPrix("4500 DA");
      //  produit.setIconCover(R.drawable.ic_vetementh2);
      //  produit.setCover(R.drawable.ic_vetementh2);
        produit.setMarque("KENZO");
        produit.setDescription(listSummary[0]);
        produit.setCategory("Homme");
        produit.setCategorie2("Vetements");
        produit.setMatiere("Laine");
        produit.setSaison("Printemps - Été");
        produit.setStyle("Chic Minimaliste");
        produitList.add(produit);

        //1
        Produit produit1 = new Produit();
        produit1.setNom("Chemise");

        produit1.setTaille(Tailles);
        produit1.setPrix("3500 DA");
      //  produit1.setIconCover(R.drawable.ic_chemisehomme);
      //  produit1.setCover(R.drawable.ic_chemisehomme);
        produit1.setMarque("BALENCIAGA");
        produit1.setDescription(listSummary[0]);
        produit1.setCategory("Homme");
        produit1.setCategorie2("Vetements");
        produit1.setMatiere("Viscose");
        produit1.setSaison("Printemps - Été");
        produit1.setStyle("Glamour");
        produitList.add(produit1);
        //2

        Produit produit6 = new Produit();
        produit6.setNom("Escarpins");
        produit6.setTaille(Tailles);
        produit6.setPrix("3500 DA");
      //  produit6.setIconCover(R.drawable.ic_1femmecha0);
      //  produit6.setCover(R.drawable.ic_1femmecha0);
        produit6.setMarque("CHLOÉ");
        produit6.setDescription(listSummary[0]);
        produit6.setCategory("Femme");
        produit6.setCategorie2("Chaussurs");
        produit6.setMatiere("Cuir");
        produit6.setSaison("Toutes saisons");
        produit6.setStyle("Glamour");
        produitList.add(produit6);
        //1
        Produit produit7 = new Produit();
        produit7.setNom("Mini-Bottes à talons");
        produit7.setTaille(Tailles);
        produit7.setPrix("3500 DA");
       // produit7.setIconCover(R.drawable.ic_1femmecha1);
       // produit7.setCover(R.drawable.ic_1femmecha1);
        produit7.setMarque("GIUSEPPE ZANOTTI");
        produit7.setDescription(listSummary[0]);
        produit7.setCategory("Femme");
        produit7.setCategorie2("Chaussurs");
        produit7.setMatiere("Cuir");
        produit7.setSaison("Toutes saisons");
        produit7.setStyle("Glamour");
        produitList.add(produit7);

        //4
        Produit produit100 = new Produit();
        produit100.setNom("Veste");
        produit100.setTaille(Tailles);
        produit100.setPrix("43000 DA");
       // produit100.setIconCover(R.drawable.ic_vestef4);
       // produit100.setCover(R.drawable.ic_vestef4);
        produit100.setMarque("GIVENCHY");
        produit100.setDescription(listSummary[0]);
        produit100.setCategory("Femme");
        produit100.setCategorie2("Veste");
        produit100.setMatiere("Cuir");
        produit100.setSaison("Toutes saisons");
        produit100.setStyle("Chic");
        produitList.add(produit100);*/





        return produitList;
    }

    public void CommanderProduits (){
      //  Toast.makeText(this,"vous aver",Toast.LENGTH_LONG).show();
        Intent intent1=new Intent(this,AuthentificationPanier.class);




    }
}

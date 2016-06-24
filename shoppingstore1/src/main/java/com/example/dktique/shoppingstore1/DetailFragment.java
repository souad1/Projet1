package com.example.dktique.shoppingstore1;

import android.app.Application;
import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


public class DetailFragment extends Fragment {



    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.detail_fragment,null);
        Bundle bundle = getArguments();
        if (bundle != null) {
            Produit produit = (Produit) bundle.getSerializable("produit");
            ImageView coverImage = (ImageView) v.findViewById(R.id.coverImage);
            TextView nom= (TextView) v.findViewById(R.id.nom1);
            TextView marque = (TextView) v.findViewById(R.id.marque1);
            TextView taille = (TextView) v.findViewById(R.id.taille1);
            TextView prix = (TextView) v.findViewById(R.id.prix1);
            TextView style = (TextView) v.findViewById(R.id.style1);
            TextView saison = (TextView) v.findViewById(R.id.saison1);

            TextView desc = (TextView) v.findViewById(R.id.description1);




           // ((TextView) v.findViewById(R.id.textView)).setVisibility(v.VISIBLE);

            coverImage.setImageResource(produit.getCover());
            desc.setText("Description : " + produit.getDescription() + " " + produit.getMatiere());
            nom.setText("Nom : "+ produit.getNom());
            marque.setText("Marque : " + produit.getMarque());
            prix.setText("Prix :"+ produit.getPrix());
            taille.setText("Taille : "+ produit.getTaille());
            style.setText("Style : "+(produit.getStyle()));
            saison.setText("Saison : "+(produit.getSaison()));

            Button btnn= (Button) v.findViewById(R.id.Ajouter);
            btnn.setOnClickListener(new View.OnClickListener()

                                    {
                                        @Override
                                        public void onClick(View v) {
                                            Toast.makeText(getActivity() ,"Produit Ajouté au panier",Toast.LENGTH_LONG).show();

                                        }
                                    }
            );

        }
        return v;
    }

    //****************************************


     //*********************************************




}


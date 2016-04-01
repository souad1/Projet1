package com.example.dktique.shoppingstore1;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


public class DetailFragment extends Fragment {



    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.detail_fragment,null);
        Bundle bundle = getArguments();
        if (bundle != null) {
            Produit produit = (Produit) bundle.getSerializable("produit");
            ImageView coverImage = (ImageView) v.findViewById(R.id.coverImage);
            TextView textSummary = (TextView) v.findViewById(R.id.summary);
            TextView textYear = (TextView) v.findViewById(R.id.yearText);
            TextView textTitle = (TextView) v.findViewById(R.id.textTitle);
            TextView textEditor = (TextView) v.findViewById(R.id.editorText);
            TextView textAuthor = (TextView) v.findViewById(R.id.textAuthor);
            ((TextView) v.findViewById(R.id.textView)).setVisibility(v.VISIBLE);
            coverImage.setImageResource(produit.getCover());
            textSummary.setText(produit.getSummary());
            textTitle.setText("Nom: "+ produit.getNom());
            textYear.setText("MARQUE: "+ produit.getYear());
            textEditor.setText("Prix: "+ produit.getPrix());
            textAuthor.setText("Taille: "+ produit.getTaille().get(0));

        }
        return v;
    }

   /* public void goToPanier(){
        Intent intent=new Intent(getActivity(), ActivityPanier.class);
        intent.putExtra("test", "test");
        startActivity(intent);

    }*/
}


package com.example.dktique.shoppingstore1;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;


public class CustomAdapterPanier extends BaseAdapter {

    private Context context;
    private List<Produit> produitListPanier;

    public CustomAdapterPanier(Context context, List<Produit> produitListPanier) {
        this.context = context;
        this.produitListPanier = produitListPanier;
    }


    @Override
    public int getCount() {
        return produitListPanier.size();
    }

    @Override
    public Object getItem(int position) {return produitListPanier.get(position);}

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        // mettre le layout une seule fois lorsque convertView est null
        if (convertView == null) {
            convertView = parent.inflate(context, R.layout.list_items2, null);

        }
        // ImageView coverIcon = (ImageView) convertView.findViewById(R.id.imageproduit);
        TextView textTitle = (TextView) convertView.findViewById(R.id.Nom);
        TextView textAuthors = (TextView) convertView.findViewById(R.id.Prix);
        textTitle.setText(produitListPanier.get(position).getNom());
        textAuthors.setText(produitListPanier.get(position).getPrix());
        return convertView;

    }


}

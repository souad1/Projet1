package com.example.dktique.shoppingstore1;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class CustomAdapter extends BaseAdapter implements Filterable {
    private Context context;
    private List<Produit> produitList;
    // Pour le fitre
    private ValueFilter  valueFilter;
    private List<Produit> mFilterList;

    public CustomAdapter(Context context, List<Produit> produitList) {
        this.context = context;
        this.produitList = produitList;
        // créer une copie de produitList pour le filtre
        this.mFilterList = produitList;
    }

    @Override
    public int getCount() {
        return produitList.size();
    }

    @Override
    public Object getItem(int position) {
        return produitList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // mettre le layout une seule fois lorsque convertView est null
        if (convertView == null) {
            convertView = parent.inflate(context, R.layout.list_items, null);
        }
        ImageView coverIcon = (ImageView) convertView.findViewById(R.id.coverIcon);
        TextView textTitle = (TextView) convertView.findViewById(R.id.title);
        TextView textAuthors = (TextView) convertView.findViewById(R.id.authors);
        TextView textEditor = (TextView) convertView.findViewById(R.id.editor);
        coverIcon.setImageResource(produitList.get(position).getIconCover());
        textTitle.setText(produitList.get(position).getNom());
        // Récupérer la liste des auteurs
        List<String> bookAuthors = produitList.get(position).getTaille();
        // Séparer la liste des auteurs par une virgule
        String authors = bookAuthors.get(0);
        int listSize = bookAuthors.size();
        if (listSize > 1) {
            for (int i = 1; i < listSize; i++) {
                authors = authors + ", " + bookAuthors.get(i);
            }
            textAuthors.setText("Auteur(s): "+ authors);
        }
        textEditor.setText("Editeur: " + produitList.get(position).getPrix());
        return convertView;
    }

    /* Implementation du filtre
       On doit redéfinir la méthode getFilter()
    */
    @Override
    public Filter getFilter() {
        // La méthode retourne un objet de type Filter
        if(valueFilter==null) {
            valueFilter = new ValueFilter();
        }
        return valueFilter;
    }

    // Une nouvelle classe de type Filter est définie
    // Quand on va instancier ValueFilter, deux méthodes sont appelées :  : performFiltering et publishResults

    private class ValueFilter extends Filter {

        // cette méthode effecute le filtre sur la liste des livres
        // une copie de cette liste mFilterList est utilisée

        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            Produit produit;
            List<Produit> listFilter = new ArrayList<Produit>();
            FilterResults filterResults = new FilterResults();
            // véirifer si le texte n'est pas vide
            if (constraint != null && constraint.length() > 0) {
                for (int i = 0; i < mFilterList.size(); i++) {
                    produit = mFilterList.get(i);
                    // Utiliser la catégorie comme filtre
                    if ((produit.getCategory().toUpperCase().contains(constraint.toString().toUpperCase()))) {
                        listFilter.add(produit);
                    }
                }
                filterResults.count = listFilter.size();
                filterResults.values = listFilter;
            } else {
                filterResults.count = mFilterList.size();
                filterResults.values = mFilterList;
            }
            return filterResults;
        }

        // Cette méthode permet d'afficher la nouvelle listView en appelant notifyDataSetChanged()
        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            produitList = (List<Produit>) results.values;
            notifyDataSetChanged();

        }
    }
}


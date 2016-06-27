package com.example.dktique.shoppingstore1;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.NumberPicker;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;


public class CustomAdapterPanier extends BaseAdapter {

    private Context context;
    private List<Produit> produitListPanier;

    TextView qt;
    SeekBar sk;


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
        TextView name = (TextView) convertView.findViewById(R.id.Name);
       // TextView brand = (TextView) convertView.findViewById(R.id.Brand);
        TextView price= (TextView) convertView.findViewById(R.id.Price);
        EditText qtt= (EditText) convertView.findViewById(R.id.editText);



        name.setText(produitListPanier.get(position).getNom());
        price.setText(produitListPanier.get(position).getPrix());
       // brand.setText("Marque : " + produitListPanier.get(position).getMarque());

       // coverIcon.setImageResource(Integer.parseInt(produitListPanier.get(position).getIconCover()));
        ImageButton btn =(ImageButton)  convertView.findViewById (R.id.delete);

        qt = (TextView) convertView.findViewById(R.id.qt);

        //*********************************

       //****************************************************************
        btn.setTag(position);
        btn.setOnClickListener(new View.OnClickListener() {
                                   @Override
                                   public void onClick(View v) {
                                       Integer index = (Integer) v.getTag();
                                       produitListPanier.remove(index.intValue());
                                       notifyDataSetChanged();
                                       Toast.makeText(context,"vous avez supprimer un objet",Toast.LENGTH_SHORT).show();


                                   }

                               }
        );
        return convertView;

    }


}

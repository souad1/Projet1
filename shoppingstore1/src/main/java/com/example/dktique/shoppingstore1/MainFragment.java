package com.example.dktique.shoppingstore1;

import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;



public class MainFragment extends Fragment {

    CustomAdapter cutomAdapter ;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.main_fragment, null);
        ListView listView = (ListView) v.findViewById(R.id.listView);
        cutomAdapter = new CustomAdapter(getActivity(),getProduitList());
        Bundle bundle = getArguments();
        int position = bundle.getInt("pos");
        if (position==0) {
            cutomAdapter.getFilter().filter("FEMME");
        }
        else {
            if (position==1) {
                cutomAdapter.getFilter().filter("HOMME");
            }
            else {
                cutomAdapter.getFilter().filter("ENFANT");

            }
        }

        listView.setAdapter(cutomAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                showView((Produit) cutomAdapter.getItem(position));
            }
        });
        return v;
    }

    public List<Produit> getProduitList() {
        String[] listSummary = getResources().getStringArray(R.array.summary);
        List<Produit> produitList = new ArrayList<Produit>();
        // le 1er livre
        Produit produit = new Produit();
        produit.setNom("PANTALLON");
        List authors = new ArrayList();
        authors.add("S");
        authors.add("M");
        produit.setTaille(authors);
        produit.setPrix("1500");
        produit.setIconCover(R.drawable.ic_dpjava);
        produit.setCover(R.drawable.ic_dpjavacover);
        produit.setYear("SMALTO");
        produit.setSummary(listSummary[0]);
        produit.setCategory("HOMME");
        produitList.add(produit);
        // le 2eme livre
        produit = new Produit();
        //produit.setTitle("UML 2.0 in a Nutshell");
        produit.setNom("CHEMISE");
        authors = new ArrayList();
        authors.add("S");
        authors.add("M");
        produit.setTaille(authors);
        produit.setPrix("2500");
        produit.setIconCover(R.drawable.ic_uml_2);
        produit.setCover(R.drawable.ic_uml_2cover);
        produit.setYear("SMALTO");
        produit.setCategory("HOMME");
        produit.setSummary(listSummary[1]);

        produitList.add(produit);
        // le 3eme livre
        produit = new Produit();
        produit.setNom("JUPE");
        authors = new ArrayList();
        authors.add("S");
        produit.setTaille(authors);
        produit.setPrix("2500");
        produit.setIconCover(R.drawable.ic_sqlpc);
        produit.setCover(R.drawable.ic_sqlpc_cover);
        produit.setYear("2012");
        produit.setSummary(listSummary[2]);
        produit.setCategory("FEMME");
        produitList.add(produit);
        // le 4ème livre
        produit = new Produit();
        produit.setNom("SALOPETTE");
        authors = new ArrayList();
        authors.add("Jason Ostrander");
        produit.setTaille(authors);
        produit.setPrix("Peachpit Press");
        produit.setIconCover(R.drawable.ic_androidfd);
        produit.setCover(R.drawable.ic_androidfdcover);
        produit.setYear("2012");
        produit.setSummary(listSummary[3]);
        produit.setCategory("ENFANT");
        produitList.add(produit);
        // le 5ème livre
        produit = new Produit();
        produit.setNom("Programming in Objective-C");
        authors = new ArrayList();
        authors.add("Stephen Kochan");
        produit.setTaille(authors);
        produit.setPrix("Developer's Library");
        produit.setIconCover(R.drawable.ic_objectivec);
        produit.setCover(R.drawable.ic_objectivecover);
        produit.setYear("CHANEL");
        produit.setSummary(listSummary[4]);
        produit.setCategory("ENFANT");
        produitList.add(produit);
        // le 6 ème livre
        produit = new Produit();
        produit.setNom("VESTE CUIR");
        authors = new ArrayList();
        authors.add("L");
        authors.add("XL");
        produit.setTaille(authors);
        produit.setPrix("5000");
        produit.setIconCover(R.drawable.ic_agile);
        produit.setCover(R.drawable.ic_agilecovrer);
        produit.setYear("SMALTO");
        produit.setSummary(listSummary[5]);
        produit.setCategory("HOMME");
        produitList.add(produit);
        // le 7 ème livre
        produit = new Produit();
        produit.setNom("MINI JUPE");
        authors = new ArrayList();
        authors.add("S");
        authors.add("M");
        authors.add("L");
        produit.setTaille(authors);
        produit.setPrix("3500.");
        produit.setIconCover(R.drawable.ic_unixicon);
        produit.setCover(R.drawable.ic_unixicover);
        produit.setYear("GIVENCHY");
        produit.setSummary(listSummary[6]);
        produit.setCategory("FEMME");
        produitList.add(produit);



        // le 8 ème livre
        produit = new Produit();
        produit.setNom("MIN LONGUE  JUPE");
        authors = new ArrayList();
        authors.add("S");
        authors.add("M");
        authors.add("L");
        produit.setTaille(authors);
        produit.setPrix("3500.");
        produit.setIconCover(R.drawable.ic_unixicon);
        produit.setCover(R.drawable.ic_unixicover);
        produit.setYear("DIOR");
        produit.setSummary(listSummary[6]);
        produit.setCategory("FEMME");
        produitList.add(produit);


        // le 9 ème livre
        produit = new Produit();
        produit.setNom("MIN LONGUE  JUPE");
        authors = new ArrayList();
        authors.add("S");
        authors.add("M");
        authors.add("L");
        produit.setTaille(authors);
        produit.setPrix("5500.");
        produit.setIconCover(R.drawable.ic_unixicon);
        produit.setCover(R.drawable.ic_unixicover);
        produit.setYear("CHRISTAN DIOR");
        produit.setSummary(listSummary[6]);
        produit.setCategory("FEMME");
        produitList.add(produit);


        // le 10 ème livre
        produit = new Produit();
        produit.setNom("MIN LONGUE  JUPE");
        authors = new ArrayList();
        authors.add("S");
        authors.add("M");
        authors.add("L");
        produit.setTaille(authors);
        produit.setPrix("4500.");
        produit.setIconCover(R.drawable.ic_unixicon);
        produit.setCover(R.drawable.ic_unixicover);
        produit.setYear("CHOLOE");
        produit.setSummary(listSummary[5]);
        produit.setCategory("FEMME");
        produitList.add(produit);



        // le 10 ème livre
        produit = new Produit();
        produit.setNom("VESTE");
        authors = new ArrayList();
        authors.add("S");
        authors.add("M");
        authors.add("L");
        produit.setTaille(authors);
        produit.setPrix("4500.");
        produit.setIconCover(R.drawable.ic_unixicon);
        produit.setCover(R.drawable.ic_unixicover);
        produit.setYear("CHOLOE");
        produit.setSummary(listSummary[1]);
        produit.setCategory("FEMME");
        produitList.add(produit);

        return produitList;
    }

    public boolean isTwoPane() {

        View v  = getActivity().findViewById(R.id.frameLayout);
        return (v!=null);

    }

    public void showView (Produit produit) {
        if (isTwoPane()) {
            DetailFragment detailFragment = new DetailFragment();
            Bundle bundle = new Bundle();
            bundle.putSerializable("produit", produit);
            detailFragment.setArguments(bundle);
            FragmentTransaction ft = getActivity().getFragmentManager().beginTransaction();
            ft.replace(R.id.frameLayout, detailFragment);

            ft.commit();

        } else {
            Intent intent = new Intent(getActivity(), DetailActivity.class);
            intent.putExtra("produit", produit);
            startActivity(intent);
        }

    }

}

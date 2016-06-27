package com.example.dktique.shoppingstore1;

import android.app.FragmentTransaction;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.dktique.shoppingstore1.service.GetProduitTask;
import com.example.dktique.shoppingstore1.util.UtilService;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by DKTIQUE on 28/03/2016.
 */
public class MainFragment extends Fragment {

    CustomAdapter cutomAdapter ;
    CustomAdapter  cutomAdapter2;
    Spinner spinner;
    private Context context2;
    private List<Produit> product = new ArrayList<Produit>();

    public static  List<Produit> listProduct = new ArrayList<>();



    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.main_fragment, null);

        Bundle bundle = getArguments();
        int position = bundle.getInt("pos");

        String poss=""+position;


        new GetProduitTask(getActivity()).execute("hdpi",poss);

        ListView listView = (ListView) v.findViewById(R.id.listView);
       cutomAdapter = (CustomAdapter) listView.getAdapter();
        if (cutomAdapter!=null){product=cutomAdapter.getProduitList();}

        cutomAdapter=new CustomAdapter(getActivity(),product);


        final Spinner spinner = (Spinner)v. findViewById(R.id.spinner);
        List<String> categories = new ArrayList<String>();
        categories.add("Accessoires");
        categories.add("Vetements");
        categories.add("Veste");
        categories.add("Sac");
        categories.add("Chaussures");


        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_item, categories);

        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner.setAdapter(dataAdapter);




        if (position==0 ) {


       /*     List<Produit> femme= new ArrayList<Produit>();
            //cutomAdapter.getFilter().filter("FEMME");

            int i=0;

            while(i<product.size()){

                if (product.get(i).getCategory().equals("Femme")){
                    femme.add(product.get(i));
                }
            }
*/
           /* Toast.makeText(getActivity(),""+position,Toast.LENGTH_SHORT).show();

            cutomAdapter=new CustomAdapter(getActivity(),product);
            cutomAdapter.notifyDataSetChanged();
            listView.setAdapter(cutomAdapter);*/

        }

        else if (position==1 ) {

        }

       else if (position==2 ) {

        }
      /*  else {
            if (position==1) {
                // cutomAdapter.getFilter().filter("HOMME");
                cutomAdapter=new CustomAdapter(getActivity(),product);
            }
            else {
                //cutomAdapter.getFilter().filter("ENFANT");
                cutomAdapter=new CustomAdapter(getActivity(),product);
            }
        }*/
      /*  spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
                Object item = parent.getItemAtPosition(pos);
                String itema = parent.getItemAtPosition(pos).toString();

                if (itema=="Accessoires" ) {
                    cutomAdapter.getFilter().filter("accessoires");

                }
                else if (itema=="Veste") {
                    cutomAdapter.getFilter().filter("veste");

                }
                else if (itema=="Vetements"){
                    cutomAdapter.getFilter().filter("vetements");
                }
                else if (itema=="Chaussures"){

                    cutomAdapter.getFilter().filter("chaussures");
                }
              else if (itema=="Sac"){

                    cutomAdapter.getFilter().filter("sac");
                }

            }
            public void onNothingSelected(AdapterView<?> parent)
            {
                // listView.setAdapter(cutomAdapter);
            }
        });*/

        // Showing selected spinner item
       // listView.setAdapter(cutomAdapter);

       /*listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                showView((Produit) cutomAdapter.getItem(position));
            }
        });
*/
        return v;
    }


    public String getScreenDensity() {
        DisplayMetrics metrics = new DisplayMetrics();
        getActivity().getWindowManager().getDefaultDisplay().getMetrics(metrics);
        String density ="";
        switch(metrics.densityDpi){
            case DisplayMetrics.DENSITY_LOW:
                density="hdpi";
                break;
            case DisplayMetrics.DENSITY_MEDIUM:
                density= "hdpi";
                break;
            case DisplayMetrics.DENSITY_HIGH:
                density="hdpi";
                break;
            case DisplayMetrics.DENSITY_XHIGH:
                density= "hdpi";;
                break;
            case DisplayMetrics.DENSITY_XXHIGH:
                density= "hdpi";
            case DisplayMetrics.DENSITY_XXXHIGH:
                density= "hdpi";
                break;
        }

        return density;

    }

/*
    public List<Produit> getProduitListEnfants() {
        String[] listSummary = getResources().getStringArray(R.array.summary);
        List<Produit> produitList = new ArrayList<Produit>();

        //------------Enfant----------------
        //----Accessoires

        //------------Enfant-----------------
        //----------------------------------Vetements------------------
        //0
        Produit produit = new Produit();
        String Tailles = "38 , 40, 42";


        produit.setNom("Jupe");
        produit.setTaille(Tailles);
        produit.setPrix("4500 DA");
        produit.setIconCover(R.drawable.ic_vetemente2);
        produit.setCover(R.drawable.ic_vetemente2);
        produit.setMarque("KENZO");
        produit.setDescription(listSummary[0]);
        produit.setCategory("Enfant");
        produit.setCategorie2("Vetements");
        produit.setMatiere("Laine");
        produit.setSaison("Printemps - Été");
        produit.setStyle("Chic Minimaliste");
        produitList.add(produit);

        //1
        Produit produit1 = new Produit();
        produit1.setNom("Jupe");

        produit1.setTaille(Tailles);
        produit1.setPrix("3500 DA");
        produit1.setIconCover(R.drawable.ic_jupeenfant);
        produit1.setCover(R.drawable.ic_jupeenfant);
        produit1.setMarque("BALENCIAGA");
        produit1.setDescription(listSummary[0]);
        produit1.setCategory("Enfant");
        produit1.setCategorie2("Vetements");
        produit1.setMatiere("Viscose");
        produit1.setSaison("Printemps - Été");
        produit1.setStyle("Glamour");
        produitList.add(produit1);
        //2
        Produit produit2 = new Produit();
        produit2.setNom("T-Shirt");
        produit2.setTaille(Tailles);
        produit2.setPrix("5000 DA");
        produit2.setIconCover(R.drawable.ic_shirtenfant);
        produit2.setCover(R.drawable.ic_shirtenfant);
        produit2.setMarque("GIVENCHY");
        produit2.setDescription(listSummary[0]);
        produit2.setCategory("Enfant");
        produit2.setCategorie2("Vetements");
        produit2.setMatiere("Soie");
        produit2.setSaison("Printemps - Été");
        produit2.setStyle("Glamour");
        produitList.add(produit2);
        //3
        Produit produit3 = new Produit();
        produit3.setNom("Ensemble");
        produit3.setTaille(Tailles);
        produit3.setPrix("6000 DA");
        produit3.setIconCover(R.drawable.ic_vetemente4);
        produit3.setCover(R.drawable.ic_vetemente4);
        produit3.setMarque("ALEXANDER MCQUEEN");
        produit3.setDescription(listSummary[0]);
        produit3.setCategory("Enfant");
        produit3.setCategorie2("Vetements");
        produit3.setMatiere("Coton");
        produit3.setSaison("Printemps - Été");
        produit3.setStyle("Chic Minimaliste");
        produitList.add(produit3);

        //4
        Produit produit4 = new Produit();
        produit4.setNom("Salopette");
        produit4.setTaille(Tailles);
        produit4.setPrix("6000 DA");
        produit4.setIconCover(R.drawable.ic_vetemente5);
        produit4.setCover(R.drawable.ic_vetemente5);
        produit4.setMarque("YVES SAINT LAURENT");
        produit4.setDescription(listSummary[0]);
        produit4.setCategory("Enfant");
        produit4.setCategorie2("Vetements");
        produit4.setMatiere("Coton");
        produit4.setSaison("Toutes les saisons");
        produit4.setStyle("Chic Minimaliste");
        produitList.add(produit4);



        //---------------------------Chausures--------------------
        //0
        Produit produit6 = new Produit();
        produit6.setNom("Baskette");
        produit6.setTaille(Tailles);
        produit6.setPrix("3500 DA");
        produit6.setIconCover(R.drawable.ic_chaussurse1);
        produit6.setCover(R.drawable.ic_chaussurse1);
        produit6.setMarque("CHLOÉ");
        produit6.setDescription(listSummary[0]);
        produit6.setCategory("Enfant");
        produit6.setCategorie2("Chaussures");
        produit6.setMatiere("Cuir");
        produit6.setSaison("Toutes saisons");
        produit6.setStyle("Glamour");
        produitList.add(produit6);
        //1
        Produit produit7 = new Produit();
        produit7.setNom("Balerine");
        produit7.setTaille(Tailles);
        produit7.setPrix("3500 DA");
        produit7.setIconCover(R.drawable.ic_chaussurse2);
        produit7.setCover(R.drawable.ic_chaussurse2);
        produit7.setMarque("GIUSEPPE ZANOTTI");
        produit7.setDescription(listSummary[0]);
        produit7.setCategory("Enfant");
        produit7.setCategorie2("Chaussurs");
        produit7.setMatiere("Cuir");
        produit7.setSaison("Toutes saisons");
        produit7.setStyle("Glamour");
        produitList.add(produit7);

        //2
        Produit produit8 = new Produit();
        produit8.setNom("Sandale");
        produit8.setTaille(Tailles);
        produit8.setPrix("2800 DA");
        produit8.setIconCover(R.drawable.ic_chaussurse3);
        produit8.setCover(R.drawable.ic_chaussurse3);
        produit8.setMarque("CHLOÉ");
        produit8.setDescription(listSummary[0]);
        produit8.setCategory("Enfant");
        produit8.setCategorie2("Chaussures");
        produit8.setMatiere("Cuir");
        produit8.setSaison("Printemps - Été");
        produit8.setStyle("Glamour");
        produitList.add(produit8);

        //3
        Produit produit9 = new Produit();
        produit9.setNom("Sandale");
        produit9.setTaille(Tailles);
        produit9.setPrix("4000 DA");
        produit9.setIconCover(R.drawable.ic_chaussurse4);
        produit9.setCover(R.drawable.ic_chaussurse4);
        produit9.setMarque("CHLOÉ");
        produit9.setDescription(listSummary[0]);
        produit9.setCategory("Enfant");
        produit9.setCategorie2("Chaussures");
        produit9.setMatiere("Cuir");
        produit9.setSaison("Printemps - Été");
        produit9.setStyle("Glamour");
        produitList.add(produit9);


        //4
        Produit produit10 = new Produit();
        produit10.setNom("Botte");
        produit10.setTaille(Tailles);
        produit10.setPrix("4000 DA");
        produit10.setIconCover(R.drawable.ic_chaussureenfant);
        produit10.setCover(R.drawable.ic_chaussureenfant);
        produit10.setMarque("GUCCI");
        produit10.setDescription(listSummary[0]);
        produit10.setCategory("Enfant");
        produit10.setCategorie2("Chaussures");
        produit10.setMatiere("Cuir");
        produit10.setSaison("Hiver");
        produit10.setStyle("Chic");
        produitList.add(produit10);


        //---------------------------Accesoires-------------------
        //0
      String  Tailles1 = "- - -";

        Produit produit11 = new Produit();
        produit11.setNom("Chapeau");
        produit11.setTaille(Tailles1);
        produit11.setPrix("3500 DA");
        produit11.setIconCover(R.drawable.ic_accessoirse1);
        produit11.setCover(R.drawable.ic_accessoirse1);
        produit11.setMarque("CHLOÉ");
        produit11.setDescription(listSummary[0]);
        produit11.setCategory("Enfant");
        produit11.setCategorie2("Accessoires");
        produit11.setMatiere("Cuir");
        produit11.setSaison("Toutes saisons");
        produit11.setStyle("Chic Minimaliste");
        produitList.add(produit11);

        //1
        Produit produit12 = new Produit();
        produit12.setNom("Protège-main");
        produit12.setTaille(Tailles1);
        produit12.setPrix("3500 DA");
        produit12.setIconCover(R.drawable.ic_accessoirse2);
        produit12.setCover(R.drawable.ic_accessoirse2);
        produit12.setMarque("GIVENCCI");
        produit12.setDescription(listSummary[0]);
        produit12.setCategory("Enfant");
        produit12.setCategorie2("Accessoires");
        produit12.setMatiere("Cuir");
        produit12.setSaison("Toutes saisons");
        produit12.setStyle("Glamour");
        produitList.add(produit12);

        //2
        Produit produit13 = new Produit();
        produit13.setNom("Echarpe");
        produit13.setTaille(Tailles1);
        produit13.setPrix("4000 DA");
        produit13.setIconCover(R.drawable.ic_accessoirse3);
        produit13.setCover(R.drawable.ic_accessoirse3);
        produit13.setMarque("DOLCI GABANA");
        produit13.setDescription(listSummary[0]);
        produit13.setCategory("Enfant");
        produit13.setCategorie2("Accessoires");
        produit13.setMatiere("Or");
        produit13.setSaison("Toutes saisons");
        produit13.setStyle("Glamour");
        produitList.add(produit13);


        //3
        Produit produit14 = new Produit();
        produit14.setNom("Protège-main");
        produit14.setTaille(Tailles1);
        produit14.setPrix("5000 DA");
        produit14.setIconCover(R.drawable.ic_accessoirse4);
        produit14.setCover(R.drawable.ic_accessoirse4);
        produit14.setMarque("DOLCI GABANA");
        produit14.setDescription(listSummary[0]);
        produit14.setCategory("Enfant");
        produit14.setCategorie2("Accessoires");
        produit14.setMatiere("Or");
        produit14.setSaison("Toutes saisons");
        produit14.setStyle("Glamour");
        produitList.add(produit14);

        //4
        Produit produit15 = new Produit();
        produit15.setNom("Chapeau");
        produit15.setTaille(Tailles1);
        produit15.setPrix("5000 DA");
        produit15.setIconCover(R.drawable.ic_accessoirse5);
        produit15.setCover(R.drawable.ic_accessoirse5);
        produit15.setMarque("DOLCI GABANA");
        produit15.setDescription(listSummary[0]);
        produit15.setCategory("Enfant");
        produit15.setCategorie2("Accessoires");
        produit15.setMatiere("Or");
        produit15.setSaison("Toutes saisons");
        produit15.setStyle("Glamour");
        produitList.add(produit15);



        //---------------------------Vestes-------------------
        //0
        Produit produit16 = new Produit();
        produit16.setNom("Veste");
        produit16.setTaille(Tailles);
        produit16.setPrix("5500 DA");
        produit16.setIconCover(R.drawable.ic_vestee1);
        produit16.setCover(R.drawable.ic_vestee1);
        produit16.setMarque("CHLOÉ");
        produit16.setDescription(listSummary[0]);
        produit16.setCategory("Enfant");
        produit16.setCategorie2("Veste");
        produit16.setMatiere("Cuir");
        produit16.setSaison("Toutes saisons");
        produit16.setStyle("Chic");
        produitList.add(produit16);

        //1
        Produit produit17 = new Produit();
        produit17.setNom("Veste");
        produit17.setTaille(Tailles);
        produit17.setPrix("4500 DA");
        produit17.setIconCover(R.drawable.ic_vestee2);
        produit17.setCover(R.drawable.ic_vestee2);
        produit17.setMarque("GIVENCCI");
        produit17.setDescription(listSummary[0]);
        produit17.setCategory("Enfant");
        produit17.setCategorie2("Veste");
        produit17.setMatiere("Cuir");
        produit17.setSaison("Toutes saisons");
        produit17.setStyle("Glamour");
        produitList.add(produit17);

        //2
        Produit produit18 = new Produit();
        produit18.setNom("Veste");
        produit18.setTaille(Tailles);
        produit18.setPrix("4000 DA");
        produit18.setIconCover(R.drawable.ic_vestee3);
        produit18.setCover(R.drawable.ic_vestee3);
        produit18.setMarque("DOLCI GABANA");
        produit18.setDescription(listSummary[0]);
        produit18.setCategory("Enfant");
        produit18.setCategorie2("Veste");
        produit18.setMatiere("Cuir");
        produit18.setSaison("Toutes saisons");
        produit18.setStyle("Glamour");
        produitList.add(produit18);


        //3
        Produit produit19 = new Produit();
        produit19.setNom("Veste");
        produit19.setTaille(Tailles);
        produit19.setPrix("4000 DA");
        produit19.setIconCover(R.drawable.ic_vestee4);
        produit19.setCover(R.drawable.ic_vestee4);
        produit19.setMarque("GUCCI");
        produit19.setDescription(listSummary[0]);
        produit19.setCategory("Enfant");
        produit19.setCategorie2("Veste");
        produit19.setMatiere("Cuir");
        produit19.setSaison("Toutes saisons");
        produit19.setStyle("Glamour");
        produitList.add(produit19);


        //4
        Produit produit100 = new Produit();
        produit100.setNom("Veste");
        produit100.setTaille(Tailles);
        produit100.setPrix("43000 DA");
        produit100.setIconCover(R.drawable.ic_vestee5);
        produit100.setCover(R.drawable.ic_vestee5);
        produit100.setMarque("GIVENCHY");
        produit100.setDescription(listSummary[0]);
        produit100.setCategory("Enfant");
        produit100.setCategorie2("Veste");
        produit100.setMatiere("Cuir");
        produit100.setSaison("Toutes saisons");
        produit100.setStyle("Chic");
        produitList.add(produit100);


        //---------------------------Sac-------------------
        //0
        Produit produit20 = new Produit();
        produit20.setNom("Sac");
        produit20.setTaille(Tailles1);
        produit20.setPrix("3500 DA");
        produit20.setIconCover(R.drawable.ic_sace3);
        produit20.setCover(R.drawable.ic_sace3);
        produit20.setMarque("CHLOÉ");
        produit20.setDescription(listSummary[0]);
        produit20.setCategory("Enfant");
        produit20.setCategorie2("Sac");
        produit20.setMatiere("Cuir");
        produit20.setSaison("Toutes saisons");
        produit20.setStyle("Chic");
        produitList.add(produit20);

        //1
        Produit produit21 = new Produit();
        produit21.setNom("Sac");
        produit21.setTaille(Tailles1);
        produit21.setPrix("4500 DA");
        produit21.setIconCover(R.drawable.ic_sace2);
        produit21.setCover(R.drawable.ic_sace2);
        produit21.setMarque("GIVENCCI");
        produit21.setDescription(listSummary[0]);
        produit21.setCategory("Enfant");
        produit21.setCategorie2("Sac");
        produit21.setMatiere("Cuir");
        produit21.setSaison("Toutes saisons");
        produit21.setStyle("Glamour");
        produitList.add(produit21);

        //2
        Produit produit23 = new Produit();
        produit23.setNom("Sac");
        produit23.setTaille(Tailles1);
        produit23.setPrix("4000 DA");
        produit23.setIconCover(R.drawable.ic_sace4);
        produit23.setCover(R.drawable.ic_sace4);
        produit23.setMarque("DOLCI GABANA");
        produit23.setDescription(listSummary[0]);
        produit23.setCategory("Enfant");
        produit23.setCategorie2("Sac");
        produit23.setMatiere("Cuir");
        produit23.setSaison("Toutes saisons");
        produit23.setStyle("Glamour");
        produitList.add(produit23);

        //3
        Produit produit24 = new Produit();
        produit24.setNom("Sac");
        produit24.setTaille(Tailles1);
        produit24.setPrix("4000 DA");
        produit24.setIconCover(R.drawable.ic_sace5);
        produit24.setCover(R.drawable.ic_sace5);
        produit24.setMarque("GUCCI");
        produit24.setDescription(listSummary[0]);
        produit24.setCategory("Enfant");
        produit24.setCategorie2("Sac");
        produit24.setMatiere("Cuir");
        produit24.setSaison("Toutes saisons");
        produit24.setStyle("Glamour");
        produitList.add(produit24);


        //4
        Produit produit25 = new Produit();
        produit25.setNom("Sac");
        produit25.setTaille(Tailles1);
        produit25.setPrix("43000 DA");
        produit25.setIconCover(R.drawable.ic_sace1);
        produit25.setCover(R.drawable.ic_sace1);
        produit25.setMarque("GIVENCHY");
        produit25.setDescription(listSummary[0]);
        produit25.setCategory("Enfant");
        produit25.setCategorie2("Sac");
        produit25.setMatiere("Cuir");
        produit25.setSaison("Toutes saisons");
        produit25.setStyle("Chic");
        produitList.add(produit25);





        return produitList;



    }
//_________________---------------------------------------__________________________________


    public List<Produit> getProduitListHomme() {
        String[] listSummary = getResources().getStringArray(R.array.summary);
        List<Produit> produitList = new ArrayList<Produit>();


        //------------Homme-----------------
        //----------------------------------Vetements------------------
        //0

        String  Tailles = "38 , 40, 42";

        Produit produit = new Produit();
        produit.setNom("Chemise");
        produit.setTaille(Tailles);
        produit.setPrix("4500 DA");
        produit.setIconCover(R.drawable.ic_vetementh2);
        produit.setCover(R.drawable.ic_vetementh2);
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
        produit1.setIconCover(R.drawable.ic_chemisehomme);
        produit1.setCover(R.drawable.ic_chemisehomme);
        produit1.setMarque("BALENCIAGA");
        produit1.setDescription(listSummary[0]);
        produit1.setCategory("Homme");
        produit1.setCategorie2("Vetements");
        produit1.setMatiere("Viscose");
        produit1.setSaison("Printemps - Été");
        produit1.setStyle("Glamour");
        produitList.add(produit1);
        //2
        Produit produit2 = new Produit();
        produit2.setNom("Pantalon");
        produit2.setTaille(Tailles);
        produit2.setPrix("5000 DA");
        produit2.setIconCover(R.drawable.ic_vetementh3);
        produit2.setCover(R.drawable.ic_vetementh3);
        produit2.setMarque("GIVENCHY");
        produit2.setDescription(listSummary[0]);
        produit2.setCategory("Homme");
        produit2.setCategorie2("Vetements");
        produit2.setMatiere("Soie");
        produit2.setSaison("Printemps - Été");
        produit2.setStyle("Glamour");
        produitList.add(produit2);
        //3
        Produit produit3 = new Produit();
        produit3.setNom("Pantalon");
        produit3.setTaille(Tailles);
        produit3.setPrix("6000 DA");
        produit3.setIconCover(R.drawable.ic_pantallonhomme);
        produit3.setCover(R.drawable.ic_pantallonhomme);
        produit3.setMarque("ALEXANDER MCQUEEN");
        produit3.setDescription(listSummary[0]);
        produit3.setCategory("Homme");
        produit3.setCategorie2("Vetements");
        produit3.setMatiere("Coton");
        produit3.setSaison("Toutes les saisons");
        produit3.setStyle("Chic Minimaliste");
        produitList.add(produit3);

        //4
        Produit produit4 = new Produit();
        produit4.setNom("Short");
        produit4.setTaille(Tailles);
        produit4.setPrix("6000 DA");
        produit4.setIconCover(R.drawable.ic_vetementh5);
        produit4.setCover(R.drawable.ic_vetementh5);
        produit4.setMarque("YVES SAINT LAURENT");
        produit4.setDescription(listSummary[0]);
        produit4.setCategory("Homme");
        produit4.setCategorie2("Vetements");
        produit4.setMatiere("Coton");
        produit4.setSaison("Toutes les saisons");
        produit4.setStyle("Chic Minimaliste");
        produitList.add(produit4);


        //---------------------------Chausures--------------------
        //0
        Produit produit6 = new Produit();
        produit6.setNom("Baskette");
        produit6.setTaille(Tailles);
        produit6.setPrix("3500 DA");
        produit6.setIconCover(R.drawable.ic_chaussursh1);
        produit6.setCover(R.drawable.ic_chaussursh1);
        produit6.setMarque("CHLOÉ");
        produit6.setDescription(listSummary[0]);
        produit6.setCategory("Homme");
        produit6.setCategorie2("Chaussures");
        produit6.setMatiere("Cuir");
        produit6.setSaison("Toutes saisons");
        produit6.setStyle("Glamour");
        produitList.add(produit6);
        //1
        Produit produit7 = new Produit();
        produit7.setNom("Mini-Bottes");
        produit7.setTaille(Tailles);
        produit7.setPrix("3500 DA");
        produit7.setIconCover(R.drawable.ic_chaussursh2);
        produit7.setCover(R.drawable.ic_chaussursh2);
        produit7.setMarque("GIUSEPPE ZANOTTI");
        produit7.setDescription(listSummary[0]);
        produit7.setCategory("Homme");
        produit7.setCategorie2("Chaussures");
        produit7.setMatiere("Cuir");
        produit7.setSaison("Toutes saisons");
        produit7.setStyle("Glamour");
        produitList.add(produit7);

        //2
        Produit produit8 = new Produit();
        produit8.setNom("Baskette");
        produit8.setTaille(Tailles);
        produit8.setPrix("2800 DA");
        produit8.setIconCover(R.drawable.ic_chaussursh3);
        produit8.setCover(R.drawable.ic_chaussursh3);
        produit8.setMarque("CHLOÉ");
        produit8.setDescription(listSummary[0]);
        produit8.setCategory("Homme");
        produit8.setCategorie2("Chaussures");
        produit8.setMatiere("Cuir");
        produit8.setSaison("Toutes saisons");
        produit8.setStyle("Glamour");
        produitList.add(produit8);

        //3
        Produit produit9 = new Produit();
        produit9.setNom("Chaussure plat");
        produit9.setTaille(Tailles);
        produit9.setPrix("4000 DA");
        produit9.setIconCover(R.drawable.ic_chaussursh4);
        produit9.setCover(R.drawable.ic_chaussursh4);
        produit9.setMarque("CHLOÉ");
        produit9.setDescription(listSummary[0]);
        produit9.setCategory("Homme");
        produit9.setCategorie2("Chaussures");
        produit9.setMatiere("Cuir");
        produit9.setSaison("Toutes saisons");
        produit9.setStyle("Glamour");
        produitList.add(produit9);


        //4
        Produit produit10 = new Produit();
        produit10.setNom("Mini-Bottes");
        produit10.setTaille(Tailles);
        produit10.setPrix("4000 DA");
        produit10.setIconCover(R.drawable.ic_chaussursh5);
        produit10.setCover(R.drawable.ic_chaussursh5);
        produit10.setMarque("GUCCI");
        produit10.setDescription(listSummary[0]);
        produit10.setCategory("Homme");
        produit10.setCategorie2("Chaussures");
        produit10.setMatiere("Cuir");
        produit10.setSaison("Hiver-Automne");
        produit10.setStyle("Chic");
        produitList.add(produit10);


        //---------------------------Accesoires-------------------
        //0
        String  Tailles1 = "- - - ";

        Produit produit11 = new Produit();
        produit11.setNom("Lunette");
        produit11.setTaille(Tailles1);
        produit11.setPrix("3500 DA");
        produit11.setIconCover(R.drawable.ic_accessoirsh1);
        produit11.setCover(R.drawable.ic_accessoirsh1);
        produit11.setMarque("CHLOÉ");
        produit11.setDescription(listSummary[0]);
        produit11.setCategory("Homme");
        produit11.setCategorie2("Accessoires");
        produit11.setMatiere("Cuir");
        produit11.setSaison("Toutes saisons");
        produit11.setStyle("Chic Minimaliste");
        produitList.add(produit11);

        //1

        //**********************************************************

        ///////////////////////////////////////////////////////////////
        Produit produit12 = new Produit();
        produit12.setNom("Chapeau");
        produit12.setTaille(Tailles1);
        produit12.setPrix("3500 DA");
        produit12.setIconCover(R.drawable.ic_accessoirsh2);
        produit12.setCover(R.drawable.ic_accessoirsh2);
        produit12.setMarque("GIVENCCI");
        produit12.setDescription(listSummary[0]);
        produit12.setCategory("Homme");
        produit12.setCategorie2("Accessoires");
        produit12.setMatiere("Cuir");
        produit12.setSaison("Toutes saisons");
        produit12.setStyle("Glamour");
        produitList.add(produit12);

        //2
        Produit produit13 = new Produit();
        produit13.setNom("Montre");
        produit13.setTaille(Tailles1);
        produit13.setPrix("4000 DA");
        produit13.setIconCover(R.drawable.ic_accessoirsh3);
        produit13.setCover(R.drawable.ic_accessoirsh3);
        produit13.setMarque("DOLCI GABANA");
        produit13.setDescription(listSummary[0]);
        produit13.setCategory("Homme");
        produit13.setCategorie2("Accessoires");
        produit13.setMatiere("Or");
        produit13.setSaison("Toutes saisons");
        produit13.setStyle("Glamour");
        produitList.add(produit13);


        //3
        Produit produit14 = new Produit();
        produit14.setNom("Casquette");
        produit14.setTaille(Tailles1);
        produit14.setPrix("5000 DA");
        produit14.setIconCover(R.drawable.ic_accessoirsh4);
        produit14.setCover(R.drawable.ic_accessoirsh4);
        produit14.setMarque("DOLCI GABANA");
        produit14.setDescription(listSummary[0]);
        produit14.setCategory("Homme");
        produit14.setCategorie2("Accessoires");
        produit14.setMatiere("Or");
        produit14.setSaison("Toutes saisons");
        produit14.setStyle("Glamour");
        produitList.add(produit14);

        //4
        Produit produit15 = new Produit();
        produit15.setNom("Montre");
        produit15.setTaille(Tailles1);
        produit15.setPrix("5000 DA");
        produit15.setIconCover(R.drawable.ic_accessoirsh5);
        produit15.setCover(R.drawable.ic_accessoirsh5);
        produit15.setMarque("DOLCI GABANA");
        produit15.setDescription(listSummary[0]);
        produit15.setCategory("Homme");
        produit15.setCategorie2("Accessoires");
        produit15.setMatiere("Or");
        produit15.setSaison("Toutes saisons");
        produit15.setStyle("Glamour");
        produitList.add(produit15);



        //---------------------------Vestes-------------------
        //0
        Produit produit16 = new Produit();
        produit16.setNom("Veste");
        produit16.setTaille(Tailles);
        produit16.setPrix("5500 DA");
        produit16.setIconCover(R.drawable.ic_vesteh1);
        produit16.setCover(R.drawable.ic_vesteh1);
        produit16.setMarque("CHLOÉ");
        produit16.setDescription(listSummary[0]);
        produit16.setCategory("Homme");
        produit16.setCategorie2("Veste");
        produit16.setMatiere("Cuir");
        produit16.setSaison("Toutes saisons");
        produit16.setStyle("Chic");
        produitList.add(produit16);

        //1
        Produit produit17 = new Produit();
        produit17.setNom("Veste");
        produit17.setTaille(Tailles);
        produit17.setPrix("4500 DA");
        produit17.setIconCover(R.drawable.ic_vesteh2);
        produit17.setCover(R.drawable.ic_vesteh2);
        produit17.setMarque("GIVENCCI");
        produit17.setDescription(listSummary[0]);
        produit17.setCategory("Homme");
        produit17.setCategorie2("Veste");
        produit17.setMatiere("Cuir");
        produit17.setSaison("Toutes saisons");
        produit17.setStyle("Glamour");
        produitList.add(produit17);

        //2
        Produit produit18 = new Produit();
        produit18.setNom("Veste");
        produit18.setTaille(Tailles);
        produit18.setPrix("4000 DA");
        produit18.setIconCover(R.drawable.ic_vesteh3);
        produit18.setCover(R.drawable.ic_vesteh3);
        produit18.setMarque("DOLCI GABANA");
        produit18.setDescription(listSummary[0]);
        produit18.setCategory("Homme");
        produit18.setCategorie2("Veste");
        produit18.setMatiere("Cuir");
        produit18.setSaison("Toutes saisons");
        produit18.setStyle("Glamour");
        produitList.add(produit18);


        //3
        Produit produit19 = new Produit();
        produit19.setNom("Veste");
        produit19.setTaille(Tailles);
        produit19.setPrix("4000 DA");
        produit19.setIconCover(R.drawable.ic_vesteh4);
        produit19.setCover(R.drawable.ic_vesteh4);
        produit19.setMarque("GUCCI");
        produit19.setDescription(listSummary[0]);
        produit19.setCategory("Homme");
        produit19.setCategorie2("Veste");
        produit19.setMatiere("Cuir");
        produit19.setSaison("Toutes saisons");
        produit19.setStyle("Glamour");
        produitList.add(produit19);


        //4
        Produit produit100 = new Produit();
        produit100.setNom("Veste");
        produit100.setTaille(Tailles);
        produit100.setPrix("43000 DA");
        produit100.setIconCover(R.drawable.ic_vestehomme);
        produit100.setCover(R.drawable.ic_vestehomme);
        produit100.setMarque("GIVENCHY");
        produit100.setDescription(listSummary[0]);
        produit100.setCategory("Homme");
        produit100.setCategorie2("Veste");
        produit100.setMatiere("Cuir");
        produit100.setSaison("Toutes saisons");
        produit100.setStyle("Chic");
        produitList.add(produit100);


        //---------------------------Sac-------------------
        //0
        Produit produit20 = new Produit();
        produit20.setNom("Sac");
        produit20.setTaille(Tailles1);
        produit20.setPrix("3500 DA");
        produit20.setIconCover(R.drawable.ic_sach1);
        produit20.setCover(R.drawable.ic_sach1);
        produit20.setMarque("CHLOÉ");
        produit20.setDescription(listSummary[0]);
        produit20.setCategory("Homme");
        produit20.setCategorie2("Sac");
        produit20.setMatiere("Cuir");
        produit20.setSaison("Toutes saisons");
        produit20.setStyle("Chic");
        produitList.add(produit20);

        //1
        Produit produit21 = new Produit();
        produit21.setNom("Sac");
        produit21.setTaille(Tailles1);
        produit21.setPrix("4500 DA");
        produit21.setIconCover(R.drawable.ic_sach2);
        produit21.setCover(R.drawable.ic_sach2);
        produit21.setMarque("GIVENCCI");
        produit21.setDescription(listSummary[0]);
        produit21.setCategory("Homme");
        produit21.setCategorie2("Sac");
        produit21.setMatiere("Cuir");
        produit21.setSaison("Toutes saisons");
        produit21.setStyle("Glamour");
        produitList.add(produit21);

        //2
        Produit produit23 = new Produit();
        produit23.setNom("Sac");
        produit23.setTaille(Tailles1);
        produit23.setPrix("4000 DA");
        produit23.setIconCover(R.drawable.ic_sachomme);
        produit23.setCover(R.drawable.ic_sachomme);
        produit23.setMarque("DOLCI GABANA");
        produit23.setDescription(listSummary[0]);
        produit23.setCategory("Homme");
        produit23.setCategorie2("Sac");
        produit23.setMatiere("Cuir");
        produit23.setSaison("Toutes saisons");
        produit23.setStyle("Glamour");
        produitList.add(produit23);

        //3
        Produit produit24 = new Produit();
        produit24.setNom("Sac");
        produit24.setTaille(Tailles1);
        produit24.setPrix("4000 DA");
        produit24.setIconCover(R.drawable.ic_sach4);
        produit24.setCover(R.drawable.ic_sach4);
        produit24.setMarque("GUCCI");
        produit24.setDescription(listSummary[0]);
        produit24.setCategory("Homme");
        produit24.setCategorie2("Sac");
        produit24.setMatiere("Cuir");
        produit24.setSaison("Toutes saisons");
        produit24.setStyle("Glamour");
        produitList.add(produit24);


        //4
        Produit produit25 = new Produit();
        produit25.setNom("Sac");
        produit25.setTaille(Tailles1);
        produit25.setPrix("43000 DA");
        produit25.setIconCover(R.drawable.ic_sach5);
        produit25.setCover(R.drawable.ic_sach5);
        produit25.setMarque("GIVENCHY");
        produit25.setDescription(listSummary[0]);
        produit25.setCategory("Homme");
        produit25.setCategorie2("Sac");
        produit25.setMatiere("Cuir");
        produit25.setSaison("Toutes saisons");
        produit25.setStyle("Chic");
        produitList.add(produit25);



        return produitList;
    }

//_____________---------------------------------------------________

    public List<Produit> getProduitListFemme() {
        String[] listSummary = getResources().getStringArray(R.array.summary);
        List<Produit> produitList = new ArrayList<Produit>();
        //------------Femme-----------------
        //----------------------------------Vetements------------------
        //0
        Produit produit = new Produit();
        String Tailles = "38, 40 ,42";


        produit.setNom("Mi-Longue Jupe");
        produit.setTaille(Tailles);
        produit.setPrix("4500 DA");
        produit.setIconCover(R.drawable.ic_images_45);
        produit.setCover(R.drawable.ic_images_45);
        produit.setMarque("KENZO");
        produit.setDescription(listSummary[0]);
        produit.setCategory("Femme");
        produit.setCategorie2("Vetements");
        produit.setMatiere("Laine");
        produit.setSaison("Printemps - Été");
        produit.setStyle("Chic Minimaliste");
        produitList.add(produit);

        //1
        Produit produit1 = new Produit();
        produit1.setNom("Pantallon");

        produit1.setTaille(Tailles);
        produit1.setPrix("3500 DA");
        produit1.setIconCover(R.drawable.ic_images_35);
        produit1.setCover(R.drawable.ic_images_35);
        produit1.setMarque("BALENCIAGA");
        produit1.setDescription(listSummary[0]);
        produit1.setCategory("Femme");
        produit1.setCategorie2("Vetements");
        produit1.setMatiere("Viscose");
        produit1.setSaison("Printemps - Été");
        produit1.setStyle("Glamour");
        produitList.add(produit1);
        //2
        Produit produit2 = new Produit();
        produit2.setNom("Robe");
        produit2.setTaille(Tailles);
        produit2.setPrix("5000 DA");
        produit2.setIconCover(R.drawable.ic_1femmevet2);
        produit2.setCover(R.drawable.ic_1femmevet2);
        produit2.setMarque("GIVENCHY");
        produit2.setDescription(listSummary[0]);
        produit2.setCategory("Femme");
        produit2.setCategorie2("Vetements");
        produit2.setMatiere("Soie");
        produit2.setSaison("Printemps - Été");
        produit2.setStyle("Glamour");
        produitList.add(produit2);
     //3
        Produit produit3 = new Produit();
        produit3.setNom("Chemise");
        produit3.setTaille(Tailles);
        produit3.setPrix("6000 DA");
        produit3.setIconCover(R.drawable.ic_vetementf3);
        produit3.setCover(R.drawable.ic_vetementf3);
        produit3.setMarque("ALEXANDER MCQUEEN");
        produit3.setDescription(listSummary[0]);
        produit3.setCategory("Femme");
        produit3.setCategorie2("Vetements");
        produit3.setMatiere("Coton");
        produit3.setSaison("Toutes les saisons");
        produit3.setStyle("Chic Minimaliste");
        produitList.add(produit3);

        //4
        Produit produit4 = new Produit();
        produit4.setNom("Pantallon");
        produit4.setTaille(Tailles);
        produit4.setPrix("6000 DA");
        produit4.setIconCover(R.drawable.ic_vetementf5);
        produit4.setCover(R.drawable.ic_vetementf5);
        produit4.setMarque("YVES SAINT LAURENT");
        produit4.setDescription(listSummary[0]);
        produit4.setCategory("Femme");
        produit4.setCategorie2("Vetements");
        produit4.setMatiere("Coton");
        produit4.setSaison("Toutes les saisons");
        produit4.setStyle("Chic Minimaliste");
        produitList.add(produit4);




        //---------------------------Chausures--------------------
        //0
        Produit produit6 = new Produit();
        produit6.setNom("Escarpins");
        produit6.setTaille(Tailles);
        produit6.setPrix("3500 DA");
        produit6.setIconCover(R.drawable.ic_1femmecha0);
        produit6.setCover(R.drawable.ic_1femmecha0);
        produit6.setMarque("CHLOÉ");
        produit6.setDescription(listSummary[0]);
        produit6.setCategory("Femme");
        produit6.setCategorie2("Chaussures");
        produit6.setMatiere("Cuir");
        produit6.setSaison("Toutes saisons");
        produit6.setStyle("Glamour");
        produitList.add(produit6);
        //1
        Produit produit7 = new Produit();
        produit7.setNom("Mini-Bottes à talons");
        produit7.setTaille(Tailles);
        produit7.setPrix("3500 DA");
        produit7.setIconCover(R.drawable.ic_1femmecha1);
        produit7.setCover(R.drawable.ic_1femmecha1);
        produit7.setMarque("GIUSEPPE ZANOTTI");
        produit7.setDescription(listSummary[0]);
        produit7.setCategory("Femme");
        produit7.setCategorie2("Chaussures");
        produit7.setMatiere("Cuir");
        produit7.setSaison("Toutes saisons");
        produit7.setStyle("Glamour");
        produitList.add(produit7);

        //2
        Produit produit8 = new Produit();
        produit8.setNom("Escarpins");
        produit8.setTaille(Tailles);
        produit8.setPrix("2800 DA");
        produit8.setIconCover(R.drawable.ic_1femmecha2);
        produit8.setCover(R.drawable.ic_1femmecha2);
        produit8.setMarque("CHLOÉ");
        produit8.setDescription(listSummary[0]);
        produit8.setCategory("Femme");
        produit8.setCategorie2("Chaussures");
        produit8.setMatiere("Cuir");
        produit8.setSaison("Toutes saisons");
        produit8.setStyle("Glamour");
        produitList.add(produit8);

        //3
        Produit produit9 = new Produit();
        produit9.setNom("Bottes a talon");
        produit9.setTaille(Tailles);
        produit9.setPrix("4000 DA");
        produit9.setIconCover(R.drawable.ic_1femmecha3);
        produit9.setCover(R.drawable.ic_1femmecha3);
        produit9.setMarque("CHLOÉ");
        produit9.setDescription(listSummary[0]);
        produit9.setCategory("Femme");
        produit9.setCategorie2("Chaussures");
        produit9.setMatiere("Cuir");
        produit9.setSaison("Toutes saisons");
        produit9.setStyle("Glamour");
        produitList.add(produit9);


        //4
        Produit produit10 = new Produit();
        produit10.setNom("Bottes sans talon");
        produit10.setTaille(Tailles);
        produit10.setPrix("4000 DA");
        produit10.setIconCover(R.drawable.ic_1femmecha4);
        produit10.setCover(R.drawable.ic_1femmecha4);
        produit10.setMarque("GUCCI");
        produit10.setDescription(listSummary[0]);
        produit10.setCategory("Femme");
        produit10.setCategorie2("Chaussures");
        produit10.setMatiere("Cuir");
        produit10.setSaison("Hiver-Automne");
        produit10.setStyle("Chic");
        produitList.add(produit10);


        //---------------------------Accesoires-------------------
        //0
        String Tailles1 = "- - -";

        Produit produit11 = new Produit();
        produit11.setNom("Chapeau");
        produit11.setTaille(Tailles1);
        produit11.setPrix("3500 DA");
        produit11.setIconCover(R.drawable.ic_1femmeacc0);
        produit11.setCover(R.drawable.ic_1femmeacc0);
        produit11.setMarque("CHLOÉ");
        produit11.setDescription(listSummary[0]);
        produit11.setCategory("Femme");
        produit11.setCategorie2("Accessoires");
        produit11.setMatiere("Cuir");
        produit11.setSaison("Toutes saisons");
        produit11.setStyle("Chic Minimaliste");
        produitList.add(produit11);

        //1
        Produit produit12 = new Produit();
        produit12.setNom("Montre");
        produit12.setTaille(Tailles1);
        produit12.setPrix("3500 DA");
        produit12.setIconCover(R.drawable.ic_1femmeacc1);
        produit12.setCover(R.drawable.ic_1femmeacc1);
        produit12.setMarque("GIVENCCI");
        produit12.setDescription(listSummary[0]);
        produit12.setCategory("Femme");
        produit12.setCategorie2("Accessoires");
        produit12.setMatiere("Cuir");
        produit12.setSaison("Toutes saisons");
        produit12.setStyle("Glamour");
        produitList.add(produit12);

        //2
        Produit produit13 = new Produit();
        produit13.setNom("Bracelet");
        produit13.setTaille(Tailles1);
        produit13.setPrix("4000 DA");
        produit13.setIconCover(R.drawable.ic_1femmeacc2);
        produit13.setCover(R.drawable.ic_1femmeacc2);
        produit13.setMarque("DOLCI GABANA");
        produit13.setDescription(listSummary[0]);
        produit13.setCategory("Femme");
        produit13.setCategorie2("Accessoires");
        produit13.setMatiere("Or");
        produit13.setSaison("Toutes saisons");
        produit13.setStyle("Glamour");
        produitList.add(produit13);


        //3
        Produit produit14 = new Produit();
        produit14.setNom("Boucles");
        produit14.setTaille(Tailles1);
        produit14.setPrix("5000 DA");
        produit14.setIconCover(R.drawable.ic_1femmeacc3);
        produit14.setCover(R.drawable.ic_1femmeacc3);
        produit14.setMarque("DOLCI GABANA");
        produit14.setDescription(listSummary[0]);
        produit14.setCategory("Femme");
        produit14.setCategorie2("Accessoires");
        produit14.setMatiere("Or");
        produit14.setSaison("Toutes saisons");
        produit14.setStyle("Glamour");
        produitList.add(produit14);

        //4
        Produit produit15 = new Produit();
        produit15.setNom("Colier");
        produit15.setTaille(Tailles1);
        produit15.setPrix("5000 DA");
        produit15.setIconCover(R.drawable.ic_1femmeacc4);
        produit15.setCover(R.drawable.ic_1femmeacc4);
        produit15.setMarque("DOLCI GABANA");
        produit15.setDescription(listSummary[0]);
        produit15.setCategory("Femme");
        produit15.setCategorie2("Accessoires");
        produit15.setMatiere("Or");
        produit15.setSaison("Toutes saisons");
        produit15.setStyle("Glamour");
        produitList.add(produit15);



        //---------------------------Vestes-------------------
        //0
        Produit produit16 = new Produit();
        produit16.setNom("Veste");
        produit16.setTaille(Tailles);
        produit16.setPrix("5500 DA");
        produit16.setIconCover(R.drawable.ic_1femmevet3);
        produit16.setCover(R.drawable.ic_1femmevet3);
        produit16.setMarque("CHLOÉ");
        produit16.setDescription(listSummary[0]);
        produit16.setCategory("Femme");
        produit16.setCategorie2("Veste");
        produit16.setMatiere("Cuir");
        produit16.setSaison("Toutes saisons");
        produit16.setStyle("Chic");
        produitList.add(produit16);

        //1
        Produit produit17 = new Produit();
        produit17.setNom("Veste");
        produit17.setTaille(Tailles);
        produit17.setPrix("4500 DA");
        produit17.setIconCover(R.drawable.ic_1femmevet4);
        produit17.setCover(R.drawable.ic_1femmevet4);
        produit17.setMarque("GIVENCCI");
        produit17.setDescription(listSummary[0]);
        produit17.setCategory("Femme");
        produit17.setCategorie2("Veste");
        produit17.setMatiere("Cuir");
        produit17.setSaison("Toutes saisons");
        produit17.setStyle("Glamour");
        produitList.add(produit17);

        //2
        Produit produit18 = new Produit();
        produit18.setNom("Veste");
        produit18.setTaille(Tailles);
        produit18.setPrix("4000 DA");
        produit18.setIconCover(R.drawable.ic_1femmevet5);
        produit18.setCover(R.drawable.ic_1femmevet5);
        produit18.setMarque("DOLCI GABANA");
        produit18.setDescription(listSummary[0]);
        produit18.setCategory("Femme");
        produit18.setCategorie2("Veste");
        produit18.setMatiere("Cuir");
        produit18.setSaison("Toutes saisons");
        produit18.setStyle("Glamour");
        produitList.add(produit18);


        //3
        Produit produit19 = new Produit();
        produit19.setNom("Veste");
        produit19.setTaille(Tailles);
        produit19.setPrix("4000 DA");
        produit19.setIconCover(R.drawable.ic_1femmevet6);
        produit19.setCover(R.drawable.ic_1femmevet6);
        produit19.setMarque("GUCCI");
        produit19.setDescription(listSummary[0]);
        produit19.setCategory("Femme");
        produit19.setCategorie2("Veste");
        produit19.setMatiere("Cuir");
        produit19.setSaison("Toutes saisons");
        produit19.setStyle("Glamour");
        produitList.add(produit19);


        //4
        Produit produit100 = new Produit();
        produit100.setNom("Veste");
        produit100.setTaille(Tailles);
        produit100.setPrix("43000 DA");
        produit100.setIconCover(R.drawable.ic_vestef4);
        produit100.setCover(R.drawable.ic_vestef4);
        produit100.setMarque("GIVENCHY");
        produit100.setDescription(listSummary[0]);
        produit100.setCategory("Femme");
        produit100.setCategorie2("Veste");
        produit100.setMatiere("Cuir");
        produit100.setSaison("Toutes saisons");
        produit100.setStyle("Chic");
        produitList.add(produit100);


        //---------------------------Sac-------------------
        //0
        Produit produit20 = new Produit();
        produit20.setNom("Sac");
        produit20.setTaille(Tailles1);
        produit20.setPrix("3500 DA");
        produit20.setIconCover(R.drawable.ic_1femmesac0);
        produit20.setCover(R.drawable.ic_1femmesac0);
        produit20.setMarque("CHLOÉ");
        produit20.setDescription(listSummary[0]);
        produit20.setCategory("Femme");
        produit20.setCategorie2("Sac");
        produit20.setMatiere("Cuir");
        produit20.setSaison("Toutes saisons");
        produit20.setStyle("Chic");
        produitList.add(produit20);

        //1
        Produit produit21 = new Produit();
        produit21.setNom("Sac");
        produit21.setTaille(Tailles1);
        produit21.setPrix("4500 DA");
        produit21.setIconCover(R.drawable.ic_1femmesac1);
        produit21.setCover(R.drawable.ic_1femmesac1);
        produit21.setMarque("GIVENCCI");
        produit21.setDescription(listSummary[0]);
        produit21.setCategory("Femme");
        produit21.setCategorie2("Sac");
        produit21.setMatiere("Cuir");
        produit21.setSaison("Toutes saisons");
        produit21.setStyle("Glamour");
        produitList.add(produit21);

        //2
        Produit produit23 = new Produit();
        produit23.setNom("Sac");
        produit23.setTaille(Tailles1);
        produit23.setPrix("4000 DA");
        produit23.setIconCover(R.drawable.ic_1femmesac2);
        produit23.setCover(R.drawable.ic_1femmesac2);
        produit23.setMarque("DOLCI GABANA");
        produit23.setDescription(listSummary[0]);
        produit23.setCategory("Femme");
        produit23.setCategorie2("Sac");
        produit23.setMatiere("Cuir");
        produit23.setSaison("Toutes saisons");
        produit23.setStyle("Glamour");
        produitList.add(produit23);

        //3
        Produit produit24 = new Produit();
        produit24.setNom("Sac");
        produit24.setTaille(Tailles1);
        produit24.setPrix("4000 DA");
        produit24.setIconCover(R.drawable.ic_sacfemme);
        produit24.setCover(R.drawable.ic_sacfemme);
        produit24.setMarque("GUCCI");
        produit24.setDescription(listSummary[0]);
        produit24.setCategory("Femme");
        produit24.setCategorie2("Sac");
        produit24.setMatiere("Cuir");
        produit24.setSaison("Toutes saisons");
        produit24.setStyle("Glamour");
        produitList.add(produit24);


        //4
        Produit produit25 = new Produit();
        produit25.setNom("Sac");
        produit25.setTaille(Tailles1);
        produit25.setPrix("43000 DA");
        produit25.setIconCover(R.drawable.ic_1femmesac4);
        produit25.setCover(R.drawable.ic_1femmesac4);
        produit25.setMarque("GIVENCHY");
        produit25.setDescription(listSummary[0]);
        produit25.setCategory("Femme");
        produit25.setCategorie2("Sac");
        produit25.setMatiere("Cuir");
        produit25.setSaison("Toutes saisons");
        produit25.setStyle("Chic");
        produitList.add(produit25);


        return produitList;
    }


    */




    public boolean isTwoPane() {

        View v  = getActivity().findViewById(R.id.frameLayout);
        return (v!=null);

    }



}

package com.example.dktique.shoppingstore1;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.widget.Toast;

public class SectionsPagerAdapter extends FragmentPagerAdapter {
    public SectionsPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {

        if (position==0){


        MainFragment mainFragment = new MainFragment();
        Bundle bundle = new Bundle();
        bundle.putInt("pos",position);
        mainFragment.setArguments(bundle);
        return mainFragment;}
        else {

            if (position==1){
            MainFragment2 mainFragment2 = new MainFragment2();
            Bundle bundle = new Bundle();
            bundle.putInt("pos",position);
            mainFragment2.setArguments(bundle);
            return mainFragment2;}

            else {
                MainFragment3 mainFragment3 = new MainFragment3();
                Bundle bundle = new Bundle();
                bundle.putInt("pos",position);
                mainFragment3.setArguments(bundle);
                return mainFragment3;}
        }
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return "FEMME";
            case 1:
                return "HOMME";
            case 2:
                return "ENFANT";
        }
        return null;
    }
}

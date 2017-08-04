package com.haysarodrigues.dearactionbarfragment;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;

/**
 * Created by Haysa on 04/08/17.
 */

class TabsAdapter extends FragmentPagerAdapter {

    public TabsAdapter(FragmentManager supportFragmentManager){
        super(supportFragmentManager);
    }


    @Override
    public Fragment getItem(int position) {

        if (position == 0){
            return new Fragment1();
        }
        else if (position == 1){
            return new Fragment2();
        }
        return new Fragment3();
    }

    @Override
    public int getCount() {
        return 3; //view page com 3 páginas
    }
}

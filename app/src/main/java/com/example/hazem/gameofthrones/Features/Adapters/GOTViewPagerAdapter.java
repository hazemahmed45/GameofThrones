package com.example.hazem.gameofthrones.Features.Adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.hazem.gameofthrones.Features.Fragments.BookFragment;
import com.example.hazem.gameofthrones.Features.Fragments.CharacterFragment;
import com.example.hazem.gameofthrones.Features.Fragments.HouseFragment;
import com.example.hazem.gameofthrones.R;
import com.example.hazem.gameofthrones.Utils.StringUtil;

/**
 * Created by Hazem on 6/15/2017.
 */

public class GOTViewPagerAdapter extends FragmentPagerAdapter {

    public GOTViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position)
        {
            case 0:
            {
                return new CharacterFragment();
            }
            case 2:
            {
                return new HouseFragment();
            }
            case 1:
            {
                return new BookFragment();
            }


        }
        return null;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position)
        {
            case 0:
            {
                return StringUtil.getStringRes(R.string.character);
            }
            case 1:
            {
                return StringUtil.getStringRes(R.string.book);
            }
            case 2:
            {
                return StringUtil.getStringRes(R.string.house);
            }
        }
        return super.getPageTitle(position);
    }

    @Override
    public int getCount() {
        return 3;
    }
}

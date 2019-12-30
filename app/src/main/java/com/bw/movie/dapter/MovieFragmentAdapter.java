package com.bw.movie.dapter;



import java.util.List;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class MovieFragmentAdapter extends FragmentPagerAdapter {
    private List<String> textList;
    private List<Fragment> fragmentList;

    public MovieFragmentAdapter(FragmentManager fm, List<String> textList, List<Fragment> fragmentList) {
        super(fm);
        this.textList = textList;
        this.fragmentList = fragmentList;
    }

    @Override
    public Fragment getItem(int i) {
        return fragmentList.get(i);
    }

    @Override
    public int getCount() {
        return fragmentList.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return textList.get(position);
    }
}

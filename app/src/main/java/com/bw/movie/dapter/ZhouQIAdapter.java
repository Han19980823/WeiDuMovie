package com.bw.movie.dapter;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

/**
 * 作者：Han98
 * 创建时间：2019/12/16
 * 描述：TODO
 * 最近修改：2019/12/16 15:48 modify by liujc
 */
public class ZhouQIAdapter extends FragmentPagerAdapter {
    List<Fragment> flist ;
    List<String> slist ;

    public ZhouQIAdapter(FragmentManager fm, List<Fragment> flist, List<String> slist) {
        super(fm);
        this.flist = flist;
        this.slist = slist;
    }

    @Override
    public Fragment getItem(int position) {
        return flist.get(position);
    }

    @Override
    public int getCount() {
        return flist.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return slist.get(position);
    }
}

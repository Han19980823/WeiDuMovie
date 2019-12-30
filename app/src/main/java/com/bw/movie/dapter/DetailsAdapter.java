package com.bw.movie.dapter;

import java.util.List;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

/**
 * 作者：Han98
 * 创建时间：2019/12/10
 * 描述：TODO
 * 最近修改：2019/12/10 15:04 modify by liujc
 */
public class DetailsAdapter extends FragmentPagerAdapter {
    List<String> slist;
    List<Fragment> flist ;

    public DetailsAdapter(FragmentManager fm, List<String> slist, List<Fragment> flist) {
        super(fm);
        this.slist = slist;
        this.flist = flist;
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

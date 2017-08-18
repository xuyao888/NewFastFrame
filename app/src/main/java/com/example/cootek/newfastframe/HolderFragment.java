package com.example.cootek.newfastframe;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;

import com.example.commonlibrary.mvp.BaseFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * Created by COOTEK on 2017/8/16.
 */

public class HolderFragment extends BaseFragment {


    @BindView(R.id.tb_fragment_holder_tab)
    TabLayout tab;
    @BindView(R.id.vp_fragment_holder_display)
    ViewPager display;

    @Override
    public void updateData(Object o) {

    }

    @Override
    protected boolean isNeedHeadLayout() {
        return false;
    }

    @Override
    protected boolean isNeedEmptyLayout() {
        return false;
    }

    @Override
    protected int getContentLayout() {
        return R.layout.fragment_holder;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {
        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getChildFragmentManager());
        List<String> titleList = new ArrayList<>();
        titleList.add("首页");
        titleList.add("排行榜");
        titleList.add("测试");
        List<BaseFragment> fragments = new ArrayList<>();
        fragments.add(MainFragment.newInstance());
        fragments.add(RankFragment.newInstance());
        fragments.add(TestFragment.newInstance());
        viewPagerAdapter.setTitleAndFragments(titleList, fragments);
        tab.setupWithViewPager(display);
        display.setOffscreenPageLimit(1);
        display.setAdapter(viewPagerAdapter);
    }

    @Override
    protected void updateView() {
        display.setCurrentItem(0);
    }

    public static HolderFragment newInstance() {
        return new HolderFragment();
    }

    private class ViewPagerAdapter extends FragmentPagerAdapter {
        private List<String> titleList;
        private List<BaseFragment> fragments;

        ViewPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return fragments.get(position);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return titleList.get(position);
        }

        @Override
        public int getCount() {
            return fragments.size();
        }

        void setTitleAndFragments(List<String> titleList, List<BaseFragment> fragments) {
            this.titleList = titleList;
            this.fragments = fragments;
        }
    }
}

package com.example.q.tablayouttest;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by YQ on 2016/7/20.
 */
//顶层的Fragment，内部有ViewPager和TabLayout
public class PageFragment  extends BaseFragment{
    private int resource;
    private TabLayout tab1;
    private ViewPager viewPager1;
    private SimpleFragmentPagerAdapter adapter;
    private List<Fragment> list;
    private List<String> names;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle=getArguments();
        resource=bundle.getInt("resource");
    }

    public static PageFragment newInstance(int resource){
        PageFragment pageFragment=new PageFragment();
        Bundle bundle=new Bundle();
        bundle.putInt("resource",resource);
        pageFragment.setArguments(bundle);
        return pageFragment;
    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //用false，不然会有bug
        View view=inflater.inflate(resource,container,false);
        tab1 = (TabLayout) view.findViewById(R.id.tab_1);
        viewPager1 = (ViewPager) view.findViewById(R.id.view_pager_1);
        initFragment();
        adapter=new SimpleFragmentPagerAdapter(getChildFragmentManager(),list,names);
        viewPager1.setAdapter(adapter);
        tab1.setupWithViewPager(viewPager1);
        tab1.setTabMode(TabLayout.MODE_FIXED);
        return view;
    }

    private void initFragment() {
        list=new ArrayList<>();
        names=new ArrayList<>();
        TabPageFragment tabPageFragment1=TabPageFragment.newInstance(1);
        TabPageFragment tabPageFragment2=TabPageFragment.newInstance(2);
        TabPageFragment tabPageFragment3=TabPageFragment.newInstance(3);
        names.add("Tab1");
        names.add("Tab2");
        names.add("Tab3");
        list.add(tabPageFragment1);
        list.add(tabPageFragment2);
        list.add(tabPageFragment3);

    }
}

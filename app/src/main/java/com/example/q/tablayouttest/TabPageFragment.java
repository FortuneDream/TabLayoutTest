package com.example.q.tablayouttest;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by YQ on 2016/7/21.
 */
//ViewPager中的Fragment
public class TabPageFragment extends BaseFragment{
    public static final String ARG_PAGE="ARG_PAGE";
    private int mPage;

    //重建，或者创建的时候，赋值,--->使用setArgument为Fragment添加构造器
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPage=getArguments().getInt(ARG_PAGE);
    }

    public static TabPageFragment newInstance(int page){
        TabPageFragment tabPageFragment=new TabPageFragment();
        Bundle bundle=new Bundle();
        bundle.putInt(ARG_PAGE,page);
        tabPageFragment.setArguments(bundle);
        return tabPageFragment;
    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_view_pager_main,container,false);
        TextView textView= (TextView) view.findViewById(R.id.txt);
        textView.setText(ARG_PAGE+mPage);
        return view;
    }


}

package com.example.q.tablayouttest;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.util.List;

//主界面，一个中上部Fragment+底部导航切换Fragment
public class MainActivity extends BaseActivity implements RadioGroup.OnCheckedChangeListener {
    private FrameLayout contentView;
    private RadioGroup radioGroup;
    private PageFragment pageFragment;
    private FragmentManager fm;
    private RadioButton rb1;
    private RadioButton rb2;
    private RadioButton rb3;
    private List<Fragment> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findView();
        setListener();
        init();
    }

    private void init() {
        rb1.setChecked(true);
    }

    private void setListener() {
        radioGroup.setOnCheckedChangeListener(this);
    }

    private void findView() {
        contentView = (FrameLayout) findViewById(R.id.content_view);
        radioGroup = (RadioGroup) findViewById(R.id.radio_group);
        rb1 = (RadioButton) findViewById(R.id.rb_1);
        rb2 = (RadioButton) findViewById(R.id.rb_2);
        rb3 = (RadioButton) findViewById(R.id.rb_3);
    }

    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int i) {
        fm = getSupportFragmentManager();
        list = fm.getFragments();
        if (list!=null){
            for (Fragment fragment : list) {
                if (fragment.isAdded()) {
                    fm.beginTransaction().hide(fragment).commit();
                }
            }
        }
        switch (radioGroup.getCheckedRadioButtonId()) {
            case R.id.rb_1:
                if (pageFragment == null) {
                    pageFragment = PageFragment.newInstance(R.layout.fragment_page_main);
                }
                if (!pageFragment.isAdded()) {
                    fm.beginTransaction().add(R.id.content_view,pageFragment).commit();
                }
                fm.beginTransaction().show(pageFragment).commit();
                break;
            case R.id.rb_2:
                Toast.makeText(MainActivity.this, "RadioButton2", Toast.LENGTH_SHORT).show();
                break;
            case R.id.rb_3:
                Toast.makeText(MainActivity.this, "RadioButton2", Toast.LENGTH_SHORT).show();
                break;
        }

    }
}

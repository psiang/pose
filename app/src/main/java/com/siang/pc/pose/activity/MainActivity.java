package com.siang.pc.pose.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.siang.pc.pose.fragment.MyFragment;
import com.siang.pc.pose.fragment.PoseFragment;
import com.siang.pc.pose.fragment.SocialFragment;
import com.siang.pc.pose.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by siang on 2019/5/3.
 */
public class MainActivity extends AppCompatActivity {

    private ViewPager mViewPager;
    private RadioGroup mTabRadioGroup;

    private List<Fragment> mFragments;
    private FragmentPagerAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
        initView();
    }

    public void onLearnClick(View v) {
        Intent intent = new Intent(this, ScoreActivity.class);
        startActivity(intent);
    }

    public void onScoreClick(View v) {
        Intent intent = new Intent(this, ScoreActivity.class);
        startActivity(intent);
    }

    private void initView() {
        // find view
        mViewPager = findViewById(R.id.fragment_vp);
        mTabRadioGroup = findViewById(R.id.radiogroup);
        // init fragment
        mFragments = new ArrayList<>(3);
        mFragments.add(new SocialFragment());
        mFragments.add(new PoseFragment());
        mFragments.add(new MyFragment());
        // init view pager
        mAdapter = new MyFragmentPagerAdapter(getSupportFragmentManager(), mFragments);
        mViewPager.setAdapter(mAdapter);
        // register listener
        mViewPager.addOnPageChangeListener(mPageChangeListener);
        mTabRadioGroup.setOnCheckedChangeListener(mOnCheckedChangeListener);
        mViewPager.setCurrentItem(1);
        mViewPager.setOffscreenPageLimit(2);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mViewPager.removeOnPageChangeListener(mPageChangeListener);
    }

    private ViewPager.OnPageChangeListener mPageChangeListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {
            RadioButton radioButton = (RadioButton) mTabRadioGroup.getChildAt(position);
            radioButton.setChecked(true);
        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };

    private RadioGroup.OnCheckedChangeListener mOnCheckedChangeListener = new RadioGroup.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(RadioGroup group, int checkedId) {
            for (int i = 0; i < group.getChildCount(); i++) {
                if (group.getChildAt(i).getId() == checkedId) {
                    mViewPager.setCurrentItem(i);
                    return;
                }
            }
        }
    };

    private class MyFragmentPagerAdapter extends FragmentPagerAdapter {

        private List<Fragment> mList;

        public MyFragmentPagerAdapter(FragmentManager fm, List<Fragment> list) {
            super(fm);
            this.mList = list;
        }

        @Override
        public Fragment getItem(int position) {
            return this.mList == null ? null : this.mList.get(position);
        }

        @Override
        public int getCount() {
            return this.mList == null ? 0 : this.mList.size();
        }
    }
    /*private SocialFragment    fragment1;
    private PoseFragment fragment2;
    private MyFragment     fragment3;
    private RadioGroup  radioGroup;
    private RadioButton radioButton;
    //private FragmentManager manager;
    //private FragmentTransaction transaction;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        //全屏显示，显示时间和电量
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LOW_PROFILE);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);


        //开启事务管理，主要处理Fragment
        //manager = getFragmentManager();
        // transaction = manager.beginTransaction();

        //设置切换Fragment
        radioGroup = (RadioGroup)findViewById(R.id.radiogroup);
        RadioGroupList radigGroupList = new RadioGroupList();
        radioGroup.setOnCheckedChangeListener(radigGroupList);

        //设置默认按钮为选中状态
        radioButton =(RadioButton) findViewById(R.id.btn_1);
        radioButton.setChecked(true);


        //开始处理Fragment
        fragment1 = new SocialFragment();
        fragment2 = new PoseFragment();
        fragment3 = new MyFragment();

        findViewById(R.id.fragment_social).setVisibility(View.INVISIBLE);
        findViewById(R.id.fragment_pose).setVisibility(View.VISIBLE);
        findViewById(R.id.fragment_my).setVisibility(View.INVISIBLE);

    }

    public class RadioGroupList implements RadioGroup.OnCheckedChangeListener
    {

        @Override
        public void onCheckedChanged(RadioGroup group, int checkedId)
        {
            if(group.getId() == R.id.radiogroup)
            {
                switch (checkedId)
                {
                    case R.id.btn_0:
                        findViewById(R.id.fragment_social).setVisibility(View.VISIBLE);
                        findViewById(R.id.fragment_pose).setVisibility(View.INVISIBLE);
                        findViewById(R.id.fragment_my).setVisibility(View.INVISIBLE);
                        Log.d(" 社区", "提示");
                        break;
                    case R.id.btn_1:
                        findViewById(R.id.fragment_social).setVisibility(View.INVISIBLE);
                        findViewById(R.id.fragment_pose).setVisibility(View.VISIBLE);
                        findViewById(R.id.fragment_my).setVisibility(View.INVISIBLE);
                        Log.d("POSE", "提示");
                        break;
                    case R.id.btn_2:
                        findViewById(R.id.fragment_social).setVisibility(View.INVISIBLE);
                        findViewById(R.id.fragment_pose).setVisibility(View.INVISIBLE);
                        findViewById(R.id.fragment_my).setVisibility(View.VISIBLE);
                        Log.d("我的", "提示");
                        break;
                    default :
                        break;
                }
            }
        }
    }*/
}


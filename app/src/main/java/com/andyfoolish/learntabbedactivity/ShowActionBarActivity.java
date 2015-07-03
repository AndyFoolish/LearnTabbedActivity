package com.andyfoolish.learntabbedactivity;

import android.app.ActionBar;
import android.app.Activity;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.Menu;
import android.view.MenuItem;



public class ShowActionBarActivity extends FragmentActivity implements ActionBar.TabListener {
    private ViewPager mViewPager;
    private SectionsPagerAdapter mSectionsPagerAdapter;
    private static final int TAB_INDEX_COUNT = 3;
    private Fragment1 mFragment1 = new Fragment1();
    private Fragment2 mFragment2 = new Fragment2();
    private Fragment3 mFragment3 = new Fragment3();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_action_bar);

        setUpActionBar();
        setUpViewPager();
        setUpTabs();

    }

    private void setUpActionBar() {
        // Set up the action bar.
        //通过调用setDisplayHomeAsUpEnabled() 来把 app icon 设置成可用的向上按钮
        // 如果你的minSdkVersion属性是11活更高, 应该这么用:
        // getActionBar().setDisplayHomeAsUpEnabled(true);
        final ActionBar actionBar = getActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        //添加Tab到Action Bar
        // 指定在action bar中显示tab.
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
//        actionBar.setHomeButtonEnabled(false);
//        actionBar.setDisplayShowTitleEnabled(false);
//        actionBar.setDisplayShowHomeEnabled(false);

    }

    private void setUpViewPager() {
        // ViewPager和他的adapter使用了support library
        // fragments,所以要用getSupportFragmentManager.
        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());
        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.pager);
        mViewPager.setAdapter(mSectionsPagerAdapter);
        //当用户通过触屏手势(touch gesture)切换页面时，你也应该选择相应的tab
        mViewPager.setOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener(){
            @Override
            public void onPageSelected(int position){
                // 当划屏切换页面时，选择相应的tab.
                 getActionBar().setSelectedNavigationItem(position);
            }
        });

    }

    // For each of the sections in the app, add a tab to the action bar.
    private void setUpTabs() {
        final ActionBar actionBar = getActionBar();
        for (int i = 0; i < mSectionsPagerAdapter.getCount(); i++) {
            actionBar.addTab(
                    actionBar.newTab()
                            .setText(mSectionsPagerAdapter.getPageTitle(i))
                            .setTabListener(this));
        }
    }

    //要插入每一个页面的子视图，你需要把这个layout与PagerAdapter挂钩
    public class SectionsPagerAdapter extends FragmentPagerAdapter {
        public SectionsPagerAdapter(FragmentManager fm){
            super(fm);
        }
        @Override
        public Fragment getItem(int position) {
            // getItem is called to instantiate the fragment for the given page.
            // Return a PlaceholderFragment (defined as a static inner class below).
            switch (position) {
                case 0:
                    return mFragment1;
                case 1:
                    return mFragment2;
                case 2:
                    return mFragment3;
            }
            throw new IllegalStateException("No fragment at position " + position);
        }
        @Override
        public int getCount() {
            // TODO Auto-generated method stub
            return TAB_INDEX_COUNT;
        }
        @Override
        public CharSequence getPageTitle(int position) {
            String tabLabel = null;
            switch (position) {
                case 0:
                    tabLabel = getString(R.string.tab_1);
                    break;
                case 1:
                    tabLabel = getString(R.string.tab_2);
                    break;
                case 2:
                    tabLabel = getString(R.string.tab_3);
                    break;
            }
            return tabLabel;
        }
    }

    @Override
    public void onTabSelected(ActionBar.Tab tab, FragmentTransaction ft) {
        mViewPager.setCurrentItem(tab.getPosition());
    }

    @Override
    public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction ft) {

    }

    @Override
    public void onTabReselected(ActionBar.Tab tab, FragmentTransaction ft) {

    }

    //以下是对actionbar的操作
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        //// 为ActionBar扩展菜单项
        getMenuInflater().inflate(R.menu.menu_show_action_bar, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
//        if (id == R.id.action_settings) {
//            return true;
//        }
        switch (id){
            case R.id.action_search:
//                openSearch();
                return true;
            case R.id.action_settings:
//                openSettings();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }
}

package com.example.xw.todaynews.Activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import com.example.xw.todaynews.Base.Impl.ContentFragment;
import com.example.xw.todaynews.Base.Impl.LeftMenuFragment;
import com.example.xw.todaynews.R;
import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;
import com.jeremyfeinstein.slidingmenu.lib.app.SlidingFragmentActivity;

/**
 * Created by xw on 2016/8/26.
 */
public class MainActivity extends SlidingFragmentActivity {

    private static final String TAG_LEFT_MENU = "TAG_LEFT_MENU";
    private static final String TAG_CONTENT = "TAG_CONTENT";
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // 添加侧边栏
        setBehindContentView(R.layout.left_menu);
        SlidingMenu slidingMenu = getSlidingMenu();
        // 全屏触摸
        slidingMenu.setTouchModeAbove(SlidingMenu.TOUCHMODE_FULLSCREEN);
        // 屏幕预留200像素
        slidingMenu.setBehindOffset(200);

        initFragment();
    }

    private void initFragment() {
        // Fragment管理器
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();// 开始事务
        // 将帧布局替换为对应的Fragment
        transaction
                .replace(R.id.fl_content, new ContentFragment(), TAG_CONTENT);
        transaction.replace(R.id.fl_left_menu, new LeftMenuFragment(),
                TAG_LEFT_MENU);
        transaction.commit();// 提交事务
        // fm.findFragmentByTag(TAG_CONTENT);
    }
}
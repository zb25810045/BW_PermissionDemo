package com.bloodcrown.permissioncomponent.contentsource;


import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;

/**
 * 作者 ： BloodCrown
 * 时间 ： 2018/4/19 下午4:18
 * 描述 ：
 */

public class FragmentSource implements ContentSource {

    private Fragment fragment;

    public FragmentSource() {
    }

    public FragmentSource(Fragment fragment) {
        this.fragment = fragment;
    }

    @Override
    public Context getContent() {
        return fragment.getActivity();
    }

    @Override
    public void startActivity(Intent intent, int code) {
        fragment.startActivityForResult(intent, code);
    }
}

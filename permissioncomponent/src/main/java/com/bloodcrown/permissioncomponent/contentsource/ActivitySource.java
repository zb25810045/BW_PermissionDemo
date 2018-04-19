package com.bloodcrown.permissioncomponent.contentsource;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;

/**
 * 作者 ： BloodCrown
 * 时间 ： 2018/4/19 下午4:17
 * 描述 ：
 */

public class ActivitySource implements ContentSource {

    private Activity activity;

    public ActivitySource() {
    }

    public ActivitySource(Activity activity) {
        this.activity = activity;
    }

    @Override
    public Context getContent() {
        return activity;
    }

    @Override
    public void startActivity(Intent intent, int code) {
        activity.startActivityForResult(intent,code);
    }
}

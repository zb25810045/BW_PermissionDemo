package com.bloodcrown.permissioncomponent.contentsource;

import android.content.Context;
import android.content.Intent;

/**
 * 作者 ： BloodCrown
 * 时间 ： 2018/4/19 下午4:14
 * 描述 ：
 */

public class ApplicationSource implements ContentSource {

    private Context context;

    public ApplicationSource() {
    }

    public ApplicationSource(Context context) {
        this.context = context;
    }

    @Override
    public Context getContent() {
        return context;
    }

    @Override
    public void startActivity(Intent intent, int code) {
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);
    }
}

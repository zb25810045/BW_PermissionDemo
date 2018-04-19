package com.bloodcrown.permissioncomponent.contentsource;

import android.content.Context;
import android.content.Intent;

/**
 * 作者 ： BloodCrown
 * 时间 ： 2018/4/19 下午12:26
 * 描述 ： 包装上下文对象，提供一些基础的功能
 */

public interface ContentSource {

    Context getContent();

    void startActivity(Intent intent, int code);

}

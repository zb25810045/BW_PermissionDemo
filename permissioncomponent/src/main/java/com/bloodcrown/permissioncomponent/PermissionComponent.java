package com.bloodcrown.permissioncomponent;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.provider.Settings;
import android.support.v4.app.Fragment;

import com.bloodcrown.permissioncomponent.contentsource.ActivitySource;
import com.bloodcrown.permissioncomponent.contentsource.ApplicationSource;
import com.bloodcrown.permissioncomponent.contentsource.ContentSource;
import com.bloodcrown.permissioncomponent.contentsource.FragmentSource;

/**
 * 作者 ： BloodCrown
 * 时间 ： 2018/4/19 下午12:44
 * 描述 ： 权限管理的最外层API
 */

public class PermissionComponent {

    public static PermissinManage with(Context context) {
        return new PermissinManage(context);
    }

    public static PermissinManage with(Activity activity) {
        return new PermissinManage(activity);
    }

    public static PermissinManage with(Fragment fragment) {
        return new PermissinManage(fragment);
    }

    public static void startSettingActivity(Activity activity, int code) {
        startSettingActivity(new ActivitySource(activity), code);
    }

    public static void startSettingActivity(Fragment fragment, int code) {
        startSettingActivity(new FragmentSource(fragment), code);
    }

    public static void startSettingActivity(Context context, int code) {
        startSettingActivity(new ApplicationSource(context), code);
    }

    private static void startSettingActivity(ContentSource contentSource, int code) {
        Intent intent = new Intent();
        intent.setAction(Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
        intent.setData(Uri.parse("package:" + contentSource.getContent().getPackageName()));

        intent.addCategory(Intent.CATEGORY_DEFAULT);
        intent.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
        intent.addFlags(Intent.FLAG_ACTIVITY_EXCLUDE_FROM_RECENTS);
        contentSource.startActivity(intent, code);
    }
}

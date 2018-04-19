package com.bloodcrown.permissioncomponent;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.provider.Settings;
import android.support.v4.app.Fragment;

import com.bloodcrown.permissioncomponent.contentsource.ActivitySource;
import com.bloodcrown.permissioncomponent.contentsource.ApplicationSource;
import com.bloodcrown.permissioncomponent.contentsource.FragmentSource;
import com.bloodcrown.permissioncomponent.executer.ExecuterFactor;

/**
 * 作者 ： BloodCrown
 * 时间 ： 2018/4/19 下午12:44
 * 描述 ：
 */

public class PermissinManage {

    private PermissionContain contain;

    public PermissinManage(Context context) {
        contain = new PermissionContain();
        contain.setContentSource(new ApplicationSource(context));
    }

    public PermissinManage(Activity activity) {
        contain = new PermissionContain();
        contain.setContentSource(new ActivitySource(activity));
    }

    public PermissinManage(Fragment fragment) {
        contain = new PermissionContain();
        contain.setContentSource(new FragmentSource(fragment));
    }

    public PermissinManage permissin(String... permissions) {
        contain.setPermissions(permissions);
        return this;
    }


    public PermissinManage onSuccess(Action action) {
        contain.setOnSuccessAction(action);
        return this;
    }

    public PermissinManage onDenial(Action action) {
        contain.setOnDenialAction(action);
        return this;
    }

    public PermissinManage onDontShow(Action action) {
        contain.setOnDontShowAction(action);
        return this;
    }

    public PermissinManage run() {
        ExecuterFactor.getDefaultInstance().run(contain);
        return this;
    }

}

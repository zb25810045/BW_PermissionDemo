package com.bloodcrown.permissioncomponent.executer;

import android.Manifest;

import com.bloodcrown.permissioncomponent.PermissionContain;
import com.yanzhenjie.permission.AndPermission;

/**
 * 作者 ： BloodCrown
 * 时间 ： 2018/4/19 下午12:22
 * 描述 ：
 */

public class AndPermissinExecuter implements PermissionExecuter {

    @Override
    public void run(PermissionContain contain) {
        AndPermission.with(contain.getContentSource().getContent())
                .permission(contain.getPermissions())
                // 用户给权限了
                .onGranted(permissions -> contain.getOnSuccessAction().run())
                // 用户拒绝权限，包括不再显示权限弹窗也在此列
                .onDenied(permissions -> {
                    // 判断用户是不是不再显示权限弹窗了，若不再显示的话进入权限设置页
                    if (AndPermission.hasAlwaysDeniedPermission(contain.getContentSource().getContent(), permissions)) {
                        // 打开权限设置页
                        contain.getOnDontShowAction().run();
                        return;
                    }
                    contain.getOnDenialAction().run();
                })
                .start();
    }
}

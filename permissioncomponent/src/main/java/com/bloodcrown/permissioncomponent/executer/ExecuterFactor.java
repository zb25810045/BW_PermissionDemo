package com.bloodcrown.permissioncomponent.executer;

/**
 * 作者 ： BloodCrown
 * 时间 ： 2018/4/20 上午3:56
 * 描述 ：
 */

public class ExecuterFactor {

    public static PermissionExecuter getDefaultInstance() {
        return getInstance(ExecuterConfig.DEFAULT_EXECUTER);
    }

    public static PermissionExecuter getInstance(String type) {
        if (type == ExecuterConfig.ANDPERMISSION) {
            return new AndPermissinExecuter();
        }
        return null;
    }

}

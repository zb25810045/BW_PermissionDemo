package com.bloodcrown.permissioncomponent.executer;

import com.bloodcrown.permissioncomponent.PermissionContain;
import com.bloodcrown.permissioncomponent.contentsource.ContentSource;

/**
 * 作者 ： BloodCrown
 * 时间 ： 2018/4/19 下午12:23
 * 描述 ： 权限请求执行器，这是实际对于不同的权限库的封装
 */

public interface PermissionExecuter {

    void run(PermissionContain contain);

}

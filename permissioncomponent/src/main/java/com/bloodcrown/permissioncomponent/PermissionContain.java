package com.bloodcrown.permissioncomponent;

import com.bloodcrown.permissioncomponent.contentsource.ContentSource;

/**
 * 作者 ： BloodCrown
 * 时间 ： 2018/4/19 下午12:23
 * 描述 ： 存储权限相关的一些数据对象
 */

public class PermissionContain {

    private ContentSource contentSource;
    private Action onSuccessAction, onDenialAction, onDontShowAction;
    private String[] permissions;

    public PermissionContain() {
    }

    public PermissionContain(ContentSource contentSource) {
        this.contentSource = contentSource;
    }

    public String[] getPermissions() {
        return permissions;
    }

    public void setPermissions(String... permissions) {
        this.permissions = permissions;
    }

    public ContentSource getContentSource() {
        return contentSource;
    }

    public void setContentSource(ContentSource contentSource) {
        this.contentSource = contentSource;
    }

    public Action getOnSuccessAction() {
        return onSuccessAction;
    }

    public void setOnSuccessAction(Action onSuccessAction) {
        this.onSuccessAction = onSuccessAction;
    }

    public Action getOnDenialAction() {
        return onDenialAction;
    }

    public void setOnDenialAction(Action onDenialAction) {
        this.onDenialAction = onDenialAction;
    }

    public Action getOnDontShowAction() {
        return onDontShowAction;
    }

    public void setOnDontShowAction(Action onDontShowAction) {
        this.onDontShowAction = onDontShowAction;
    }
}

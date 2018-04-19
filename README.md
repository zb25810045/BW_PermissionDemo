针对不同权限管理开源库进行业务层面的二次封装的练习

原文地址：[简单对权限开源库进行功能性封装](https://www.jianshu.com/p/24df6b089221)

话说相同的开源库总是有一些的，不唯一，权限管理也是如此，我们可以选择 AndPermission，RxPermission 等，那么我们常见的需求出现一个了，未来如何在切换开源库时不影响我们的业务代码吗，要达到一处崔改，处处适用的效果呢

这里就要求我们对这些开源库进行二次封装了，这里我简单的封装了一下，看看 api 
```java
 btn_permission.setOnClickListener(v -> {

            PermissionComponent.with(this)
                    .permissin(Manifest.permission.CAMERA)
                    .onSuccess(() -> show("成功!"))
                    .onDenial(() -> show("失败!"))
                    .onDontShow(() -> {
                        //  打开权限管理页面
                        PermissionComponent.startSettingActivity(MainActivity.this, 200);
                    })
                    .run();
        });
```

支持 activity，fragment，content，这个支持几种需要看我们里买使用的什么开源库了。提供了3个回调，给权限，拒绝权限，不再显示权限弹窗的回调，提供了打开权限设置页的功能。切换底层开源库的方法都懒没写。

代码很简单，就是很繁琐，我简单说一下
![Snip20180420_11.png](https://upload-images.jianshu.io/upload_images/1785445-1e74de849bbdffa8.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

* contentSource 维护不同的上下文类型
* executer 维护的不同的具体的开源库
* action 是针对3种回调的抽象接口
* permissioncontain 保存全部的所需的参数
* PermissionComponent 是暴露给外层使用的工具累
* PermissinManage 是具体的业务实现类

这个例子里面，我只是实现了 AndPermission 的集成，RxPermission 有兴趣的自己去搞搞，原理都是一样的

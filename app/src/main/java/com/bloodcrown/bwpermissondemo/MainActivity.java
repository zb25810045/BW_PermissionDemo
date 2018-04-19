package com.bloodcrown.bwpermissondemo;

import android.Manifest;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.Toast;

import com.bloodcrown.permissioncomponent.PermissionComponent;

public class MainActivity extends AppCompatActivity {

    Button btn_permission;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_permission = findViewById(R.id.btn_perission);
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
    }

    public void show(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}

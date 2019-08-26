package com.zbj.nechajian;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.zbj.pluginlib.PluginManager;
import com.zbj.pluginlib.ProxyActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        startActivity(new Intent(this,aaa.class));
        //通过代理跳转
        PluginManager.getInstance().init(this);
        findViewById(R.id.load).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String apkPath = Utils.copyAssetAndWrite(MainActivity.this, "ne.apk");
                PluginManager.getInstance().loadApk(apkPath);
            }
        });
        findViewById(R.id.gotoa).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(MainActivity.this, ProxyActivity.class);
                intent.putExtra("className", "com.zbj.neplug.PlugActivity");
                startActivity(intent);
            }
        });
    }
}

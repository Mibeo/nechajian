package com.zbj.pluginlib;

import android.app.Activity;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;

/**
 * Created by bingjia.zheng on 2019/8/26.
 */

public class ProxyActivity extends Activity {
    //指定跳转的activity
    private String mClassName;
    private PluginApk mPluginApk;
    private IPlugin mIplgin;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mClassName = getIntent().getStringExtra("className");
        mPluginApk = PluginManager.getInstance().getPluginApk();
        launchPluginActivity();
    }

    private void launchPluginActivity() {
        if (mPluginApk == null) {
            Log.e("错误", "Loading your apk file first please");
        }
        try {
            Class<?> clazz = mPluginApk.mClassLoader.loadClass(mClassName);
            Object object = clazz.newInstance();
            if (object instanceof IPlugin) {
                mIplgin = (IPlugin) object;
                mIplgin.attach(this);
                Bundle bundle = new Bundle();
                bundle.putInt("FROM", IPlugin.FROM_EXTERNAL);
                mIplgin.onCreate(bundle);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public Resources getResources() {
        return mPluginApk != null ? mPluginApk.mResources : super.getResources();
    }

    @Override
    public AssetManager getAssets() {
        return mPluginApk != null ? mPluginApk.mAssetManager : super.getAssets();
    }

    @Override
    public ClassLoader getClassLoader() {
        return mPluginApk != null ? mPluginApk.mClassLoader : super.getClassLoader();
    }
}

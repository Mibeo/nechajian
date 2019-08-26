package com.zbj.pluginlib;

import android.content.pm.PackageInfo;
import android.content.res.AssetManager;
import android.content.res.Resources;

import dalvik.system.DexClassLoader;

/**
 * Created by bingjia.zheng on 2019/8/26.
 */
// 插件apk的实体对象
public class PluginApk {
    public PackageInfo mPackageInfo;
    public DexClassLoader mClassLoader;
    public Resources mResources;
    public AssetManager mAssetManager;

    public PluginApk(PackageInfo mPackageInfo, DexClassLoader mClassLoader,
                     Resources mResources) {
        this.mPackageInfo = mPackageInfo;
        this.mClassLoader = mClassLoader;
        this.mResources = mResources;
        this.mAssetManager = mResources.getAssets();
    }
}

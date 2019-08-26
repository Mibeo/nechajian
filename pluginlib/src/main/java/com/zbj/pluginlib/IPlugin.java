package com.zbj.pluginlib;

import android.app.Activity;
import android.os.Bundle;

/**
 * Created by bingjia.zheng on 2019/8/26.
 */

public interface IPlugin {
    int FROM_INTERNAL = 0;
    int FROM_EXTERNAL = 1;

    void attach(Activity activity);

    void onCreate(Bundle saveInstanceState);

    void onStart();

    void onRestart();

}

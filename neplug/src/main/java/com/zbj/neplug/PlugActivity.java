package com.zbj.neplug;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.zbj.pluginlib.PluginActivity;

public class PlugActivity extends PluginActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plug);
    }
}

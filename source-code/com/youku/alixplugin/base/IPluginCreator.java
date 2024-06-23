package com.youku.alixplugin.base;

import android.view.ViewGroup;
import com.youku.alixplugin.AlixPlayerContext;

/* compiled from: Taobao */
public interface IPluginCreator {
    IPlugin create(AlixPlayerContext alixPlayerContext, PluginConfig pluginConfig, ViewGroup viewGroup);
}

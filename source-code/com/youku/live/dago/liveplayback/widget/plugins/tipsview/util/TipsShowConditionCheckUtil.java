package com.youku.live.dago.liveplayback.widget.plugins.tipsview.util;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.alixplugin.AlixPlayerContext;
import com.youku.live.dago.liveplayback.widget.plugins.tipsview.TipsConfig;
import com.youku.live.dago.liveplayback.widget.plugins.tipsview.tipsconfig.TipsConfigManagerEx;

/* compiled from: Taobao */
public class TipsShowConditionCheckUtil {
    private static transient /* synthetic */ IpChange $ipChange;

    public static boolean canShowTips(AlixPlayerContext alixPlayerContext, TipsConfig tipsConfig) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-792923687")) {
            return TipsConfigManagerEx.canShowTips(alixPlayerContext, tipsConfig);
        }
        return ((Boolean) ipChange.ipc$dispatch("-792923687", new Object[]{alixPlayerContext, tipsConfig})).booleanValue();
    }

    public static void recordTipsHasShown(AlixPlayerContext alixPlayerContext, TipsConfig tipsConfig) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1833601832")) {
            ipChange.ipc$dispatch("-1833601832", new Object[]{alixPlayerContext, tipsConfig});
            return;
        }
        TipsConfigManagerEx.recordTipsHasShown(alixPlayerContext, tipsConfig);
    }

    public static void updateRemoteConfig(TipsConfig tipsConfig) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1094811474")) {
            ipChange.ipc$dispatch("1094811474", new Object[]{tipsConfig});
            return;
        }
        TipsConfigManagerEx.updateRemoteConfig(tipsConfig);
    }
}

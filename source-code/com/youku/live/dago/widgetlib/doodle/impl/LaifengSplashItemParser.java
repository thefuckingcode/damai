package com.youku.live.dago.widgetlib.doodle.impl;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.live.dago.widgetlib.doodle.SplashItemParser;
import com.youku.live.dago.widgetlib.doodle.SplashScheduler;
import java.util.ArrayList;
import java.util.List;
import mtopsdk.common.util.SymbolExpUtil;

/* compiled from: Taobao */
public class LaifengSplashItemParser implements SplashItemParser<String, String> {
    private static transient /* synthetic */ IpChange $ipChange;
    private static LaifengSplashItemParser sInstance;

    private LaifengSplashItemParser() {
    }

    public static SplashItemParser<String, String> getInstance() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "368888714")) {
            return (SplashItemParser) ipChange.ipc$dispatch("368888714", new Object[0]);
        }
        if (sInstance == null) {
            synchronized (LaifengSplashItemParser.class) {
                if (sInstance == null) {
                    sInstance = new LaifengSplashItemParser();
                }
            }
        }
        return sInstance;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.util.List] */
    @Override // com.youku.live.dago.widgetlib.doodle.SplashItemParser
    @Nullable
    public /* bridge */ /* synthetic */ List parse(@NonNull String str, List list) {
        return parse(str, (List<SplashScheduler.SplashItem>) list);
    }

    @Nullable
    public List<SplashScheduler.SplashItem> parse(String str) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1894462470")) {
            return parse(str, (List<SplashScheduler.SplashItem>) new ArrayList());
        }
        return (List) ipChange.ipc$dispatch("1894462470", new Object[]{this, str});
    }

    @Nullable
    public int[] parseCanvasSize(@NonNull String str) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1354387516")) {
            return parseCanvasSize(str, new int[2]);
        }
        return (int[]) ipChange.ipc$dispatch("1354387516", new Object[]{this, str});
    }

    @Nullable
    public List<SplashScheduler.SplashItem> parse(@NonNull String str, List<SplashScheduler.SplashItem> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "230664437")) {
            return (List) ipChange.ipc$dispatch("230664437", new Object[]{this, str, list});
        }
        list.clear();
        String[] split = str.split(SymbolExpUtil.SYMBOL_VERTICALBAR);
        if (split.length > 0) {
            for (String str2 : split) {
                String[] split2 = str2.split(",");
                SplashScheduler.SplashItem splashItem = new SplashScheduler.SplashItem();
                splashItem.x = (float) ((int) Float.parseFloat(split2[0]));
                splashItem.y = (float) ((int) Float.parseFloat(split2[1]));
                SplashScheduler.IconItem iconItem = new SplashScheduler.IconItem();
                splashItem.iconItem = iconItem;
                iconItem.stringId = split2[2];
                iconItem.iconIdentity = split2[2].hashCode();
                list.add(splashItem);
            }
        }
        return list;
    }

    @Nullable
    public int[] parseCanvasSize(@NonNull String str, int[] iArr) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "236924142")) {
            return (int[]) ipChange.ipc$dispatch("236924142", new Object[]{this, str, iArr});
        } else if (iArr.length >= 2) {
            String[] split = str.split("\\*");
            iArr[0] = (int) Float.parseFloat(split[0]);
            iArr[1] = (int) Float.parseFloat(split[1]);
            return iArr;
        } else {
            throw new IllegalArgumentException("size length must larger than 2");
        }
    }
}

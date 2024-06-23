package com.youku.live.dsl.danmaku.youku;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.danmaku.engine.danmaku.model.android.Danmakus;
import com.youku.danmaku.engine.danmaku.parser.BaseDanmakuParser;

/* compiled from: Taobao */
public class DanmakuParser extends BaseDanmakuParser {
    private static transient /* synthetic */ IpChange $ipChange;

    /* access modifiers changed from: protected */
    @Override // com.youku.danmaku.engine.danmaku.parser.BaseDanmakuParser
    public Danmakus parse() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1209244759")) {
            return new Danmakus();
        }
        return (Danmakus) ipChange.ipc$dispatch("-1209244759", new Object[]{this});
    }
}

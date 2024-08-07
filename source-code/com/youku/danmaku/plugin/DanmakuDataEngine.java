package com.youku.danmaku.plugin;

import com.youku.danmaku.engine.controller.IDanmakuView;
import com.youku.danmaku.engine.danmaku.model.BaseDanmaku;
import com.youku.danmaku.engine.danmaku.util.Log;
import com.youku.danmaku.plugin.IDanmakuDataPlugin;
import java.util.List;
import java.util.Map;

/* compiled from: Taobao */
public class DanmakuDataEngine {
    private IDanmakuDataPlugin mDanmakuDataPlugin;
    private IDanmakuView mDanmakuView;
    private long mRequestId = 0;

    public DanmakuDataEngine() {
    }

    public void registerPlugin(IDanmakuDataPlugin iDanmakuDataPlugin) {
        this.mDanmakuDataPlugin = iDanmakuDataPlugin;
    }

    public void release() {
        this.mDanmakuView = null;
        this.mDanmakuDataPlugin = null;
    }

    public void triggerFetchDataWithParams(Map<String, Object> map) {
        IDanmakuDataPlugin iDanmakuDataPlugin = this.mDanmakuDataPlugin;
        if (iDanmakuDataPlugin != null) {
            long j = this.mRequestId + 1;
            this.mRequestId = j;
            iDanmakuDataPlugin.triggerFetchDataWithParams(map, j, new IDanmakuDataPlugin.DanmakuDataCallback() {
                /* class com.youku.danmaku.plugin.DanmakuDataEngine.AnonymousClass1 */

                @Override // com.youku.danmaku.plugin.IDanmakuDataPlugin.DanmakuDataCallback
                public void onGetDanmakuList(long j, List<BaseDanmaku> list) {
                    String str;
                    if (DanmakuDataEngine.this.mRequestId == j && list != null && list.size() > 0) {
                        if (Log.isDebug()) {
                            BaseDanmaku baseDanmaku = list.get(0);
                            if (baseDanmaku != null) {
                                str = baseDanmaku.minute + ":" + baseDanmaku.second;
                            } else {
                                str = "";
                            }
                            Log.d("DanmakuDataEngine add danmakuList=" + list.size() + ", time=" + str);
                        }
                        if (DanmakuDataEngine.this.mDanmakuView != null) {
                            DanmakuDataEngine.this.mDanmakuView.addDanmakuList(list);
                        }
                    }
                }
            });
        }
    }

    public DanmakuDataEngine(IDanmakuView iDanmakuView) {
        this.mDanmakuView = iDanmakuView;
    }
}

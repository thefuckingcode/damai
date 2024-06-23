package com.youku.danmaku.engine.danmaku.renderer.android;

import android.text.TextUtils;
import com.youku.danmaku.engine.danmaku.model.BaseDanmaku;
import com.youku.danmaku.engine.danmaku.model.IDisplayer;
import com.youku.danmaku.engine.danmaku.model.danmaku.R2LDanmaku;
import com.youku.danmaku.plugin.IDanmakuLayoutPlugin;
import com.youku.danmaku.plugin.IDanmakuSettingPlugin;
import org.apache.commons.lang3.StringUtils;

/* compiled from: Taobao */
public class DanmakusRetainer {
    private IDanmakusRetainer fbdrInstance = null;
    private IDanmakusRetainer ftdrInstance = null;
    private IDanmakusRetainer lrdrInstance = null;
    private IDanmakuLayoutPlugin mDanmakuLayoutPlugin;
    private IDanmakuSettingPlugin mDanmakuSettingPlugin;
    private IDanmakusRetainer rldrInstance = null;

    /* compiled from: Taobao */
    static class FixResult {
        boolean mIsOutOfVerticalEdge = true;
        int mLine = 0;
        float mTopPos = 0.0f;
        boolean mWillHit = false;
        boolean shown = false;

        FixResult() {
        }
    }

    /* compiled from: Taobao */
    public interface IDanmakusRetainer {
        void clear();

        void fix(BaseDanmaku baseDanmaku, IDisplayer iDisplayer, Verifier verifier);
    }

    /* compiled from: Taobao */
    public static class RetainerState {
        BaseDanmaku firstItem = null;
        BaseDanmaku insertItem = null;
        BaseDanmaku lastItem = null;
        public int lines = 0;
        BaseDanmaku minBotttom = null;
        BaseDanmaku minRightRow = null;
        boolean overwriteInsert = false;
        BaseDanmaku removeItem = null;
        boolean shown = false;
        boolean willHit = false;

        public String log() {
            StringBuilder sb = new StringBuilder();
            sb.append(StringUtils.LF);
            sb.append("lines:");
            sb.append(this.lines);
            sb.append(StringUtils.LF);
            sb.append("overwriteInsert:");
            sb.append(this.overwriteInsert);
            sb.append(StringUtils.LF);
            sb.append("shown:");
            sb.append(this.shown);
            sb.append(StringUtils.LF);
            sb.append("willHit:");
            sb.append(this.willHit);
            sb.append(StringUtils.LF);
            BaseDanmaku baseDanmaku = this.insertItem;
            if (baseDanmaku == null || TextUtils.isEmpty(baseDanmaku.text)) {
                sb.append("insertItem:");
                sb.append("null");
                sb.append(StringUtils.LF);
            } else {
                sb.append("insertItem:");
                sb.append(this.insertItem.text);
                sb.append(StringUtils.LF);
            }
            BaseDanmaku baseDanmaku2 = this.firstItem;
            if (baseDanmaku2 == null || TextUtils.isEmpty(baseDanmaku2.text)) {
                sb.append("firstItem:");
                sb.append("null");
                sb.append(StringUtils.LF);
            } else {
                sb.append("firstItem:");
                sb.append(this.firstItem.text);
                sb.append(StringUtils.LF);
            }
            BaseDanmaku baseDanmaku3 = this.lastItem;
            if (baseDanmaku3 == null || TextUtils.isEmpty(baseDanmaku3.text)) {
                sb.append("lastItem:");
                sb.append("null");
                sb.append(StringUtils.LF);
            } else {
                sb.append("lastItem:");
                sb.append(this.lastItem.text);
                sb.append(StringUtils.LF);
            }
            BaseDanmaku baseDanmaku4 = this.minRightRow;
            if (baseDanmaku4 == null || TextUtils.isEmpty(baseDanmaku4.text)) {
                sb.append("minRightRow:");
                sb.append("null");
                sb.append(StringUtils.LF);
            } else {
                sb.append("minRightRow:");
                sb.append(this.minRightRow.text);
                sb.append(StringUtils.LF);
            }
            return sb.toString();
        }
    }

    /* compiled from: Taobao */
    public interface Verifier {
        boolean skipLayout(BaseDanmaku baseDanmaku, float f, int i, boolean z);
    }

    DanmakusRetainer(IDanmakuLayoutPlugin iDanmakuLayoutPlugin, IDanmakuSettingPlugin iDanmakuSettingPlugin) {
        this.mDanmakuLayoutPlugin = iDanmakuLayoutPlugin;
        this.mDanmakuSettingPlugin = iDanmakuSettingPlugin;
        if (iDanmakuSettingPlugin == null || !iDanmakuSettingPlugin.isNewTypesetting()) {
            IDanmakuSettingPlugin iDanmakuSettingPlugin2 = this.mDanmakuSettingPlugin;
            if (iDanmakuSettingPlugin2 == null || !iDanmakuSettingPlugin2.isNewCompose()) {
                this.rldrInstance = new RLDanmakusRetainer();
            } else {
                this.rldrInstance = new RLDanmakusLineRetainer(this.mDanmakuSettingPlugin);
            }
        } else {
            this.rldrInstance = new RLDanmakusNewRetainer(this.mDanmakuSettingPlugin);
        }
        if (this.lrdrInstance == null) {
            this.lrdrInstance = new RLDanmakusRetainer();
        }
        if (this.ftdrInstance == null) {
            this.ftdrInstance = new FTDanmakusRetainer();
        }
        if (this.fbdrInstance == null) {
            this.fbdrInstance = new FBDanmakusRetainer();
        }
    }

    /* access modifiers changed from: package-private */
    public void changeSpeed(float f, float f2) {
        IDanmakusRetainer iDanmakusRetainer = this.rldrInstance;
        if (iDanmakusRetainer instanceof RLDanmakusNewRetainer) {
            ((RLDanmakusNewRetainer) iDanmakusRetainer).changeSpeed(f, f2);
        } else if (iDanmakusRetainer instanceof RLDanmakusLineRetainer) {
            ((RLDanmakusLineRetainer) iDanmakusRetainer).changeSpeed(f, f2);
        }
    }

    public void clear() {
        IDanmakusRetainer iDanmakusRetainer = this.rldrInstance;
        if (iDanmakusRetainer != null) {
            iDanmakusRetainer.clear();
        }
        IDanmakusRetainer iDanmakusRetainer2 = this.lrdrInstance;
        if (iDanmakusRetainer2 != null) {
            iDanmakusRetainer2.clear();
        }
        IDanmakusRetainer iDanmakusRetainer3 = this.ftdrInstance;
        if (iDanmakusRetainer3 != null) {
            iDanmakusRetainer3.clear();
        }
        IDanmakusRetainer iDanmakusRetainer4 = this.fbdrInstance;
        if (iDanmakusRetainer4 != null) {
            iDanmakusRetainer4.clear();
        }
        IDanmakuLayoutPlugin iDanmakuLayoutPlugin = this.mDanmakuLayoutPlugin;
        if (iDanmakuLayoutPlugin != null) {
            iDanmakuLayoutPlugin.clear();
        }
    }

    /* access modifiers changed from: package-private */
    public void fix(BaseDanmaku baseDanmaku, IDisplayer iDisplayer, Verifier verifier) {
        int type = baseDanmaku.getType();
        IDanmakuLayoutPlugin iDanmakuLayoutPlugin = this.mDanmakuLayoutPlugin;
        IDanmakusRetainer danmakuLayout = iDanmakuLayoutPlugin != null ? iDanmakuLayoutPlugin.getDanmakuLayout(baseDanmaku) : null;
        if (danmakuLayout != null) {
            danmakuLayout.fix(baseDanmaku, iDisplayer, verifier);
        } else if (type == 1) {
            this.rldrInstance.fix(baseDanmaku, iDisplayer, verifier);
        } else if (type == 4) {
            this.fbdrInstance.fix(baseDanmaku, iDisplayer, verifier);
        } else if (type == 5) {
            this.ftdrInstance.fix(baseDanmaku, iDisplayer, verifier);
        } else if (type == 6) {
            this.lrdrInstance.fix(baseDanmaku, iDisplayer, verifier);
        } else if (type == 7) {
            baseDanmaku.layout(iDisplayer, 0.0f, 0.0f);
        }
    }

    public void release() {
        clear();
    }

    /* access modifiers changed from: package-private */
    public void showVisibleDanmakuLog() {
        IDanmakusRetainer iDanmakusRetainer = this.rldrInstance;
        if (iDanmakusRetainer instanceof RLDanmakusNewRetainer) {
            ((RLDanmakusNewRetainer) iDanmakusRetainer).showVisibleDanmakuLog();
        } else if (iDanmakusRetainer instanceof RLDanmakusLineRetainer) {
            ((RLDanmakusLineRetainer) iDanmakusRetainer).showVisibleDanmakuLog();
        }
    }

    /* access modifiers changed from: package-private */
    public void changeSpeed(R2LDanmaku r2LDanmaku) {
        IDanmakusRetainer iDanmakusRetainer = this.rldrInstance;
        if (iDanmakusRetainer instanceof RLDanmakusNewRetainer) {
            ((RLDanmakusNewRetainer) iDanmakusRetainer).changeSpeed(r2LDanmaku);
        } else if (iDanmakusRetainer instanceof RLDanmakusLineRetainer) {
            ((RLDanmakusLineRetainer) iDanmakusRetainer).changeSpeed(r2LDanmaku);
        }
    }
}

package com.youku.live.dago.liveplayback.widget.plugins.toptip;

import android.view.View;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.live.dago.liveplayback.widget.plugins.tipsview.TipsConfig;
import tb.jl1;

/* compiled from: Taobao */
public class TopTipInfo {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static final String TAG = "TopTipInfo";
    public boolean anim = true;
    public String backImgUrl = null;
    public DismissCallback dismissCallback = null;
    public String featureId;
    public int frequency;
    public TipsConfig.FrequencyType frequencyType;
    public boolean isNextSticky = false;
    public boolean isSticky = false;
    public long lastCancelTime = -1;
    public long lastShowTime = -1;
    public int leftVipIconRes = -1;
    public String leftVipIconUrl = null;
    public int level = -1;
    public boolean needFullScreen = false;
    public View.OnClickListener onClickListener;
    public String playIdUsingFrequency;
    public boolean quickDismiss = false;
    public int rightIconRes = -1;
    public int showCount = 0;
    public int style;
    public CharSequence text;
    public int textSize = -1;
    public int time = 0;
    public String tipName;
    public int tipSeq = -1;
    public int tipType = 1000;

    /* compiled from: Taobao */
    public interface DismissCallback {
        void onDismiss();
    }

    public TopTipInfo() {
    }

    public String toString() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1142116449")) {
            return (String) ipChange.ipc$dispatch("-1142116449", new Object[]{this});
        }
        return "TopTipInfo() called with: tipName = [" + this.tipName + "], style = [" + this.style + "], time = [" + this.time + "], text = [" + ((Object) this.text) + "], rightIconRes = [" + this.rightIconRes + jl1.ARRAY_END_STR + ", level = [" + this.level + jl1.ARRAY_END_STR + "， isSticky = [" + this.isSticky + "], isNextSticky = [" + this.isNextSticky + "], lastShowTime = [" + this.lastShowTime + jl1.ARRAY_END_STR + ", lastCancelTime = [" + this.lastCancelTime + "], showCount = [" + this.showCount + "], quickDismiss = [" + this.quickDismiss + "], tipSeq=[" + this.tipSeq + "], leftIconUrl = [" + this.leftVipIconUrl + jl1.ARRAY_END_STR;
    }

    public TopTipInfo(String str, int i, CharSequence charSequence) {
        this.tipName = str;
        this.style = i;
        this.text = charSequence;
    }

    public TopTipInfo(String str, int i, int i2, CharSequence charSequence) {
        this.tipName = str;
        this.style = i;
        this.time = i2;
        this.text = charSequence;
    }

    public TopTipInfo(String str, int i, CharSequence charSequence, View.OnClickListener onClickListener2) {
        this.tipName = str;
        this.style = i;
        this.text = this.text;
        this.onClickListener = onClickListener2;
    }
}

package com.youku.alixplayer.opensdk.statistics.track.business;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/* compiled from: Taobao */
public class HeartBeatHelper {
    public static final String TAG = "HeartBeatHelper";
    private int delayTime = 1000;
    private Runnable liveTime;
    private long liveTimeCount = 0;
    private Map<String, String> mArgs = new LinkedHashMap<String, String>() {
        /* class com.youku.alixplayer.opensdk.statistics.track.business.HeartBeatHelper.AnonymousClass1 */

        {
            put("background_mode", "0");
        }
    };
    private Map<String, String> mBasicArgs;
    private OnBusinessTrackListener mBusinessTrackListener;
    private Context mContext;
    private long mDelay;
    private Handler mHandler;
    private String mLiveId;
    private SeiDelay mSeiDelay = new SeiDelay();

    public HeartBeatHelper(Context context, String str, String str2, Map<String, String> map) {
        this.mContext = context;
        this.mLiveId = str;
        this.mHandler = new Handler(Looper.getMainLooper());
        this.mBasicArgs = map;
    }

    static /* synthetic */ long access$108(HeartBeatHelper heartBeatHelper) {
        long j = heartBeatHelper.liveTimeCount;
        heartBeatHelper.liveTimeCount = 1 + j;
        return j;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void analyticsPlayHeart(long j) {
        HashMap hashMap = new HashMap();
        int i = ((j % 20) > 0 ? 1 : ((j % 20) == 0 ? 0 : -1));
        long j2 = i == 0 ? 20 : j;
        StringBuilder sb = new StringBuilder();
        sb.append(i == 0 ? 20 : j);
        sb.append("");
        hashMap.put("heartInterval", sb.toString());
        long j3 = 2;
        if (j == 5) {
            j3 = 1;
        } else if (j != 10) {
            j3 = i == 0 ? 2 + (j / 20) : 0;
        }
        hashMap.put("lognum", j3 + "");
        hashMap.put("view", "onlineEducation");
        Map<String, String> map = this.mBasicArgs;
        if (map != null) {
            hashMap.putAll(map);
        }
        Map<String, String> map2 = this.mArgs;
        if (map2 != null) {
            hashMap.putAll(map2);
        }
        long j4 = this.mDelay;
        if (j4 != 0) {
            hashMap.put("delay", String.valueOf(j4));
        }
        if (this.mSeiDelay.mDelay != 0) {
            hashMap.put("seiDelay", this.mSeiDelay.mDelay + "");
            hashMap.put("seiNtpOffset", this.mSeiDelay.ntpOffset + "");
            hashMap.put("seiLocalTs", this.mSeiDelay.localTimestamp);
            hashMap.put("seiTs", this.mSeiDelay.seiTimestamp);
        }
        Log.i("BusinessReport", toString() + " report 12030 : liveId=" + this.mLiveId + " mDelay=" + this.mDelay + " seiDelay=" + this.mSeiDelay.mDelay + " seiNtpOffset=" + this.mSeiDelay.ntpOffset + " seiTs=" + this.mSeiDelay.seiTimestamp + " seiLocalTs=" + this.mSeiDelay.localTimestamp);
        if (this.mBusinessTrackListener != null) {
            hashMap.put("heartInterval", j2 + "");
            this.mBusinessTrackListener.onMonitorPoint(null, "12030", hashMap);
        }
        this.mSeiDelay.reset();
    }

    private void initHeartBeat() {
        this.mHandler = new Handler(Looper.getMainLooper());
        this.liveTimeCount = 0;
        this.liveTime = new Runnable() {
            /* class com.youku.alixplayer.opensdk.statistics.track.business.HeartBeatHelper.AnonymousClass2 */

            public void run() {
                HeartBeatHelper heartBeatHelper = HeartBeatHelper.this;
                heartBeatHelper.removeHandler(heartBeatHelper.liveTime);
                HeartBeatHelper.access$108(HeartBeatHelper.this);
                if (HeartBeatHelper.this.liveTimeCount == 5 || HeartBeatHelper.this.liveTimeCount == 10 || (HeartBeatHelper.this.liveTimeCount >= 20 && HeartBeatHelper.this.liveTimeCount % 20 == 0)) {
                    HeartBeatHelper heartBeatHelper2 = HeartBeatHelper.this;
                    heartBeatHelper2.analyticsPlayHeart(heartBeatHelper2.liveTimeCount);
                }
                HeartBeatHelper heartBeatHelper3 = HeartBeatHelper.this;
                heartBeatHelper3.postHandler(heartBeatHelper3.delayTime, HeartBeatHelper.this.liveTime);
            }
        };
    }

    public void postHandler(int i, Runnable runnable) {
        Handler handler = this.mHandler;
        if (handler != null) {
            handler.postDelayed(runnable, (long) i);
        }
    }

    public void put(String str, String str2) {
        if (!TextUtils.isEmpty(str2) && !"-1".equals(str2)) {
            this.mArgs.put(str, str2);
        }
    }

    public void removeHandler(Runnable runnable) {
        Handler handler = this.mHandler;
        if (handler != null) {
            handler.removeCallbacks(runnable);
        }
    }

    public void setBusinessTrackListener(OnBusinessTrackListener onBusinessTrackListener) {
        this.mBusinessTrackListener = onBusinessTrackListener;
    }

    public void setDelay(long j) {
        this.mDelay = j;
    }

    public void setSeiDelay(SeiDelay seiDelay) {
        this.mSeiDelay = seiDelay;
    }

    public void startTime() {
        initHeartBeat();
        postHandler(this.delayTime, this.liveTime);
    }

    public void stopTime() {
        Handler handler = this.mHandler;
        if (handler != null) {
            handler.removeCallbacks(this.liveTime);
            this.mHandler.removeCallbacksAndMessages(null);
            this.mHandler = null;
        }
    }
}

package cn.damai.player;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import cn.damai.common.user.c;
import cn.damai.common.util.ToastUtil;
import cn.damai.commonbusiness.imagebrowse.bean.VideoInfo;
import cn.damai.network.NetworkType;
import cn.damai.player.base.DMBaseVideoController;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.playerservice.axp.playinfo.PlayInfoResult;
import com.youku.youkuplayer.YKEventListener;
import java.util.HashMap;
import tb.bs;
import tb.d20;
import tb.g91;
import tb.s41;
import tb.xh1;
import tb.yz2;

/* compiled from: Taobao */
public class PlayerEventListener extends YKEventListener {
    private static transient /* synthetic */ IpChange $ipChange;
    volatile DMBaseVideoController a;
    volatile bs b;
    volatile Context c;
    private int d = 0;
    private String e;
    private String f;
    private OnRealVideoStartListener g;
    long h;
    String i;

    /* compiled from: Taobao */
    public interface OnRealVideoStartListener {
        void getVideoSize(int i, int i2);
    }

    public PlayerEventListener(DMBaseVideoController dMBaseVideoController, bs bsVar, Context context) {
        this.a = dMBaseVideoController;
        this.b = bsVar;
        this.c = context;
        this.e = dMBaseVideoController.getSpmB();
        this.f = dMBaseVideoController.getSpmC() == null ? "" : dMBaseVideoController.getSpmC();
    }

    private void d(String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1734293558")) {
            ipChange.ipc$dispatch("1734293558", new Object[]{this, str, str2});
            return;
        }
        String str3 = null;
        if (this.b != null && this.a != null) {
            if (this.b.e() != null) {
                str3 = s41.e(this.b.e());
            }
            String str4 = this.a.getClass().getName() + "_errorCode=" + str2 + "_errorMsg=" + str + "_videoData=" + str3;
            yz2.a(yz2.i("播放器播放错误", this.a.getClass().getName(), str2, str, str4), "-600", str4);
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void f(VideoInfo videoInfo, long j, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1080390588")) {
            ipChange.ipc$dispatch("-1080390588", new Object[]{this, videoInfo, Long.valueOf(j), str});
        } else if (videoInfo != null) {
            HashMap hashMap = new HashMap();
            hashMap.put("usercode", d20.E());
            if (videoInfo.getProjectInfo() != null) {
                hashMap.put("item_id", videoInfo.getProjectInfo().id);
            }
            hashMap.put("videoId", videoInfo.getValidId());
            hashMap.put("videoTitle", videoInfo.getTitle());
            hashMap.put("duration", j + "");
            hashMap.put("spm-url", "a2o4t." + this.e + "." + this.f + "." + "playend");
            if (!TextUtils.isEmpty(str)) {
                hashMap.put("play_session_id", str);
            }
            c e2 = c.e();
            String str2 = this.e;
            e2.D(str2, "page_" + this.e + "_playend", "playend", "", hashMap, 12003);
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void g(VideoInfo videoInfo) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2049268387")) {
            ipChange.ipc$dispatch("2049268387", new Object[]{this, videoInfo});
        } else if (videoInfo != null) {
            HashMap hashMap = new HashMap();
            hashMap.put("usercode", d20.E());
            if (videoInfo.getProjectInfo() != null) {
                hashMap.put("item_id", videoInfo.getProjectInfo().id);
            }
            hashMap.put("videoId", videoInfo.getValidId());
            hashMap.put("videoTitle", videoInfo.getTitle());
            if (this.c != null) {
                hashMap.put("is_auto_play", xh1.b(this.c) == NetworkType.NETWORK_WIFI ? "1" : "0");
            }
            hashMap.put("spm-url", "a2o4t." + this.e + "." + this.f + "." + "playstart");
            if (!(this.b == null || this.b.b() == null)) {
                hashMap.put("play_session_id", this.b.b().getSessionId());
            }
            c e2 = c.e();
            String str = this.e;
            e2.D(str, "page_" + this.e + "_playstart", "playstart", "", hashMap, 12002);
        }
    }

    private void i(int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2071816186")) {
            ipChange.ipc$dispatch("-2071816186", new Object[]{this, Integer.valueOf(i2)});
            return;
        }
        j(null, i2);
    }

    private void j(final Object obj, final int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1537439510")) {
            ipChange.ipc$dispatch("-1537439510", new Object[]{this, obj, Integer.valueOf(i2)});
            return;
        }
        if (i2 != 6) {
            g91.c("PlayerEventListener", "currentState: " + i2);
        }
        Context context = this.c;
        if (context instanceof Activity) {
            Activity activity = (Activity) context;
            if (i2 != 6) {
                g91.c("PlayerEventListener", "mContext currentState: " + i2);
            }
            activity.runOnUiThread(new Runnable() {
                /* class cn.damai.player.PlayerEventListener.AnonymousClass2 */
                private static transient /* synthetic */ IpChange $ipChange;

                public void run() {
                    IpChange ipChange = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange, "-44097574")) {
                        ipChange.ipc$dispatch("-44097574", new Object[]{this});
                        return;
                    }
                    if (i2 != 6) {
                        g91.c("PlayerEventListener", "run currentState: " + i2);
                    }
                    if (PlayerEventListener.this.a != null) {
                        PlayerEventListener.this.a.onPlayStateChanged(i2, obj);
                    }
                }
            });
        } else if (i2 != 6) {
            g91.c("PlayerEventListener", "context currentState: null" + i2);
            release();
        }
        bs bsVar = this.b;
        if (i2 != 6 && bsVar != null && bsVar.c() != null) {
            bsVar.c().f(i2);
        }
    }

    public int e() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "533411512")) {
            return this.d;
        }
        return ((Integer) ipChange.ipc$dispatch("533411512", new Object[]{this})).intValue();
    }

    public void h(OnRealVideoStartListener onRealVideoStartListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "79610214")) {
            ipChange.ipc$dispatch("79610214", new Object[]{this, onRealVideoStartListener});
            return;
        }
        this.g = onRealVideoStartListener;
    }

    @Override // com.youku.youkuplayer.IPlayerEventListener, com.youku.youkuplayer.YKEventListener
    public void onComplete() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2088454561")) {
            ipChange.ipc$dispatch("-2088454561", new Object[]{this});
            return;
        }
        super.onComplete();
        this.d = 7;
        i(7);
        if (this.a != null && this.a.isAutoReport() && this.b != null) {
            f(this.b.e(), System.currentTimeMillis() - this.h, this.i);
            this.b.g(null);
        }
    }

    @Override // com.youku.youkuplayer.IPlayerEventListener, com.youku.youkuplayer.YKEventListener
    public void onDataFail(int i2, String str, Object obj) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1824136025")) {
            ipChange.ipc$dispatch("1824136025", new Object[]{this, Integer.valueOf(i2), str, obj});
            return;
        }
        super.onDataFail(i2, str, obj);
        this.d = 9;
        s41.e(obj);
        d(str + "_ext" + s41.e(obj) + "_DM_PLAYER_GET_VIDEO_INFO_FAILED", i2 + "");
        i(9);
    }

    @Override // com.youku.youkuplayer.IPlayerEventListener, com.youku.youkuplayer.YKEventListener
    public void onDataReady(PlayInfoResult playInfoResult) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "87409569")) {
            ipChange.ipc$dispatch("87409569", new Object[]{this, playInfoResult});
            return;
        }
        super.onDataReady(playInfoResult);
        this.d = 10;
        i(10);
    }

    @Override // com.youku.youkuplayer.IPlayerEventListener, com.youku.youkuplayer.YKEventListener
    public void onEndLoading() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-841675273")) {
            ipChange.ipc$dispatch("-841675273", new Object[]{this});
            return;
        }
        super.onEndLoading();
        this.d = 13;
        i(13);
    }

    @Override // com.youku.youkuplayer.IPlayerEventListener, com.youku.youkuplayer.YKEventListener
    public void onError(int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "334539705")) {
            ipChange.ipc$dispatch("334539705", new Object[]{this, Integer.valueOf(i2)});
            return;
        }
        super.onError(i2);
        this.d = 8;
        d("DM_PLAYER_ERROR", i2 + "");
        if (i2 == 15301) {
            ToastUtil.b("          暂不支持\n此视频格式的预览哦~", 1000);
            yz2.g("IssueFragment:jsondata={HavanaId:" + d20.i() + ",videoPath:" + this.b.e().getVideoUrl() + "}", "-602", "播放器不识别的视频格式");
        }
        i(8);
    }

    @Override // com.youku.youkuplayer.IPlayerEventListener, com.youku.youkuplayer.YKEventListener
    public void onNewRequest() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-502479287")) {
            ipChange.ipc$dispatch("-502479287", new Object[]{this});
            return;
        }
        super.onNewRequest();
        this.d = 1;
        i(1);
    }

    @Override // com.youku.youkuplayer.IPlayerEventListener, com.youku.youkuplayer.YKEventListener
    public void onPause() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "304010716")) {
            ipChange.ipc$dispatch("304010716", new Object[]{this});
            return;
        }
        super.onPause();
        int i2 = this.d;
        if (i2 != 4 && i2 != 7) {
            this.d = 4;
            i(4);
            if (this.a != null && this.a.isAutoReport() && this.b != null) {
                f(this.b.e(), System.currentTimeMillis() - this.h, this.i);
                if (this.b != null) {
                    this.b.g(null);
                }
            }
        }
    }

    @Override // com.youku.youkuplayer.IPlayerEventListener, com.youku.youkuplayer.YKEventListener
    public void onPositionChange(int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1201093692")) {
            ipChange.ipc$dispatch("-1201093692", new Object[]{this, Integer.valueOf(i2)});
            return;
        }
        super.onPositionChange(i2);
        this.d = 6;
        j(Integer.valueOf(i2), 6);
    }

    @Override // com.youku.youkuplayer.IPlayerEventListener, com.youku.youkuplayer.YKEventListener
    public void onRealVideoStart() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1497940749")) {
            ipChange.ipc$dispatch("-1497940749", new Object[]{this});
            return;
        }
        super.onRealVideoStart();
        this.d = 5;
        i(5);
        if (this.b != null) {
            ((Activity) this.c).runOnUiThread(new Runnable() {
                /* class cn.damai.player.PlayerEventListener.AnonymousClass1 */
                private static transient /* synthetic */ IpChange $ipChange;

                public void run() {
                    IpChange ipChange = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange, "152415931")) {
                        ipChange.ipc$dispatch("152415931", new Object[]{this});
                    } else if (PlayerEventListener.this.b != null) {
                        if (PlayerEventListener.this.b.a() == null) {
                            if (PlayerEventListener.this.g != null) {
                                PlayerEventListener.this.g.getVideoSize(PlayerEventListener.this.b.b().getVideoWidth(), PlayerEventListener.this.b.b().getVideoHeight());
                            }
                            PlayerEventListener.this.h = System.currentTimeMillis();
                            PlayerEventListener playerEventListener = PlayerEventListener.this;
                            playerEventListener.i = playerEventListener.b.b().getSessionId();
                            if (PlayerEventListener.this.a != null && PlayerEventListener.this.a.isAutoReport()) {
                                PlayerEventListener playerEventListener2 = PlayerEventListener.this;
                                playerEventListener2.g(playerEventListener2.b.e());
                            }
                        } else if (PlayerEventListener.this.a != null && PlayerEventListener.this.a.isAutoReport()) {
                            PlayerEventListener playerEventListener3 = PlayerEventListener.this;
                            VideoInfo a = playerEventListener3.b.a();
                            long currentTimeMillis = System.currentTimeMillis();
                            PlayerEventListener playerEventListener4 = PlayerEventListener.this;
                            playerEventListener3.f(a, currentTimeMillis - playerEventListener4.h, playerEventListener4.i);
                            PlayerEventListener.this.b.g(null);
                            PlayerEventListener playerEventListener5 = PlayerEventListener.this;
                            playerEventListener5.g(playerEventListener5.b.e());
                            PlayerEventListener.this.h = System.currentTimeMillis();
                            PlayerEventListener playerEventListener6 = PlayerEventListener.this;
                            playerEventListener6.i = playerEventListener6.b.b().getSessionId();
                        }
                        PlayerEventListener.this.b.g(PlayerEventListener.this.b.e());
                    }
                }
            });
        }
    }

    @Override // com.youku.youkuplayer.IPlayerEventListener, com.youku.youkuplayer.YKEventListener
    public void onStart() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "347115504")) {
            ipChange.ipc$dispatch("347115504", new Object[]{this});
            return;
        }
        super.onStart();
        this.d = 5;
        i(5);
    }

    @Override // com.youku.youkuplayer.IPlayerEventListener, com.youku.youkuplayer.YKEventListener
    public void onStartLoading() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "797661182")) {
            ipChange.ipc$dispatch("797661182", new Object[]{this});
            return;
        }
        super.onStartLoading();
        this.d = 12;
        i(12);
    }

    @Override // com.youku.youkuplayer.IPlayerEventListener, com.youku.youkuplayer.YKEventListener
    public void onVideoSizeChanged(int i2, int i3) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "222365856")) {
            ipChange.ipc$dispatch("222365856", new Object[]{this, Integer.valueOf(i2), Integer.valueOf(i3)});
            return;
        }
        super.onVideoSizeChanged(i2, i3);
        i(e());
    }

    public void release() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-961795284")) {
            ipChange.ipc$dispatch("-961795284", new Object[]{this});
            return;
        }
        this.c = null;
        this.a = null;
        this.b = null;
    }
}

package cn.damai.player.video.view;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import cn.damai.common.AppConfig;
import cn.damai.commonbusiness.imagebrowse.bean.VideoInfo;
import cn.damai.player.video.decor.a;
import cn.damai.player.video.listener.VideoEventListener;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.uc.webview.export.media.MessageID;
import com.youku.youkuplayer.YKEventListener;
import tb.s41;
import tb.yz2;

/* compiled from: Taobao */
public class MainThreadVideoListener extends YKEventListener {
    private static transient /* synthetic */ IpChange $ipChange;
    private Handler a = new Handler(Looper.getMainLooper());
    private ApiPlayer b;
    private a c;
    private VideoEventListener d;
    private VideoInfo e;
    private long f;

    public MainThreadVideoListener(ApiPlayer apiPlayer, a aVar) {
        this.b = apiPlayer;
        this.c = aVar;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void f(String str, int i, String str2) {
        String str3;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "912908411")) {
            ipChange.ipc$dispatch("912908411", new Object[]{this, str, Integer.valueOf(i), str2});
            return;
        }
        VideoInfo videoInfo = null;
        try {
            ApiPlayer apiPlayer = this.b;
            if (apiPlayer != null) {
                videoInfo = apiPlayer.getPlayInfo();
            }
            if (videoInfo != null) {
                str3 = s41.e(videoInfo);
            } else {
                str3 = "";
            }
            String str4 = str + "_errorCode=" + i + "_errorMsg=" + str2 + "_videoData=" + str3;
            yz2.a(yz2.i("播放器播放错误", str, i + "", str2, str4), "-601", str4);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void g() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "437848405")) {
            ipChange.ipc$dispatch("437848405", new Object[]{this});
        } else if (this.d != null && this.e != null) {
            this.d.onVideoEnd(this.b, this.e, (int) (System.currentTimeMillis() - this.f));
            this.e = null;
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void h() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-490237522")) {
            ipChange.ipc$dispatch("-490237522", new Object[]{this});
            return;
        }
        VideoInfo playInfo = this.b.getPlayInfo();
        if (this.d != null && playInfo != null) {
            this.e = playInfo;
            this.f = System.currentTimeMillis();
            VideoEventListener videoEventListener = this.d;
            ApiPlayer apiPlayer = this.b;
            videoEventListener.onVideoPlay(apiPlayer, playInfo, apiPlayer.getDuration());
        }
    }

    /* access modifiers changed from: private */
    public static void i(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2022888145")) {
            ipChange.ipc$dispatch("2022888145", new Object[]{str});
        } else if (AppConfig.v()) {
            Log.e("MyVideoView", " thread=" + Thread.currentThread().getName() + " " + str);
        }
    }

    private void runOnUiThread(Runnable runnable) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "855012578")) {
            ipChange.ipc$dispatch("855012578", new Object[]{this, runnable});
        } else if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
            runnable.run();
        } else {
            this.a.post(runnable);
        }
    }

    public void j(VideoEventListener videoEventListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1991255844")) {
            ipChange.ipc$dispatch("1991255844", new Object[]{this, videoEventListener});
            return;
        }
        this.d = videoEventListener;
    }

    @Override // com.youku.youkuplayer.IPlayerEventListener, com.youku.youkuplayer.YKEventListener
    public void onComplete() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2017222662")) {
            ipChange.ipc$dispatch("2017222662", new Object[]{this});
            return;
        }
        runOnUiThread(new Runnable() {
            /* class cn.damai.player.video.view.MainThreadVideoListener.AnonymousClass8 */
            private static transient /* synthetic */ IpChange $ipChange;

            public void run() {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-1941409651")) {
                    ipChange.ipc$dispatch("-1941409651", new Object[]{this});
                    return;
                }
                MainThreadVideoListener.i("onVideoComplete");
                MainThreadVideoListener.this.g();
                MainThreadVideoListener.this.c.d();
            }
        });
    }

    @Override // com.youku.youkuplayer.IPlayerEventListener, com.youku.youkuplayer.YKEventListener
    public void onDataFail(final int i, final String str, Object obj) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-190038510")) {
            ipChange.ipc$dispatch("-190038510", new Object[]{this, Integer.valueOf(i), str, obj});
            return;
        }
        super.onDataFail(i, str, obj);
        runOnUiThread(new Runnable() {
            /* class cn.damai.player.video.view.MainThreadVideoListener.AnonymousClass1 */
            private static transient /* synthetic */ IpChange $ipChange;

            public void run() {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-565815116")) {
                    ipChange.ipc$dispatch("-565815116", new Object[]{this});
                    return;
                }
                MainThreadVideoListener.this.f("直击现场CMS组件onDataFail", i, str);
                MainThreadVideoListener.i("onDataFail");
                MainThreadVideoListener.this.c.f(i, str);
            }
        });
    }

    @Override // com.youku.youkuplayer.IPlayerEventListener, com.youku.youkuplayer.YKEventListener
    public void onEndLoading() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1934158302")) {
            ipChange.ipc$dispatch("1934158302", new Object[]{this});
            return;
        }
        runOnUiThread(new Runnable() {
            /* class cn.damai.player.video.view.MainThreadVideoListener.AnonymousClass7 */
            private static transient /* synthetic */ IpChange $ipChange;

            public void run() {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-1744896146")) {
                    ipChange.ipc$dispatch("-1744896146", new Object[]{this});
                    return;
                }
                MainThreadVideoListener.i("onEndLoading");
                MainThreadVideoListener.this.c.e();
            }
        });
    }

    @Override // com.youku.youkuplayer.IPlayerEventListener, com.youku.youkuplayer.YKEventListener
    public void onError(final int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1040487200")) {
            ipChange.ipc$dispatch("1040487200", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        super.onError(i);
        runOnUiThread(new Runnable() {
            /* class cn.damai.player.video.view.MainThreadVideoListener.AnonymousClass5 */
            private static transient /* synthetic */ IpChange $ipChange;

            public void run() {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-1351869136")) {
                    ipChange.ipc$dispatch("-1351869136", new Object[]{this});
                    return;
                }
                MainThreadVideoListener.this.f("直击现场CMS组件onError", i, "");
            }
        });
    }

    @Override // com.youku.youkuplayer.IPlayerEventListener, com.youku.youkuplayer.YKEventListener
    public void onPause() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1573709205")) {
            ipChange.ipc$dispatch("1573709205", new Object[]{this});
            return;
        }
        runOnUiThread(new Runnable() {
            /* class cn.damai.player.video.view.MainThreadVideoListener.AnonymousClass3 */
            private static transient /* synthetic */ IpChange $ipChange;

            public void run() {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-958842126")) {
                    ipChange.ipc$dispatch("-958842126", new Object[]{this});
                    return;
                }
                MainThreadVideoListener.i(MessageID.onPause);
                MainThreadVideoListener.this.g();
                MainThreadVideoListener.this.c.i();
            }
        });
    }

    @Override // com.youku.youkuplayer.IPlayerEventListener, com.youku.youkuplayer.YKEventListener
    public void onPositionChange(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1034600387")) {
            ipChange.ipc$dispatch("-1034600387", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        super.onPositionChange(i);
    }

    @Override // com.youku.youkuplayer.IPlayerEventListener, com.youku.youkuplayer.YKEventListener
    public void onRealVideoStart() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1971113306")) {
            ipChange.ipc$dispatch("1971113306", new Object[]{this});
            return;
        }
        runOnUiThread(new Runnable() {
            /* class cn.damai.player.video.view.MainThreadVideoListener.AnonymousClass2 */
            private static transient /* synthetic */ IpChange $ipChange;

            public void run() {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-762328621")) {
                    ipChange.ipc$dispatch("-762328621", new Object[]{this});
                    return;
                }
                MainThreadVideoListener.this.h();
                MainThreadVideoListener.i("onVideoStart");
                MainThreadVideoListener.this.c.j();
            }
        });
    }

    @Override // com.youku.youkuplayer.IPlayerEventListener, com.youku.youkuplayer.YKEventListener
    public void onStart() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1616813993")) {
            ipChange.ipc$dispatch("1616813993", new Object[]{this});
            return;
        }
        runOnUiThread(new Runnable() {
            /* class cn.damai.player.video.view.MainThreadVideoListener.AnonymousClass4 */
            private static transient /* synthetic */ IpChange $ipChange;

            public void run() {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-1155355631")) {
                    ipChange.ipc$dispatch("-1155355631", new Object[]{this});
                    return;
                }
                MainThreadVideoListener.i("onStart");
                MainThreadVideoListener.this.h();
                MainThreadVideoListener.this.c.k();
            }
        });
    }

    @Override // com.youku.youkuplayer.IPlayerEventListener, com.youku.youkuplayer.YKEventListener
    public void onStartLoading() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1199035941")) {
            ipChange.ipc$dispatch("1199035941", new Object[]{this});
            return;
        }
        runOnUiThread(new Runnable() {
            /* class cn.damai.player.video.view.MainThreadVideoListener.AnonymousClass6 */
            private static transient /* synthetic */ IpChange $ipChange;

            public void run() {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-1548382641")) {
                    ipChange.ipc$dispatch("-1548382641", new Object[]{this});
                    return;
                }
                MainThreadVideoListener.i("onStartLoading");
                MainThreadVideoListener.this.c.h();
            }
        });
    }
}

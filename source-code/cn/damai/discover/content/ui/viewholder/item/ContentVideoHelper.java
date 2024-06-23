package cn.damai.discover.content.ui.viewholder.item;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.view.View;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import io.flutter.plugins.connectivity.ConnectivityBroadcastReceiver;
import java.lang.ref.WeakReference;
import tb.cs;
import tb.g91;
import tb.yh1;

/* compiled from: Taobao */
public class ContentVideoHelper {
    private static transient /* synthetic */ IpChange $ipChange;
    private ContentVideoView a;
    private Context b;
    private WifiStateChangeReceiver c;
    private boolean d = true;
    private boolean e = false;
    private View.OnAttachStateChangeListener f = new a();

    /* compiled from: Taobao */
    public static class WifiStateChangeReceiver extends BroadcastReceiver {
        private static transient /* synthetic */ IpChange $ipChange;
        WeakReference<ContentVideoView> a;

        WifiStateChangeReceiver(ContentVideoView contentVideoView) {
            if (contentVideoView != null) {
                this.a = new WeakReference<>(contentVideoView);
            }
        }

        public void onReceive(Context context, Intent intent) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "948848315")) {
                ipChange.ipc$dispatch("948848315", new Object[]{this, context, intent});
                return;
            }
            g91.b("ContentVideoHelper", "onReceive/in act:" + intent.getAction());
            if (!yh1.c(context)) {
                g91.b("ContentVideoHelper", "onReceive/in pause");
                try {
                    this.a.get().pausePlayer(false);
                } catch (NullPointerException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /* compiled from: Taobao */
    public class a implements View.OnAttachStateChangeListener {
        private static transient /* synthetic */ IpChange $ipChange;

        a() {
        }

        public void onViewAttachedToWindow(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "364508083")) {
                ipChange.ipc$dispatch("364508083", new Object[]{this, view});
                return;
            }
            g91.b("ContentVideoHelper", "Video.onViewAttachedToWindow auto:" + ContentVideoHelper.this.d + " v:" + view);
            ContentVideoHelper.this.e = true;
            if (ContentVideoHelper.this.d && yh1.c(ContentVideoHelper.this.b)) {
                ContentVideoHelper.this.a.getPlayer().mute(1);
                ContentVideoHelper.this.a.autoPlayMuted();
                ContentVideoHelper contentVideoHelper = ContentVideoHelper.this;
                contentVideoHelper.l(contentVideoHelper.b);
                ContentVideoHelper.this.d = false;
            }
        }

        public void onViewDetachedFromWindow(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1771546768")) {
                ipChange.ipc$dispatch("-1771546768", new Object[]{this, view});
                return;
            }
            g91.b("ContentVideoHelper", "Video.onViewDetachedFromWindow mvi:" + ContentVideoHelper.this.a);
            ContentVideoHelper.this.e = false;
            if (ContentVideoHelper.this.a != null) {
                ContentVideoHelper.this.a.pausePlayer(false);
            }
        }
    }

    public ContentVideoHelper(ContentVideoView contentVideoView) {
        if (contentVideoView != null) {
            this.a = contentVideoView;
            this.b = contentVideoView.getContext();
            this.a.addOnAttachStateChangeListener(this.f);
            return;
        }
        throw new RuntimeException("video view cannot be null");
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void l(Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1501608805")) {
            ipChange.ipc$dispatch("-1501608805", new Object[]{this, context});
        } else if (context != null && this.c == null) {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction(ConnectivityBroadcastReceiver.CONNECTIVITY_ACTION);
            WifiStateChangeReceiver wifiStateChangeReceiver = new WifiStateChangeReceiver(this.a);
            this.c = wifiStateChangeReceiver;
            context.registerReceiver(wifiStateChangeReceiver, intentFilter);
        }
    }

    private void o(Context context) {
        WifiStateChangeReceiver wifiStateChangeReceiver;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1825728098")) {
            ipChange.ipc$dispatch("1825728098", new Object[]{this, context});
        } else if (context != null && (wifiStateChangeReceiver = this.c) != null) {
            context.unregisterReceiver(wifiStateChangeReceiver);
            this.c = null;
        }
    }

    public ContentVideoView g() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-895696499")) {
            return this.a;
        }
        return (ContentVideoView) ipChange.ipc$dispatch("-895696499", new Object[]{this});
    }

    public void h() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-117858695")) {
            ipChange.ipc$dispatch("-117858695", new Object[]{this});
            return;
        }
        g91.b("ContentVideoHelper", "Helper.onActivityDestroy:" + cs.d().b());
        ContentVideoView contentVideoView = this.a;
        if (contentVideoView != null) {
            contentVideoView.releasePlayer();
            this.a = null;
        }
    }

    public void i() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "418365053")) {
            ipChange.ipc$dispatch("418365053", new Object[]{this});
            return;
        }
        g91.b("ContentVideoHelper", "Helper.onActivityPause:" + cs.d().b());
        o(this.b);
        ContentVideoView contentVideoView = this.a;
        if (contentVideoView != null) {
            contentVideoView.pausePlayer(false);
        }
    }

    public void j(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2136290070")) {
            ipChange.ipc$dispatch("-2136290070", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        g91.b("ContentVideoHelper", "Helper.onActivityResume：" + cs.d().b());
        l(this.b);
        if (z && yh1.c(this.b) && this.e) {
            this.a.startPlayer();
        }
    }

    public void k() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1469568978")) {
            ipChange.ipc$dispatch("-1469568978", new Object[]{this});
            return;
        }
        ContentVideoView contentVideoView = this.a;
        if (contentVideoView != null) {
            contentVideoView.pausePlayer(false);
        }
    }

    public void m() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1239766781")) {
            ipChange.ipc$dispatch("-1239766781", new Object[]{this});
            return;
        }
        g91.b("ContentVideoHelper", "resumePlayerOnWifi/in");
        if (this.a != null && yh1.c(this.b)) {
            this.a.startPlayer();
        }
    }

    public void n(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2098297624")) {
            ipChange.ipc$dispatch("2098297624", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        this.d = z;
    }
}

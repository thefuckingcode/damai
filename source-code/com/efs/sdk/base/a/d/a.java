package com.efs.sdk.base.a.d;

import android.content.IntentFilter;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.os.Process;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Pair;
import android.webkit.ValueCallback;
import androidx.annotation.NonNull;
import com.alibaba.security.common.track.model.a;
import com.alibaba.wireless.security.aopsdk.replace.android.os.Build;
import com.alimm.xadsdk.request.builder.IRequestConst;
import com.efs.sdk.base.Constants;
import com.efs.sdk.base.EfsReporter;
import com.efs.sdk.base.a.c.a.c;
import com.efs.sdk.base.a.e.f;
import com.efs.sdk.base.protocol.ILogProtocol;
import com.taobao.weex.annotation.JSMethod;
import io.flutter.plugins.connectivity.ConnectivityBroadcastReceiver;
import io.flutter.wpkbridge.WPKFactory;
import java.util.HashMap;
import java.util.Locale;
import java.util.TimeZone;
import tb.c13;
import tb.d63;
import tb.f23;
import tb.g23;
import tb.g63;
import tb.h63;
import tb.j53;
import tb.k53;
import tb.l23;
import tb.o13;
import tb.r03;
import tb.s23;
import tb.t43;
import tb.u33;
import tb.x23;

/* compiled from: Taobao */
public final class a implements Handler.Callback {
    public static c13 e;
    private int a = 0;
    private volatile boolean b = false;
    private com.efs.sdk.base.a.d.a.a c;
    private Handler d;

    public a(EfsReporter.Builder builder) {
        e = builder.e();
        Handler handler = new Handler(o13.a.getLooper(), this);
        this.d = handler;
        handler.sendEmptyMessage(0);
    }

    @NonNull
    public static c13 a() {
        return e;
    }

    private void c() {
        if (this.c == null) {
            this.c = new com.efs.sdk.base.a.d.a.a();
        }
        try {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction(ConnectivityBroadcastReceiver.CONNECTIVITY_ACTION);
            e.c.registerReceiver(this.c, intentFilter);
        } catch (Throwable th) {
            t43.b(Constants.TAG, "register network change receiver error", th);
            int i = this.a + 1;
            this.a = i;
            if (i < 3) {
                this.d.sendEmptyMessageDelayed(3, 6000);
            }
        }
    }

    static /* synthetic */ void d(ILogProtocol iLogProtocol) {
        for (ValueCallback<Pair<Message, Message>> valueCallback : e.a(9)) {
            HashMap hashMap = new HashMap(4);
            hashMap.put(WPKFactory.INSTANCE_KEY_LOG_TYPE, iLogProtocol.getLogType());
            hashMap.put("log_data", iLogProtocol.generateString());
            hashMap.put("link_key", iLogProtocol.getLinkKey());
            hashMap.put("link_id", iLogProtocol.getLinkId());
            Message obtain = Message.obtain(null, 9, hashMap);
            Message obtain2 = Message.obtain();
            valueCallback.onReceiveValue(new Pair<>(obtain, obtain2));
            obtain.recycle();
            obtain2.recycle();
        }
    }

    private void e(final ILogProtocol iLogProtocol) {
        if (iLogProtocol != null) {
            u33.a(new Runnable() {
                /* class com.efs.sdk.base.a.d.a.AnonymousClass1 */

                public final void run() {
                    try {
                        iLogProtocol.insertGlobal(s23.a.a().a);
                        if (!Constants.LOG_TYPE_WA.equalsIgnoreCase(iLogProtocol.getLogType())) {
                            a.d(iLogProtocol);
                        }
                        if (a.a().e) {
                            u33.a(new Runnable(g23.b(iLogProtocol)) {
                                /* class com.efs.sdk.base.a.g.d.AnonymousClass1 */
                                final /* synthetic */ g23 a;

                                {
                                    this.a = r2;
                                }

                                public final void run() {
                                    d.this.a.b(this.a);
                                }
                            });
                        }
                    } catch (Throwable th) {
                        t43.c(Constants.TAG, "log send error", th);
                    }
                }
            });
        }
    }

    public final void b(ILogProtocol iLogProtocol) {
        if (!this.b) {
            Message obtain = Message.obtain();
            obtain.what = 1;
            obtain.obj = iLogProtocol;
            this.d.sendMessage(obtain);
            return;
        }
        e(iLogProtocol);
    }

    public final boolean handleMessage(@NonNull Message message) {
        String str;
        int i = message.what;
        if (i == 0) {
            s23 a2 = s23.a.a();
            f23 f23 = new f23();
            a2.a = f23;
            f23.b("appid", e.a);
            int myPid = Process.myPid();
            a2.a.b("pid", Integer.valueOf(myPid));
            a2.a.b(IRequestConst.PS, g63.a(myPid));
            String a3 = h63.a(a2.b);
            a2.a.b("wid", a3);
            if (TextUtils.isEmpty(e.i)) {
                a2.a.b("uid", a3);
            } else {
                a2.a.b("uid", e.i);
            }
            f23 f232 = a2.a;
            r03.c();
            f232.b("stime", Long.valueOf(r03.e() - Process.getElapsedCpuTime()));
            a2.a.b("pkg", a2.b.getPackageName());
            a2.a.b("ver", d63.a(a2.b));
            a2.a.b("vcode", d63.b(a2.b));
            a2.a.b("sdk_ver", "1.3.1");
            a2.a.b("brand", Build.getBRAND().toLowerCase());
            f23 f233 = a2.a;
            String model = Build.getMODEL();
            f233.b("model", model == null ? "unknown" : model.replace(" ", "-").replace(JSMethod.NOT_SET, "-").toLowerCase());
            DisplayMetrics displayMetrics = a2.b.getResources().getDisplayMetrics();
            a2.a.b("dsp_w", Integer.valueOf(com.alibaba.wireless.security.aopsdk.replace.android.util.DisplayMetrics.getwidthPixels(displayMetrics)));
            a2.a.b("dsp_h", Integer.valueOf(com.alibaba.wireless.security.aopsdk.replace.android.util.DisplayMetrics.getheightPixels(displayMetrics)));
            a2.a.b("fr", "android");
            a2.a.b("rom", Build.VERSION.getRELEASE());
            a2.a.b(a.C0103a.a, Integer.valueOf(Build.VERSION.SDK_INT));
            a2.a.b("lang", Locale.getDefault().getLanguage());
            a2.a.b("tzone", TimeZone.getDefault().getID());
            a2.a.b("net", j53.b(a2.b));
            f.a.a();
            c.a().h();
            c();
            k53 a4 = k53.a.a();
            boolean z = e.j;
            x23 x23 = a4.a;
            if (z) {
                x23.a = "https://gjapplog.ucweb.com/collect";
                str = "4ea4e41a3993";
            } else {
                x23.a = "https://applog.uc.cn/collect";
                str = "28ef1713347d";
            }
            x23.b = str;
            a4.b = this;
            a4.c.a = this;
            a4.d.a = this;
            this.b = true;
            com.efs.sdk.base.a.e.a.a().sendEmptyMessageDelayed(0, e.l);
            k53 a5 = k53.a.a();
            if (a5.b != null && e.d) {
                a5.b.b(new l23("efs_core", "pvuv", a5.a.c));
            }
        } else if (i == 1) {
            Object obj = message.obj;
            if (obj != null && (obj instanceof ILogProtocol)) {
                e((ILogProtocol) obj);
            }
        } else if (i == 3) {
            c();
        }
        return true;
    }
}

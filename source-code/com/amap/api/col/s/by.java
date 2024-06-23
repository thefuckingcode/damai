package com.amap.api.col.s;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.provider.Settings;
import android.text.TextUtils;
import cn.damai.commonbusiness.discover.bean.GridBean;
import java.lang.ref.WeakReference;
import java.util.List;

/* compiled from: Taobao */
public final class by {
    public static final String a = bw.c("SU2hhcmVkUHJlZmVyZW5jZUFkaXU");
    private static by f;
    private List<String> b;
    private String c;
    private final Context d;
    private final Handler e;

    private by(Context context) {
        this.d = context.getApplicationContext();
        if (Looper.myLooper() == null) {
            this.e = new a(Looper.getMainLooper(), this);
        } else {
            this.e = new a(this);
        }
    }

    /* compiled from: Taobao */
    private static final class a extends Handler {
        private final WeakReference<by> a;

        a(by byVar) {
            this.a = new WeakReference<>(byVar);
        }

        public final void handleMessage(Message message) {
            Object obj;
            by byVar = this.a.get();
            if (byVar != null && message != null && (obj = message.obj) != null) {
                byVar.a((String) obj, message.what);
            }
        }

        a(Looper looper, by byVar) {
            super(looper);
            this.a = new WeakReference<>(byVar);
        }
    }

    public final void b(String str) {
        List<String> list = this.b;
        if (list != null) {
            list.clear();
            this.b.add(str);
        }
        a(str, GridBean.TYPE_VIDEO_UNDER_REVIEW);
    }

    public static by a(Context context) {
        if (f == null) {
            synchronized (by.class) {
                if (f == null) {
                    f = new by(context);
                }
            }
        }
        return f;
    }

    public final void a(String str) {
        this.c = str;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private synchronized void a(final String str, final int i) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            new Thread() {
                /* class com.amap.api.col.s.by.AnonymousClass1 */

                public final void run() {
                    String b2 = ce.b(str);
                    if (!TextUtils.isEmpty(b2)) {
                        if ((i & 1) > 0) {
                            try {
                                if (Build.VERSION.SDK_INT < 23) {
                                    Settings.System.putString(by.this.d.getContentResolver(), by.this.c, b2);
                                } else if (Settings.System.canWrite(by.this.d)) {
                                    Settings.System.putString(by.this.d.getContentResolver(), by.this.c, b2);
                                }
                            } catch (Exception unused) {
                            }
                        }
                        if ((i & 16) > 0) {
                            ca.a(by.this.d, by.this.c, b2);
                        }
                        if ((i & 256) > 0) {
                            SharedPreferences.Editor edit = by.this.d.getSharedPreferences(by.a, 0).edit();
                            edit.putString(by.this.c, b2);
                            if (Build.VERSION.SDK_INT >= 9) {
                                edit.apply();
                            } else {
                                edit.commit();
                            }
                        }
                    }
                }
            }.start();
            return;
        }
        String b2 = ce.b(str);
        if (!TextUtils.isEmpty(b2)) {
            if ((i & 1) > 0) {
                try {
                    if (Build.VERSION.SDK_INT >= 23) {
                        Settings.System.putString(this.d.getContentResolver(), this.c, b2);
                    } else {
                        Settings.System.putString(this.d.getContentResolver(), this.c, b2);
                    }
                } catch (Exception unused) {
                }
            }
            if ((i & 16) > 0) {
                ca.a(this.d, this.c, b2);
            }
            if ((i & 256) > 0) {
                SharedPreferences.Editor edit = this.d.getSharedPreferences(a, 0).edit();
                edit.putString(this.c, b2);
                if (Build.VERSION.SDK_INT >= 9) {
                    edit.apply();
                    return;
                }
                edit.commit();
            }
        }
    }
}

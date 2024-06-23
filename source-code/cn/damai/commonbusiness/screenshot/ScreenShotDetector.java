package cn.damai.commonbusiness.screenshot;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.Context;
import android.database.ContentObserver;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.util.ArrayMap;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.WorkerThread;
import cn.damai.common.nav.DMNav;
import cn.damai.common.nav.NavUri;
import com.alibaba.aliweex.adapter.module.audio.IWXAudio;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import tb.hp1;
import tb.i3;
import tb.lp1;
import tb.p42;
import tb.wa2;
import tb.xs0;

/* compiled from: Taobao */
public class ScreenShotDetector {
    private static transient /* synthetic */ IpChange $ipChange;
    private static final String o = MediaStore.Images.Media.EXTERNAL_CONTENT_URI.toString();
    private static final String p = MediaStore.Images.Media.INTERNAL_CONTENT_URI.toString();
    private static final String[] q = {"_data", "datetaken", "date_added"};
    private static final String[] r = {"screenshot", "截屏", "截图", "screen_shot", "screen-shot", "screen shot", "screencapture", "screen_capture", "screen-capture", "screen capture", "screencap", "screen_cap", "screen-cap", "screen cap"};
    private static ScreenShotDetector s = null;
    private final List<String> a = new ArrayList();
    public boolean b = false;
    private ContentResolver c = null;
    private ContentObserver d = null;
    private Context e;
    private IScreenShotDetectorListener f;
    private IScreenShotExtraListener g;
    private boolean h = true;
    private boolean i = true;
    Handler j = new b();
    private String[] k = {"_data", "date_added"};
    private String[] l = {"image/png", "image/jpeg"};
    private ScreenShotBean m = new ScreenShotBean();
    private StringBuilder n = new StringBuilder();

    /* compiled from: Taobao */
    public interface IScreenShotDetectorListener {
        void onFeedbackClick(ScreenShotBean screenShotBean, Activity activity);
    }

    /* compiled from: Taobao */
    public interface IScreenShotExtraListener {
        void onDetected(String str, Activity activity);
    }

    /* compiled from: Taobao */
    public class a extends c {
        private static transient /* synthetic */ IpChange $ipChange;

        a(Handler handler, Context context) {
            super(handler, context);
        }

        public void onChange(boolean z, Uri uri) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "7511482")) {
                ipChange.ipc$dispatch("7511482", new Object[]{this, Boolean.valueOf(z), uri});
                return;
            }
            Message obtainMessage = ScreenShotDetector.this.j.obtainMessage();
            obtainMessage.obj = uri;
            ScreenShotDetector.this.j.sendMessage(obtainMessage);
            super.onChange(z, uri);
        }
    }

    /* compiled from: Taobao */
    public class b extends Handler {
        private static transient /* synthetic */ IpChange $ipChange;

        b() {
        }

        public void handleMessage(Message message) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "748521159")) {
                ipChange.ipc$dispatch("748521159", new Object[]{this, message});
                return;
            }
            Uri uri = (Uri) message.obj;
            if (uri != null) {
                if (uri.toString().matches(ScreenShotDetector.o) || uri.toString().matches(ScreenShotDetector.p) || uri.toString().startsWith(ScreenShotDetector.o)) {
                    p42.f().h();
                    if (hp1.i(lp1.STORAGE)) {
                        ScreenShotDetector.this.t(uri);
                    }
                }
                super.handleMessage(message);
            }
        }
    }

    /* compiled from: Taobao */
    public static class c extends ContentObserver {
        public c(Handler handler, Context context) {
            super(handler);
            new WeakReference(context);
        }
    }

    private void e(final String str, long j2) {
        wa2 j3;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "549901776")) {
            ipChange.ipc$dispatch("549901776", new Object[]{this, str, Long.valueOf(j2)});
        } else if (n(str, System.currentTimeMillis() / 1000, j2) && !f(str) && (j3 = j(this.e)) != null) {
            if (!j3.b() || !this.h) {
                final Activity a2 = j3.a();
                a2.runOnUiThread(new Runnable() {
                    /* class cn.damai.commonbusiness.screenshot.ScreenShotDetector.AnonymousClass3 */
                    private static transient /* synthetic */ IpChange $ipChange;

                    public void run() {
                        IpChange ipChange = $ipChange;
                        if (AndroidInstantRuntime.support(ipChange, "-1702230841")) {
                            ipChange.ipc$dispatch("-1702230841", new Object[]{this});
                            return;
                        }
                        ScreenShotDetector.this.s(a2, str);
                    }
                });
            }
        }
    }

    private boolean f(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1015176158")) {
            return ((Boolean) ipChange.ipc$dispatch("-1015176158", new Object[]{this, str})).booleanValue();
        } else if (this.a.contains(str)) {
            return true;
        } else {
            if (this.a.size() >= 20) {
                for (int i2 = 0; i2 < 5; i2++) {
                    this.a.remove(0);
                }
            }
            this.a.add(str);
            return false;
        }
    }

    private Bundle g(String str, String[] strArr, String str2, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-786640519")) {
            return (Bundle) ipChange.ipc$dispatch("-786640519", new Object[]{this, str, strArr, str2, Integer.valueOf(i2)});
        } else if (str == null && strArr == null && str2 == null) {
            return null;
        } else {
            Bundle bundle = new Bundle();
            if (str != null) {
                bundle.putString("android:query-arg-sql-selection", str);
            }
            if (strArr != null) {
                bundle.putStringArray("android:query-arg-sql-selection-args", strArr);
            }
            if (str2 != null) {
                bundle.putString("android:query-arg-sql-sort-order", str2);
            }
            bundle.putString("android:query-arg-sql-limit", i2 + "");
            return bundle;
        }
    }

    @NonNull
    public static List<wa2> h(@Nullable Context context, boolean z) {
        Collection collection;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1969191261")) {
            return (List) ipChange.ipc$dispatch("1969191261", new Object[]{context, Boolean.valueOf(z)});
        }
        ArrayList arrayList = new ArrayList();
        try {
            Class<?> cls = Class.forName("android.app.ActivityThread");
            Object i2 = i(context, cls);
            Field declaredField = cls.getDeclaredField("mActivities");
            declaredField.setAccessible(true);
            Object obj = declaredField.get(i2);
            if (obj instanceof HashMap) {
                collection = ((HashMap) obj).values();
            } else {
                if (Build.VERSION.SDK_INT >= 19 && (obj instanceof ArrayMap)) {
                    collection = ((ArrayMap) obj).values();
                }
                return arrayList;
            }
            for (Object obj2 : collection) {
                Class<?> cls2 = obj2.getClass();
                Field declaredField2 = cls2.getDeclaredField(IWXAudio.KEY_PAUSED);
                declaredField2.setAccessible(true);
                Field declaredField3 = cls2.getDeclaredField("activity");
                declaredField3.setAccessible(true);
                Activity activity = (Activity) declaredField3.get(obj2);
                if (activity != null) {
                    arrayList.add(new wa2(declaredField2.getBoolean(obj2), activity));
                }
            }
        } catch (Throwable unused) {
        }
        return arrayList;
    }

    @Nullable
    public static Object i(@Nullable Context context, @Nullable Class<?> cls) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2128699509")) {
            return ipChange.ipc$dispatch("-2128699509", new Object[]{context, cls});
        }
        if (cls == null) {
            try {
                cls = Class.forName("android.app.ActivityThread");
            } catch (Throwable unused) {
                return null;
            }
        }
        Method method = cls.getMethod("currentActivityThread", new Class[0]);
        method.setAccessible(true);
        Object invoke = method.invoke(null, new Object[0]);
        if (invoke != null || context == null) {
            return invoke;
        }
        Field field = context.getClass().getField("mLoadedApk");
        field.setAccessible(true);
        Object obj = field.get(context);
        Field declaredField = obj.getClass().getDeclaredField("mActivityThread");
        declaredField.setAccessible(true);
        return declaredField.get(obj);
    }

    @Nullable
    public static wa2 j(@Nullable Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-848336082")) {
            return (wa2) ipChange.ipc$dispatch("-848336082", new Object[]{context});
        }
        List<wa2> h2 = h(context, false);
        if (h2.isEmpty()) {
            return null;
        }
        return h2.get(0);
    }

    public static ScreenShotDetector k() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1027227109")) {
            return (ScreenShotDetector) ipChange.ipc$dispatch("-1027227109", new Object[0]);
        }
        synchronized (ScreenShotDetector.class) {
            if (s == null) {
                s = new ScreenShotDetector();
            }
        }
        return s;
    }

    private static boolean n(String str, long j2, long j3) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "617011580")) {
            return q(j2, j3) && p(str);
        }
        return ((Boolean) ipChange.ipc$dispatch("617011580", new Object[]{str, Long.valueOf(j2), Long.valueOf(j3)})).booleanValue();
    }

    private static boolean p(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-255805403")) {
            return ((Boolean) ipChange.ipc$dispatch("-255805403", new Object[]{str})).booleanValue();
        } else if (TextUtils.isEmpty(str)) {
            return false;
        } else {
            String lowerCase = str.toLowerCase();
            for (String str2 : r) {
                if (lowerCase.contains(str2)) {
                    return true;
                }
            }
            return false;
        }
    }

    private static boolean q(long j2, long j3) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1699156173")) {
            return Math.abs(j2 - j3) <= 1000;
        }
        return ((Boolean) ipChange.ipc$dispatch("-1699156173", new Object[]{Long.valueOf(j2), Long.valueOf(j3)})).booleanValue();
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void s(Activity activity, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "243664284")) {
            ipChange.ipc$dispatch("243664284", new Object[]{this, activity, str});
            return;
        }
        r(str);
        Activity c2 = i3.b().c();
        if (c2 != null) {
            IScreenShotExtraListener iScreenShotExtraListener = this.g;
            if (iScreenShotExtraListener != null) {
                iScreenShotExtraListener.onDetected(str, c2);
            }
        } else {
            IScreenShotExtraListener iScreenShotExtraListener2 = this.g;
            if (iScreenShotExtraListener2 != null) {
                iScreenShotExtraListener2.onDetected(str, activity);
            }
        }
        if (o()) {
            p42.f().i();
            Bundle bundle = new Bundle();
            bundle.putSerializable("screen_shot_info", this.m);
            DMNav.from(activity).withExtras(bundle).toUri(NavUri.b("screen_float"));
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void t(Uri uri) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1690858036")) {
            ipChange.ipc$dispatch("1690858036", new Object[]{this, uri});
        } else if (uri != null) {
            Cursor cursor = null;
            if (Build.VERSION.SDK_INT >= 29) {
                ScreentShotInfo u = u();
                e(u.path, u.addTime);
                return;
            }
            try {
                cursor = this.c.query(uri, q, null, null, "date_added desc limit 1");
                if (cursor != null && cursor.moveToFirst()) {
                    e(cursor.getString(cursor.getColumnIndex("_data")), cursor.getLong(cursor.getColumnIndex("date_added")));
                }
                if (cursor == null) {
                    return;
                }
            } catch (Throwable th) {
                if (0 != 0) {
                    cursor.close();
                }
                throw th;
            }
            cursor.close();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x006c, code lost:
        if (0 == 0) goto L_0x0071;
     */
    @RequiresApi(26)
    @WorkerThread
    private ScreentShotInfo u() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1738600196")) {
            return (ScreentShotInfo) ipChange.ipc$dispatch("-1738600196", new Object[]{this});
        }
        ScreentShotInfo screentShotInfo = new ScreentShotInfo();
        Cursor cursor = null;
        try {
            cursor = xs0.a().getContentResolver().query(MediaStore.Files.getContentUri("external"), this.k, g("media_type=1 AND mime_type=? or mime_type=?", this.l, "_id DESC", 1), null);
            if (cursor == null) {
                if (cursor != null) {
                    cursor.close();
                }
                return screentShotInfo;
            }
            if (cursor.moveToFirst()) {
                String string = cursor.getString(cursor.getColumnIndexOrThrow(this.k[0]));
                long j2 = cursor.getLong(cursor.getColumnIndexOrThrow(this.k[1]));
                screentShotInfo.path = string;
                screentShotInfo.addTime = j2;
            }
            cursor.close();
            return screentShotInfo;
        } catch (Exception e2) {
            e2.printStackTrace();
        } catch (Throwable th) {
            if (0 != 0) {
                cursor.close();
            }
            throw th;
        }
    }

    public void A(Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "555835436")) {
            ipChange.ipc$dispatch("555835436", new Object[]{this, context});
            return;
        }
        this.a.clear();
        this.e = context.getApplicationContext();
        this.c = xs0.a().getContentResolver();
        a aVar = new a(null, context);
        this.d = aVar;
        this.c.registerContentObserver(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, true, aVar);
        this.c.registerContentObserver(MediaStore.Images.Media.INTERNAL_CONTENT_URI, true, this.d);
    }

    public void B() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1064435932")) {
            ipChange.ipc$dispatch("-1064435932", new Object[]{this});
            return;
        }
        ContentResolver contentResolver = this.c;
        if (contentResolver != null) {
            contentResolver.unregisterContentObserver(this.d);
            this.c = null;
        }
        this.a.clear();
    }

    public ScreenShotBean l() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1239360208")) {
            return this.m;
        }
        return (ScreenShotBean) ipChange.ipc$dispatch("1239360208", new Object[]{this});
    }

    public IScreenShotDetectorListener m() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "2064628139")) {
            return this.f;
        }
        return (IScreenShotDetectorListener) ipChange.ipc$dispatch("2064628139", new Object[]{this});
    }

    public boolean o() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1451035603")) {
            return this.i;
        }
        return ((Boolean) ipChange.ipc$dispatch("1451035603", new Object[]{this})).booleanValue();
    }

    public ScreenShotBean r(String str) {
        Set<String> keySet;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1175996708")) {
            return (ScreenShotBean) ipChange.ipc$dispatch("-1175996708", new Object[]{this, str});
        }
        Bundle bundle = null;
        if (i3.b().c() == null || this.b) {
            return null;
        }
        StringBuilder sb = this.n;
        sb.delete(0, sb.length());
        if (this.m == null) {
            this.m = new ScreenShotBean();
        }
        this.m.clear();
        Activity c2 = i3.b().c();
        if (c2 != null) {
            String name = c2.getClass().getName();
            if (!TextUtils.isEmpty(name)) {
                this.m.put("fromPage", name);
                String[] split = name.split("\\.");
                if (split != null && split.length > 2) {
                    this.m.put("module", split[2]);
                }
            }
            if (c2.getIntent() != null) {
                bundle = c2.getIntent().getExtras();
            }
            if (!(bundle == null || (keySet = bundle.keySet()) == null)) {
                for (String str2 : keySet) {
                    Object obj = bundle.get(str2);
                    if (!(obj == null || obj.toString() == null)) {
                        StringBuilder sb2 = this.n;
                        sb2.append(str2);
                        sb2.append("=");
                        sb2.append(obj.toString());
                        sb2.append("&");
                    }
                }
                if (this.n.length() > 0) {
                    StringBuilder sb3 = this.n;
                    sb3.delete(sb3.length() - 1, this.n.length());
                }
                this.m.put("extra", this.n.toString());
            }
        }
        return this.m;
    }

    public void v(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1514513807")) {
            ipChange.ipc$dispatch("-1514513807", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        this.h = z;
    }

    public void w(IScreenShotDetectorListener iScreenShotDetectorListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "170942161")) {
            ipChange.ipc$dispatch("170942161", new Object[]{this, iScreenShotDetectorListener});
            return;
        }
        this.f = iScreenShotDetectorListener;
    }

    public void x(IScreenShotExtraListener iScreenShotExtraListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "219446735")) {
            ipChange.ipc$dispatch("219446735", new Object[]{this, iScreenShotExtraListener});
            return;
        }
        this.g = iScreenShotExtraListener;
    }

    public void y(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1271563013")) {
            ipChange.ipc$dispatch("1271563013", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        this.i = z;
    }

    public void z(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2031379749")) {
            ipChange.ipc$dispatch("2031379749", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        this.b = z;
    }
}

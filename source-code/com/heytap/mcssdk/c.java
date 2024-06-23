package com.heytap.mcssdk;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import android.taobao.windvane.connect.api.ApiConstants;
import android.text.TextUtils;
import com.heytap.mcssdk.constant.MessageConstant$CommandId;
import com.heytap.mcssdk.d.d;
import com.heytap.msp.push.callback.ICallBackResultService;
import com.heytap.msp.push.callback.IGetAppNotificationCallBackService;
import com.heytap.msp.push.callback.ISetAppNotificationCallBackService;
import com.mcs.aidl.IMcsSdkService;
import com.taobao.accs.common.Constants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;
import tb.a23;
import tb.b23;
import tb.hu2;
import tb.u03;
import tb.v03;
import tb.w03;
import tb.w33;

/* compiled from: Taobao */
public class c implements a {
    private static final int[] k = {99, 111, 109, 46, 99, 111, 108, 111, 114, 111, 115, 46, 109, 99, 115};
    private static final int[] l = {99, 111, 109, 46, 99, 111, 108, 111, 114, 111, 115, 46, 109, 99, 115, 115, 100, 107, 46, 97, 99, 116, 105, 111, 110, 46, 82, 69, 67, 69, 73, 86, 69, 95, 83, 68, 75, 95, 77, 69, 83, 83, 65, 71, 69};
    private static String m = "";
    private static int n = 0;
    private static String o;
    private static boolean p;
    private Context a;
    private List<com.heytap.mcssdk.e.c> b;
    private List<d> c;
    private String d;
    private String e;
    private String f;
    private ICallBackResultService g;
    private ISetAppNotificationCallBackService h;
    private IGetAppNotificationCallBackService i;
    private ConcurrentHashMap<Integer, v03> j;

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public class a implements ServiceConnection {
        final /* synthetic */ Intent a;

        a(Intent intent) {
            this.a = intent;
        }

        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            Bundle bundle = new Bundle();
            bundle.putAll(this.a.getExtras());
            try {
                IMcsSdkService.Stub.asInterface(iBinder).process(bundle);
            } catch (Exception e) {
                w33.a("bindMcsService exception:" + e);
            }
            c.this.a.unbindService(this);
        }

        public void onServiceDisconnected(ComponentName componentName) {
        }
    }

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public static class b {
        private static final c a = new c(null);
    }

    private c() {
        this.b = new ArrayList();
        this.c = new ArrayList();
        this.f = null;
        synchronized (c.class) {
            int i2 = n;
            if (i2 <= 0) {
                n = i2 + 1;
            } else {
                throw new RuntimeException("PushService can't create again!");
            }
        }
        c(new b23());
        c(new w03());
        d(new com.heytap.mcssdk.e.b());
        d(new com.heytap.mcssdk.e.a());
        this.j = new ConcurrentHashMap<>();
    }

    /* synthetic */ c(a aVar) {
        this();
    }

    public static String A() {
        return "3.0.0";
    }

    private boolean E(Context context) {
        if (this.a == null) {
            this.a = context.getApplicationContext();
        }
        String o2 = o(this.a);
        return hu2.f(this.a, o2) && hu2.c(this.a, o2) >= 1019 && hu2.g(this.a, o2, "supportOpenPush");
    }

    private void H(int i2, String str, JSONObject jSONObject) {
        if (g(i2)) {
            ICallBackResultService iCallBackResultService = this.g;
            if (iCallBackResultService != null) {
                iCallBackResultService.onError(l(i2), "api_call_too_frequently");
                return;
            }
            return;
        }
        try {
            this.a.startService(n(i2, str, jSONObject));
        } catch (Exception e2) {
            w33.b("startMcsService--Exception" + e2.getMessage());
        }
    }

    private void I(int i2, JSONObject jSONObject) {
        H(i2, "", jSONObject);
    }

    private v03 b(int i2) {
        String str;
        if (this.j.containsKey(Integer.valueOf(i2))) {
            v03 v03 = this.j.get(Integer.valueOf(i2));
            if (j(v03)) {
                v03.b(1);
                v03.c(System.currentTimeMillis());
                str = "addCommandToMap : appLimitBean.setCount(1)";
            } else {
                v03.b(v03.d() + 1);
                str = "addCommandToMap :appLimitBean.getCount() + 1";
            }
            w33.a(str);
            return v03;
        }
        v03 v032 = new v03(System.currentTimeMillis(), 1);
        this.j.put(Integer.valueOf(i2), v032);
        w33.a("addCommandToMap :appBean is null");
        return v032;
    }

    private synchronized void c(d dVar) {
        if (dVar != null) {
            this.c.add(dVar);
        }
    }

    private synchronized void d(com.heytap.mcssdk.e.c cVar) {
        if (cVar != null) {
            this.b.add(cVar);
        }
    }

    private boolean f() {
        return h() && i();
    }

    private boolean h() {
        return this.a != null;
    }

    private boolean i() {
        return this.f != null;
    }

    private boolean j(v03 v03) {
        long a2 = v03.a();
        long currentTimeMillis = System.currentTimeMillis();
        w33.a("checkTimeNeedUpdate : lastedTime " + a2 + " currentTime:" + currentTimeMillis);
        return currentTimeMillis - a2 > 1000;
    }

    public static c m() {
        return b.a;
    }

    private Intent n(int i2, String str, JSONObject jSONObject) {
        Intent intent = new Intent();
        intent.setAction(y(this.a));
        intent.setPackage(o(this.a));
        intent.putExtra("type", i2);
        JSONObject jSONObject2 = new JSONObject();
        try {
            Context context = this.a;
            jSONObject2.putOpt("versionName", hu2.e(context, context.getPackageName()));
            Context context2 = this.a;
            jSONObject2.putOpt("versionCode", Integer.valueOf(hu2.c(context2, context2.getPackageName())));
            if (jSONObject != null) {
                Iterator<String> keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    jSONObject2.putOpt(next, jSONObject.get(next));
                }
            }
        } catch (Exception unused) {
        } catch (Throwable th) {
            intent.putExtra("extra", jSONObject2.toString());
            throw th;
        }
        intent.putExtra("extra", jSONObject2.toString());
        intent.putExtra("params", str);
        intent.putExtra("appPackage", this.a.getPackageName());
        intent.putExtra("appKey", this.d);
        intent.putExtra(ApiConstants.APPSECRET, this.e);
        intent.putExtra("registerID", this.f);
        intent.putExtra("sdkVersion", A());
        return intent;
    }

    private String p(Context context) {
        if (TextUtils.isEmpty(m)) {
            m = new String(u03.l("Y29tLm1jcy5hY3Rpb24uUkVDRUlWRV9TREtfTUVTU0FHRQ=="));
        }
        List<ResolveInfo> queryIntentServices = context.getPackageManager().queryIntentServices(new Intent(m), 8192);
        if (Build.VERSION.SDK_INT < 24) {
            return null;
        }
        for (ResolveInfo resolveInfo : queryIntentServices) {
            String str = resolveInfo.serviceInfo.packageName;
            try {
                boolean z = false;
                boolean z2 = (context.getPackageManager().getApplicationInfo(str, 0).flags & 1) == 1;
                if (context.getPackageManager().getPackageUid(str, 0) == context.getPackageManager().getPackageUid("android", 0)) {
                    z = true;
                }
                if (z2 || z) {
                    return str;
                }
            } catch (PackageManager.NameNotFoundException unused) {
            }
        }
        return null;
    }

    public static int z() {
        return 3000;
    }

    public c B(Context context, boolean z) {
        if (context != null) {
            C(context);
            new com.heytap.mcssdk.b.a().a(this.a);
            w33.d(z);
            return this;
        }
        throw new IllegalArgumentException("context can't be null");
    }

    public void C(Context context) {
        boolean z;
        Context applicationContext = context.getApplicationContext();
        this.a = applicationContext;
        if (o == null) {
            String p2 = p(applicationContext);
            if (p2 == null) {
                o = hu2.a(k);
                z = false;
            } else {
                o = p2;
                z = true;
            }
            p = z;
        }
    }

    public boolean D(Context context) {
        return E(context);
    }

    public void F(String str, String str2) {
        this.d = str;
        this.e = str2;
    }

    public void G(ICallBackResultService iCallBackResultService) {
        this.g = iCallBackResultService;
    }

    public void J(Context context, String str, String str2, JSONObject jSONObject, ICallBackResultService iCallBackResultService) {
        this.d = str;
        this.e = str2;
        this.a = context.getApplicationContext();
        this.g = iCallBackResultService;
        unRegister(jSONObject);
    }

    @Override // com.heytap.mcssdk.a
    public void clearNotificationType() {
        clearNotificationType(null);
    }

    @Override // com.heytap.mcssdk.a
    public void clearNotificationType(JSONObject jSONObject) {
        if (f()) {
            I(MessageConstant$CommandId.COMMAND_CLEAR_NOTIFICATION_TYPE, jSONObject);
        } else {
            w33.c(w33.a, "please call the register first!");
        }
    }

    @Override // com.heytap.mcssdk.a
    public void clearNotifications() {
        clearNotifications(null);
    }

    @Override // com.heytap.mcssdk.a
    public void clearNotifications(JSONObject jSONObject) {
        if (h()) {
            I(MessageConstant$CommandId.COMMAND_CLEAR_PKG_NOTIFICATION, jSONObject);
        } else {
            w33.c(w33.a, "please call the register first!");
        }
    }

    @Override // com.heytap.mcssdk.a
    public void disableAppNotificationSwitch(ISetAppNotificationCallBackService iSetAppNotificationCallBackService) {
        if (h()) {
            this.h = iSetAppNotificationCallBackService;
            I(MessageConstant$CommandId.COMMAND_APP_NOTIFICATION_CLOSE, null);
        } else if (s() != null) {
            this.h.onSetAppNotificationSwitch(-2);
        }
    }

    public void e(int i2) {
        if (g(i2)) {
            ICallBackResultService iCallBackResultService = this.g;
            if (iCallBackResultService != null) {
                iCallBackResultService.onError(l(i2), "api_call_too_frequently");
                return;
            }
            return;
        }
        Intent n2 = n(i2, "", null);
        this.a.bindService(n2, new a(n2), 1);
    }

    @Override // com.heytap.mcssdk.a
    public void enableAppNotificationSwitch(ISetAppNotificationCallBackService iSetAppNotificationCallBackService) {
        if (h()) {
            this.h = iSetAppNotificationCallBackService;
            I(MessageConstant$CommandId.COMMAND_APP_NOTIFICATION_OPEN, null);
            return;
        }
        ISetAppNotificationCallBackService iSetAppNotificationCallBackService2 = this.h;
        if (iSetAppNotificationCallBackService2 != null) {
            iSetAppNotificationCallBackService2.onSetAppNotificationSwitch(-2);
        }
    }

    public boolean g(int i2) {
        return (i2 == 12291 || i2 == 12312 || b(i2).d() <= 2) ? false : true;
    }

    @Override // com.heytap.mcssdk.a
    public void getAppNotificationSwitch(IGetAppNotificationCallBackService iGetAppNotificationCallBackService) {
        if (h()) {
            this.i = iGetAppNotificationCallBackService;
            I(MessageConstant$CommandId.COMMAND_APP_NOTIFICATION_GET, null);
            return;
        }
        IGetAppNotificationCallBackService iGetAppNotificationCallBackService2 = this.i;
        if (iGetAppNotificationCallBackService2 != null) {
            iGetAppNotificationCallBackService2.onGetAppNotificationSwitch(-2, 0);
        }
    }

    @Override // com.heytap.mcssdk.a
    public void getNotificationStatus() {
        getNotificationStatus(null);
    }

    @Override // com.heytap.mcssdk.a
    public void getNotificationStatus(JSONObject jSONObject) {
        if (f()) {
            I(MessageConstant$CommandId.COMMAND_GET_NOTIFICATION_STATUS, jSONObject);
        } else if (s() != null) {
            s().onGetNotificationStatus(-2, 0);
        }
    }

    @Override // com.heytap.mcssdk.a
    public void getRegister() {
        getRegister(null);
    }

    @Override // com.heytap.mcssdk.a
    public void getRegister(JSONObject jSONObject) {
        if (h()) {
            I(MessageConstant$CommandId.COMMAND_REGISTER, jSONObject);
        } else if (s() != null) {
            s().onRegister(-2, null);
        }
    }

    @Override // com.heytap.mcssdk.a
    public String getRegisterID() {
        return this.f;
    }

    public Context k() {
        return this.a;
    }

    public int l(int i2) {
        switch (i2) {
            case MessageConstant$CommandId.COMMAND_REGISTER:
                return -1;
            case MessageConstant$CommandId.COMMAND_UNREGISTER:
                return -2;
            case MessageConstant$CommandId.COMMAND_STATISTIC:
                return -14;
            default:
                switch (i2) {
                    case MessageConstant$CommandId.COMMAND_SET_PUSH_TIME:
                        return -11;
                    case MessageConstant$CommandId.COMMAND_PAUSE_PUSH:
                        return -3;
                    case MessageConstant$CommandId.COMMAND_RESUME_PUSH:
                        return -4;
                    default:
                        switch (i2) {
                            case MessageConstant$CommandId.COMMAND_GET_PUSH_STATUS:
                                return -10;
                            case MessageConstant$CommandId.COMMAND_SET_NOTIFICATION_TYPE:
                                return -6;
                            case MessageConstant$CommandId.COMMAND_CLEAR_NOTIFICATION_TYPE:
                                return -7;
                            case MessageConstant$CommandId.COMMAND_GET_NOTIFICATION_STATUS:
                                return -5;
                            case MessageConstant$CommandId.COMMAND_SET_NOTIFICATION_SETTINGS:
                                return -8;
                            case MessageConstant$CommandId.COMMAND_CLEAR_PKG_NOTIFICATION:
                                return -9;
                            case MessageConstant$CommandId.COMMAND_SEND_INSTANT_ACK:
                                return -13;
                            case MessageConstant$CommandId.COMMAND_NOTIFICATION_ALLOWANCE:
                                return -12;
                            default:
                                switch (i2) {
                                    case MessageConstant$CommandId.COMMAND_APP_NOTIFICATION_OPEN:
                                        return -15;
                                    case MessageConstant$CommandId.COMMAND_APP_NOTIFICATION_CLOSE:
                                        return -16;
                                    case MessageConstant$CommandId.COMMAND_APP_NOTIFICATION_GET:
                                        return -17;
                                    default:
                                        return 0;
                                }
                        }
                }
        }
    }

    public String o(Context context) {
        boolean z;
        if (o == null) {
            String p2 = p(context);
            if (p2 == null) {
                o = hu2.a(k);
                z = false;
            } else {
                o = p2;
                z = true;
            }
            p = z;
        }
        return o;
    }

    @Override // com.heytap.mcssdk.a
    public void openNotificationSettings() {
        openNotificationSettings(null);
    }

    @Override // com.heytap.mcssdk.a
    public void openNotificationSettings(JSONObject jSONObject) {
        if (f()) {
            I(MessageConstant$CommandId.COMMAND_SET_NOTIFICATION_SETTINGS, jSONObject);
        } else {
            w33.c(w33.a, "please call the register first!");
        }
    }

    @Override // com.heytap.mcssdk.a
    public void pausePush() {
        pausePush(null);
    }

    @Override // com.heytap.mcssdk.a
    public void pausePush(JSONObject jSONObject) {
        if (f()) {
            I(MessageConstant$CommandId.COMMAND_PAUSE_PUSH, jSONObject);
        } else {
            w33.c(w33.a, "please call the register first!");
        }
    }

    public List<d> q() {
        return this.c;
    }

    public List<com.heytap.mcssdk.e.c> r() {
        return this.b;
    }

    @Override // com.heytap.mcssdk.a
    public void register(Context context, String str, String str2, ICallBackResultService iCallBackResultService) {
        register(context, str, str2, null, iCallBackResultService);
    }

    @Override // com.heytap.mcssdk.a
    public void register(Context context, String str, String str2, JSONObject jSONObject, ICallBackResultService iCallBackResultService) {
        if (context != null) {
            if (this.a == null) {
                this.a = context.getApplicationContext();
            }
            if (hu2.h(this.a)) {
                this.d = str;
                this.e = str2;
                this.g = iCallBackResultService;
                if (jSONObject == null) {
                    jSONObject = new JSONObject();
                }
                try {
                    jSONObject.putOpt(Constants.KEY_APP_VERSION_CODE, Integer.valueOf(hu2.b(context)));
                    jSONObject.putOpt(Constants.KEY_APP_VERSION_NAME, hu2.d(context));
                } catch (JSONException e2) {
                    w33.b("register-Exception:" + e2.getMessage());
                }
                I(MessageConstant$CommandId.COMMAND_REGISTER, jSONObject);
            } else if (iCallBackResultService != null) {
                iCallBackResultService.onRegister(-2, null);
            }
        } else if (iCallBackResultService != null) {
            iCallBackResultService.onRegister(-2, null);
        }
    }

    @Override // com.heytap.mcssdk.a
    public void requestNotificationPermission() {
        if (h()) {
            e(MessageConstant$CommandId.COMMAND_NOTIFICATION_ALLOWANCE);
        } else {
            w33.c(w33.a, "please call the register first!");
        }
    }

    @Override // com.heytap.mcssdk.a
    public void resumePush() {
        resumePush(null);
    }

    @Override // com.heytap.mcssdk.a
    public void resumePush(JSONObject jSONObject) {
        if (f()) {
            I(MessageConstant$CommandId.COMMAND_RESUME_PUSH, jSONObject);
        } else {
            w33.c(w33.a, "please call the register first!");
        }
    }

    public ICallBackResultService s() {
        return this.g;
    }

    @Override // com.heytap.mcssdk.a
    public void setNotificationType(int i2) {
        setNotificationType(i2, null);
    }

    @Override // com.heytap.mcssdk.a
    public void setNotificationType(int i2, JSONObject jSONObject) {
        if (f()) {
            H(MessageConstant$CommandId.COMMAND_SET_NOTIFICATION_TYPE, i2 + "", jSONObject);
            return;
        }
        w33.c(w33.a, "please call the register first!");
    }

    @Override // com.heytap.mcssdk.a
    public void setPushTime(List<Integer> list, int i2, int i3, int i4, int i5) {
        setPushTime(list, i2, i3, i4, i5, null);
    }

    @Override // com.heytap.mcssdk.a
    public void setPushTime(List<Integer> list, int i2, int i3, int i4, int i5, JSONObject jSONObject) {
        if (f()) {
            if (list == null || list.size() <= 0 || i2 < 0 || i3 < 0 || i4 < i2 || i4 > 23 || i5 < i3 || i5 > 59) {
                throw new IllegalArgumentException("params are not all right,please check params");
            }
            try {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("weekDays", a23.a(list));
                jSONObject2.put("startHour", i2);
                jSONObject2.put("startMin", i3);
                jSONObject2.put("endHour", i4);
                jSONObject2.put("endMin", i5);
                H(MessageConstant$CommandId.COMMAND_SET_PUSH_TIME, jSONObject2.toString(), jSONObject);
            } catch (JSONException e2) {
                w33.c(w33.a, e2.getLocalizedMessage());
            }
        } else if (s() != null) {
            s().onSetPushTime(-2, "please call the register first!");
        }
    }

    @Override // com.heytap.mcssdk.a
    public void setRegisterID(String str) {
        this.f = str;
    }

    public IGetAppNotificationCallBackService t() {
        return this.i;
    }

    public ISetAppNotificationCallBackService u() {
        return this.h;
    }

    @Override // com.heytap.mcssdk.a
    public void unRegister() {
        unRegister(null);
    }

    @Override // com.heytap.mcssdk.a
    public void unRegister(JSONObject jSONObject) {
        if (h()) {
            I(MessageConstant$CommandId.COMMAND_UNREGISTER, jSONObject);
        } else if (s() != null) {
            s().onUnRegister(-2);
        }
    }

    public void v() {
        if (f()) {
            I(MessageConstant$CommandId.COMMAND_GET_PUSH_STATUS, null);
        } else if (s() != null) {
            s().onGetPushStatus(-2, 0);
        }
    }

    public int w() {
        if (!h()) {
            return 0;
        }
        Context context = this.a;
        return hu2.c(context, o(context));
    }

    public String x() {
        if (!h()) {
            return "";
        }
        Context context = this.a;
        return hu2.e(context, o(context));
    }

    public String y(Context context) {
        if (o == null) {
            p(context);
        }
        if (!p) {
            return hu2.a(l);
        }
        if (TextUtils.isEmpty(m)) {
            m = new String(u03.l("Y29tLm1jcy5hY3Rpb24uUkVDRUlWRV9TREtfTUVTU0FHRQ=="));
        }
        return m;
    }
}

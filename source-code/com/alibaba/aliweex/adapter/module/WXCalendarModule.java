package com.alibaba.aliweex.adapter.module;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.taobao.weex.annotation.JSMethod;
import com.taobao.weex.bridge.JSCallback;
import com.taobao.weex.common.WXModule;
import com.taobao.weex.utils.WXLogUtils;
import java.util.ArrayList;
import java.util.Calendar;
import tb.a30;
import tb.lf1;
import tb.re;

/* compiled from: Taobao */
public class WXCalendarModule extends WXModule {
    static final int REQUEST_CALENDAR_PERMISSION_CODE = 25;
    public static final String TAG = "WXCalendarModule";

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public static class PerReceiver extends BroadcastReceiver {
        PermissionCallback a;

        PerReceiver(PermissionCallback permissionCallback) {
            this.a = permissionCallback;
        }

        public void onReceive(Context context, Intent intent) {
            boolean z = false;
            try {
                if (intent.getIntExtra("requestCode", 0) == 25) {
                    int[] intArrayExtra = intent.getIntArrayExtra(WXModule.GRANT_RESULTS);
                    String[] stringArrayExtra = intent.getStringArrayExtra("permissions");
                    int i = 0;
                    while (true) {
                        if (intArrayExtra == null || i >= intArrayExtra.length) {
                            z = true;
                        } else if (intArrayExtra[i] != 0) {
                            this.a.onPermissionsDenied(stringArrayExtra[i]);
                            break;
                        } else {
                            i++;
                        }
                    }
                    if (z) {
                        this.a.onPermissionsGranted();
                    }
                }
                LocalBroadcastManager.getInstance(context).unregisterReceiver(this);
            } catch (Throwable th) {
                WXLogUtils.e(WXCalendarModule.TAG, th);
            }
        }
    }

    /* compiled from: Taobao */
    public interface PermissionCallback {
        void onPermissionsDenied(String str);

        void onPermissionsGranted();
    }

    /* compiled from: Taobao */
    class a implements PermissionCallback {
        final /* synthetic */ JSONObject a;
        final /* synthetic */ JSCallback b;
        final /* synthetic */ JSCallback c;

        a(JSONObject jSONObject, JSCallback jSCallback, JSCallback jSCallback2) {
            this.a = jSONObject;
            this.b = jSCallback;
            this.c = jSCallback2;
        }

        @Override // com.alibaba.aliweex.adapter.module.WXCalendarModule.PermissionCallback
        public void onPermissionsDenied(String str) {
            JSCallback jSCallback = this.c;
            WXCalendarModule wXCalendarModule = WXCalendarModule.this;
            jSCallback.invoke(wXCalendarModule.buildError("no permission:" + str));
        }

        @Override // com.alibaba.aliweex.adapter.module.WXCalendarModule.PermissionCallback
        public void onPermissionsGranted() {
            if (this.a.containsKey("batch")) {
                JSONArray jSONArray = this.a.getJSONArray("batch");
                for (int i = 0; i < jSONArray.size(); i++) {
                    WXCalendarModule.this.addSingleEvent(jSONArray.getJSONObject(i));
                }
                this.b.invoke(null);
                return;
            }
            WXCalendarModule.this.addSingleEvent(this.a);
            this.b.invoke(null);
        }
    }

    /* compiled from: Taobao */
    class b implements PermissionCallback {
        final /* synthetic */ JSONObject a;
        final /* synthetic */ JSCallback b;
        final /* synthetic */ JSCallback c;

        b(JSONObject jSONObject, JSCallback jSCallback, JSCallback jSCallback2) {
            this.a = jSONObject;
            this.b = jSCallback;
            this.c = jSCallback2;
        }

        @Override // com.alibaba.aliweex.adapter.module.WXCalendarModule.PermissionCallback
        public void onPermissionsDenied(String str) {
            JSCallback jSCallback = this.c;
            WXCalendarModule wXCalendarModule = WXCalendarModule.this;
            jSCallback.invoke(wXCalendarModule.buildError("no permission:" + str));
        }

        @Override // com.alibaba.aliweex.adapter.module.WXCalendarModule.PermissionCallback
        public void onPermissionsGranted() {
            if (this.a.containsKey("batch")) {
                JSONArray jSONArray = new JSONArray();
                JSONArray jSONArray2 = this.a.getJSONArray("batch");
                for (int i = 0; i < jSONArray2.size(); i++) {
                    jSONArray.add(Boolean.valueOf(WXCalendarModule.this.checkSingleEvent(jSONArray2.getJSONObject(i))));
                }
                this.b.invoke(jSONArray);
            } else if (WXCalendarModule.this.checkSingleEvent(this.a)) {
                this.b.invoke(Boolean.TRUE);
            } else {
                this.b.invoke(Boolean.FALSE);
            }
        }
    }

    /* compiled from: Taobao */
    class c implements PermissionCallback {
        final /* synthetic */ JSONObject a;
        final /* synthetic */ JSCallback b;
        final /* synthetic */ JSCallback c;

        c(JSONObject jSONObject, JSCallback jSCallback, JSCallback jSCallback2) {
            this.a = jSONObject;
            this.b = jSCallback;
            this.c = jSCallback2;
        }

        @Override // com.alibaba.aliweex.adapter.module.WXCalendarModule.PermissionCallback
        public void onPermissionsDenied(String str) {
            JSCallback jSCallback = this.c;
            WXCalendarModule wXCalendarModule = WXCalendarModule.this;
            jSCallback.invoke(wXCalendarModule.buildError("no permission: " + str));
        }

        @Override // com.alibaba.aliweex.adapter.module.WXCalendarModule.PermissionCallback
        public void onPermissionsGranted() {
            if (this.a.containsKey("batch")) {
                JSONArray jSONArray = this.a.getJSONArray("batch");
                for (int i = 0; i < jSONArray.size(); i++) {
                    WXCalendarModule.this.removeSingleEvent(jSONArray.getJSONObject(i));
                }
                this.b.invoke(null);
                return;
            }
            WXCalendarModule.this.removeSingleEvent(this.a);
            this.b.invoke(null);
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private boolean addSingleEvent(JSONObject jSONObject) {
        try {
            String string = jSONObject.getString("title");
            String string2 = jSONObject.getString("note");
            String string3 = jSONObject.getString("startDate");
            String string4 = jSONObject.getString("endDate");
            int intValue = jSONObject.getIntValue("timeOffset");
            Calendar instance = Calendar.getInstance();
            instance.setTime(a30.b(string3));
            Calendar instance2 = Calendar.getInstance();
            instance2.setTime(a30.b(string4));
            if (re.c(this.mWXSDKInstance.getContext(), string, string2, instance, instance2, intValue / 60)) {
                return true;
            }
            return false;
        } catch (Exception e) {
            WXLogUtils.e(TAG, e);
            return false;
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private JSONObject buildError(String str) {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("result", (Object) "WX_FAILED");
        jSONObject.put("message", (Object) str);
        return jSONObject;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private boolean checkSingleEvent(JSONObject jSONObject) {
        try {
            String string = jSONObject.getString("title");
            String string2 = jSONObject.getString("startDate");
            String string3 = jSONObject.getString("endDate");
            Calendar instance = Calendar.getInstance();
            instance.setTime(a30.b(string2));
            Calendar instance2 = Calendar.getInstance();
            instance2.setTime(a30.b(string3));
            if (re.d(this.mWXSDKInstance.getContext(), string, "", instance, instance2)) {
                return true;
            }
            return false;
        } catch (Exception e) {
            WXLogUtils.e(TAG, e);
            return false;
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private boolean removeSingleEvent(JSONObject jSONObject) {
        try {
            String string = jSONObject.getString("title");
            String string2 = jSONObject.getString("startDate");
            String string3 = jSONObject.getString("endDate");
            Calendar instance = Calendar.getInstance();
            instance.setTime(a30.b(string2));
            Calendar instance2 = Calendar.getInstance();
            instance2.setTime(a30.b(string3));
            return re.e(this.mWXSDKInstance.getContext(), string, instance, instance2);
        } catch (Exception e) {
            WXLogUtils.e(TAG, e);
            return false;
        }
    }

    private void requestPermission(PermissionCallback permissionCallback, String... strArr) {
        try {
            ActivityCompat.requestPermissions((Activity) this.mWXSDKInstance.getContext(), strArr, 25);
            LocalBroadcastManager.getInstance(this.mWXSDKInstance.getContext()).registerReceiver(new PerReceiver(permissionCallback), new IntentFilter(WXModule.ACTION_REQUEST_PERMISSIONS_RESULT));
        } catch (Throwable th) {
            WXLogUtils.e(TAG, th);
        }
    }

    @JSMethod
    public void addEvent(JSONObject jSONObject, JSCallback jSCallback, JSCallback jSCallback2) {
        requestPermission(new a(jSONObject, jSCallback, jSCallback2), "android.permission.READ_CALENDAR", "android.permission.WRITE_CALENDAR");
    }

    @JSMethod
    public void checkEvent(JSONObject jSONObject, JSCallback jSCallback, JSCallback jSCallback2) {
        requestPermission(new b(jSONObject, jSCallback, jSCallback2), "android.permission.READ_CALENDAR");
    }

    @JSMethod
    public void checkPermission(JSONObject jSONObject, JSCallback jSCallback, JSCallback jSCallback2) {
        try {
            Context context = this.mWXSDKInstance.getContext();
            ArrayList<String> arrayList = new ArrayList();
            if (jSONObject == null || jSONObject.getJSONArray("permissions") == null) {
                arrayList.add("android.permission.READ_CALENDAR");
                arrayList.add("android.permission.WRITE_CALENDAR");
            } else {
                JSONArray jSONArray = jSONObject.getJSONArray("permissions");
                if (jSONArray.size() == 0) {
                    jSCallback2.invoke(buildError("permissions.size() == 0"));
                    return;
                }
                for (int i = 0; i < jSONArray.size(); i++) {
                    String string = jSONArray.getString(i);
                    char c2 = 65535;
                    int hashCode = string.hashCode();
                    if (hashCode != 3496342) {
                        if (hashCode == 113399775 && string.equals(lf1.OPERATION_WRITE)) {
                            c2 = 1;
                        }
                    } else if (string.equals(lf1.OPERATION_READ)) {
                        c2 = 0;
                    }
                    if (c2 == 0) {
                        arrayList.add("android.permission.READ_CALENDAR");
                    } else if (c2 != 1) {
                        jSCallback2.invoke(buildError("undefine permission: " + string));
                        return;
                    } else {
                        arrayList.add("android.permission.WRITE_CALENDAR");
                    }
                }
            }
            for (String str : arrayList) {
                if (ContextCompat.checkSelfPermission(context, str) != 0) {
                    jSCallback2.invoke(buildError("no permission: " + str));
                    return;
                }
            }
            jSCallback.invoke(null);
        } catch (Throwable th) {
            jSCallback2.invoke(buildError(th.getMessage()));
        }
    }

    @JSMethod
    public void removeEvent(JSONObject jSONObject, JSCallback jSCallback, JSCallback jSCallback2) {
        requestPermission(new c(jSONObject, jSCallback, jSCallback2), "android.permission.READ_CALENDAR", "android.permission.WRITE_CALENDAR");
    }
}
